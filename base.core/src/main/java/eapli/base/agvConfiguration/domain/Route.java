package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * The type Route.
 */
@Embeddable
public class Route implements ValueObject {

    private int route;

    /**
     * Instantiates a new Route.
     */
    protected Route() {
    }

    /**
     * Instantiates a new Route.
     *
     * @param route agv route
     */
    public Route(int route) {
        this.route = route;
    }

    /**
     * @return agv route
     */
    @Override
    public String toString() {
        return String.valueOf(this.route);
    }


}
