package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {
    @Test
    void testTValidatePhone() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber m = new PhoneNumber();
            PhoneNumber m2 = new PhoneNumber("13454351");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Invalid Phone Number", thrown.getMessage());
    }
    @Test
    void testTPhone() {
        PhoneNumber m = new PhoneNumber();
        PhoneNumber m2 = new PhoneNumber("978457893");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

}