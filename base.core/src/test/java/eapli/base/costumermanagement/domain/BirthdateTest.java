package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthdateTest {
    @Test
    void testTValidateBirthdate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Birthdate m = new Birthdate();
            Birthdate m2 = new Birthdate("22-45-54");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Invalid date. Should be like: yyyy-MM-dd", thrown.getMessage());
    }
    @Test
    void testTBirthdate() {
            Birthdate m = new Birthdate();
            Birthdate m2 = new Birthdate("2222-01-28");
            Assertions.assertNotEquals(m.toString(), m2.toString());
    }

}