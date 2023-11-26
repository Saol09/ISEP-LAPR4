package eapli.base.productsCategory.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Alphanumeric code.
 */
@Embeddable
public class AlphanumericCode implements ValueObject, Comparable<AlphanumericCode>{

    private String code;

    /**
     * Instantiates a new Alphanumeric code.
     */
    protected AlphanumericCode(){}

    /**
     * Instantiates a new Alphanumeric code.
     *
     * @param code the code
     */
    public AlphanumericCode(String code){

        validateAlphanumericCode(code);
        this.code = code;
    }

    private void validateAlphanumericCode(String code){

        Pattern pattern = Pattern.compile("[A-Za-zÇ-ú\\d]{1,10}");
        Matcher matcher = pattern.matcher(code);
        if(!matcher.find() || code.length() < 1 || code.length() > 10)
            throw new IllegalArgumentException("The Alphanumeric code should have between 1-10 letters.");
    }

    @Override
    public int compareTo(AlphanumericCode o) {
        return this.code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return "Code: " + code + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlphanumericCode that = (AlphanumericCode) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
