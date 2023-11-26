package eapli.base.product.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceTest {

    @Test
    void testToString() {
        Reference m = new Reference();
        Reference m2 = new Reference("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Reference m2 = new Reference("5 hours");
        String expected = "Reference{5 hours;";
        Assertions.assertEquals(m2.toString(), expected);
    }

    @Test
    void testValidate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Reference r = new Reference("");
            String expected = "";
            Assertions.assertEquals(r.toString(), expected);
        });
        Assertions.assertEquals("Reference should have maximum 23 letters", thrown.getMessage());

    }
}