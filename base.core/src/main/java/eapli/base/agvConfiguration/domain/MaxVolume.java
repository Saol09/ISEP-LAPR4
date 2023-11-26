package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Max volume.
 */
@Embeddable
public class MaxVolume implements ValueObject {

    private double maxVolume;

    /**
     * Instantiates a new Max volume.
     */
    protected MaxVolume() {
    }

    /**
     * Checks if maxVolume follows the correct params
     *
     * @param maxVolume agv maxVolume
     */
    private void checkMaxVolume(double maxVolume) {
        if (maxVolume <= 0)
            throw new IllegalArgumentException("Max Volume cannot be null nor zero");
    }

    /**
     * Instantiates a new Max volume.
     *
     * @param maxVolume agv max volume
     */
    public MaxVolume(double maxVolume) {
        this.maxVolume = maxVolume;
        checkMaxVolume(maxVolume);
    }

    /**
     * Gets max volume.
     *
     * @return the max volume
     */
    public double getMaxVolume() {
        return maxVolume;
    }

    /**
     * @return agv max volume
     */
    @Override
    public String toString() {
        return String.valueOf(this.maxVolume);
    }
}
