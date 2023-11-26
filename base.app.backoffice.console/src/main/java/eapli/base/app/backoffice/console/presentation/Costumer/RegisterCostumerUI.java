package eapli.base.app.backoffice.console.presentation.Costumer;

import eapli.base.costumermanagement.application.RegisterCostumerController;
import eapli.base.costumermanagement.domain.*;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

public class RegisterCostumerUI extends AbstractUI {

    private final RegisterCostumerController controller = new RegisterCostumerController();

    @Override
    protected boolean doShow() {
        String name = null, phoneNumber = null, username=null, password=null, vat = null, email = null, streetName, postalCode, city, country, birthdate = null;
        int choiceGender = 3, choiceAddress, choiceMoreAddresses, choiceBirthdate, choice, gender = 0, doorNumber;
        boolean flag = true;
        Set<Address> addresses = null;

        while (flag) {
            name = Console.readLine("Insert your full name.");
            phoneNumber = Console.readLine("Insert your phone number.");
            vat = Console.readLine("Insert your VAT.");
            email = Console.readLine("Insert your email address.");
            while (true) {
                choiceGender = Console.readInteger("Do you want to insert your gender? \n 1 -> Yes \n 2 -> No");
                if (choiceGender == 1 || choiceGender == 2)
                    break;
            }

            if (choiceGender == 1)
                while (true) {
                    gender = Console.readInteger("1 -> Female \n 2 -> Male \n 3 -> Other");
                    if (gender == 1 | gender == 2 || gender == 3)
                        break;
                }


            while (true) {
                while (true) {
                    choiceAddress = Console.readInteger("Do you want to insert an address? \n 1 -> Yes \n 2 -> No");
                    if (choiceAddress == 1 | choiceAddress == 2)
                        break;
                }
                if (choiceAddress == 1) {
                    streetName = Console.readLine("Insert your street name.");
                    postalCode = Console.readLine("Insert your postal code.");
                    city = Console.readLine("Insert your city.");
                    country = Console.readLine("Insert your country.");
                    doorNumber = Console.readInteger("Insert your door number");


                    addresses.add(new Address(streetName, doorNumber, postalCode, city, country));
                    choiceMoreAddresses = Console.readInteger("Do you want to insert more addresses? \n 1 -> Yes \n 2 -> No");
                    if (choiceMoreAddresses == 2)
                        break;
                }
                break;
            }

            while (true) {
                choiceBirthdate = Console.readInteger("Do you want to insert your birthday? \n 1 -> Yes \n 2 -> No");
                if (choiceBirthdate == 1 || choiceBirthdate == 2)
                    break;
            }
            if (choiceBirthdate == 1)
                birthdate = Console.readLine("Insert your birthdate in formay yyyy-MM-dd.");

            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("VAT: " + vat);
            System.out.println("Email: " + email);

            if (choiceGender == 1)
                System.out.println("Gender: " + gender);
            if (choiceAddress == 1)
                for (Address ad : addresses)
                    System.out.println(ad.toString());
            if (choiceBirthdate == 1)
                System.out.println("Birthdate: " + birthdate);

            choice = Console.readInteger("Do Confirm this data? \n 1 -> Yes \n 2 -> No");
            if (choice == 1)
                flag = false;

            username = Console.readLine("What's the username of the customer?");
            password = Console.readLine("What's the password?");

        }
        controller.registerCostumer(new Name(name), new PhoneNumber(phoneNumber), new VAT(vat), new Email(email),
                addresses, new Gender(gender), new Birthdate(birthdate), username, password, (Set<Role>) BaseRoles.CLIENT_USER);
        return true;
    }

    @Override
    public String headline() {
        return "Register a new Costumer";
    }
}
