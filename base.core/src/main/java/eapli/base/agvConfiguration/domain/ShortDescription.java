package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Short description.
 */
@Embeddable
public class ShortDescription implements ValueObject {

    private String shortDescription;

    /**
     * Instantiates a new Short description.
     */
    protected ShortDescription() {
    }

    /**
     * Instantiates a new Short description.
     *
     * @param shortDescription agv shortDescription
     */
    public ShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        checkShortDescription(shortDescription);
    }

    /**
     * checks if shortDescription follows the correct params
     *
     * @param shortDescription agv shortDescription
     */
    private void checkShortDescription(String shortDescription) {
        String regex = "[A-Za-zÇ-ú0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(shortDescription);

        if (!matcherCodeCheck.find() || (shortDescription.length() <= 0 || shortDescription.length() >= 30))
            throw new IllegalArgumentException("Short Description should not be empty and should have max 30 characters");
    }

    /**
     * @return agv shortDescription
     */
    @Override
    public String toString() {
        return shortDescription;
    }
}
