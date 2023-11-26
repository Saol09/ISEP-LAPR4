package eapli.base.questionnaires.application;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaires.domain.Answer;
import eapli.base.questionnaires.domain.QuestionnaireString;
import eapli.base.questionnaires.repository.AnswerRepository;
import eapli.base.questionnaires.repository.QuestionnaireRepository;

public class QuestionnaireServices {
    private final QuestionnaireRepository repository = PersistenceContext.repositories().questionnaireRepository();
    private final AnswerRepository repositoryA = PersistenceContext.repositories().answerRepository();



    public QuestionnaireString findByQuestId(String id) {
        return repository.findByQuestId(id);
    }

    public Iterable<QuestionnaireString> allQuestionnaires(){
        return repository.findAll();
    }


    public void saveAnswer(Answer answer){
        repositoryA.save(answer);
    }

    public Iterable<Answer> allAnswer(){
        return repositoryA.findAll();
    }




}
