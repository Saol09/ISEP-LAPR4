package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    void testTValidateName() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Name m = new Name();
            Name m2 = new Name("erro");
            Assertions.assertEquals(m.toString(), m2.toString());
        });
        Assertions.assertEquals("Please input your first and last name (at least).", thrown.getMessage());
    }
    @Test
    void testTName() {
        Name m = new Name();
        Name m2 = new Name("vasco azevedo");
        Assertions.assertNotEquals(m.toString(), m2.toString());
    }
}