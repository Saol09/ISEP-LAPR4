package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

/**
 * The type Answer report.
 */
@Embeddable
public class AnswerReport implements ValueObject {

    private String answer;
    private double percentage;
    private int sectionID;
    private int questionID;

    /**
     * Instantiates a new Answer report.
     */
    protected AnswerReport() {
    }

    /**
     * Instantiates a new Answer report.
     *
     * @param answer     the answer
     * @param percentage the percentage
     * @param sectionID    the section
     * @param questionID   the question
     */
    public AnswerReport(String answer, double percentage, int sectionID, int questionID) {
        this.answer = answer;
        this.percentage = percentage;
        this.sectionID = sectionID;
        this.questionID = questionID;
    }

    /**
     * Gets answer.
     *
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Gets percentage.
     *
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Gets section.
     *
     * @return the section
     */
    public int getSection() {
        return sectionID;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public int getQuestion() {
        return questionID;
    }

    @Override
    public String toString() {
        return "[AnswerReport]: " +
                "\n\t\tanswer:" + answer +
                "\n\t\tpercentage: " + percentage +
                "\n\t\tsectionID: " + sectionID +
                "\n\t\tquestionID: " + questionID +"\n";
    }
}
