package eapli.base.productsCategory.repository;

import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Products category repository.
 */
public interface ProductsCategoryRepository extends DomainRepository<AlphanumericCode, ProductsCategory> {
    /**
     * Find by code iterable.
     *
     * @param code the code
     * @return the iterable
     */
    Iterable<ProductsCategory> findByCode(AlphanumericCode code);
    /*Iterable<ProductsCategory> findByCode(AlphanumericCode code);*/


    Iterable<ProductsCategory> findAll();


}
