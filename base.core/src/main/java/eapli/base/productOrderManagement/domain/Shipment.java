package eapli.base.productOrderManagement.domain;

import eapli.framework.general.domain.model.Money;


/**
 * The enum Shipment.
 */
public enum Shipment {
    /**
     * Standard shipment.
     */
    STANDARD(Constants.STANDARD_COST),
    /**
     * Blue shipment.
     */
    BLUE(Constants.BLUE_COST),
    /**
     * Green shipment.
     */
    GREEN(Constants.GREEN_COST);

    private final Money cost;

    Shipment(final Money cost) {
        this.cost = cost;
    }

    /**
     * Cost double.
     *
     * @return the double
     */
    public double cost() {
        return this.cost.amountAsDouble();
    }

    private static class Constants {
        private static final Money STANDARD_COST = Money.euros(5);
        private static final Money BLUE_COST = Money.euros(10);
        private static final Money GREEN_COST = Money.euros(15);
    }
}

