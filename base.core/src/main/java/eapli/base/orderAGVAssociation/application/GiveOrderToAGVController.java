package eapli.base.orderAGVAssociation.application;

import eapli.base.orderAGVAssociation.dto.AGVDTO;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;

/**
 * The type Give order to agv controller.
 */
public class GiveOrderToAGVController {


    /**
     * The Services.
     */
    GiveOrderToAGVService services = new GiveOrderToAGVService();


    /**
     * All to be prepared orders iterable.
     *
     * @return the iterable
     */
    public Iterable<ProductOrderDTO> allToBePreparedOrders(){
        return services.allToBePreparedOrders();
    }

    /**
     * All available ag vs iterable.
     *
     * @param orderWeight the order weight
     * @param orderVolume the order volume
     * @return the iterable
     */
    public Iterable<AGVDTO> allAvailableAGVs(final double orderWeight,final double orderVolume){
        return services.allAvailableAGVs(orderWeight,orderVolume);
    }


    /**
     * Give order to agv agvdto.
     *
     * @param agvDTO          the agv dto
     * @param productOrderDTO the product order dto
     * @return the agvdto
     */
    public AGVDTO giveOrderToAGV(AGVDTO agvDTO,ProductOrderDTO productOrderDTO){
        return services.grabAndSaveRealValues(agvDTO.id,productOrderDTO.id);
    }



}
