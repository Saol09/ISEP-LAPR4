package eapli.base.agvConfiguration.domain;

import eapli.base.orderAGVAssociation.dto.AGVDTO;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

/**
 * The type Agv.
 */
@Entity
@Table
public class AGV implements Comparable<Id>, AggregateRoot<Id> {

    @EmbeddedId
    private Id id;

    @Embedded
    private MaxVolume maxVolume;

    @Embedded
    private MaxWeight maxWeight;

    @Embedded
    private Model model;

    @Embedded
    private Route route;

    @Embedded
    private ShortDescription shortDescription;

    //    @Embedded
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Status status;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private Autonomy autonomy;

    @Embedded
    private Task task;

    @OneToOne(cascade = CascadeType.ALL)
    private AGVDocks agvDocks;

    //@Embedded
   // private Speed speed;

    //@Embedded
    //private Position position;


    /**
     * Instantiates a new Agv.
     */
    protected AGV() {
    }


    /**
     * Instantiates a new Agv.
     *
     * @param id               the id
     * @param maxWeight        the max weight
     * @param maxVolume        the max volume
     * @param model            the model
     * @param route            the route
     * @param shortDescription the short description
     * @param status           the status
     * @param autonomy         the autonomy
     * @param task             the task
     * @param agvDocks         the agv docks
     */
    public AGV(Id id, MaxWeight maxWeight, MaxVolume maxVolume, Model model, Route route, ShortDescription shortDescription, Status status, Autonomy autonomy, Task task, AGVDocks agvDocks) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.model = model;
        this.route = route;
        this.shortDescription = shortDescription;
        this.status = status;
        this.autonomy = autonomy;
        this.task = task;
        this.agvDocks = agvDocks;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Id getId() {
        return id;
    }

    /**
     * Gets agv docks.
     *
     * @return the agv docks
     */
    public synchronized AGVDocks getAgvDocks() {
        return agvDocks;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public synchronized Task getTask() {
        return task;
    }


    /**
     * Gets max volume.
     *
     * @return the max volume
     */
    public MaxVolume getMaxVolume() {
        return maxVolume;
    }

    /**
     * Gets max weight.
     *
     * @return the max weight
     */
    public MaxWeight getMaxWeight() {
        return maxWeight;
    }

    /**
     * Change route to.
     *
     * @param route the route
     */
    public void changeRouteTo(Route route) {
        this.route = route;
    }

    /**
     * Change short description to.
     *
     * @param shortDescription the short description
     */
    public void changeShortDescriptionTo(ShortDescription shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * Change autonomy to.
     *
     * @param autonomy the autonomy
     */
    public void changeAutonomyTo(Autonomy autonomy) {
        this.autonomy = autonomy;
    }

    /**
     * Change status to.
     *
     * @param status the status
     */
    public void changeStatusTo(Status status) {
        this.status = status;
    }

    /**
     * Change task to.
     *
     * @param task the task
     */
    public void changeTaskTo(Task task) {
        this.task = task;
    }

   /* public Speed getSpeed() {
        return speed;
    }

    public void changeSpeed(Speed speed) {
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position position) {
        this.position = position;
    }*/

    /**
     * To dto agvdto.
     *
     * @return the agvdto
     */
    public AGVDTO toDTO() {

        String id = String.valueOf(this.id);
        String autonomy = String.valueOf(this.autonomy);
        String maxVolume = String.valueOf(this.maxVolume);
        String maxWeight = String.valueOf(this.maxWeight);
        String status = String.valueOf(this.status);
        String task = String.valueOf(this.task);
        return new AGVDTO(id, autonomy, maxVolume, maxWeight, status, task);
    }

    /**
     * @return AGV toString
     */
    @Override
    public String toString() {
        return "AGV-> " +
                "id=" + id +
                "\n\tmaxVolume=" + maxVolume +
                "\n\tmaxWeight=" + maxWeight +
                "\n\tmodel=" + model +
                "\n\troute=" + route +
                "\n\tshortDescription=" + shortDescription +
                "\n\tstatus=" + status +
                "\n\tautonomy=" + autonomy +
                "\n\ttask=" + task +
                "\n\tagvDocks=" + agvDocks;
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * @return
     */
    @Override
    public Id identity() {
        return this.id;
    }


    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Occupied charging status.
         */
        OCCUPIED_CHARGING,
        /**
         * Occupied doing task status.
         */
        OCCUPIED_DOING_TASK,
        /**
         * Free status.
         */
        FREE
    }
}
