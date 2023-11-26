package eapli.base.plantmanagment.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * The type Unit.
 */
@Embeddable
public class Unit implements ValueObject {

    private String unit;

    /**
     * Instantiates a new Unit.
     */
    protected Unit(){

    }

    /**
     * Instantiates a new Unit.
     *
     * @param unit the unit
     */
    public Unit(String unit){

        validateUnit(unit);
        this.unit = unit;
    }

    //aqui so vai ter in(inches) cm(centimeters) e mm(millimeters)
    private void validateUnit(String unit){
        String CONSTANT_INCHES ="in";
        String CONSTANT_CENTIMETERS ="cm";
        String CONSTANT_MILLIMETERS ="mm";

        if (!unit.equals(CONSTANT_INCHES) && !unit.equals(CONSTANT_CENTIMETERS) && !unit.equals(CONSTANT_MILLIMETERS)) {
            throw new IllegalArgumentException("Units incorrect or not recognized.");
        }
    }

    @Override
    public String toString() {
        return this.unit;
    }
}
