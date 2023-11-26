package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Production code.
 */
@Embeddable
public class ProductionCode implements ValueObject {

    /**
     * The Production code.
     */
    String productionCode;

    /**
     * Instantiates a new Production code.
     */
    protected ProductionCode(){}

    /**
     * Instantiates a new Production code.
     *
     * @param productionCode the production code
     */
    public ProductionCode(String productionCode){

        this.productionCode = productionCode;
        validateProductionCode(productionCode);
    }


    private void validateProductionCode(String internalCode){

        Pattern pattern = Pattern.compile("[A-Za-zÇ-ú\\d]");
        Matcher matcher = pattern.matcher(productionCode);
        if(!matcher.find() || productionCode.length() <= 0 || productionCode.length() > 23)
            throw new IllegalArgumentException("The Production Code code should have between 1-23 letters.");
    }

    @Override
    public String toString() {
        return "ProductionCode{" + productionCode + ";";
    }
}
