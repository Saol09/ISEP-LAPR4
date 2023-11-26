package eapli.base.questionnaires.application;

import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaires.domain.Answer;
import eapli.base.questionnaires.domain.AnswerReport;
import eapli.base.questionnaires.domain.StatisticalReport;
import eapli.base.questionnaires.repository.StatisticalReportRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Statistical report controller.
 */
public class StatisticalReportController {

    /**
     * The Questionnaire services.
     */
    QuestionnaireServices questionnaireServices = new QuestionnaireServices();
    private final StatisticalReportRepository repo = PersistenceContext.repositories().statisticalReportRepository();

    /**
     * The Reports.
     */
    Map<Long, QuestionnaireInfoController> reports = new HashMap<>();

    /**
     * Create info.
     *
     * @param questionnaireID the questionnaire id
     */
    public void createInfo(Long questionnaireID) {
        Iterable<Answer> answers = questionnaireServices.allAnswer();

        for (Answer answer : answers) {
            long questId = answer.getIdQuestionnaire();
            if (questId != questionnaireID) {
                continue;
            }
            QuestionnaireInfoController report = reports.get(questId);
            if (report == null) {
                QuestionnaireInfoController newReport = new QuestionnaireInfoController();
                newReport.addAnswer(answer.getIdSection(), answer.getIdQuestion(), answer.getQuestionAnswer());

                reports.put(questId, newReport);
            } else {
                report.addAnswer(answer.getIdSection(), answer.getIdQuestion(), answer.getQuestionAnswer());
            }
        }
    }

    /**
     * Create report.
     *
     * @param questionnaireID the questionnaire id
     */
    public StatisticalReport createReport(Long questionnaireID) {
        QuestionnaireInfoController info = reports.get(questionnaireID);

        if (info == null) {
            System.out.println("There is no Statistical Report available for this Questionnaire.");
            return null;
        }
        long numberOfViews = info.getNumberOfViews();
        List<AnswerReport> answerReports = new LinkedList<>();
        Map<Integer, Map<Integer, List<String>>> sections = info.getSections();
        List<AnswerReport> mostCommonAnswers = new LinkedList<>();

        for (Map.Entry<Integer, Map<Integer, List<String>>> section : sections.entrySet()) {
            int sectionId = section.getKey();
            Map<Integer, List<String>> questions = section.getValue();

            for (Map.Entry<Integer, List<String>> question : questions.entrySet()) {
                int questionId = question.getKey();
                List<String> answers = question.getValue();
                Map<String, Integer> answersCount = new HashMap<>();
                countFrequencies(answers, answersCount);
                AnswerReport mostCommon = null;

                for (Map.Entry<String, Integer> answer : answersCount.entrySet()) {
                    String answerString = answer.getKey();
                    double percentage = (double) answer.getValue() / (double) answers.size();
                    AnswerReport answerReport = new AnswerReport(answerString, percentage, sectionId, questionId);
                    answerReports.add(answerReport);

                    if (mostCommon == null) {
                        mostCommon = new AnswerReport(answerString, percentage, sectionId, questionId);
                    } else {
                        if (mostCommon.getPercentage() < percentage) {
                            mostCommon = new AnswerReport(answerString, percentage, sectionId, questionId);
                        }
                    }
                }
                mostCommonAnswers.add(mostCommon);
            }
        }

        StatisticalReport report = new StatisticalReport(questionnaireID, numberOfViews, answerReports, mostCommonAnswers);
        repo.save(report);
        return report;
    }


    /**
     * Count frequencies.
     *
     * @param list  the list
     * @param count the count
     */
    public void countFrequencies(List<String> list, Map<String, Integer> count) {
        for (String i : list) {
            Integer j = count.get(i);
            count.put(i, (j == null) ? 1 : j + 1);
        }
    }
}
