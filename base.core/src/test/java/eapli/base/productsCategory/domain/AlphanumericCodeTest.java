package eapli.base.productsCategory.domain;

import eapli.base.agvConfiguration.domain.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AlphanumericCodeTest {

    @Test
    void testToCompareToDifferent() {
        AlphanumericCode m = new AlphanumericCode("12");
        AlphanumericCode m2 = new AlphanumericCode("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(2,result);
    }

    @Test
    void testToCompareToEqual() {
        AlphanumericCode m = new AlphanumericCode("1234");
        AlphanumericCode m2 = new AlphanumericCode("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(0,result);
    }
    @Test
    void testToCompareToDifferent2() {
        AlphanumericCode m = new AlphanumericCode("12345");
        AlphanumericCode m2 = new AlphanumericCode("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(-1,result);
    }

    @Test
    void testToStringIfIsDifferent() {
        AlphanumericCode m = new AlphanumericCode();
        AlphanumericCode m2 = new AlphanumericCode("1234");
        assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToStringIfIsEqual() {
        AlphanumericCode m2 = new AlphanumericCode("1234");
        String expected = "Code: 1234;";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToStringEmpty() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AlphanumericCode m2 = new AlphanumericCode("");
            String expected = "Code: ;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("The Alphanumeric code should have between 1-10 letters.", thrown.getMessage());
    }
    @Test
    void testToStringMoreLettersThanAllowed() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AlphanumericCode m2 = new AlphanumericCode("123488888888888888888888888888888888888");
            String expected = "Code: 123488888888888888888888888888888888888;";
            Assertions.assertEquals(m2.toString(), expected);
        });
        Assertions.assertEquals("The Alphanumeric code should have between 1-10 letters.", thrown.getMessage());
    }

    @Test
    void testEqualsEqual() {

        AlphanumericCode code1 = new AlphanumericCode("1sasda4");
        AlphanumericCode code2 = new AlphanumericCode("1sasda4");
        assertEquals(code1, code2);
    }

    @Test
    void testEqualsDifferent() {

        AlphanumericCode cou1 = new AlphanumericCode("4s5a");
        AlphanumericCode cou2 = new AlphanumericCode("da45");
        assertNotEquals(cou1, cou2);
    }
    @Test
    void testEqualsNull() {

        AlphanumericCode cou1 = null;
        AlphanumericCode cou2 = new AlphanumericCode("sdfa1");
        boolean result = cou2.equals(cou1);
        assertFalse(result);
    }
    @Test
    void testHashCode1() {

        AlphanumericCode cou1 = new AlphanumericCode("das84");
        int result = 95354161;
        assertEquals(result, cou1.hashCode());
    }
    @Test
    void testHashCode2() {

        AlphanumericCode cou1 = new AlphanumericCode("454sa");
        AlphanumericCode cou2 = new AlphanumericCode("454sa");
        assertTrue(cou1.equals(cou2) && cou2.equals(cou1));
        assertEquals(cou1.hashCode(), cou2.hashCode());
    }
}
