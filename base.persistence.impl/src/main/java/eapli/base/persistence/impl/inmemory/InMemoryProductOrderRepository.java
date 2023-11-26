package eapli.base.persistence.impl.inmemory;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductOrderRepository extends InMemoryDomainRepository<ProductOrder, Long> implements ProductOrderRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ProductOrder> findToBePrepared() {
        return null;
    }

    @Override
    public Iterable<ProductOrder> findPaidOrder() {
        return null;
    }

    @Override
    public Iterable<ProductOrder> findPrepared() {
        return null;
    }

    @Override
    public ProductOrder findByOrderId(Long id) {
        return null;
    }

    @Override
    public Iterable<ProductOrder> findDispatchedForCustomerDeliveryOrder(){return null;}

    @Override
    public Iterable<ProductOrder> findOpenOrdersByCostumer(Costumer costumer){
        return null;
    }
}
