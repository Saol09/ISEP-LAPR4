package eapli.base.product.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;

class ProductLocationTest {
    @Test
    void test(){
        ProductLocation p = new ProductLocation();
        ProductLocation p2 = new ProductLocation(1,2,3);
        Assertions.assertNotEquals(p,p2);
    }

}