package eapli.base.product.domain;

import eapli.base.agvConfiguration.domain.ShortDescription;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.CostumerBuilder;
import eapli.base.costumermanagement.domain.Gender;
import eapli.base.costumermanagement.domain.Name;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Money;

import java.util.Set;

/**
 * The type Product builder.
 */
public class ProductBuilder implements DomainFactory<Product> {

    private Product product;

    private InternalCode internalCode;
    private ShortDescription shortDescription;
    private ExtendedDescription extendedDescription;
    private Barcode barcode;
    private Money priceWithoutTax;
    private Money priceWithTax;
    private Double weight;
    private Double volume;
    private ProductsCategory productsCategory;
    private boolean status;

    /**
     * With internal code product builder.
     *
     * @param internalCode the internal code
     * @return the product builder
     */
    public ProductBuilder withInternalCode(final InternalCode internalCode) {
        this.internalCode = internalCode;
        return this;
    }

    /**
     * With short description product builder.
     *
     * @param shortDescription the short description
     * @return the product builder
     */
    public ProductBuilder withShortDescription(final ShortDescription shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * With extended description product builder.
     *
     * @param extendedDescription the extended description
     * @return the product builder
     */
    public ProductBuilder withExtendedDescription(final ExtendedDescription extendedDescription) {
        this.extendedDescription = extendedDescription;
        return this;
    }

    /**
     * With barcode product builder.
     *
     * @param barcode the barcode
     * @return the product builder
     */
    public ProductBuilder withBarcode(final Barcode barcode) {
        this.barcode = barcode;
        return this;
    }

    /**
     * With price without tax product builder.
     *
     * @param priceWithoutTax the price without tax
     * @return the product builder
     */
    public ProductBuilder withPriceWithoutTax(final Money priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
        return this;
    }

    /**
     * With price with tax product builder.
     *
     * @param priceWithTax the price with tax
     * @return the product builder
     */
    public ProductBuilder withPriceWithTax(final Money priceWithTax) {
        this.priceWithTax = priceWithTax;
        return this;
    }

    /**
     * With weight product builder.
     *
     * @param weight the weight
     * @return the product builder
     */
    public ProductBuilder withWeight(final Double weight) {
        this.weight = weight;
        return this;
    }

    /**
     * With volume product builder.
     *
     * @param volume the volume
     * @return the product builder
     */
    public ProductBuilder withVolume(final Double volume) {
        this.volume = volume;
        return this;
    }

    /**
     * With products category product builder.
     *
     * @param productsCategory the products category
     * @return the product builder
     */
    public ProductBuilder withProductsCategory(final ProductsCategory productsCategory) {
        this.productsCategory = productsCategory;
        return this;
    }

    /**
     * With status product builder.
     *
     * @param status the status
     * @return the product builder
     */
    public ProductBuilder withStatus(final boolean status) {
        this.status = status;
        return this;
    }


    private Product buildOrThrow() {
        if (product != null) {
            return product;
        } else if (internalCode != null
                && shortDescription != null
                && extendedDescription != null
                && barcode != null
                && priceWithoutTax != null
                && priceWithTax != null
                && weight != null
                && volume != null
                && productsCategory != null) {

            product = new Product(internalCode, shortDescription, extendedDescription, barcode,
                    priceWithoutTax, priceWithTax, weight, volume, productsCategory, status);
            return product;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * With technical description product builder.
     *
     * @param technicalDescription the technical description
     * @return the product builder
     */
    public ProductBuilder withTechnicalDescription(final TechnicalDescription technicalDescription) {
        buildOrThrow();
        if (technicalDescription != null)
            product.changeTechnicalDescription(technicalDescription);
        return this;
    }

    /**
     * With brand product builder.
     *
     * @param brand the brand
     * @return the product builder
     */
    public ProductBuilder withBrand(final Brand brand) {
        buildOrThrow();
        if (brand != null)
            product.changeBrand(brand);
        return this;
    }

    /**
     * With reference product builder.
     *
     * @param reference the reference
     * @return the product builder
     */
    public ProductBuilder withReference(final Reference reference) {
        buildOrThrow();
        if (reference != null)
            product.changeReference(reference);
        return this;
    }

    /**
     * With production code product builder.
     *
     * @param productionCode the production code
     * @return the product builder
     */
    public ProductBuilder withProductionCode(final ProductionCode productionCode) {
        buildOrThrow();
        if (productionCode != null)
            product.changeProductionCode(productionCode);
        return this;
    }

    /**
     * With product location product builder.
     *
     * @param ProductLocation the product location
     * @return the product builder
     */
    public ProductBuilder withProductLocation(final ProductLocation ProductLocation) {
        buildOrThrow();
        if (ProductLocation != null)
            product.changeProductLocation(ProductLocation);
        return this;
    }

    /**
     * With photos product builder.
     *
     * @param photos the photos
     * @return the product builder
     */
    public ProductBuilder withPhotos(final Set<String> photos) {
        buildOrThrow();
        if (photos != null)
            product.addPhotos(photos);
        return this;
    }


    @Override
    public Product build() {
        final Product ret = buildOrThrow();
        product = null;
        return ret;
    }
}
