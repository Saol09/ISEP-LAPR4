package eapli.base.agvConfiguration.domain;

import eapli.base.common.util.Pair;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Position implements ValueObject, Comparable<Position> {

    private int xPos;
    private int yPos;

    protected Position() {

    }

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public synchronized int getxPos() {
        return xPos;
    }

    public synchronized void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public synchronized int getyPos() {
        return yPos;
    }

    public synchronized void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Pair<Integer, Integer> coordinates() {
        return new Pair<>(this.xPos, this.yPos);
    }

    @Override
    public int compareTo(Position o) {
        return 0;
    }
}
