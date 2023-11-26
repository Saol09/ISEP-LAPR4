package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaProductOrderRepository extends JpaAutoTxRepository<ProductOrder, Long, Long> implements ProductOrderRepository {

    public JpaProductOrderRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public JpaProductOrderRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");

    }


    @Override
    public Iterable<ProductOrder> findToBePrepared() {
        try {
            ProductOrder.Status d = ProductOrder.Status.valueOf("TO_BE_PREPARED");

            final TypedQuery<ProductOrder> productOrder = createQuery("SELECT e FROM ProductOrder e WHERE e.status=:status", ProductOrder.class);
            productOrder.setParameter("status", d);
            return productOrder.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public Iterable<ProductOrder> findPrepared() {
        try {
            ProductOrder.Status d = ProductOrder.Status.valueOf("PREPARED");

            final TypedQuery<ProductOrder> productOrder = super.entityManager().createQuery("SELECT e FROM ProductOrder e WHERE e.status=:status", ProductOrder.class);
            productOrder.setParameter("status", d);
            return productOrder.getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public ProductOrder findByOrderId(Long id) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM ProductOrder p WHERE p.id=:id");
            query.setParameter("id", id);
            ProductOrder order = (ProductOrder) query.getSingleResult();
            return order;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Iterable<ProductOrder> findPaidOrder() {
        try {
            ProductOrder.Status d = ProductOrder.Status.valueOf("PAID");

            final TypedQuery<ProductOrder> productOrder = super.entityManager().createQuery("SELECT e FROM ProductOrder e WHERE e.status=:status", ProductOrder.class);
            productOrder.setParameter("status", d);
            return productOrder.getResultList();
        } catch (NoResultException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Iterable<ProductOrder> findDispatchedForCustomerDeliveryOrder(){
        try{
            ProductOrder.Status d = ProductOrder.Status.valueOf("DISPATCHED_FOR_CUSTOMER_DELIVERY");

            final TypedQuery<ProductOrder> productOrder = super.entityManager().createQuery("SELECT e FROM ProductOrder e WHERE e.status=:status", ProductOrder.class);
            productOrder.setParameter("status", d);
            return productOrder.getResultList();
        }catch (NoResultException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Iterable<ProductOrder> findOpenOrdersByCostumer(Costumer costumer){
        try{

            ProductOrder.Status d = ProductOrder.Status.valueOf("DELIVERED");

            final TypedQuery<ProductOrder> productOrder = super.entityManager().createQuery("SELECT e FROM ProductOrder e WHERE e.costumer=:costumer AND NOT e.status=:status", ProductOrder.class);
            productOrder.setParameter("costumer", costumer);
            productOrder.setParameter("status",d);
            return productOrder.getResultList();
        }catch (NoResultException e){
            System.out.println(e);
            return null;
        }
    }

}
