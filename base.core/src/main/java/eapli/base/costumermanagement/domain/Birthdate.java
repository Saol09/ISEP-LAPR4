package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The type Birthdate.
 */
@Embeddable
public class Birthdate implements ValueObject {
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    /**
     * Instantiates a new Birthdate.
     *
     * @param birthdate the birthdate
     */
    public Birthdate(String birthdate) {
        if(birthdate != null) {
            try {
                validateData(birthdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Instantiates a new Birthdate.
     */
    protected Birthdate() {
        // for ORM only

    }

    private void validateData(String birthdate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            this.birthdate = formatter.parse(birthdate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date. Should be like: yyyy-MM-dd");
        }
    }
}
