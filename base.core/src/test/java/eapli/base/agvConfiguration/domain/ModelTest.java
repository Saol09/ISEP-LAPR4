package eapli.base.agvConfiguration.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void testToString() {
        Model m = new Model();
        Model m2 = new Model("ze manel dos produtos é o melhor sales clerk");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        Model m2 = new Model("ze manel dos produtos é o melhor sales clerk");
        String expected = "ze manel dos produtos é o melhor sales clerk";
        Assertions.assertEquals( m2.toString(),expected);
    }

    @Test
    void testToString3() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Model m2 = new Model("");
            String expected = "model: ;";
            Assertions.assertEquals( m2.toString(),expected);
        });
        Assertions.assertEquals("Model should not be empty and should have max 50 characters", thrown.getMessage());
    }
    @Test
    void testToString4() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Model m2 = new Model("12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
            String expected = "model: 12345dfgdfsgdsjgnjdfsbghbsdfhbgdsfdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff;";
            Assertions.assertEquals(m2.toString(), expected);
        });
        Assertions.assertEquals("Model should not be empty and should have max 50 characters", thrown.getMessage());
    }
}