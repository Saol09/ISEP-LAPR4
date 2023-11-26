package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.util.List;
import java.util.Set;


/**
 * The type Costumer builder.
 */
public class CostumerBuilder implements DomainFactory<Costumer> {

    private Costumer costumer;
    private Name name;
    private PhoneNumber phoneNumber;
    private VAT vat;
    private Email email;


    /**
     * Named costumer builder.
     *
     * @param name the name
     * @return the costumer builder
     */
    public CostumerBuilder named(final Name name) {
        this.name = name;
        return this;
    }

    /**
     * With phone number costumer builder.
     *
     * @param phoneNumber the phone number
     * @return the costumer builder
     */
    public CostumerBuilder withPhoneNumber(final PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * With vat costumer builder.
     *
     * @param vat the vat
     * @return the costumer builder
     */
    public CostumerBuilder withVat(final VAT vat) {
        this.vat = vat;
        return this;
    }

    /**
     * With email costumer builder.
     *
     * @param email the email
     * @return the costumer builder
     */
    public CostumerBuilder withEmail(final Email email) {
        this.email = email;
        return this;
    }

    private Costumer buildOrThrow() {
        if (costumer != null) {
            return costumer;
        } else if (name != null
                && phoneNumber != null
                && vat != null
                && email != null) {

            costumer = new Costumer(name, phoneNumber, vat, email);
            return costumer;
        } else {
            throw new IllegalStateException();
        }
    }


    /**
     * With gender costumer builder.
     *
     * @param gender the gender
     * @return the costumer builder
     */
    public CostumerBuilder withGender(final Gender gender) {
        buildOrThrow();
        if(gender != null)
            costumer.changeGender(gender);
        return this;
    }

    /**
     * With birthdate costumer builder.
     *
     * @param birthdate the birthdate
     * @return the costumer builder
     */
    public CostumerBuilder withBirthdate(final Birthdate birthdate) {
        buildOrThrow();
        if(birthdate != null)
            costumer.changeBirthdate(birthdate);
        return this;
    }

    /**
     * With addresses costumer builder.
     *
     * @param addresses the addresses
     * @return the costumer builder
     */
    public CostumerBuilder withAddresses(final Set<Address> addresses) {
        buildOrThrow();
        if(addresses != null)
            costumer.addAddresses(addresses);
        return this;
    }

    @Override
    public Costumer build() {
        final Costumer ret = buildOrThrow();
        costumer = null;
        return ret;
    }
}
