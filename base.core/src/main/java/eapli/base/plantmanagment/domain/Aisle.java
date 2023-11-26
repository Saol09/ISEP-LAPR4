package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Aisle.
 */
@Entity
public class Aisle implements AggregateRoot<Integer> {

    @Id
    private Integer id;


    @Embedded
    private Begin begin;


    @Embedded
    private End end;


    @Embedded
    private Depth depth;


    @Embedded
    private Accessibility accessibility;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Rows> rows = new ArrayList<>();


    /**
     * Instantiates a new Aisle.
     */
    public Aisle(){

    }

    /**
     * Instantiates a new Aisle.
     *
     * @param id            the id
     * @param beginEndDepth the begin end depth
     * @param accessibility the accessibility
     * @param rows          the rows
     */
    public Aisle(Integer id,ArrayList<Long> beginEndDepth,Accessibility accessibility,List<Rows> rows){

        this.id=id;
        this.begin=new Begin(Math.toIntExact(beginEndDepth.get(0)), Math.toIntExact(beginEndDepth.get(1)));
        this.end= new End(Math.toIntExact(beginEndDepth.get(2)), Math.toIntExact(beginEndDepth.get(3)));
        this.depth=new Depth(Math.toIntExact(beginEndDepth.get(4)), Math.toIntExact(beginEndDepth.get(5)));
        this.accessibility=accessibility;
        this.rows= rows;

    }


    public Accessibility getAccessibility() {
        return accessibility;
    }

    /**
     * Gets begin.
     *
     * @return the begin
     */
    public Begin getBegin() {
        return begin;
    }

    /**
     * Gets depth.
     *
     * @return the depth
     */
    public Depth getDepth() {
        return depth;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public End getEnd() {
        return end;
    }


    public synchronized List<Rows> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "Aisle{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                ", row=" + rows +
                '}';
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
        return this.id;
    }
}
