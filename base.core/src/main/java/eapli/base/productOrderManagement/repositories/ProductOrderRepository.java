package eapli.base.productOrderManagement.repositories;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Product order repository.
 */
public interface ProductOrderRepository extends DomainRepository<Long, ProductOrder> {

    /**
     * Find by order id product order.
     *
     * @param id the id
     * @return the product order
     */
    ProductOrder findByOrderId(Long id);


    /**
     * Find to be prepared iterable.
     *
     * @return the iterable
     */
    Iterable<ProductOrder> findToBePrepared();

    /**
     * Find paid order iterable.
     *
     * @return the iterable
     */
    Iterable<ProductOrder> findPaidOrder();

    /**
     * Find prepared iterable.
     *
     * @return the iterable
     */
    Iterable<ProductOrder> findPrepared();

    Iterable<ProductOrder> findDispatchedForCustomerDeliveryOrder();

    Iterable<ProductOrder> findOpenOrdersByCostumer(Costumer costumer);
}
