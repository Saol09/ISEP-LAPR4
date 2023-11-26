package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * The type End.
 */
@Embeddable
public class End implements ValueObject {
    private int lSquare;
    private int wSquare;

    /**
     * Instantiates a new End.
     */
    protected End(){}

    /**
     * Instantiates a new End.
     *
     * @param lSquare the l square
     * @param wSquare the w square
     */
    public End(int lSquare,int wSquare){


        this.lSquare=lSquare;

        this.wSquare=wSquare;
    }

    /**
     * Gets square.
     *
     * @return the square
     */
    public int getlSquare() {
        return lSquare;
    }

    /**
     * Gets square.
     *
     * @return the square
     */
    public int getwSquare() {
        return wSquare;
    }

    /**
     * Sets square.
     *
     * @param lSquare the l square
     */
    public void setlSquare(int lSquare) {
        this.lSquare = lSquare;
    }

    /**
     * Sets square.
     *
     * @param wSquare the w square
     */
    public void setwSquare(int wSquare) {
        this.wSquare = wSquare;
    }

    @Override
    public String toString() {
        return "Depth{" +
                "lSquare=" + lSquare +
                ", wSquare=" + wSquare +
                '}';
    }
}
