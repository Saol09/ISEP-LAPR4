package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The type Costumer.
 */
@Entity
public class Costumer implements AggregateRoot<Long>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Name name;

    private PhoneNumber phoneNumber;

    private VAT vat;

    private Email email;

    @ElementCollection
    private Set<Address> addresses;

    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Birthdate birthdate;

    @OneToOne
    private SystemUser systemUser;

    /**
     * Instantiates a new Costumer.
     *
     * @param name        the name
     * @param phoneNumber the phone number
     * @param vat         the vat
     * @param email       the email
     */
    public Costumer(final Name name, final PhoneNumber phoneNumber, final VAT vat, final Email email) {
        Preconditions.noneNull(name, phoneNumber, vat, email);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vat = vat;
        this.email = email;
    }

    /**
     * Instantiates a new Costumer.
     */
    protected Costumer() {
        // for ORM only
    }

    /**
     * Became system user.
     *
     * @param sysUser the sys user
     */
    public void becameSystemUser(SystemUser sysUser){
        this.systemUser = sysUser;
    }


    /**
     * Change gender.
     *
     * @param gender the gender
     */
    public void changeGender(final Gender gender) {
        this.gender = gender;
    }

    /**
     * Change birthdate.
     *
     * @param birthdate the birthdate
     */
    public void changeBirthdate(final Birthdate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Add addresses.
     *
     * @param addresses the addresses
     */
    public void addAddresses(final Set<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * View name name.
     *
     * @return the name
     */
    public Name viewName(){return this.name;}

    /**
     * Gets email.
     *
     * @return the email
     */
    public Email getEmail() {
        return email;
    }



    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
