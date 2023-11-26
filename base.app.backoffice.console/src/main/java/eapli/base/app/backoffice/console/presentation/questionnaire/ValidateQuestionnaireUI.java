package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.questionnaires.application.CreateQuestionnaireController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class ValidateQuestionnaireUI extends AbstractUI {
    CreateQuestionnaireController controller = new CreateQuestionnaireController();

    @Override
    protected boolean doShow() {
        String input = Console.readLine("Please insert File name: ");

        try {
            controller.validateQuestionnaire(input);
            controller.saveQuestionnaireString(input);
            controller.saveQuest(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Validate Questionnaire";
    }
}
