package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Question.
 */
@Entity
public class Question implements AggregateRoot<Long> {
    @Id
    private long questionId;
    private String question;
    private String instruction;
    private String obligatoriness;
    private String extraInfo;
    private Integer questionType;

//    @ManyToMany
//    private List<Answer> answers;

    /**
     * Instantiates a new Question.
     */
    protected Question() {

    }

    /**
     * Instantiates a new Question.
     *
     * @param questionId     the question id
     * @param question       the question
     * @param instruction    the instruction
     * @param obligatoriness the obligatoriness
     * @param extraInfo      the extra info
     */
    public Question(Integer questionType, long questionId, String question, String instruction, String obligatoriness, String extraInfo) {

        checkQuestionID(questionId);
        checkQuestion(question);
        checkObligatoriness(obligatoriness);
        this.questionType = questionType;
        this.questionId = questionId;
        this.question = question;
        this.instruction = instruction;
        this.obligatoriness = obligatoriness;
        this.extraInfo = extraInfo;
    }

    private void checkQuestionID(long question_id)
    {
        if (StringUtils.isBlank(String.valueOf(question_id)))
            throw new AssertionError("Question_id cannot be blank.");
    }

    private void checkQuestion(String question)
    {
        if (StringUtils.isBlank(question))
            throw new IllegalArgumentException("Question cannot be blank.");
    }

    private void checkType(String type)
    {
        if (StringUtils.isBlank(String.valueOf(type)))
            throw new IllegalArgumentException("Type cannot be blank.");
    }

    private void checkObligatoriness(String obligatoriness)
    {
        if (StringUtils.isBlank(String.valueOf(obligatoriness)))
            throw new IllegalArgumentException("Obligatoriness cannot be blank.");
    }

    /**
     * Gets question id.
     *
     * @return the question id
     */
    public long getQuestionId() {
        return questionId;
    }

    /**
     * Sets question id.
     *
     * @param questionId the question id
     */
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets instruction.
     *
     * @return the instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * Sets instruction.
     *
     * @param instruction the instruction
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
     * Gets answers.
     *
     * @return the answers
     */
//    public List<Answer> getAnswers() {
//        return answers;
//    }

    /**
     * Sets obligatoriness.
     *
     * @param obligatoriness the obligatoriness
     */
    public void setObligatoriness(String obligatoriness) {
        this.obligatoriness = obligatoriness;
    }

    /**
     * Gets extra info.
     *
     * @return the extra info
     */
    public String getExtraInfo() {
        return extraInfo;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    /**
     * Sets extra info.
     *
     * @param extraInfo the extra info
     */
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    /*@Override
    public Long identity() {
        return this.questionId;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Question)) {
            return false;
        }

        final Question that = (Question) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }*/

    @Override
    public String toString() {
        String string1 = questionId + "." + question + '\n';
        List<String> list = new ArrayList<>();

        /*for (int i = 0; i < options.size();i++){
            String string2 = " " + i + ". " + options.get(i) + '\n';
            list.add(string2)
        }*/

            return string1 /*+ string2*/;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }


    @Override
    public Long identity() {
        return this.questionId;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }
}
