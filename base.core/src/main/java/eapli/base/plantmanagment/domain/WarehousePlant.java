package eapli.base.plantmanagment.domain;


import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Warehouse plant.
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONE)
public class WarehousePlant implements AggregateRoot<String>, Comparable<String> {

    @Id
    private String warehouse;
    private long length;
    private long width;
    private long square;

    @Embedded
    private Unit unit;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aisle> aisle= new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<AGVDocks> agvDocks= new ArrayList<>();

    /**
     * Instantiates a new Warehouse plant.
     */
    public WarehousePlant() {

    }

    /**
     * Instantiates a new Warehouse plant.
     *
     * @param warehouse the warehouse
     * @param length    the length
     * @param width     the width
     * @param square    the square
     * @param unit      the unit
     * @param aisles    the aisles
     * @param agvDocks  the agv docks
     */
    public WarehousePlant(String warehouse,long length,long width,long square,Unit unit,List<Aisle> aisles, List<AGVDocks> agvDocks) {

        this.warehouse=warehouse;

        this.length=length;

        this.width=width;

        this.square=square;

        this.unit = unit;

        this.aisle=aisles;

        this.agvDocks=agvDocks;
    }
    @Override
    public String toString() {
        return "WarehousePlant{" +
                "\nwarehouse='" + warehouse + '\'' +
                ", \nlength=" + length +
                ", \nwidth=" + width +
                ", \nsquare=" + square +
                ", \nunit=" + unit +
                ", \naisle=" + aisle +
                ", \nagvDocks=" + agvDocks +
                '}';
    }

    /**
     * Get agv docks list.
     *
     * @return the list
     */
    public List<AGVDocks> getAGVDocks(){
        return agvDocks;
    }

    /**
     * Gets aisle.
     *
     * @return the aisle
     */
    public synchronized List<Aisle> getAisle() {
        return aisle;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }


    /**
     * Gets length.
     *
     * @return the length
     */
    public long getLength() {
        return length;
    }

    /**
     * Gets square.
     *
     * @return the square
     */
    public long getSquare() {
        return square;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public long getWidth() {
        return width;
    }

    @Override
    public int compareTo(String other) {
        return this.warehouse.compareTo(other);
    }

    @Override
    public String identity() {
        return this.warehouse;
    }
}
