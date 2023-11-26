package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    void testToString() {
        AGV.Status m = AGV.Status.FREE;
        AGV.Status m2 = AGV.Status.OCCUPIED_DOING_TASK;
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        AGV.Status m2 = AGV.Status.OCCUPIED_DOING_TASK;
        String expected = "OCCUPIED_DOING_TASK";
        Assertions.assertEquals( m2.toString(),expected);
    }
}