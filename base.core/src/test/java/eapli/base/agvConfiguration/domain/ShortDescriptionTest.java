package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortDescriptionTest {

    @Test
    void testToString() {
        ShortDescription m = new ShortDescription();
        ShortDescription m2 = new ShortDescription("ze manel dos produtos" );
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        ShortDescription m2 = new ShortDescription("ze manel dos produtos é o");
        String expected = "ze manel dos produtos é o";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToString3() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ShortDescription m2 = new ShortDescription("");
            String expected = "model: ;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Short Description should not be empty and should have max 30 characters", thrown.getMessage());
    }
    @Test
    void testToString4() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ShortDescription m2 = new ShortDescription("12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
            String expected = "model: 12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff;";
            Assertions.assertEquals(m2.toString(), expected);
        });
        Assertions.assertEquals("Short Description should not be empty and should have max 30 characters", thrown.getMessage());
    }
}