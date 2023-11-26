package eapli.base.agvConfiguration.domain;

import eapli.base.agvManager.application.AGVManagerController;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productOrderManagement.domain.ProductOrder;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Task.
 */
@Embeddable
public class Task {

    private String task;

    @ElementCollection
    private Set<Item> items;


    /**
     * Instantiates a new task.
     */
    protected Task() {
    }

    /**
     * Instantiates a new Route.
     *
     * @param task agv task
     */
    public  Task(String task) {
        this.task = task;
    }

    /**
     * Instantiates a new Task.
     *
     * @param items the items
     */
    public Task(Set<Item> items) {
        this.items = items;
    }

    /**
     * @return agv task
     */
    @Override
    public String toString() {
        return this.task;
    }

}
