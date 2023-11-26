package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTest {

    @Test
    void compareTo() {
        Id m = new Id("12");
        Id m2 = new Id("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(2,result);
    }

    @Test
    void compareTo2() {
        Id m = new Id("1234");
        Id m2 = new Id("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(0,result);
    }
    @Test
    void compareTo3() {
        Id m = new Id("12345");
        Id m2 = new Id("1234");
        int result = m2.compareTo(m);
        Assertions.assertEquals(-1,result);
    }

    @Test
    void testToString() {
        Id m = new Id();
        Id m2 = new Id("1234");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Id m2 = new Id("1234");
        String expected = "1234";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToString3() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Id m2 = new Id("");
            String expected = "id: ;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Id should not be empty and should have max 8 Alphanumeric code", thrown.getMessage());
    }
    @Test
    void testToString4() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Id m2 = new Id("123488888888888888888888888888888888888");
            String expected = "id: 123488888888888888888888888888888888888;";
            Assertions.assertEquals(m2.toString(), expected);
        });
        Assertions.assertEquals("Id should not be empty and should have max 8 Alphanumeric code", thrown.getMessage());
    }

    @Test
    void testHashCode() {

        Id m2 = new Id("1234");
        int result = 1509473;
        assertEquals(result, m2.hashCode());
    }
    @Test
    void testHashCode2() {

        Id m2 = new Id("1234");
        Id m = new Id("1234");
        assertTrue(m2.equals(m) && m.equals(m2));
        assertEquals(m.hashCode(), m2.hashCode());
    }

    @Test
    void testEquals() {

        Id m2 = new Id("1234");
        Id m = new Id("1234");
        assertEquals(m, m2);
    }

    @Test
    void testEquals2() {

        Id m2 = new Id("134");
        Id m = new Id("1234");
        assertNotEquals(m, m2);
    }
    @Test
    void testEquals3() {

        Id m2 = new Id();
        Id m = new Id("1234");
        boolean result = m2.equals(m);
        assertFalse(result);
    }
}