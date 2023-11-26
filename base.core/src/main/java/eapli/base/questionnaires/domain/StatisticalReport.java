package eapli.base.questionnaires.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.List;

/**
 * The type Statistical report.
 */
@Entity
@Table
public class StatisticalReport implements Comparable<Long>, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportID;

    private Long questionnaireId;

    private Long numberOfViews;

    @ElementCollection
    private List<AnswerReport> answerStatistics;

    @ElementCollection
    private List<AnswerReport> mostCommonAnswers;


    /**
     * Instantiates a new Statistical report.
     */
    protected StatisticalReport() {

    }

    /**
     * Instantiates a new Statistical report.
     *
     * @param questId           the quest id
     * @param numberOfViews     the number of views
     * @param answerStatistics  the answer statistics
     * @param mostCommonAnswers the most common answers
     */
    public StatisticalReport(Long questId, Long numberOfViews, List<AnswerReport> answerStatistics, List<AnswerReport> mostCommonAnswers) {
        this.questionnaireId = questId;
        this.numberOfViews = numberOfViews;
        this.answerStatistics = answerStatistics;
        this.mostCommonAnswers = mostCommonAnswers;
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
        return this.reportID;
    }

    @Override
    public boolean hasIdentity(Long id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public String toString() {
        return "StatisticalReport:\n" +
                "\n\treportID: " + reportID +
                "\n\tquestionnaireId: " + questionnaireId +
                "\n\tnumber of questionnaire views: " + numberOfViews +
                "\nanswerInfo: \n" + answerStatistics +
                "\n\tmost common answer(s): " + mostCommonAnswers +"\n";
    }
}
