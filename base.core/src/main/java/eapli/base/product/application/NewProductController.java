package eapli.base.product.application;

import eapli.base.agvConfiguration.domain.ShortDescription;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.*;
import eapli.base.product.repository.ProductRepository;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.general.domain.model.Money;

import java.util.Set;

/**
 * The type New product controller.
 */
public class NewProductController {

    private final ProductRepository repoProduct = PersistenceContext.repositories().productRepository();

    /**
     * New product product.
     *
     * @param internalCode         the internal code
     * @param shortDescription     the short description
     * @param extendedDescription  the extended description
     * @param technicalDescription the technical description
     * @param brand                the brand
     * @param reference            the reference
     * @param photos               the photos
     * @param barcode              the barcode
     * @param productionCode       the production code
     * @param priceWithoutTax      the price without tax
     * @param priceWithTax         the price with tax
     * @param weight               the weight
     * @param volume               the volume
     * @param category             the category
     * @param productLocation      the product location
     * @param status               the status
     * @return the product
     */
    public Product newProduct(InternalCode internalCode, ShortDescription shortDescription,
                              ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand,
                              Reference reference, Set<String> photos, Barcode barcode, ProductionCode productionCode, Money priceWithoutTax,
                              Money priceWithTax, Double weight, Double volume,
                              ProductsCategory category, ProductLocation productLocation, boolean status){

        Product product = new ProductBuilder().withInternalCode(internalCode).
                withShortDescription(shortDescription).
                withExtendedDescription(extendedDescription).
                withBarcode(barcode).
                withPriceWithoutTax(priceWithoutTax).
                withPriceWithTax(priceWithTax).
                withWeight(weight).
                withVolume(volume).
                withProductsCategory(category).
                withTechnicalDescription(technicalDescription).
                withBrand(brand).
                withReference(reference).
                withPhotos(photos).
                withProductionCode(productionCode).
                withProductLocation(productLocation).
                withStatus(status).build();

        return repoProduct.save(product);
    }

   /* public Product newProductWithoutProductionCode(InternalCode internalCode, ShortDescription shortDescription,
                              ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand,
                              Reference reference, Barcode barcode, Money priceWithoutTax,
                                                   Money priceWithTax, Double weight, Double volume,
                              ProductsCategory category, ProductLocation location){

        Product product = new Product(internalCode, shortDescription, extendedDescription, technicalDescription, brand,
                reference, barcode, priceWithoutTax, priceWithTax, weight, volume, category, location);

        return repoProduct.save(product);
    }

    public Product newProductWithProductionCode(InternalCode internalCode, ShortDescription shortDescription,
                                                ExtendedDescription extendedDescription, TechnicalDescription technicalDescription, Brand brand,
                                                Reference reference, Barcode barcode, ProductionCode productionCode, Money priceWithoutTax,
                                                Money priceWithTax, Double weight, Double volume,
                                                ProductsCategory category, ProductLocation location){

        Product product = new Product(internalCode, shortDescription, extendedDescription, technicalDescription, brand,
                        reference, barcode, productionCode, priceWithoutTax, priceWithTax, volume, weight, category, location);

        return repoProduct.save(product);
    }*/


}
