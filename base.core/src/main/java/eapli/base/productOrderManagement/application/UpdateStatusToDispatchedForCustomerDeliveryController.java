package eapli.base.productOrderManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The type Order status controller.
 */
public class UpdateStatusToDispatchedForCustomerDeliveryController {

    private final ProductOrderRepository productOrderRepository = PersistenceContext.repositories().productOrderRepository();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * Prepared orders iterable.
     *
     * @return the iterable
     */
    public Iterable<ProductOrderDTO> preparedOrders() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        final Iterable<ProductOrder> orders = productOrderRepository.findPrepared();
        return StreamSupport.stream(orders.spliterator(), true)
                .map(ProductOrder::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Change status to dispatched.
     *
     * @param id the id
     */
    public void changeStatusToDispatched(Long id) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        ProductOrder productOrder = productOrderRepository.findByOrderId(id);
        if (productOrder != null) {
            productOrder.changeStatusTo(ProductOrder.Status.DISPATCHED_FOR_CUSTOMER_DELIVERY);
            productOrderRepository.save(productOrder);
        } else System.out.println("Id Invalid");
    }



}
