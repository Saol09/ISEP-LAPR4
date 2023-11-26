package eapli.base.orderAGVAssociation.application;


import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.agvConfiguration.domain.Task;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.orderAGVAssociation.dto.AGVDTO;
import eapli.base.productOrderManagement.dto.ProductOrderDTO;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;
import eapli.framework.application.ApplicationService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * The type Give order to agv service.
 */
@ApplicationService
public class GiveOrderToAGVService {
    private final ProductOrderRepository orderRepository = PersistenceContext.repositories().productOrderRepository();
    private final AGVConfigurationRepository agvConfigurationRepository = PersistenceContext.repositories().agvConfigurationRepository();


    /**
     * All to be prepared orders iterable.
     *
     * @return the iterable
     */
//===========ORDER STUFF=============
    public Iterable<ProductOrderDTO> allToBePreparedOrders(){
        final Iterable<ProductOrder> orders = orderRepository.findToBePrepared();

        return transformOrderToDTO(orders);
    }

    private Iterable<ProductOrderDTO> transformOrderToDTO(final Iterable<ProductOrder> orders) {
        return StreamSupport.stream(orders.spliterator(), true)
                .map(ProductOrder::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }
    //===========ORDER STUFF=============


    /**
     * All paid order iterable.
     *
     * @return the iterable
     */
    public Iterable<ProductOrder> allPaidOrder(){
        return orderRepository.findPaidOrder();
    }


    /**
     * All available ag vs iterable.
     *
     * @param orderWeight the order weight
     * @param orderVolume the order volume
     * @return the iterable
     */
//===========AGV STUFF=============
    public Iterable<AGVDTO> allAvailableAGVs(final double orderWeight,final double orderVolume){
        final Iterable<AGV> agvs = agvConfigurationRepository.findAvailable(orderWeight,orderVolume);

        return transformAGVToDTO(agvs);
    }

    private Iterable<AGVDTO> transformAGVToDTO(final Iterable<AGV> agvs) {
        return StreamSupport.stream(agvs.spliterator(), true)
                .map(AGV::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }
    //===========AGV STUFF=============




    //===========GIVE STUFF=============


    /**
     * Grab and save real values agvdto.
     *
     * @param agvId   the agv id
     * @param orderId the order id
     * @return the agvdto
     */
    public AGVDTO grabAndSaveRealValues(String agvId,Long orderId){
        AGV agv= agvConfigurationRepository.findByAGVId(new Id(agvId));
        ProductOrder order= orderRepository.findByOrderId(orderId);
        agv.changeStatusTo(AGV.Status.OCCUPIED_DOING_TASK);
        agv.changeTaskTo(new Task("Preparing Order: " + order.identity()));
        order.changeStatusTo(ProductOrder.Status.BEING_PREPARED);
        agvConfigurationRepository.save(agv);
        orderRepository.save(order);

        return agvConfigurationRepository.findByAGVId(new Id(agvId)).toDTO();
    }








}
