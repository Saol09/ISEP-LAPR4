package eapli.base.product.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductionCodeTest {

    @Test
    void testToString() {
        ProductionCode m = new ProductionCode();
        ProductionCode m2 = new ProductionCode("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    @Test
    void testToString2() {
        ProductionCode m2 = new ProductionCode("5 hours");
        String expected = "ProductionCode{5 hours;";
        Assertions.assertEquals( m2.toString(),expected);
    }
    @Test
    void testValidate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ProductionCode r = new ProductionCode("");
            String expected = "";
            Assertions.assertEquals(r.toString(), expected);
        });
        Assertions.assertEquals("The Production Code code should have between 1-23 letters.", thrown.getMessage());

    }
}
