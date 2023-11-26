package eapli.base.productsCategory.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Description.
 */
@Embeddable
public class Description implements ValueObject {

    private String description;

    /**
     * Instantiates a new Description.
     */
    protected Description() {
    }

    /**
     * Instantiates a new Description.
     *
     * @param text the text
     */
    public Description(String text) {
        validateDescription(text);
        this.description = text;
    }

    private void validateDescription(String text) {

        String regex = "[A-Za-zÇ-ú]{20,50}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(text);

        if(matcherCodeCheck.find() || text.length() < 20 || text.length() > 50)
            throw new IllegalArgumentException("The Description should have between 20-50 letters.");
    }

    @Override
    public String toString() {
        return "Description: " + description + ';';
    }
}
