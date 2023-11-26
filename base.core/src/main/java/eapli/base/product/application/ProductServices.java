package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;
import eapli.framework.application.ApplicationService;

/**
 * The type Product services.
 */
@ApplicationService
public class ProductServices {

    private final ProductRepository productRepository = PersistenceContext.repositories().productRepository();

    /**
     * Find product by code product.
     *
     * @param code the code
     * @return the product
     */
    public Product findProductByCode(InternalCode code){
        return productRepository.findByInternalCode(code);
    }
}
