package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * The type Agv docks.
 */
@Entity
public class AGVDocks implements AggregateRoot<IDagvDocks>, Comparable<IDagvDocks> {

    @EmbeddedId
    private IDagvDocks id;

    @Embedded
    private Begin begin;
    @Embedded
    private End end;
    @Embedded
    private Depth depth;

    @Embedded
    private Accessibility accessibility;


    /**
     * Instantiates a new Agv docks.
     */
    public AGVDocks(){

    }


    /**
     * Instantiates a new Agv docks.
     *
     * @param id            the id
     * @param beginEndDepth the begin end depth
     * @param accessibility the accessibility
     */
    public AGVDocks(IDagvDocks id, ArrayList<Long> beginEndDepth, Accessibility accessibility){
        this.id=id;
        this.begin=new Begin(Math.toIntExact(beginEndDepth.get(0)), Math.toIntExact(beginEndDepth.get(1)));
        this.end= new End(Math.toIntExact(beginEndDepth.get(2)), Math.toIntExact(beginEndDepth.get(3)));
        this.depth=new Depth(Math.toIntExact(beginEndDepth.get(4)), Math.toIntExact(beginEndDepth.get(5)));
        this.accessibility=accessibility;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public synchronized IDagvDocks getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AGVDocks{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
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
     * Gets end.
     *
     * @return the end
     */
    public End getEnd() {
        return end;
    }

    /**
     * Gets depth.
     *
     * @return the depth
     */
    public Depth getDepth() {
        return depth;
    }

    @Override
    public int compareTo(IDagvDocks other) {
        return this.id.compareTo(other);
    }

    @Override
    public IDagvDocks identity() {
        return null;
    }
}
