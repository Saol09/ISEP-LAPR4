package eapli.base.product.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BarcodeTest {
    @Test
    void testBarcode(){
        Barcode b = new Barcode();
        Barcode b1 = new Barcode(1234567890123L, Product.TYPE.EAN13);
        Assertions.assertNotEquals(b,b1);
    }
    @Test
    void testBarcode2(){
        Barcode b1 = new Barcode();
        Barcode b = new Barcode(123456789012L, Product.TYPE.UPC);
        Assertions.assertNotEquals(b,b1);
    }

}