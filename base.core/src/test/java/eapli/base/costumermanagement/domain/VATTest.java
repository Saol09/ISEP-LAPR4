package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class VATTest {
    @Test
    void testTValidateVat() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            VAT m = new VAT();
            VAT m2 = new VAT("AT1789");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Invalid VAT.", thrown.getMessage());
    }
    @Test
    void testTVat() {
        VAT m = new VAT();
        VAT m2 = new VAT("PT123456789");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

}