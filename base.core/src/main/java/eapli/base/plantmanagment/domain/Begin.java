package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * The type Begin.
 */
@Embeddable
public class Begin implements ValueObject {

    private int lSquareb;
    private int wSquareb;

    /**
     * Instantiates a new Begin.
     */
    protected Begin(){}

    /**
     * Instantiates a new Begin.
     *
     * @param lSquareb the l squareb
     * @param wSquareb the w squareb
     */
    public Begin(int lSquareb, int wSquareb){


        this.lSquareb = lSquareb;

        this.wSquareb = wSquareb;
    }

    /**
     * Sets squareb.
     *
     * @param lSquareb the l squareb
     */
    public void setlSquareb(int lSquareb) {
        this.lSquareb = lSquareb;
    }

    /**
     * Sets squareb.
     *
     * @param wSquareb the w squareb
     */
    public void setwSquareb(int wSquareb) {
        this.wSquareb = wSquareb;
    }

    /**
     * Gets squareb.
     *
     * @return the squareb
     */
    public int getlSquareb() {
        return lSquareb;
    }

    /**
     * Gets squareb.
     *
     * @return the squareb
     */
    public int getwSquareb() {
        return wSquareb;
    }

    @Override
    public String toString() {
        return "Begin{" +
                "lSquare=" + lSquareb +
                ", wSquare=" + wSquareb +
                '}';
    }
}
