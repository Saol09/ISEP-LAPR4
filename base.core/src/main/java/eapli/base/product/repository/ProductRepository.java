package eapli.base.product.repository;

import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends DomainRepository<Long, Product> {
    /**
     * Find by category iterable.
     *
     * @param category    the category
     * @param description the description
     * @return the iterable
     */
    Iterable<Product> findByCategory(String category, String description);

    /**
     * Find by description iterable.
     *
     * @param description the description
     * @return the iterable
     */
    Iterable<Product> findByDescription(String description);

    /**
     * Find by brand iterable.
     *
     * @param brand the brand
     * @return the iterable
     */
    Iterable<Product> findByBrand(String brand);

    /**
     * Find by internal code product.
     *
     * @param code the code
     * @return the product
     */
    Product findByInternalCode(InternalCode code);


    Product findByID(Long id);







}
