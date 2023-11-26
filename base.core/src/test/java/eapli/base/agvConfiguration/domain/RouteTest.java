package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {
    @Test
    void testToString() {
        Route m = new Route();
        Route m2 = new Route(2);
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Route m2 = new Route(2);
        String expected = "2";
        Assertions.assertEquals( m2.toString(),expected);
    }
}