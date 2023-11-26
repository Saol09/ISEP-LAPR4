package eapli.base.product.domain;

import eapli.base.agvConfiguration.domain.Autonomy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechnicalDescriptionTest {

    @Test
    void testToString() {
        TechnicalDescription m = new TechnicalDescription();
        TechnicalDescription m2 = new TechnicalDescription("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        TechnicalDescription m2 = new TechnicalDescription("5 hours");
        String expected = "TechnicalDescription{5 hours;";
        Assertions.assertEquals( m2.toString(),expected);
    }
    @Test
    void testValidate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TechnicalDescription r = new TechnicalDescription("");
            String expected = "";
            Assertions.assertEquals(r.toString(), expected);
        });
        Assertions.assertEquals("Technical Description should have multiple lines.", thrown.getMessage());

    }
}