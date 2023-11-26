package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.questionnaires.application.QuestionnaireController;
import eapli.base.questionnaires.application.StatisticalReportController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Objects;

public class StatisticalReportUI extends AbstractUI {

    StatisticalReportController controller = new StatisticalReportController();
    QuestionnaireController ctr = new QuestionnaireController();

    @Override
    protected boolean doShow() {

        ArrayList<String> arrayList = ctr.allQuestionnaires();
        for (String quest : arrayList) {
            System.out.println("Questionnaire:" + quest);
        }
        int numQuest = 0;
        numQuest = Console.readInteger("Choose Questionnaire by the ID: ");

        controller.createInfo((long) numQuest);
        System.out.println(controller.createReport((long) numQuest));

        return false;
    }

    @Override
    public String headline() {
        return "Validate Questionnaire";
    }
}


