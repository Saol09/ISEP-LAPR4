package eapli.base.costumermanagement.domain;

import eapli.base.agvConfiguration.domain.Autonomy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testToString() {
        Address m = new Address();
        Address m2 = new Address("rua da coibes",5,"4754-847","porto","portugal");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Address m2 = new Address("rua da coibes",5,"4754-847","porto","portugal");
        String expected = "Address: \n" +
                "\tStreetName: rua da coibes\n" +
                "\tDoor number: 5\n" +
                "\tPostal Code:4754-847\n" +
                "\tCity: porto\n" +
                "\tCountry='portugal\n";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testTValidatePostalCode() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Address m = new Address();
        Address m2 = new Address("rua da coibes",5,"4754-87","porto","portugal");
        Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Postal code is not correct", thrown.getMessage());
    }
    @Test
    void testTValidateSDoor() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Address m = new Address();
        Address m2 = new Address("rua da coibes",-5,"4754-874","porto","portugal");
        Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Door number can not be negative.", thrown.getMessage());
    }
}