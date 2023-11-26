package eapli.base.questionnaires.domain;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;

/**
 * The type Answer.
 */
@Entity
public class Answer implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnswer;


    private String questionAnswer;

    private Long idQuestionnaire;

    private int idSection;

    private int questionType;

    private int idQuestion;

    @OneToOne
    private Costumer user;

    /**
     * Gets id answer.
     *
     * @return the id answer
     */
    public int getIdAnswer() {
        return idAnswer;
    }

    /**
     * Gets id questionnaire.
     *
     * @return the id questionnaire
     */
    public Long getIdQuestionnaire() {
        return idQuestionnaire;
    }

    /**
     * Gets id section.
     *
     * @return the id section
     */
    public int getIdSection() {
        return idSection;
    }

    /**
     * Gets question type.
     *
     * @return the question type
     */
    public int getQuestionType() {
        return questionType;
    }

    /**
     * Gets id question.
     *
     * @return the id question
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public Costumer getUser() {
        return user;
    }

    /**
     * Gets answer id.
     *
     * @return the answer id
     */
    public long getAnswerId() {
        return idAnswer;
    }

    /**
     * Gets question answer.
     *
     * @return the question answer
     */
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    /**
     * Sets answer id.
     *
     * @param idQuestionnaire the id
     */
    public void setAnswerId(int idQuestionnaire) {
        this.idAnswer = idQuestionnaire;
    }

    /**
     * Sets question answer.
     *
     * @param questionAnswer the question answer
     */
    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    /**
     * Instantiates a new Answer.
     */
    protected Answer() {
    }


    /**
     * Instantiates a new Answer.
     *
     * @param answer the answer
     * @param user   the user
     */
    public Answer(String[] answer,Costumer user) {

        this.questionAnswer = answer[4];
        this.idQuestionnaire = Long.valueOf(answer[0]);
        this.idQuestion = Integer.parseInt(answer[3]);
        this.idSection = Integer.parseInt(answer[1]);
        this.questionType = Integer.parseInt(answer[2]);
        this.user = user;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }


    @Override
    public String identity() {
        return String.valueOf(this.idAnswer);
    }




}
