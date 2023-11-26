package eapli.base.product.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import eapli.base.agvConfiguration.domain.*;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.general.domain.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void changeTechnicalDescription() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);
        Product p1 = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);

        p.changeTechnicalDescription(new TechnicalDescription("siga pa vigo"));

        Assertions.assertNotEquals(p, p1);
    }

    @Test
    void changeBrand() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);
        Product p1 = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);
        p.changeBrand(new Brand("carro do sergio"));
        Assertions.assertNotEquals(p, p1);
    }

    @Test
    void changeReference() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);
        Product p1 = new Product(ic, sd, ed, b, mw, mt, 54.2, 87.0, pc, true);
        p.changeReference(new Reference("carro do sergio"));
        Assertions.assertNotEquals(p, p1);
    }

    @Test
    void changeProductionCode() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        p.changeProductionCode(new ProductionCode("carro do sergio"));
        Assertions.assertNotEquals(p,p1);
    }

    @Test
    void changeProductLocation() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        p.changeProductLocation(new ProductLocation(1,2,3));
        Assertions.assertNotEquals(p,p1);
    }

    @Test
    void addPhotos() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);
        Photo p2 = new Photo("nininho.png");
        Set<String> a = new HashSet<>();
        a.add(p2.toString());

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);

        p.addPhotos(a);

        Assertions.assertNotEquals(p,p1);
    }

    @Test
    void getBrand() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);
        Photo p2 = new Photo("nininho.png");
        Set<String> a = new HashSet<>();
        a.add(p2.toString());

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);

        p.changeBrand(new Brand("bmw"));
        p1.changeBrand(new Brand("mw"));
        Assertions.assertNotEquals(p.getBrand().toString(),p1.getBrand().toString());

    }

    @Test
    void getDescription() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);
        Photo p2 = new Photo("nininho.png");
        Set<String> a = new HashSet<>();
        a.add(p2.toString());

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);

        Assertions.assertEquals(p.getDescription(),p1.getDescription());
    }

//    @Test
//    void testToString() {
//        InternalCode ic = new InternalCode("hello");
//        ShortDescription sd = new ShortDescription("hello");
//        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
//        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
//        Money mt = Money.euros(545256);
//        Money mw = Money.euros(5256);
//        AlphanumericCode ac = new AlphanumericCode("123");
//        Description d = new Description("nem sei mas so sei que estes testes");
//        ProductsCategory pc = new ProductsCategory(ac, d);
//        Photo p2 = new Photo("nininho.png");
//        Set<String> a = new HashSet<>();
//        a.add(p2.toString());
//
//        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
//
//        String expected = "Product{id=null, internalCode=InternalCode{hello;, shortDescription=shortDescription: hello;, extendedDescription=ExtendedDescription{5 hours sdgfsdfgsdfgsdfgdfs;, technicalDescription=null, brand=null, reference=null, barcode=eapli.base.product.domain.Barcode@353d0772, productionCode=null, priceWithoutTax=5 256,00 €, priceWithTax=545 256,00 €, weight=54.2, volume=87.0, category=ProductsCategory{code='Code: 123;', description='Description: nem sei mas so sei que estes testes;'}, location=null, Status=true}";
//
//        Assertions.assertEquals(p.toString(),expected);
//    }
    @Test
    void testToString2() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);
        Photo p2 = new Photo("nininho.png");
        Set<String> a = new HashSet<>();
        a.add(p2.toString());

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);

        String expected = "Product{, internalCode=InternalCode{hello;, shortDescription=shortDescription: hello;, extendedDescription=ExtendedDescription{5 hours sdgfsdfgsdfgsdfgdfs;, technicalDescription=null, brand=null, reference=null, barcode=eapli.base.product.domain.Barcode@353d0772, productionCode=null, priceWithoutTax=5 256,00 €, priceWithTax=545 256,00 €, weight=54.2, volume=87.0, category=ProductsCategory{code='Code: 123;', description='Description: nem sei mas so sei que estes testes;'}, location=null, Status=true}";

        Assertions.assertNotEquals(p.toString(),expected);
    }

    @Test
    void sameAs() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Object p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Assertions.assertTrue(p.sameAs(p1));
    }

    @Test
    void test(){ InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);
        Product p = new Product();
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Assertions.assertNotEquals(p,p1);
    }

//    @Test
//    void sameAs2() {
//        InternalCode ic = new InternalCode("hello");
//        InternalCode ic1 = new InternalCode("llo");
//        ShortDescription sd = new ShortDescription("hello");
//        ShortDescription sd1 = new ShortDescription("nao");
//        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
//        ExtendedDescription ed2 = new ExtendedDescription("5 hours sdgfsdfgfgsdfgdfs");
//        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
//        Money mt = Money.euros(545256);
//        Money mw = Money.euros(5256);
//        AlphanumericCode ac = new AlphanumericCode("123");
//        Description d = new Description("nem sei mas so sei que estes testes");
//        ProductsCategory pc = new ProductsCategory(ac, d);
//
//        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
//
//        Object p1 = new Product(ic1,sd1,ed2,b,mw,mt,54.2,87.0,pc,false);
//        Assertions.assertFalse(p.sameAs(p1));
//    }


    @Test
    void identity() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
        Assertions.assertEquals(p.identity(), p1.identity());
    }

//    @Test
//    void identity2() {
//        InternalCode ic = new InternalCode("hello");
//        ShortDescription sd = new ShortDescription("hello");
//        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
//        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
//        Money mt = Money.euros(545256);
//        Money mw = Money.euros(5256);
//        AlphanumericCode ac = new AlphanumericCode("123");
//        Description d = new Description("nem sei mas so sei que estes testes");
//        ProductsCategory pc = new ProductsCategory(ac, d);
//
//        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
//        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,false);
//        Assertions.assertEquals(p.identity(), p1.identity());
//        Assertions.assertNotEquals(p.identity(), p1.identity());
//    }

//    @Test
//    void compareTo() {
//        InternalCode ic = new InternalCode("hello");
//        ShortDescription sd = new ShortDescription("hello");
//        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
//        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
//        Money mt = Money.euros(545256);
//        Money mw = Money.euros(5256);
//        AlphanumericCode ac = new AlphanumericCode("123");
//        Description d = new Description("nem sei mas so sei que estes testes");
//        ProductsCategory pc = new ProductsCategory(ac, d);
//
//        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
////        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,false);
//        Long id = 12L;
//        int result = p.compareTo(id);
//        Assertions.assertEquals(2,result);
//    }
//


//    @Test
//    void hasIdentity() {
//        InternalCode ic = new InternalCode("hello");
//        ShortDescription sd = new ShortDescription("hello");
//        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
//        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
//        Money mt = Money.euros(545256);
//        Money mw = Money.euros(5256);
//        AlphanumericCode ac = new AlphanumericCode("123");
//        Description d = new Description("nem sei mas so sei que estes testes");
//        ProductsCategory pc = new ProductsCategory(ac, d);
//
//        Product p = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
//        Product p1 = new Product(ic,sd,ed,b,mw,mt,54.2,87.0,pc,true);
//        Long l = 12L;
//        boolean a = p.hasIdentity(l);
//        Assertions.assertFalse(a);
//    }
}