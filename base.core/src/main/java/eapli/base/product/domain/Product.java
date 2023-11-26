package eapli.base.product.domain;

import eapli.base.agvConfiguration.domain.ShortDescription;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Money;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Product.
 */
@Entity
@Table
public class Product implements Comparable<Long>, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private InternalCode internalCode; //mandatory

    @Embedded
    private ShortDescription shortDescription; //mandatory

    @Embedded
    private ExtendedDescription extendedDescription; //mandatory

    @Embedded
    private TechnicalDescription technicalDescription; //not mandatory

    @Embedded
    private Brand brand;//not mandatory

    @Embedded
    private Reference reference;//not mandatory

    @ElementCollection
    private Set<String> photos; //mandatory

    @Embedded
    private Barcode barcode; //EAN13, UPC (mandatory)

    @Embedded
    private ProductionCode productionCode;//not mandatory

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "no_taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "no_taxes_currency"))
    })
    private Money priceWithoutTax;//mandatory


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "taxes_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "taxes_currency"))
    })
    private Money priceWithTax; //mandatory

    private double weight; //mandatory

    private double volume; //mandatory

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "category_code", referencedColumnName = "code")
    })
    private ProductsCategory productsCategory;

    @Embedded
    private ProductLocation productLocation; //not mandatory

    private boolean status; //mandatory

    /**
     * Instantiates a new Product.
     */
    protected Product(){}

    /**
     * Instantiates a new Product.
     *
     * @param internalCode        the internal code
     * @param shortDescription    the short description
     * @param extendedDescription the extended description
     * @param barcode             the barcode
     * @param priceWithoutTax     the price without tax
     * @param priceWithTax        the price with tax
     * @param weight              the weight
     * @param volume              the volume
     * @param productsCategory    the products category
     * @param status              the status
     */
    public Product(InternalCode internalCode, ShortDescription shortDescription, ExtendedDescription extendedDescription,
                   Barcode barcode, Money priceWithoutTax, Money priceWithTax, double weight, double volume,
                   ProductsCategory productsCategory, boolean status) {

        Preconditions.noneNull(internalCode,shortDescription,extendedDescription,barcode,priceWithoutTax,priceWithTax,
                weight,volume,productsCategory,status);
        this.internalCode = internalCode;
        this.shortDescription = shortDescription;
        this.extendedDescription = extendedDescription;
        this.barcode = barcode;
        this.priceWithoutTax = priceWithoutTax;
        this.priceWithTax = priceWithTax;
        this.weight = weight;
        this.volume = volume;
        this.productsCategory = productsCategory;
        this.status = status;
    }


    public synchronized ProductLocation getProductLocation() {
        return productLocation;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public Double getVolume() {
        return this.volume;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }


    /**
     * The enum Type.
     */
    public enum TYPE {
        /**
         * Ean 13 type.
         */
        EAN13,
        /**
         * Upc type.
         */
        UPC;
    }

    /**
     * Change technical description.
     *
     * @param technicalDescription the technical description
     */
    public void changeTechnicalDescription(final TechnicalDescription technicalDescription){
        this.technicalDescription=technicalDescription;
    }

    /**
     * Change brand.
     *
     * @param brand the brand
     */
    public void changeBrand(final Brand brand){
        this.brand=brand;
    }

    /**
     * Change reference.
     *
     * @param reference the reference
     */
    public void changeReference(final Reference reference){
        this.reference=reference;
    }

    /**
     * Change production code.
     *
     * @param productionCode the production code
     */
    public void changeProductionCode(final ProductionCode productionCode){
        this.productionCode=productionCode;
    }

    /**
     * Change product location.
     *
     * @param productLocation the product location
     */
    public void changeProductLocation(final ProductLocation productLocation) {
        this.productLocation = productLocation;
    }

    /**
     * Add photos.
     *
     * @param photos the photos
     */
    public void addPhotos(final Set<String> photos){
        this.photos = photos;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public Brand getBrand() {return brand;}

    /**
     * Gets description.
     *
     * @return the description
     */
    public ShortDescription getDescription() {return shortDescription;}

    @Override
    public String toString() {
        return "\nProduct: " +
                "\n\tId: " + id +
                "\n\tInternal Code: " + internalCode +
                "\n\tShort Description: " + shortDescription +
                "\n\tExtended Description: " + extendedDescription +
                "\n\tTechnical Description: " + technicalDescription +
                "\n\tBrand:" + brand +
                "\n\tReference: " + reference +
                "\n\tBarcode: " + barcode +
                "\n\tProduction Code: " + productionCode +
                "\n\tPrice Without Tax: " + priceWithoutTax +
                "\n\tPrice With Tax: " + priceWithTax +
                "\n\tWeight: " + weight +
                "\n\tVolume: " + volume +
                "\n\tCategory: " + productsCategory +
                "\n\tLocation: " + productLocation +
                "\n\tStatus: " + status;
    }


    /**
     * Gets price with taxes.
     *
     * @return the price with taxes
     */
    public Money getPriceWithTaxes() {
        return priceWithTax;
    }

    /**
     * Gets price without taxes.
     *
     * @return the price without taxes
     */
    public Money getPriceWithoutTaxes() {
        return priceWithoutTax;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
