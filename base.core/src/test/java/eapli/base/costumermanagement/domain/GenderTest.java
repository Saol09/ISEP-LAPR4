package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderTest {
    @Test
    void test(){
        Gender g = new Gender();
        Gender g2 = new Gender();
        Assertions.assertNotEquals(g,g2);
    }

}