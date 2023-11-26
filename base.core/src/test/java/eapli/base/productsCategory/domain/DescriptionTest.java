package eapli.base.productsCategory.domain;

import eapli.base.agvConfiguration.domain.ShortDescription;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescriptionTest {

    @Test
    void testToDifferentDescriptions() {
        Description m = new Description();
        Description m2 = new Description("ze manel dos produtos" );
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString() {
        Description m2 = new Description("ze manel dos produtos é o");
        String expected = "Description: ze manel dos produtos é o;";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToDescriptionWithLessLettersThanAllowed() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Description m2 = new Description("");
            String expected = "model: ;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("The Description should have between 20-50 letters.", thrown.getMessage());
    }

    @Test
    void testToDescriptionWithMoreLettersThanAllowed() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Description m2 = new Description("12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
            String expected = "model: 12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff;";
            Assertions.assertEquals(m2.toString(), expected);
        });
        Assertions.assertEquals("The Description should have between 20-50 letters.", thrown.getMessage());
    }


}
