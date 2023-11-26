package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutonomyTest {

    @Test
    void testToString() {
        Autonomy m = new Autonomy();
        Autonomy m2 = new Autonomy("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Autonomy m2 = new Autonomy("5 hours");
        String expected = "5 hours";
        Assertions.assertEquals( m2.toString(),expected);
    }
}