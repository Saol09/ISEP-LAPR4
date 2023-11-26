package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Speed implements ValueObject, Comparable<Speed> {

    private static final int MAX_VELOCITY = 2;

    private int velocity;

    protected Speed() {

    }

    public Speed(int velocity) {
        setVelocity(velocity);
    }

    public int getVelocity() {
        return this.velocity;
    }

    private void setVelocity(int velocity) {
        if (velocity > 0 && velocity <= MAX_VELOCITY)
            this.velocity = velocity;
        else
            throw new IllegalArgumentException("Invalid Velocity");
    }

    @Override
    public String toString() {
        return "Speed{" +
                "velocity=" + velocity +
                '}';
    }

    @Override
    public int compareTo(Speed o) {
        return 0;
    }
}
