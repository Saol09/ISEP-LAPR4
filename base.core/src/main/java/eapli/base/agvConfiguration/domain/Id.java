package eapli.base.agvConfiguration.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Id.
 */
@Embeddable
public class Id implements ValueObject, Comparable<Id> {

    private String id;

    /**
     * Instantiates a new Id.
     */
    protected Id() {
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

    /**
     * Instantiates a new Id.
     *
     * @param id the id
     */
    public Id(String id) {
        this.id = id;
        checkId(id);

    }

    /**
     * Checks if id follows the correct params
     *
     * @param id agv id
     */
    private void checkId(String id) {
        String regex = "[A-Za-z0-9]*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherCodeCheck = pattern.matcher(id);

        if (!matcherCodeCheck.find() || (id.length() <= 0 || id.length() > 8))
            throw new IllegalArgumentException("Id should not be empty and should have max 8 Alphanumeric code");
    }

    /**
     * compares the ids of agv
     *
     * @param o object id
     * @return compared ids
     */
    @Override
    public int compareTo(Id o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id that = (Id) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * toString of agv id
     *
     * @return id
     */
    @Override
    public String toString() {
        return this.id;
    }
}
