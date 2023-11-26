package eapli.base.shoppingCart.domain;

import eapli.base.costumermanagement.domain.*;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShoppingCartTest {

    /*@Test
    public void testToStringNotEquals() {



        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");

        Costumer c1 = new Costumer(n,p,v,e);

        Item item = new Item("sda1",2);
        Set<Item> lista= new HashSet<>();
        lista.add(item);

        ShoppingCart cart = new ShoppingCart();
        ShoppingCart cart1 = new ShoppingCart(c1,lista);
        assertNotEquals(cart.toString(),cart1.toString());
    }*/
}
