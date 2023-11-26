package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Internal code.
 */
@Embeddable
public class InternalCode implements ValueObject, Comparable<InternalCode> {

    private String internalCode;

    /**
     * Instantiates a new Internal code.
     */
    protected InternalCode(){}

    /**
     * Instantiates a new Internal code.
     *
     * @param internalCode the internal code
     */
    public InternalCode(String internalCode){

        this.internalCode = internalCode;
        validateAlphaCode(internalCode);
    }

    private void validateAlphaCode(String internalCode){

        Pattern pattern = Pattern.compile("[A-Za-zÇ-ú\\d]");
        Matcher matcher = pattern.matcher(internalCode);
        if(!matcher.find() || internalCode.length() <= 0 || internalCode.length() > 23)
            throw new IllegalArgumentException("The Internal Code code should have between 1-23 letters.");
    }

    @Override
    public String toString() {
        return internalCode + " ;";
    }


    @Override
    public int compareTo(InternalCode o) {
        return this.internalCode.compareTo(o.internalCode);
    }
}
