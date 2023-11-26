package eapli.base.productsCategory.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductsCategoryTest {

    @Test
    public void testToStringNotEquals() {

        AlphanumericCode code = new AlphanumericCode("sda54");
        Description description = new Description("This is a test, cause this is a test");
        ProductsCategory cat = new ProductsCategory();
        ProductsCategory cat2 = new ProductsCategory(code,description);
        assertNotEquals(cat.toString(),cat2.toString());
    }

    @Test
    public void testToStringEquals() {

        AlphanumericCode code = new AlphanumericCode("sda54");
        Description description = new Description("This is a test, cause this is a test");
        ProductsCategory cat = new ProductsCategory(code,description);
        ProductsCategory cat2 = new ProductsCategory(code,description);
        assertEquals(cat.toString(),cat2.toString());
    }

    @Test
    public void testSameAsEqual() {
        AlphanumericCode code = new AlphanumericCode("sda54");
        Description description = new Description("This is a test, cause this is a test");
        ProductsCategory cat = new ProductsCategory(code,description);
        Object a2 = new ProductsCategory(code,description);
        assertTrue(cat.sameAs(a2));
    }

    @Test
    public void testSameAsNotEqual() {
        AlphanumericCode code = new AlphanumericCode("sda54");
        Description description = new Description("This is a test, cause this is a test");

        AlphanumericCode ac = new AlphanumericCode("1324");
        Description c = new Description("da lhe serginho na queima");

        ProductsCategory a1 = new ProductsCategory(ac, c);
        Object a2 = new ProductsCategory(code, description);
        assertFalse(a1.sameAs(a2));
    }

    @Test
    public void testCompareToEqual() {

        AlphanumericCode code = new AlphanumericCode("5555");
        ProductsCategory cat = new ProductsCategory(code,new Description("dada454da4fasfasfafafafa"));

        int result = cat.getCode().compareTo(code);

        assertEquals(0,result);
    }

    @Test
    public void testCompareToNotEqual1() {

        AlphanumericCode code = new AlphanumericCode("a4da");
        AlphanumericCode code2 = new AlphanumericCode("da45");
        ProductsCategory cat = new ProductsCategory(code,new Description("dada454da4fasfasfafafafa"));

        int result = cat.getCode().compareTo(code2);

        assertNotEquals(0,result);
    }

    @Test
    public void testCompareToNotEqual2() {

        AlphanumericCode code = new AlphanumericCode("da45");
        AlphanumericCode code2 = new AlphanumericCode("a4da");
        ProductsCategory cat = new ProductsCategory(code,new Description("dada454da4fasfasfafafafa"));

        int result = cat.getCode().compareTo(code2);

        assertNotEquals(0,result);
    }





}