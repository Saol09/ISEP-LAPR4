package eapli.base.product.domain;

import eapli.base.plantmanagment.domain.Aisle;

import javax.persistence.Embeddable;

/**
 * The type Product location.
 */
@Embeddable
public class ProductLocation {

    private int productAisle;

    private int productRow;

    private int productShelf;

    /**
     * Instantiates a new Product location.
     */
    protected ProductLocation(){}

    /**
     * Instantiates a new Product location.
     *
     * @param productAisle the product aisle
     * @param productRow   the product row
     * @param productShelf the product shelf
     */
    public ProductLocation(int productAisle, int productRow, int productShelf) {
        this.productAisle = productAisle;
        this.productRow = productRow;
        this.productShelf = productShelf;
    }

    public synchronized int getProductAisle() {
        return productAisle;
    }

    public synchronized int getProductRow() {
        return productRow;
    }

    public int getProductShelf() {
        return productShelf;
    }

    public void setProductAisle(int productAisle) {
        this.productAisle = productAisle;
    }

    public void setProductRow(int productRow) {
        this.productRow = productRow;
    }

    public void setProductShelf(int productShelf) {
        this.productShelf = productShelf;
    }

    @Override
    public String toString() {
        return "Aisle: " + productAisle +
                " | Row: " + productRow +
                " | Shelf: " + productShelf;
    }
}
