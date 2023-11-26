package eapli.base.persistence.impl.inmemory;

import eapli.base.questionnaires.domain.Questionnaire;
import eapli.base.questionnaires.domain.QuestionnaireString;
import eapli.base.questionnaires.repository.QuestionnaireRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.function.Consumer;

public class InMemoryQuestionnaireRepository extends InMemoryDomainRepository<QuestionnaireString,String> implements QuestionnaireRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public QuestionnaireString findByQuestId(final String id) {
        return (QuestionnaireString) match(e -> e.getId().equals(id));
    }
}
