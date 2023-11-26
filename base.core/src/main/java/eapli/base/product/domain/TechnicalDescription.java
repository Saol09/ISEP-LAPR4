package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Technical description.
 */
@Embeddable
public class TechnicalDescription implements ValueObject {

    private String technicalDescription;

    /**
     * Instantiates a new Technical description.
     */
    protected TechnicalDescription(){}

    /**
     * Instantiates a new Technical description.
     *
     * @param technicalDescription the technical description
     */
    public TechnicalDescription(String technicalDescription){

        this.technicalDescription = technicalDescription;
        validateTechnicalDescription(technicalDescription);
    }

    private void validateTechnicalDescription(String technicalDescription){
        String regex = "[A-Za-zÇ-ú0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(technicalDescription);

        if (!matcherCodeCheck.find() || (technicalDescription.length() <= 0 || technicalDescription.length() >= 150))
            throw new IllegalArgumentException("Technical Description should have multiple lines.");
    }

    @Override
    public String toString() {
        return "TechnicalDescription{" + technicalDescription + ";";
    }
}
