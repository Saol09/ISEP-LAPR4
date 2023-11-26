package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Accessibility.
 */
@Embeddable
public class Accessibility implements ValueObject {

    private String access;

    /**
     * Instantiates a new Accessibility.
     */
    public Accessibility(){}

    /**
     * Instantiates a new Accessibility.
     *
     * @param access the access
     */
    public Accessibility(String access){
        validateAlphanumericCode(access);
        this.access=access;
    }

    public String getAccess() {
        return access;
    }

    private void validateAlphanumericCode(String access){

        Pattern pattern = Pattern.compile("[l|w][+|-]");
        Matcher matcher = pattern.matcher(access);
        if(!matcher.find() || access.length() != 2)
            throw new IllegalArgumentException("Invalid accessibility there are only [ l+ | l- | w+ | w- ]");
    }


    @Override
    public String toString() {
        return this.access;
    }


}
