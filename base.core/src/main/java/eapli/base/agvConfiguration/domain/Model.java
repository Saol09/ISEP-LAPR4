package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Model.
 */
@Embeddable
public class Model implements ValueObject {


    private String model;

    /**
     * Instantiates a new Model.
     */
    protected Model() {}

    /**
     * Instantiates a new Model.
     *
     * @param model agv model
     */
    public Model(String model){
        this.model = model;
        checkModel(model);
    }

    /**
     * checks if model follows the correct params
     * @param model agv model
     */
    private void checkModel(String model) {
        String regex = "[A-Za-zÇ-ú0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(model);

        if (!matcherCodeCheck.find() || (model.length() <= 0 || model.length() >= 50))
            throw new IllegalArgumentException("Model should not be empty and should have max 50 characters");
    }

    /**
     *
     * @return agv model
     */
    @Override
    public String toString() {
        return model;
    }
}
