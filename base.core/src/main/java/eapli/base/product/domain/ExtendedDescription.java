package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Extended description.
 */
@Embeddable
public class ExtendedDescription implements ValueObject {

    private String extendedDescription;

    /**
     * Instantiates a new Extended description.
     */
    protected ExtendedDescription(){}

    /**
     * Instantiates a new Extended description.
     *
     * @param extendedDescription the extended description
     */
    public ExtendedDescription(String extendedDescription){

        this.extendedDescription = extendedDescription;
        validateExtendedDescription(extendedDescription);
    }

    private void validateExtendedDescription(String extendedDescription){

        String regex = "[A-Za-zÇ-ú\\d]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(extendedDescription);

        if (!matcherCodeCheck.find() || (extendedDescription.length() <= 20 || extendedDescription.length() >= 100))
            throw new IllegalArgumentException("Extended Description should not be empty and should have between 20 and 100 characters");
    }

    @Override
    public String toString() {
        return "ExtendedDescription{" + extendedDescription + ";";
    }
}
