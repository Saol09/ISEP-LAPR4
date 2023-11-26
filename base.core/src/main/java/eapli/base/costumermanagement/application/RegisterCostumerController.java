package eapli.base.costumermanagement.application;

import eapli.base.costumermanagement.domain.*;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.Set;

/**
 * The type Register costumer controller.
 */
public class RegisterCostumerController {
    private final CostumerRepository repoCostumer = PersistenceContext.repositories().costumerRepository();

    private final AddUserController user = new AddUserController();


    /**
     * Became system user.
     *
     * @param costumer  the costumer
     * @param username  the username
     * @param password  the password
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param email     the email
     * @param roless    the roless
     */
    public void becameSystemUser(Costumer costumer, String username, String password, String firstname, String lastname, String email, Set<Role> roless){
        costumer.becameSystemUser(user.addUser(username,password,firstname,lastname,email, roless));
    }

    /**
     * Register costumer costumer.
     *
     * @param name        the name
     * @param phoneNumber the phone number
     * @param vat         the vat
     * @param email       the email
     * @param addresses   the addresses
     * @param gender      the gender
     * @param birthdate   the birthdate
     * @param username    the username
     * @param password    the password
     * @param roless      the roless
     * @return the costumer
     */
    public Costumer registerCostumer(final Name name, final PhoneNumber phoneNumber, final VAT vat, final Email email,
                                     Set<Address> addresses, final Gender gender, final Birthdate birthdate,
                                     String username, String password, Set<Role> roless) {

        Costumer costumer = new CostumerBuilder().named(name)
                                    .withPhoneNumber(phoneNumber)
                                    .withVat(vat).withEmail(email)
                                    .withAddresses(addresses)
                                    .withGender(gender)
                                    .withBirthdate(birthdate)
                                    .build();

        becameSystemUser(costumer,username,password, name.toString(),name.toString(),email.toString(),roless);
        return repoCostumer.save(costumer);
    }
}
