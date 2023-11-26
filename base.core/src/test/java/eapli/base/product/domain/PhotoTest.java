package eapli.base.product.domain;

import eapli.base.agvConfiguration.domain.Id;
import eapli.framework.validations.Preconditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotoTest {

    @Test
    void valueOf() {
        Photo p1 = new Photo("sergio.png");
        Photo p2 = new Photo("sergio.png");
        Assertions.assertEquals(Photo.valueOf(p2.toString()),Photo.valueOf(p1.toString()));
    }
    @Test
    void valueOf2() {
        Photo p1 = new Photo("serio.png");
        Photo p2 = new Photo("sergio.png");
        Assertions.assertNotEquals(Photo.valueOf(p2.toString()),Photo.valueOf(p1.toString()));
    }

    @Test
    void testHashCode() {

        Photo p1 = new Photo("serio.png");
        int result = -562389444;
        assertEquals(result, p1.hashCode());
    }
    @Test
    void testHashCode2() {

        Photo p1 = new Photo("serio.png");
        Photo p2 = new Photo("serio.png");
        assertTrue(p1.equals(p2) && p2.equals(p1));
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEquals() {

        Photo p1 = new Photo("serio.png");
        Photo p2 = new Photo("serio.png");
        assertEquals(p1, p2);
    }

    @Test
    void testEquals2() {

        Photo p1 = new Photo("rio.png");
        Photo p2 = new Photo("serio.png");
        assertNotEquals(p1, p2);
    }
    @Test
    void testEquals3() {

        Photo p2 = new Photo("serio.png");
        Photo p = new Photo();
        boolean result = p2.equals(p);
        assertFalse(result);
    }

    @Test
    void testToString() {
        Photo p = new Photo();
        Photo p1 = new Photo("hello.png");
        Assertions.assertNotEquals(p.toString(),p1.toString());
    }
    @Test
    void testToString2() {
        Photo p1 = new Photo("hello.png");
        String expected = "hello.png";
        Assertions.assertEquals(expected,p1.toString());
    }
}