package eapli.base.productOrderManagement.domain;

import eapli.base.costumermanagement.domain.Address;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.base.product.application.ProductServices;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

/**
 * The type Product order.
 */
@Entity
public class ProductOrder implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "billing_streetName")),
            @AttributeOverride(name = "doorNumber", column = @Column(name = "billing_doorNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "billing_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city")),
            @AttributeOverride(name = "country", column = @Column(name = "billing_country"))
    })
    private Address billingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "shipping_streetName")),
            @AttributeOverride(name = "doorNumber", column = @Column(name = "shipping_doorNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "shipping_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "country", column = @Column(name = "shipping_country"))
    })
    private Address deliveryAddress;

    @ElementCollection
    private Set<Item> items;

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

    @ManyToOne
    private Costumer costumer;

    @Temporal(TemporalType.DATE)
    private Calendar registerDate;

    private String comment;

    private double orderWeight;

    private double orderVolume;

    @Temporal(TemporalType.DATE)
    private Calendar communicationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Shipment shipment;

    @Enumerated(EnumType.STRING)
    private CommunicationMethod communicationMethod;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    private SystemUser clerkResponsable;

    private Notification notification;


    /**
     * Instantiates a new Product order.
     */
    protected ProductOrder() {
        // ORM
    }

    /**
     * Instantiates a new Product order.
     *
     * @param costumer            the costumer
     * @param deliveryAddress     the delivery address
     * @param billingAddress      the billing address
     * @param items               the items
     * @param shipment            the shipment
     * @param communicationMethod the communication method
     * @param communicationDate   the communication date
     * @param paymentMethod       the payment method
     * @param clerkResponsible    the clerk responsible
     */
    public ProductOrder(Costumer costumer, Address deliveryAddress, Address billingAddress,
                        Set<Item> items, Shipment shipment, CommunicationMethod communicationMethod,
                        Calendar communicationDate, PaymentMethod paymentMethod, SystemUser clerkResponsible) {
        this.costumer = costumer;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.items = items;
        this.shipment = shipment;
        this.communicationMethod = communicationMethod;
        this.paymentMethod = paymentMethod;
        this.communicationDate = communicationDate;
        this.clerkResponsable = clerkResponsible;
        this.orderVolume = totalVolume(new ProductServices());
        this.orderWeight = totalWeight(new ProductServices());
        this.priceWithTaxes = totalPriceWithTaxes(new ProductServices());
        this.priceWithoutTaxes = totalPriceWithoutTaxes(new ProductServices());
        this.status = Status.TO_BE_PREPARED;
        this.registerDate = Calendars.now();
        this.notification = new Notification(costumer.getEmail().toString(),
                "Order Registered.", "Your order was registered in our system. Thank you for your preference.");
    }

    /**
     * Instantiates a new Product order.
     *
     * @param costumer            the costumer
     * @param deliveryAddress     the delivery address
     * @param billingAddress      the billing address
     * @param items               the items
     * @param shipment            the shipment
     * @param communicationMethod the communication method
     * @param communicationDate   the communication date
     * @param paymentMethod       the payment method
     * @param comment             the comment
     * @param clerkResponsible    the clerk responsible
     */
    public ProductOrder(Costumer costumer, Address deliveryAddress, Address billingAddress,
                        Set<Item> items, Shipment shipment, CommunicationMethod communicationMethod,
                        Calendar communicationDate, PaymentMethod paymentMethod,
                        String comment, SystemUser clerkResponsible) {
        Preconditions.nonEmpty(comment);
        this.costumer = costumer;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
        this.items = items;
        this.shipment = shipment;
        this.communicationMethod = communicationMethod;
        this.communicationDate = communicationDate;
        this.registerDate = Calendars.now();
        this.paymentMethod = paymentMethod;
        this.comment = comment;
        this.clerkResponsable = clerkResponsible;
        this.paymentMethod = paymentMethod;
        this.orderVolume = totalVolume(new ProductServices());
        this.orderWeight = totalWeight(new ProductServices());
        this.priceWithTaxes = totalPriceWithTaxes(new ProductServices());
        this.priceWithoutTaxes = totalPriceWithoutTaxes(new ProductServices());
        this.status = Status.TO_BE_PREPARED;
        this.notification = new Notification(costumer.getEmail().toString(),
                "Order Registered.", "Your order was registered in our system. Thank you for your preference.");
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    /**
     * Change status to.
     *
     * @param status the status
     */
    public void changeStatusTo(Status status) {
        this.status = status;
    }

    /**
     * Total price with taxes money.
     *
     * @param productServices the product services
     * @return the money
     */
    public Money totalPriceWithTaxes(ProductServices productServices) {
        double priceWithTaxes = 0;

        for (Item item : items) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            priceWithTaxes += (item.getQuantity() * product.getPriceWithTaxes().amountAsDouble());
        }

        return this.priceWithTaxes = Money.euros(priceWithTaxes + this.shipment.cost());
    }

    /**
     * Total price without taxes money.
     *
     * @param productServices the product services
     * @return the money
     */
    public Money totalPriceWithoutTaxes(ProductServices productServices) {
        double priceWithoutTaxes = 0;

        for (Item item : items) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            priceWithoutTaxes += (item.getQuantity() * product.getPriceWithoutTaxes().amountAsDouble());
        }

        return this.priceWithTaxes = Money.euros(priceWithoutTaxes);
    }

    /**
     * Total volume double.
     *
     * @param productServices the product services
     * @return the double
     */
    public Double totalVolume(ProductServices productServices) {
        double volume = 0;

        for (Item item : items) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            volume += (item.getQuantity() * product.getVolume());
        }

        return this.orderVolume = volume;
    }

    /**
     * Total weight double.
     *
     * @param productServices the product services
     * @return the double
     */
    public Double totalWeight(ProductServices productServices) {
        double weight = 0;

        for (Item item : items) {
            String code = item.getProductID();
            Product product = productServices.findProductByCode(new InternalCode(code));
            weight += (item.getQuantity() * product.getWeight());
        }

        return this.orderVolume = weight;
    }


    /**
     * To dto product order dto.
     *
     * @return the product order dto
     */
    public ProductOrderDTO toDTO(){
        ArrayList<String> listItems = new ArrayList<>();
        for (Item item : items) {
            listItems.add(item.getProductID()+" "+item.getQuantity());
        }
        //got it from web
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(registerDate.getTime());
        //
        return new ProductOrderDTO(id,formatted,listItems,orderVolume,orderWeight,costumer.viewName().toString());
    }

    /**
     * The enum Communication method.
     */
    public enum CommunicationMethod {
        /**
         * Call communication method.
         */
        CALL,
        /**
         * Messages communication method.
         */
        MESSAGES,
        /**
         * Email communication method.
         */
        EMAIL,
        /**
         * Personally communication method.
         */
        PERSONALLY
    }

    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Being prepared status.
         */
        BEING_PREPARED,
        /**
         * To be prepared status.
         */
        TO_BE_PREPARED,
        /**
         * Prepared status.
         */
        PREPARED,
        /**
         * Ready for packing status.
         */
        READY_FOR_PACKING,
        /**
         * Payment pending status.
         */
        PAYMENT_PENDING,
        /**
         * Dispatched for customer delivery status.
         */
        DISPATCHED_FOR_CUSTOMER_DELIVERY,
        /**
         * Paid status.
         */
        PAID,
        /**
         * Being delivered status.
         */
        BEING_DELIVERED,
        /**
         * Delivered by carrier status.
         */
        DELIVERED_BY_CARRIER,
        /**
         * Delivered status.
         */
        DELIVERED
    }

    /**
     * The enum Payment method.
     */
    public enum PaymentMethod {
        /**
         * Paypal payment method.
         */
        PAYPAL,
        /**
         * Applepay payment method.
         */
        APPLEPAY
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Gets order weight.
     *
     * @return the order weight
     */
    public double getOrderWeight() {
        return orderWeight;
    }

    /**
     * Gets order volume.
     *
     * @return the order volume
     */
    public double getOrderVolume() {
        return orderVolume;
    }

    /**
     * Gets register date.
     *
     * @return the register date
     */
    public Calendar getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "\nProductOrder" +
                "\nid = " + id +
                "\nstatus = " + status +
                "\nitems = " + items +
                "\npriceWithoutTaxes = " + priceWithoutTaxes +
                "\npriceWithTaxes = " + priceWithTaxes +
                "}\n";
    }
}
