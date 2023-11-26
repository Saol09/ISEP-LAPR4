package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Reference.
 */
@Embeddable
public class Reference implements ValueObject {

    private String reference;

    /**
     * Instantiates a new Reference.
     */
    protected Reference(){}

    /**
     * Instantiates a new Reference.
     *
     * @param reference the reference
     */
    public Reference(String reference){

        this.reference = reference;
        validateReference(reference);
    }

    private void validateReference(String reference){
        String regex = "[A-Za-zÇ-ú\\d]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(reference);

        if (!matcherCodeCheck.find() || (reference.length() <= 0) || (reference.length() > 23))
            throw new IllegalArgumentException("Reference should have maximum 23 letters");
    }

    @Override
    public String toString() {
        return "Reference{" + reference + ";";
    }
}
