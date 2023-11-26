package eapli.base.persistence.impl.inmemory;

import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Long> implements ProductRepository {

    static{
        InMemoryInitializer.init();
    }




    @Override
    public Iterable<Product> findByCategory(String category, String description) {
        return null;
    }

    @Override
    public Iterable<Product> findByDescription(String description) {
        return null;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return null;
    }

    @Override
    public Product findByInternalCode(InternalCode code) {
        return null;
    }



    @Override
    public Product findByID(Long id) {
        return null;
    }



}
