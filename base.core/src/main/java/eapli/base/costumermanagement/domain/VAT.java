package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Vat.
 */
@Embeddable

public class VAT implements ValueObject {
    private String vat;

    /**
     * Instantiates a new Vat.
     */
    protected VAT() {
        // for ORM only
    }

    /**
     * Instantiates a new Vat.
     *
     * @param vat the vat
     */
    public VAT(String vat) {
        validateVat(vat);
        this.vat = vat;
    }

    private void validateVat(String vat) {
        String patterns = "^((AT)?U[0-9]{8}|(BE)?0[0-9]{9}|(BG)?[0-9]{9,10}|" +
                "(CY)?[0-9]{8}L|(CZ)?[0-9]{8,10}|(DE)?[0-9]{9}|(DK)?[0-9]{8}|" +
                "(EE)?[0-9]{9}|(EL|GR)?[0-9]{9}|(ES)?[0-9A-Z][0-9]{7}[0-9A-Z]|(FI)?[0-9]{8}|" +
                "(FR)?[0-9A-Z]{2}[0-9]{9}|(GB)?([0-9]{9}([0-9]{3})?|[A-Z]{2}[0-9]{3})|(HU)?[0-9]{8}|" +
                "(IE)?[0-9]S[0-9]{5}L|(IT)?[0-9]{11}|(LT)?([0-9]{9}|[0-9]{12})|(LU)?[0-9]{8}|(LV)?[0-9]{11}|" +
                "(MT)?[0-9]{8}|(NL)?[0-9]{9}B[0-9]{2}|(PL)?[0-9]{10}|(PT)?[0-9]{9}|(RO)?[0-9]{2,10}|(SE)?[0-9]{12}|" +
                "(SI)?[0-9]{8}|(SK)?[0-9]{10})$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(vat);
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid VAT.");
    }
}
