package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * The type Rows.
 */
@Entity
public class Rows implements AggregateRoot<Integer> {

    @EmbeddedId
    private RowsIDs id;


    @Embedded
    private Begin begin;


    @Embedded
    private End end;


    private int shelves;


    /**
     * Instantiates a new Rows.
     */
    public Rows(){

    }

    /**
     * Instantiates a new Rows.
     *
     * @param rowsIDs  the rows i ds
     * @param beginEnd the begin end
     * @param shelves  the shelves
     */
    public Rows(RowsIDs rowsIDs, ArrayList<Long> beginEnd, int shelves){
        this.id = rowsIDs;
        this.begin = new  Begin(Math.toIntExact(beginEnd.get(0)), Math.toIntExact(beginEnd.get(1)));;
        this.end = new End(Math.toIntExact(beginEnd.get(2)), Math.toIntExact(beginEnd.get(3)));
        this.shelves = shelves;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", shelves=" + shelves +
                '}';
    }

    public Begin getBegin() {
        return begin;
    }

    public End getEnd() {
        return end;
    }

    public int getShelves() {
        return shelves;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Integer other) {
        return this.id.compareTo(other);
    }

    @Override
    public synchronized Integer identity() {
        return this.id.getRowID();
    }
}
