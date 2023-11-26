package eapli.base.costumermanagement.domain;

import eapli.base.agvConfiguration.domain.*;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CostumerTest {


    @Test
    void testHashCode() {

        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");

        Costumer c1 = new Costumer(n,p,v,e);
        int result = 1147;
        assertEquals(result, c1.hashCode());
    }
    @Test
    void test() {

        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");
        Costumer c = new Costumer();
        Costumer c1 = new Costumer(n,p,v,e);

        assertNotEquals(c, c1);
    }
    @Test
    void testHashCode2() {

        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");

        Costumer c1 = new Costumer(n,p,v,e);
        Costumer c2 = new Costumer(n,p,v,e);
        assertFalse(c2.equals(c1) && c1.equals(c2));
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void sameAs() {
        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");

//        Costumer c = new Costumer();
        Costumer c1 = new Costumer(n,p,v,e);
        Object c2 = new Costumer(n,p,v,e);
        Assertions.assertTrue(c1.sameAs(c2));
    }

    @Test
    void sameAs2() {
        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");

//        Costumer c = new Costumer();
        Costumer c1 = new Costumer(n,p,v,e);

        AlphanumericCode ac = new AlphanumericCode("1324");
        Description c = new Description("da lhe serginho na queima");

        Object a2 = new ProductsCategory(ac, c);
        Assertions.assertFalse(c1.sameAs(a2));
    }


    @Test
    void identity() {
        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");
        Costumer c1 = new Costumer(n,p,v,e);
        Costumer c2 = new Costumer(n,p,v,e);
        Assertions.assertEquals(c1.identity(), c2.identity());
    }

    @Test
    void getEmail(){
        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");
        Costumer c1 = new Costumer(n,p,v,e);
        Costumer c2 = new Costumer(n,p,v,e);
        Assertions.assertEquals(c1.getEmail(), c2.getEmail());

    }
    @Test
    void getEmail2(){
        Name n =new Name("joaquim alberto");
        PhoneNumber p = new PhoneNumber("918547595");
        VAT v = new VAT("PT123456789");
        Email e = new Email("va@gmail.com");
        Email e2 = new Email("va123123@gmail.com");
        Costumer c1 = new Costumer(n,p,v,e);
        Costumer c2 = new Costumer(n,p,v,e2);
        Assertions.assertNotEquals(c1.getEmail(), c2.getEmail());

    }
}