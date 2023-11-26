package eapli.base.productsCategory.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

/**
 * The type Products category.
 */
@Entity
@Table
public class ProductsCategory implements Comparable<AlphanumericCode>, AggregateRoot<AlphanumericCode>{

    @EmbeddedId
    private AlphanumericCode code;

    @Embedded
    @Column(name="Description")
    private Description description;

    /**
     * Instantiates a new Products category.
     */
    protected ProductsCategory() {
    }

    /**
     * Instantiates a new Products category.
     *
     * @param code the code
     * @param text the text
     */
    public ProductsCategory(AlphanumericCode code, Description text) {
        this.code = code;
        this.description = text;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public AlphanumericCode getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ProductsCategory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this,other);
    }

    @Override
    public int compareTo(AlphanumericCode o) {
        return this.code.compareTo(o);
    }

    @Override
    public AlphanumericCode identity() {
        return this.code;
    }
}
