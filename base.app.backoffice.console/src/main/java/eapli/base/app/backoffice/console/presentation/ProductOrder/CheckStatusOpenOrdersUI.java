package eapli.base.app.backoffice.console.presentation.ProductOrder;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.application.CheckOpenOrdersController;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;

public class CheckStatusOpenOrdersUI extends AbstractUI {

    private final CheckOpenOrdersController controller = new CheckOpenOrdersController();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    @Override
    protected boolean doShow() {

        String email = authz.session().get().authenticatedUser().email().toString();
        Costumer costumer = controller.findCostumerByEmail(email);

        Iterable<ProductOrder> orders = controller.openOrdersByCustomer(costumer);

        for (ProductOrder order : orders)
            System.out.println(order.toString());

        return true;
    }

    @Override
    public String headline() {
        return "-------- Open Orders --------";
    }
}
