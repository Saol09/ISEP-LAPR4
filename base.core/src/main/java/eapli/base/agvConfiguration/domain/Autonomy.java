package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * The type Autonomy.
 */
@Embeddable
public class Autonomy implements ValueObject {

    private String autonomy;

    /**
     * Instantiates a new Autonomy.
     */
    protected Autonomy (){}

    /**
     * Instantiates a new Autonomy.
     *
     * @param autonomy the autonomy
     */
    public Autonomy(String autonomy){
        this.autonomy = autonomy;
    }

    @Override
    public String toString() {
        return this.autonomy;
    }


}
