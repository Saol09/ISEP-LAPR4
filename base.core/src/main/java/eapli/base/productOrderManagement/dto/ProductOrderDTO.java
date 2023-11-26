package eapli.base.productOrderManagement.dto;

import eapli.framework.representations.dto.DTO;

import java.util.ArrayList;

/**
 * The type Product order dto.
 */
@DTO
public class ProductOrderDTO {

    /**
     * The Id.
     */
    public Long id;
    /**
     * The Date.
     */
    public String date;
    /**
     * The List items.
     */
    public ArrayList<String> listItems;
    /**
     * The Order volume.
     */
    public double orderVolume;
    /**
     * The Order weight.
     */
    public double orderWeight;
    /**
     * The Costumer name.
     */
    public String costumerName;


    /**
     * Instantiates a new Product order dto.
     *
     * @param id           the id
     * @param date         the date
     * @param listItems    the list items
     * @param orderVolume  the order volume
     * @param orderWeight  the order weight
     * @param costumerName the costumer name
     */
    public ProductOrderDTO(final Long id, final String date,final ArrayList<String> listItems,final double orderVolume,final double orderWeight,final String costumerName) {
        this.id = id;
        this.date = date;
        this.listItems = listItems;
        this.orderVolume = orderVolume;
        this.orderWeight = orderWeight;
        this.costumerName = costumerName;
    }

    @Override
    public String toString() {
        return "Order:" +
                "\nid=" + id +
                "\ndate=" + date +
                "\nlistItems=" + listItems.toString() +
                "\norderVolume=" + orderVolume +
                "\norderWeight=" + orderWeight +
                "\ncostumerName=" + costumerName+"\n\n";
    }
}
