package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Email.
 */
@Embeddable
public class Email implements ValueObject {
    private String email;

    /**
     * Instantiates a new Email.
     *
     * @param email the email
     */
    public Email(final String email) {
        validateEmail(email);
        this.email = email;
    }

    /**
     * Instantiates a new Email.
     */
    protected Email() {
        // for ORM only
    }

    private void validateEmail(String email) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.find())
            throw new IllegalArgumentException("Invalid Email Address.");
    }

    @Override
    public String toString() {
        return email;
    }
}
