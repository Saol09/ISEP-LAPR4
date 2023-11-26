package eapli.base.agvManager.application;

import eapli.base.agvConfiguration.application.AGVConfigurationController;
import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Task;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.agvManager.domain.TaskTimer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.orderAGVAssociation.application.GiveOrderToAGVService;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;

import java.util.*;

/**
 * The type Agv manager controller.
 */
public class AGVManagerController {

    /**
     * The My q.
     */
    Queue<ProductOrder> myQ = new LinkedList<ProductOrder>();
    /**
     * The Ctr.
     */
    AGVConfigurationController ctr = new AGVConfigurationController();
    /**
     * The Services.
     */
    GiveOrderToAGVService services = new GiveOrderToAGVService();
    private final AGVConfigurationRepository repoAGV = PersistenceContext.repositories().agvConfigurationRepository();
    private final ProductOrderRepository repoProductOrder = PersistenceContext.repositories().productOrderRepository();

    private List<TaskTimer> currentTasks = new LinkedList<>();


    private Iterable<AGV> findAllAGV() {
        return ctr.findAllAGV();
    }

    private void findAllOrders() {
        LinkedList<ProductOrder> listOfOrders = new LinkedList<>();
        services.allPaidOrder().forEach(productOrder -> {
            if (!myQ.contains(productOrder)) {
                listOfOrders.add(productOrder);
            }
        });

        listOfOrders.sort(Comparator.comparing(ProductOrder::getRegisterDate));
        myQ.addAll(listOfOrders);
    }

    private void allAGVs() {
        for (AGV agv : findAllAGV()) {
            addTaskToAgv(agv);
        }
    }

    private void allTasks() {
        for (TaskTimer taskTimer : currentTasks) {
            taskTimer.addTime();
            if (taskTimer.checkFinished()) {
                System.out.println("The AGV has ended his Task.");
                currentTasks.remove(taskTimer);
            }
        }
    }

    /**
     * Main loop.
     */
    public void mainLoop() {
        Thread t1 = new Thread(() -> {
            while (true) {
                findAllOrders();
                allAGVs();
                allTasks();
            }
        });
        t1.start();
    }


    private void addTaskToAgv(AGV agv) {
        if (myQ.isEmpty()) {
            System.out.println("There is no new Product Orders.");
            return;
        }
        if (!agv.getStatus().equals(AGV.Status.FREE)) {
            return;
        }
        ProductOrder productOrder = ((LinkedList<ProductOrder>) myQ).getFirst();
        if (productOrder.getStatus() != ProductOrder.Status.PAID) {
            return;
        }
        if (agv.getMaxVolume().getMaxVolume() < productOrder.getOrderVolume() ||
                agv.getMaxWeight().getMaxWeight() < productOrder.getOrderWeight()) {
            return;
        }

        //if paid goes to be prepared
        productOrder.changeStatusTo(ProductOrder.Status.TO_BE_PREPARED);
        Task task = new Task(Objects.requireNonNull(myQ.poll()).getItems());
        TaskTimer taskTimer = new TaskTimer(agv, productOrder);
        agv.changeTaskTo(task);
        agv.changeStatusTo(AGV.Status.OCCUPIED_DOING_TASK);
        productOrder.changeStatusTo(ProductOrder.Status.BEING_PREPARED);
        currentTasks.add(taskTimer);
        repoProductOrder.save(productOrder);
        repoAGV.save(agv);
        System.out.println("The AGV will start now his Task.");
    }

}
