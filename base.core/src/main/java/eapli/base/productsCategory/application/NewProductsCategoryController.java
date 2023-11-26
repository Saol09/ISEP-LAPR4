package eapli.base.productsCategory.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.base.productsCategory.repository.ProductsCategoryRepository;

import java.util.List;
import java.util.Objects;

/**
 * The type New products category controller.
 */
public class NewProductsCategoryController {

    private final ProductsCategoryRepository repoCategory = PersistenceContext.repositories().productsCategoryRepository();

    /**
     * New products category products category.
     *
     * @param code the code
     * @param text the text
     * @return the products category
     */
    public ProductsCategory newProductsCategory(AlphanumericCode code, Description text){

        ProductsCategory cat = new ProductsCategory(code, text);

        return repoCategory.save(cat);
    }

    /**
     * Show all categories list.
     *
     * @return the list
     */
    public List<ProductsCategory> showAllCategories(){

        return (List<ProductsCategory>) repoCategory.findAll();
    }
}
