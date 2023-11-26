package eapli.base.shoppingCart.domain;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.product.application.ProductServices;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Shopping cart.
 */
@Table
@Entity
public class ShoppingCart implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @ElementCollection
    private Set<Item> products;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "NoTaxes_Amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "NoTaxes_Currency")),

    })
    private Money priceWithoutTaxes;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "Taxes_Amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "Taxes_Currency")),
    })
    private Money priceWithTaxes;

    /**
     * Instantiates a new Shopping cart.
     */
    protected ShoppingCart() {
        // ORM
    }

    /**
     * Instantiates a new Shopping cart.
     *
     * @param costumer the costumer
     * @param products the products
     */
    public ShoppingCart(Costumer costumer, Set<Item> products) {
        this.costumer = costumer;
        this.products = products;
        this.priceWithoutTaxes = totalPriceWithoutTaxes(new ProductServices());
        this.priceWithTaxes = totalPriceWithTaxes(new ProductServices());

    }

    /**
     * Total price with taxes money.
     *
     * @param productServices the product services
     * @return the money
     */
    public Money totalPriceWithTaxes(ProductServices productServices) {
        double priceWithTaxes = 0;

        for (Item item : products) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            priceWithTaxes += (item.getQuantity() * product.getPriceWithTaxes().amountAsDouble());
        }

        return this.priceWithTaxes = Money.euros(priceWithTaxes);
    }

    /**
     * Total price without taxes money.
     *
     * @param productServices the product services
     * @return the money
     */
    public Money totalPriceWithoutTaxes(ProductServices productServices) {
        double priceWithoutTaxes = 0;

        for (Item item : products) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            priceWithoutTaxes += (item.getQuantity() * product.getPriceWithoutTaxes().amountAsDouble());
        }

        return this.priceWithTaxes = Money.euros(priceWithoutTaxes);
    }

    /**
     * Gets costumer.
     *
     * @return the costumer
     */
    public Costumer getCostumer() {
        return costumer;
    }

    /**
     * Sets costumer.
     *
     * @param costumer the costumer
     */
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public Set<Item> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(Set<Item> products) {
        Set<Item> lista= new HashSet<>();
        lista.addAll(products);

        this.products = lista;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ShoppingCart -> " +
                ", products=" + products +
                ", priceWithoutTaxes=" + priceWithoutTaxes +
                ", priceWithTaxes=" + priceWithTaxes +
                '}';
    }
}
