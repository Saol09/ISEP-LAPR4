package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * The type Name.
 */
@Embeddable
public class Name implements ValueObject {
    private String name;

    /**
     * Instantiates a new Name.
     *
     * @param name the name
     */
    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    /**
     * Instantiates a new Name.
     */
    protected Name() {
        // for ORM only
    }

    private void validateName(String name) {
        String[] arrPhrase = name.split(" ");
        if (arrPhrase.length >= 2 && (name.length() > 7 && name.length() < 40))
            this.name = name;
        else throw new IllegalArgumentException("Please input your first and last name (at least).");
    }

    @Override
    public String toString(){
        return this.name;
    }
}
