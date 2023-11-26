package eapli.base.questionnaires.application;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Questionnaire info controller.
 */
public class QuestionnaireInfoController {

    private final Map<Integer, Map<Integer, List<String>>> sections = new HashMap<>();


    /**
     * Add answer.
     *
     * @param sectionId  the section id
     * @param questionId the question id
     * @param answer     the answer
     */
    public void addAnswer(Integer sectionId, Integer questionId, String answer) {
        Map<Integer, List<String>> section = sections.get(sectionId);
        if (section == null) {
            Map<Integer, List<String>> newSection = new HashMap<>();
            addQuestion(newSection, questionId, answer);
            sections.put(sectionId, newSection);
        } else {
            addQuestion(section, questionId, answer);
            sections.put(sectionId, section);
        }
    }

    private void addQuestion(Map<Integer, List<String>> section, Integer questionId, String answer) {
        List<String> answers = section.get(questionId);
        if (answers == null) {
            List<String> newAnswers = new LinkedList<>();
            newAnswers.add(answer);
            section.put(questionId, newAnswers);
        } else {
            answers.add(answer);
        }
    }

    /**
     * Get number of views long.
     *
     * @return the long
     */
    public long getNumberOfViews(){
        Map.Entry<Integer, Map<Integer, List<String>>> sectionEntry = sections.entrySet().iterator().next();
        Map<Integer, List<String>> questions = sectionEntry.getValue();
        Map.Entry<Integer, List<String>> questionEntry = questions.entrySet().iterator().next();
        long numberOfViews = questionEntry.getValue().size();
        return numberOfViews;
    }

    /**
     * Gets sections.
     *
     * @return the sections
     */
    public Map<Integer, Map<Integer, List<String>>> getSections() {
        return sections;
    }
}
