package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The type Phone number.
 */
@Embeddable
public class PhoneNumber implements ValueObject {

    private String phoneNumber;

    /**
     * Instantiates a new Phone number.
     */
    protected PhoneNumber() {
        // for ORM only
    }

    /**
     * Instantiates a new Phone number.
     *
     * @param phoneNumber the phone number
     */
    public PhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches())
            throw new IllegalArgumentException("Invalid Phone Number");
    }
}
