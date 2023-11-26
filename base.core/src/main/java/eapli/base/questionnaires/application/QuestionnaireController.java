package eapli.base.questionnaires.application;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaires.domain.Answer;
import eapli.base.questionnaires.domain.QuestionnaireString;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;

public class QuestionnaireController {


    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CostumerRepository repositoryC = PersistenceContext.repositories().costumerRepository();


    QuestionnaireServices services = new QuestionnaireServices();

    public ArrayList<String> allQuestionnaires() {


        Iterable<QuestionnaireString> questionnaires = services.allQuestionnaires();

        return doList(questionnaires);
    }


    public String[] organizeQuestioner(String quest) {


        String[] questiondivison = quest.split("\r\n\r\n");

        return questiondivison;

    }

    public String questionnaireWithID(int id) {


        QuestionnaireString questionnaires = services.findByQuestId(String.valueOf(id));


        return questionnaires.getQuestionnaire();

    }


    public void submitAnswers(ArrayList<String[]> answersList, String email) {
        Costumer costumer = repositoryC.findCostumerByEmail(new Email(email));

        for (String[] answers : answersList) {

            Answer answer = new Answer(answers, costumer);

            services.saveAnswer(answer);
        }


    }


    private ArrayList<String> doList(Iterable<QuestionnaireString> questionnaires) {
        ArrayList<String> quests = new ArrayList<>();
        for (QuestionnaireString questionnaireString : questionnaires) {
            quests.add(questionnaireString.identity());
        }


        return quests;
    }


}
