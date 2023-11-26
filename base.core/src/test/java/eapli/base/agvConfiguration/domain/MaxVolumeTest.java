package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MaxVolumeTest {

    @Test
    void testToString() {
        MaxVolume m = new MaxVolume();
        MaxVolume m2 = new MaxVolume(54.02);
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
    @Test
    void testToString2() {
        MaxVolume m2 = new MaxVolume(54.02);
        String expected = "54.02";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void checkMaxVolume() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MaxVolume m2 = new MaxVolume(-54.02);
            String expected = "maxVolume= -54.02;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Max Volume cannot be null nor zero", thrown.getMessage());
    }
    @Test
    void checkMaxVolume2() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MaxVolume m2 = new MaxVolume(0);
            String expected = "maxVolume= 0;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Max Volume cannot be null nor zero", thrown.getMessage());
    }

}