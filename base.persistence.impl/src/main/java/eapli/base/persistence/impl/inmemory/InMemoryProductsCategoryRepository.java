package eapli.base.persistence.impl.inmemory;

import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.base.productsCategory.repository.ProductsCategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductsCategoryRepository extends InMemoryDomainRepository<ProductsCategory, AlphanumericCode> implements ProductsCategoryRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ProductsCategory> findByCode(AlphanumericCode code) {
        return null;
    }
}
