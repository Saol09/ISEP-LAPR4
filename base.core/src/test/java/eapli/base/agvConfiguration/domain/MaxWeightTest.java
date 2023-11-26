package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxWeightTest {

    @Test
    void testToString() {
        MaxWeight m = new MaxWeight();
        MaxWeight m2 = new MaxWeight(54.02);
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
    @Test
    void testToString2() {
        MaxWeight m2 = new MaxWeight(54.02);
        String expected = "54.02";
        Assertions.assertEquals( m2.toString(),expected);
    }
    @Test
    void checkMaxWeight() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MaxWeight m2 = new MaxWeight(-54.02);
            String expected = "maxWeight= -54.02;";
            Assertions.assertEquals( m2.toString(),expected);
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Max Weight cannot be null nor zero", thrown.getMessage());
    }
    @Test
    void checkMaxWeight2() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MaxWeight m2 = new MaxWeight(0);
            String expected = "maxWeight= 0;";
            Assertions.assertEquals( m2.toString(),expected);
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Max Weight cannot be null nor zero", thrown.getMessage());
    }
}