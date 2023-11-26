package eapli.base.agvManager.domain;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Task;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.repositories.ProductOrderRepository;

/**
 * The type Task timer.
 */
public class TaskTimer {
    private AGV agv;
    private ProductOrder productOrder;
    private final AGVConfigurationRepository repoAGV = PersistenceContext.repositories().agvConfigurationRepository();
    private final ProductOrderRepository repoProductOrder = PersistenceContext.repositories().productOrderRepository();


    private long minute = 1000;
    private long start = System.currentTimeMillis();
    private long time = 0;

    /**
     * Instantiates a new Task timer.
     *
     * @param agv          the agv
     * @param productOrder the product order
     */
    public TaskTimer(AGV agv, ProductOrder productOrder) {
        this.agv = agv;
        this.productOrder = productOrder;
    }

    /**
     * Add time.
     */
    public void addTime() {
        time = System.currentTimeMillis() - start;
    }

    /**
     * Check finished boolean.
     *
     * @return the boolean
     */
    public boolean checkFinished() {
        if (time >= minute / 6) {
            agv.changeTaskTo(new Task("No Task"));
            agv.changeStatusTo(AGV.Status.FREE);
            productOrder.changeStatusTo(ProductOrder.Status.PREPARED);
            repoProductOrder.save(productOrder);
            repoAGV.save(agv);
            return true;
        }
        return false;
    }
}
