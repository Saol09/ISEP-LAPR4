package eapli.base.product.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedDescriptionTest {

    @Test
    void testToString() {
        ExtendedDescription m = new ExtendedDescription();
        ExtendedDescription m2 = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
    @Test
    void testValidate() {  IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        ExtendedDescription m = new ExtendedDescription();
        ExtendedDescription m2 = new ExtendedDescription("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString()); });
        Assertions.assertEquals("Extended Description should not be empty and should have between 20 and 100 characters", thrown.getMessage());

    }

    @Test
    void testToString2() {
        ExtendedDescription m2 = new ExtendedDescription("5 hours vsdbfgsdbgksdfbgksdfhbgkdsf");
        String expected = "ExtendedDescription{5 hours vsdbfgsdbgksdfbgksdfhbgkdsf;";
        Assertions.assertEquals( m2.toString(),expected);
    }
}