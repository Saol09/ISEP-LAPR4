package eapli.base.product.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import eapli.base.agvConfiguration.domain.ShortDescription;
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

class ProductBuilderTest {

    @Test
    void withInternalCode() {
        InternalCode ic = new InternalCode("hello");


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withInternalCode(ic);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withShortDescription() {
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");

        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withShortDescription(sd);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withExtendedDescription() {

        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withExtendedDescription(ed);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withBarcode() {

        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withBarcode(b);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withPriceWithoutTax() {

        Money mw = Money.euros(5256);


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withPriceWithoutTax(mw);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withPriceWithTax() {

        Money mt = Money.euros(545256);

        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withPriceWithTax(mt);
        Assertions.assertNotEquals(pb, pb1);
    }

    @Test
    void withWeight() {


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withWeight(54.2);
        Assertions.assertNotEquals(pb,pb1);
    }

    @Test
    void withVolume() {

        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withVolume(78.145);
        Assertions.assertNotEquals(pb,pb1);
    }

    @Test
    void withProductsCategory() {

        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);


        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withProductsCategory(pc);
        Assertions.assertNotEquals(pb,pb1);
    }

    @Test
    void withStatus() {

        ProductBuilder pb = new ProductBuilder();
        ProductBuilder pb1 = new ProductBuilder();
        pb.withStatus(true);
        Assertions.assertNotEquals(pb,pb1);
    }

    @Test
    void withTechnicalDescription() {
        InternalCode ic = new InternalCode("hello");
        ShortDescription sd = new ShortDescription("hello");
        ExtendedDescription ed = new ExtendedDescription("5 hours sdgfsdfgsdfgsdfgdfs");
        Barcode b = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Money mt = Money.euros(545256);
        Money mw = Money.euros(5256);
        AlphanumericCode ac = new AlphanumericCode("123");
        Description d = new Description("nem sei mas so sei que estes testes");
        ProductsCategory pc = new ProductsCategory(ac, d);

        Photo photo = new Photo("eapli.png");
        Set<String> a = new HashSet<>();
        a.add(photo.toString());

        Product p = new ProductBuilder().withInternalCode(ic).withShortDescription(sd).withExtendedDescription(ed).withBarcode(b).withPriceWithoutTax(mw).withPriceWithTax(mt).withWeight(54.5).withVolume(87.5).withProductsCategory(pc).withStatus(true).withTechnicalDescription(new TechnicalDescription("vamos embora")).withBrand(new Brand("teslano")).withReference(new Reference("123")).withProductionCode(new ProductionCode("qewr")).withProductLocation(new ProductLocation(1,2,3)).withPhotos(a).build();
        Product p2 = new ProductBuilder().withInternalCode(ic).withShortDescription(sd).withExtendedDescription(ed).withBarcode(b).withPriceWithoutTax(mw).withPriceWithTax(mt).withWeight(5.5).withVolume(7.5).withProductsCategory(pc).withStatus(false).build();



        Assertions.assertNotEquals(p,p2);
    }

//    @Test
//    void withBrand() {
//
//
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//        pb.withBrand(new Brand("teslano"));
//        Assertions.assertNotEquals(pb,pb1);
//    }
//
//    @Test
//    void withReference() {
//
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//        pb.withReference(new Reference("wqeqwr"));
//        Assertions.assertNotEquals(pb,pb1);
//    }
//
//    @Test
//    void withProductionCode() {
//
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//        pb.withProductionCode(new ProductionCode("siga"));
//        Assertions.assertNotEquals(pb,pb1);
//    }
//
//    @Test
//    void withProductLocation() {
//
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//        pb.withProductLocation(new ProductLocation(1,2,3));
//        Assertions.assertNotEquals(pb,pb1);
//    }
//
//    @Test
//    void withPhotos() {
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//
//        Photo p = new Photo("sd.png");
//
//        Set<String> s = new HashSet<>();
//        s.add(p.toString());
//
//        pb.withPhotos(s);
//        Assertions.assertNotEquals(pb,pb1);
//    }
//
//    @Test
//    void build() {
//        ProductBuilder pb = new ProductBuilder();
//        ProductBuilder pb1 = new ProductBuilder();
//        pb.build();
//        Assertions.assertNotEquals(pb,pb1);
//    }
}