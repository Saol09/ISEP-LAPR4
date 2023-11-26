package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * The type Depth.
 */
@Embeddable
public class Depth implements ValueObject {
    private int lSquared;
    private int wSquared;

    /**
     * Instantiates a new Depth.
     */
    protected Depth(){}

    /**
     * Instantiates a new Depth.
     *
     * @param lSquared the l squared
     * @param wSquared the w squared
     */
    public Depth(int lSquared, int wSquared){


        this.lSquared = lSquared;

        this.wSquared = wSquared;
    }

    /**
     * Gets squared.
     *
     * @return the squared
     */
    public int getlSquared() {
        return lSquared;
    }

    /**
     * Sets squared.
     *
     * @param lSquared the l squared
     */
    public void setlSquared(int lSquared) {
        this.lSquared = lSquared;
    }

    /**
     * Gets squared.
     *
     * @return the squared
     */
    public int getwSquared() {
        return wSquared;
    }

    /**
     * Sets squared.
     *
     * @param wSquared the w squared
     */
    public void setwSquared(int wSquared) {
        this.wSquared = wSquared;
    }

    @Override
    public String toString() {
        return "Depth{" +
                "lSquare=" + lSquared +
                ", wSquare=" + wSquared +
                '}';
    }
}
