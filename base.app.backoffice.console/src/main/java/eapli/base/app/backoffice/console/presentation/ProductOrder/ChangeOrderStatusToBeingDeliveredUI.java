package eapli.base.app.backoffice.console.presentation.ProductOrder;

import eapli.base.productOrderManagement.application.UpdateStatusToBeingPreparedController;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ChangeOrderStatusToBeingDeliveredUI extends AbstractUI {

    private final UpdateStatusToBeingPreparedController controller = new UpdateStatusToBeingPreparedController();

    @Override
    protected boolean doShow() {
        while (true) {
            Iterable<ProductOrderDTO> orderDTOS = controller.dispatchedForCustomerDeliveryOrders();
            System.out.println("\n============================================================");
            System.out.println("           ORDERS DISPATCHED FOR CUSTOMER DELIVERY            ");
            System.out.println("==============================================================\n\n");
            for (ProductOrderDTO order : orderDTOS)
                System.out.println(order);
            int answer = Console.readInteger("Do you wish to update the status of any of these orders??\n 1 -> Yes | 2 -> No\n");
            if (answer == 1) {
                long productOrderID = Console.readLong("Please insert the ID of the order you wish to change the status.");
                controller.changeDispatchedToBeingDelivered(productOrderID);
                System.out.println("Order Status changed");
            }
            if (answer == 2)
                break;
        }
        return false;
    }

    @Override
    public String headline() {
        return "Change Order Status to Being Delivered";
    }
}
