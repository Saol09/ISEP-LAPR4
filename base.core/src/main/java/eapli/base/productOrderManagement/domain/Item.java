package eapli.base.productOrderManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

/**
 * The type Item.
 */
@Embeddable
public class Item implements ValueObject {

    private String productID;
    private int quantity;

    /**
     * Instantiates a new Item.
     */
    protected Item() {
        // ORM
    }

    /**
     * Instantiates a new Item.
     *
     * @param productID the product id
     * @param quantity  the quantity
     */
    public Item(String productID, int quantity) {
        Preconditions.nonEmpty(productID);
        Preconditions.nonNull(quantity);
        Preconditions.isPositive(quantity);

        this.productID = productID;
        this.quantity = quantity;
    }


    /**
     * Gets product id.
     *
     * @return the product id
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productID='" + productID + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
