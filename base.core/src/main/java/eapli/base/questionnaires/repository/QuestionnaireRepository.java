package eapli.base.questionnaires.repository;

import eapli.base.questionnaires.domain.Questionnaire;
import eapli.base.questionnaires.domain.QuestionnaireString;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Questionnaire repository.
 */
public interface QuestionnaireRepository extends DomainRepository<String, QuestionnaireString> {
    QuestionnaireString findByQuestId(String id);
}
