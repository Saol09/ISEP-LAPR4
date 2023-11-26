package eapli.base.productOrderManagement.application;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CheckOpenOrdersController {

    private final ProductOrderRepository productOrderRepository = PersistenceContext.repositories().productOrderRepository();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final CostumerRepository repoCostumer = PersistenceContext.repositories().costumerRepository();

    public Iterable<ProductOrder> openOrdersByCustomer(Costumer costumer){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CLIENT_USER);
        final Iterable<ProductOrder> orders = productOrderRepository.findOpenOrdersByCostumer(costumer);
        return orders;
    }

    public Costumer findCostumerByEmail(String email){
        Email email1 = new Email(email);

        return repoCostumer.findCostumerByEmail(email1);
    }
}
