package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * The type Max weight.
 */
@Embeddable
public class MaxWeight implements ValueObject {
    private double maxWeight;

    /**
     * Instantiates a new Max weight.
     */
    protected MaxWeight() {
    }

    /**
     * Checks if maxWeight follows the correct params
     *
     * @param maxWeight agv maxWeight
     */
    private void checkMaxWeight(double maxWeight) {
        if (maxWeight <= 0)
            throw new IllegalArgumentException("Max Weight cannot be null nor zero");
    }

    /**
     * Instantiates a new Max weight.
     *
     * @param maxWeight agv max weight
     */
    public MaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
        checkMaxWeight(maxWeight);
    }

    /**
     * Gets max weight.
     *
     * @return the max weight
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * @return agv max weight
     */
    @Override
    public String toString() {
        return String.valueOf(this.maxWeight);
    }
}
