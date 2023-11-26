package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void testTValidateBirthdate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Email m = new Email();
            Email m2 = new Email("tfgmail.com");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Invalid Email Address.", thrown.getMessage());
    }
    @Test
    void testTBirthdate() {
        Email m = new Email();
        Email m2 = new Email("tf@gmail.com");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

}