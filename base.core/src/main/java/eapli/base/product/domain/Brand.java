package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Brand.
 */
@Embeddable
public class Brand implements ValueObject {

    private String brand;

    /**
     * Instantiates a new Brand.
     */
    protected Brand(){}

    /**
     * Instantiates a new Brand.
     *
     * @param brand the brand
     */
    public Brand(String brand){

        this.brand = brand;
        validateBrand(brand);
    }

    private void validateBrand(String brand){
        String regex = "[A-Za-zÇ-ú\\d]";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(brand);

        if (!matcherCodeCheck.find() || (brand.length() <= 0 || brand.length() >= 50))
            throw new IllegalArgumentException("Brand should not be empty and should have 50 chars maximum");
    }

    @Override
    public String toString() {
        return "Brand{" + brand + ";";
    }
}
