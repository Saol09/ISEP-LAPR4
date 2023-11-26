package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Barcode.
 */
@Embeddable
public class Barcode implements ValueObject  {

    private Long barcode;//12 digits for upc and 13 digits for EAN-13

    /**
     * Instantiates a new Barcode.
     */
    protected Barcode(){}


    /**
     * Instantiates a new Barcode.
     *
     * @param barcode the barcode
     * @param type    the type
     */
    public Barcode(Long barcode, Product.TYPE type) {

        if(type.equals(Product.TYPE.EAN13)){
            Preconditions.ensure(barcode.toString().length()==13);
            this.barcode = barcode;
        }else if (type.equals(Product.TYPE.UPC)){
            Preconditions.ensure(barcode.toString().length()==12);
            this.barcode = barcode;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(barcode);
    }
}
