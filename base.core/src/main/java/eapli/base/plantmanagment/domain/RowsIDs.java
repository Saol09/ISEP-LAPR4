package eapli.base.plantmanagment.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.util.Objects;


/**
 * The type Rows i ds.
 */
@Embeddable
public class RowsIDs implements ValueObject {

    private int rowID;

    private int AisleID;

    /**
     * Instantiates a new Rows i ds.
     */
    protected RowsIDs(){}

    /**
     * Instantiates a new Rows i ds.
     *
     * @param rowID   the row id
     * @param AisleID the aisle id
     */
    public RowsIDs(int rowID, int AisleID){


        this.rowID = rowID;

        this.AisleID = AisleID;
    }


    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowsIDs rowsIDs = (RowsIDs) o;
        return rowID == rowsIDs.rowID && AisleID == rowsIDs.AisleID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowID, AisleID);
    }

    @Override
    public String toString() {
        return "RowsIDs{" +
                "rowID=" + rowID +
                ", AisleID=" + AisleID +
                '}';
    }

    /**
     * Compare to int.
     *
     * @param other the other
     * @return the int
     */
    public int compareTo(Integer other) {
        return 0;
    }
}