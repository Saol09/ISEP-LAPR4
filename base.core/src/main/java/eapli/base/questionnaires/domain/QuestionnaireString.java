package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

/**
 * The type Questionnaire string.
 */
@Entity
@Table
public class QuestionnaireString implements Comparable<String>, AggregateRoot<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=10000)
    private String questionnaire;

    /**
     * Instantiates a new Questionnaire string.
     */
    protected QuestionnaireString() {

    }

    /**
     * Instantiates a new Questionnaire string.
     *
     * @param questionnaire the questionnaire
     */
    public QuestionnaireString(String questionnaire){
        this.questionnaire = questionnaire;
    }

    /**
     * Gets questionnaire.
     *
     * @return the questionnaire
     */
    public String getQuestionnaire() {
        return questionnaire;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(String other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean hasIdentity(String id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
