package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.orderAGVAssociation.application.GiveOrderToAGVController;
import eapli.base.orderAGVAssociation.dto.AGVDTO;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class GiveOrderToAGVUI extends AbstractUI {

    private final GiveOrderToAGVController theController = new GiveOrderToAGVController();

    @Override
    protected boolean doShow() {


        /////////////////////////ORDER///////////////////////////////
        Iterable<ProductOrderDTO> ordersDTOs = theController.allToBePreparedOrders();
        if (ordersDTOs.iterator().hasNext()) {


            int i = 0;
            for (ProductOrderDTO n : ordersDTOs) {
                i++;
                System.out.println(i + "=====" + n);
            }
            int order = Console.readInteger("Choose an Order: ");
            ProductOrderDTO productOrderDTO = null;
            i = 0;
            for (ProductOrderDTO orderDTO : ordersDTOs) {
                i++;
                if (i == order) {
                    productOrderDTO = orderDTO;
                }
            }
            /////////////////////////ORDER///////////////////////////////
            //////////////////////////AGV////////////////////////////////
            Iterable<AGVDTO> AGVsDTOs = theController.allAvailableAGVs(productOrderDTO.orderWeight,productOrderDTO.orderVolume);
            if (AGVsDTOs.iterator().hasNext()) {
                i = 0;
                for (AGVDTO AGVsDTO : AGVsDTOs) {
                    i++;
                    System.out.println(i + "=====" + AGVsDTO);
                }
                int agv = Console.readInteger("Choose an AGV: ");
                AGVDTO agvDTO = null;
                i = 0;
                for (AGVDTO AGVsDTO : AGVsDTOs) {
                    i++;
                    if (i == agv) {
                        agvDTO = AGVsDTO;
                    }
                }
                //////////////////////////AGV////////////////////////////////


                System.out.println("\n\n=============="+theController.giveOrderToAGV(agvDTO, productOrderDTO));
            }else{
                System.out.println("None Available AGVs");
            }
        }else{
            System.out.println("None to be prepared orders");
        }







        return false;

    }

    @Override
    public String headline() {
        return "Force order on AGV";
    }
}


