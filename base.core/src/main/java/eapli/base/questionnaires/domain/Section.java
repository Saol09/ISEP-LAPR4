package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

/**
 * The type Section.
 */
@Entity
public class Section implements AggregateRoot<Long> {
    @Id
    private long sectionId;
    private String sectionTitle;
    private String sectionDescription;
    private String obligatoriness;
    private Integer repeatability;
    @ManyToMany
    private List<Question> content;

    /**
     * Instantiates a new Section.
     */
    protected Section() {
        //ORM
    }

    /**
     * Instantiates a new Section.
     *
     * @param sectionId          the section id
     * @param sectionTitle       the section title
     * @param sectionDescription the section description
     * @param obligatoriness     the obligatoriness
     * @param repeatability      the repeatability
     * @param content            the content
     */
    public Section(long sectionId, String sectionTitle, String sectionDescription, String obligatoriness, Integer repeatability, List<Question> content) {

        checkSectionId(sectionId);
        checkSectionTitle(sectionTitle);
        checkObligatoriness(obligatoriness);
        checkContent(content);

        this.sectionId = sectionId;
        this.sectionTitle = sectionTitle;
        this.sectionDescription = sectionDescription;
        this.obligatoriness = obligatoriness;
        this.repeatability = repeatability;
        this.content = content;
    }

    private void checkSectionId(long section_id)
    {
        if (StringUtils.isBlank(String.valueOf(section_id)))
            throw new AssertionError("Section_id cannot be blank.");
    }

    private void checkSectionTitle(String section_title)
    {
        if (StringUtils.isBlank(section_title))
            throw new IllegalArgumentException("Section_title cannot be blank.");
    }

    private void checkObligatoriness(String obligatoriness)
    {
        if (StringUtils.isBlank(String.valueOf(obligatoriness)))
            throw new IllegalArgumentException("Obligatoriness cannot be blank.");
    }

    private void checkContent(List<Question> content)
    {
        if (StringUtils.isBlank(String.valueOf(content)))
            throw new AssertionError("Content cannot be blank.");
    }

    /**
     * Gets section id.
     *
     * @return the section id
     */
    public long getSectionId() {
        return sectionId;
    }

    /**
     * Sets section id.
     *
     * @param sectionId the section id
     */
    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Gets section title.
     *
     * @return the section title
     */
    public String getSectionTitle() {
        return sectionTitle;
    }

    /**
     * Sets section title.
     *
     * @param sectionTitle the section title
     */
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    /**
     * Gets section description.
     *
     * @return the section description
     */
    public String getSectionDescription() {
        return sectionDescription;
    }

    /**
     * Sets section description.
     *
     * @param sectionDescription the section description
     */
    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    /**
     * Gets obligatoriness.
     *
     * @return the obligatoriness
     */
    public String getObligatoriness() {
        return obligatoriness;
    }

    /**
     * Sets obligatoriness.
     *
     * @param obligatoriness the obligatoriness
     */
    public void setObligatoriness(String obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    /**
     * Gets repeatability.
     *
     * @return the repeatability
     */
    public Integer getRepeatability() {
        return repeatability;
    }

    /**
     * Sets repeatability.
     *
     * @param repeatability the repeatability
     */
    public void setRepeatability(int repeatability) {
        this.repeatability = repeatability;
    }

    /*public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }*/

    /**
     * Gets content.
     *
     * @return the content
     */
    public List<Question> getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(List<Question> content) {
        this.content = content;
    }

    /*@Override
    public Long identity() {
        return this.sectionId;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Section)) {
            return false;
        }

        final Section that = (Section) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }*/

    @Override
    public String toString() {
        return "Section " +
                "sectionId=" + sectionId +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", sectionDescription='" + sectionDescription + '\'' +
                ", obligatoriness='" + obligatoriness + '\'' +
                ", repeatability=" + repeatability +
                ", content=" + content +
                ' ';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public Long identity() {
        return this.sectionId;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
