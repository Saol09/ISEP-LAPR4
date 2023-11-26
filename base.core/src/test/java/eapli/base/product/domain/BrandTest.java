package eapli.base.product.domain;

import eapli.base.costumermanagement.domain.VAT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

    @Test
    void testTValidatebrand() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Brand m = new Brand();
            Brand m2 = new Brand("");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Brand should not be empty and should have 50 chars maximum", thrown.getMessage());
    }
    @Test
    void testTVat() {
        Brand m = new Brand();
        Brand m2 = new Brand("bmw");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
}