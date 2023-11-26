package eapli.base.orderAGVAssociation.dto;

import eapli.framework.representations.dto.DTO;

import java.util.ArrayList;

/**
 * The type Agvdto.
 */
@DTO
public class AGVDTO {

    /**
     * The Id.
     */
    public String id;
    /**
     * The Autonomy.
     */
    public String autonomy;
    /**
     * The Max volume.
     */
    public String maxVolume;
    /**
     * The Max weight.
     */
    public String maxWeight;
    /**
     * The Status.
     */
    public String status;
    /**
     * The Task.
     */
    public String task;


    /**
     * Instantiates a new Agvdto.
     *
     * @param id        the id
     * @param autonomy  the autonomy
     * @param maxVolume the max volume
     * @param maxWeight the max weight
     * @param status    the status
     * @param task      the task
     */
    public AGVDTO(final String id, final String autonomy,final String maxVolume, final String maxWeight,final String status, final String task) {
        this.id = id;
        this.autonomy = autonomy;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
        this.status = status;
        this.task = task;
    }

    @Override
    public String toString() {
        return "AGV" +
                "\nId= " + id  +
                "\nAutonomy= " + autonomy +
                "\nMaxVolume= " + maxVolume +
                "\nMaxWeight= " + maxWeight +
                "\nStatus= " + status +
                "\nTask= " + task + "\n=================\n";
    }
}
