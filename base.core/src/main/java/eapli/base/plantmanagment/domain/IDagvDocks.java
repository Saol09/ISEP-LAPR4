package eapli.base.plantmanagment.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Dagv docks.
 */
@Embeddable
public class IDagvDocks implements ValueObject,Comparable<IDagvDocks> {

    private String id;

    /**
     * Instantiates a new Dagv docks.
     */
    protected IDagvDocks(){

    }

    /**
     * Instantiates a new Dagv docks.
     *
     * @param idDock the id dock
     */
    public IDagvDocks(String idDock){
        validateIDagvDocks(idDock);
        this.id=idDock;
    }

    private void validateIDagvDocks(String idDock){

        Pattern pattern = Pattern.compile("D[0-9]*");
        Matcher matcher = pattern.matcher(idDock);
        if(!matcher.find()|idDock.equals("D0"))
            throw new IllegalArgumentException("The Alphanumeric code should have between 1-10 letters.");
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return  this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDagvDocks that = (IDagvDocks) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(IDagvDocks other) {
        return this.id.compareTo(other.id);
    }
}
