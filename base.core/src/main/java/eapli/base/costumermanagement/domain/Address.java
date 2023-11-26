package eapli.base.costumermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Address.
 */
@Embeddable
public class Address implements ValueObject {

    private String streetName;
    private int doorNumber;
    private String postalCode;
    private String city;
    private String country;

    /**
     * Instantiates a new Address.
     */
    protected Address() {
        // for ORM only
    }

    /**
     * Instantiates a new Address.
     *
     * @param streetName the street name
     * @param doorNumber the door number
     * @param postalCode the postal code
     * @param city       the city
     * @param country    the country
     */
    public Address(String streetName, int doorNumber, String postalCode, String city, String country) {
        Preconditions.noneNull(streetName, doorNumber, postalCode, city, country);
        validatePostalCode(postalCode);
        validateDoorNumber(doorNumber);
        this.streetName = streetName;
        this.doorNumber = doorNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    private void validatePostalCode(String postalCode) {
        Pattern pattern = Pattern.compile("\\d{4}-\\d{3}");
        Matcher matcher = pattern.matcher(postalCode);
        if (!matcher.find() || postalCode.length() != 8)
            throw new IllegalArgumentException("Postal code is not correct");
    }

    private void validateDoorNumber(int doorNumber) {
        if (doorNumber < 0)
            throw new IllegalArgumentException("Door number can not be negative.");
    }

    @Override
    public String toString() {
        return "Address: " +
                "\n\tStreetName: " + streetName +
                "\n\tDoor number: " + doorNumber +
                "\n\tPostal Code:" + postalCode +
                "\n\tCity: " + city +
                "\n\tCountry='" + country + "\n";
    }
}
