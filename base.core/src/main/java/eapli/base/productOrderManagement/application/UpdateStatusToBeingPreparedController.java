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

public class UpdateStatusToBeingPreparedController {

    private final ProductOrderRepository productOrderRepository = PersistenceContext.repositories().productOrderRepository();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<ProductOrderDTO> dispatchedForCustomerDeliveryOrders() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        final Iterable<ProductOrder> orders = productOrderRepository.findDispatchedForCustomerDeliveryOrder();
        return StreamSupport.stream(orders.spliterator(), true)
                .map(ProductOrder::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    public void changeDispatchedToBeingDelivered(Long id) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        ProductOrder productOrder = productOrderRepository.findByOrderId(id);
        if (productOrder != null) {
            productOrder.changeStatusTo(ProductOrder.Status.BEING_DELIVERED);
            productOrderRepository.save(productOrder);
        } else System.out.println("Id Invalid");
    }
}
