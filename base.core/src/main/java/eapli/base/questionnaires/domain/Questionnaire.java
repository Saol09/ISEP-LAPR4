package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * The type Questionnaire.
 */
@Entity
public class Questionnaire implements AggregateRoot<String> {
    @Id
    private String id;
    private String title;
    private String welcomeMessage;
    @Transient
    private List<Section> sections;
    private String finalMessage;

    /**
     * Instantiates a new Questionnaire.
     */
    protected Questionnaire(){

    }

    /**
     * Instantiates a new Questionnaire.
     *
     * @param id             the id
     * @param title          the title
     * @param welcomeMessage the welcome message
     * @param sections       the sections
     * @param finalMessage   the final message
     */
    public Questionnaire(String id, String title, String welcomeMessage, List<Section> sections, String finalMessage) {

        checkId(id);
        checkTitle(title);
        checkSections(sections);
        checkFinalMessage(finalMessage);

        this.id = id;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.sections = sections;
        this.finalMessage = finalMessage;
    }

    private void checkId(String id)
    {
        if (StringUtils.isBlank(id))
            throw new AssertionError("ID cannot be blank.");
        if (id.length() > 15)
            throw new AssertionError("ID cannot have more than 15 characters.");
    }

    private void checkTitle(String title)
    {
        if (StringUtils.isBlank(title))
            throw new AssertionError("Title cannot be blank.");
        if (title.length() > 20)
            throw new AssertionError("title cannot have more than 20 characters.");
    }

    private void checkSections(List<Section> sections)
    {
        if (StringUtils.isBlank(String.valueOf(sections)))
            throw new AssertionError("Section cannot be blank.");
    }

    private void checkFinalMessage(String final_message)
    {
        if (StringUtils.isBlank(final_message))
            throw new AssertionError("Final_message cannot be blank.");
        if (final_message.length() > 30)
            throw new AssertionError("Final_message cannot have more than 30 characters.");
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String identity() {
        return String.valueOf(this.id);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Questionnaire)) {
            return false;
        }

        final Questionnaire that = (Questionnaire) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", sections=" + sections +
                ", finalMessage='" + finalMessage + '\'' +
                '}';
    }
}
