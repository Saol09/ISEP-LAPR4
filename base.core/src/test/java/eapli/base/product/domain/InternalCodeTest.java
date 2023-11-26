package eapli.base.product.domain;

import eapli.base.agvConfiguration.domain.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalCodeTest {

    @Test
    void testToString() {
        InternalCode m = new InternalCode();
        InternalCode m2 = new InternalCode("5 hours");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }

    /*
    @Test
    void testToString2() {
        InternalCode m2 = new InternalCode("5 hours");
        String expected = "5 hours";
        Assertions.assertEquals( m2.toString(),expected);
    }
*/

    @Test
    void compareTo() {
        InternalCode m = new InternalCode("hello");
        InternalCode m2 = new InternalCode("5 hours");
        int result = m2.compareTo(m);
        Assertions.assertEquals(-51,result);
    }

    @Test
    void compareTo2() {
        InternalCode m = new InternalCode("hello");
        InternalCode m2 = new InternalCode("hello");
        int result = m2.compareTo(m);
        Assertions.assertEquals(0,result);
    } @Test
    void compareTo3() {
        InternalCode m = new InternalCode("hello");
        InternalCode m2 = new InternalCode("hello36");
        int result = m2.compareTo(m);
        Assertions.assertEquals(2,result);
    }
    @Test
    void testValidate() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InternalCode r = new InternalCode("");
            String expected = "";
            Assertions.assertEquals(r.toString(), expected);
        });
        Assertions.assertEquals("The Internal Code code should have between 1-23 letters.", thrown.getMessage());

    }
}