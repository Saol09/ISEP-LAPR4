package eapli.base.product.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.base.productsCategory.repository.ProductsCategoryRepository;


/**
 * The type Search products controller.
 */
public class SearchProductsController {


    private final ProductRepository productRepository = PersistenceContext.repositories().productRepository();
    private final ProductsCategoryRepository productsCategory = PersistenceContext.repositories().productsCategoryRepository();


    /**
     * Show all.
     */
    public void showAll () {
        Iterable<Product> products = productRepository.findAll();
        for (Product prod: products) {
            System.out.println(prod);
        }
    }


    /**
     * Show all category's available.
     */
    public void showCategorys () {
        Iterable<ProductsCategory> category = productsCategory.findAll();
        for (ProductsCategory cat: category) {
            System.out.println(cat);
        }
    }

    /**
     * Filter by category.
     *
     * @param category    the category
     * @param description the description
     */
    public void filterByCategory(final String category, final String description) {
        Iterable<Product> categ = productRepository.findByCategory(category, description);
        for (Product prod: categ) {
            System.out.println(prod);
        }
    }


    /**
     * Show all descriptions available.
     */
    public void showDescription () {
        Iterable<Product> products = productRepository.findAll();
        for (Product prod: products) {
            System.out.println(prod.getDescription());
        }
    }

    /**
     * Filter by description.
     *
     * @param description the description
     */
    public void filterByDescription(final String description) {
        Iterable<Product> descr = productRepository.findByDescription(description);
        for (Product prod: descr) {
            System.out.println(prod);
        }
    }


    /**
     * Show all brands available.
     */
    public void showBrand () {
        Iterable<Product> products = productRepository.findAll();
        for (Product prod: products) {
            System.out.println(prod.getBrand());
        }
    }

    /**
     * Filter by brand.
     *
     * @param brand the brand
     */
    public void filterByBrand(final String brand) {
        Iterable<Product> bra = productRepository.findByBrand(brand);
        for (Product prod: bra) {
            System.out.println(prod);
        }
    }



}
