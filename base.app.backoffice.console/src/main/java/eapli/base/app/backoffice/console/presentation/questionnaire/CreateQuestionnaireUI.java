package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.questionnaires.application.CreateQuestionnaireController;
//import eapli.base.questionnaires.application.ListSection;
import eapli.base.questionnaires.domain.Answer;
import eapli.base.questionnaires.domain.Question;
import eapli.base.questionnaires.domain.Section;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionnaireUI extends AbstractUI {

    private final CreateQuestionnaireController ctr = new CreateQuestionnaireController();

    @Override
    protected boolean doShow() {
        int id = Console.readInteger("Insert Questionnaire ID: ");
        String title = Console.readLine("Insert Questionnaire Title: ");
        String welcome = Console.readLine("Insert Questionnaire Welcome Message: ");

        //section
        List<Section> sectionList = new ArrayList<>();

        int sectionId = 0;
        boolean sectionVerify = false;
        boolean questionVerify = false;
        do {
            sectionId++;
            int sectionID = sectionId;
            String sectionTitle = Console.readLine("Insert Section Title: ");
            String sectionDescript = Console.readLine("Insert Section Description: ");
            String sectionObligt = Console.readLine("Insert Section Obligatoriness: ");

            int sectionRepeat = 0;
            String optionRepeat = Console.readLine("Do you want Repeat this Section? (Y/N)");
            while (!optionRepeat.equalsIgnoreCase("Y") && !optionRepeat.equalsIgnoreCase("N"))
                optionRepeat = Console.readLine("Wrong answer! Do you want to add Question Instruction? (Y/N)");
            if (optionRepeat.equalsIgnoreCase("Y")) {
                sectionRepeat = Console.readInteger("Insert Section Repeat: ");
            } else if (optionRepeat.equalsIgnoreCase("N")) {
                sectionRepeat = 1;
            }


            List<Question> questionList = new ArrayList<>();

            do {

                int questionType = Console.readInteger("Whats ur Question Type:\n\t1)Free Answer\n\t2)Multiple Choice");
                switch (questionType) {
                    case 1:
                        int questionId = Console.readInteger("Insert Question ID: ");
                        String quest = Console.readLine("Insert the Question: ");

                        String questInstruction = null;

                        String option = Console.readLine("Do you want to add Question Instruction? (Y/N)");
                        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N"))
                            option = Console.readLine("Wrong answer! Do you want to add Question Instruction? (Y/N)");
                        if (option.equalsIgnoreCase("Y")) {
                            questInstruction = Console.readLine("Insert Question Instruction: ");
                        } else if (option.equalsIgnoreCase("N")) {
                            questInstruction = ("");
                        }

                        String questionObligt = Console.readLine("Insert Question Obligatoriness: ");
                        String questionExtraInfo = Console.readLine("Insert Question Extra Info: ");


                        questionList.add(ctr.buildQuestion(questionType, questionId, quest, questInstruction, questionObligt, questionExtraInfo));

                        break;
                    case 2:

                        int questionIdMultiple = Console.readInteger("Insert Question ID: ");
                        StringBuilder questMultiple = new StringBuilder(Console.readLine("Insert the Question: "));
                        int numberanswers = Console.readInteger("How many Multiple Options: ");
                        for (int i = 0; i < numberanswers; i++) {
                            questMultiple.append("\n").append(Console.readLine(i + 1 + " choice: "));
                        }


                        String questInstructionMultiple = null;

                        String optionMultiple = Console.readLine("Do you want to add Question Instruction? (Y/N)");
                        while (!optionMultiple.equalsIgnoreCase("Y") && !optionMultiple.equalsIgnoreCase("N"))
                            optionMultiple = Console.readLine("Wrong answer! Do you want to add Question Instruction? (Y/N)");
                        if (optionMultiple.equalsIgnoreCase("Y")) {
                            questInstructionMultiple = Console.readLine("Insert Question Instruction: ");
                        } else if (optionMultiple.equalsIgnoreCase("N")) {
                            questInstructionMultiple = ("");
                        }

                        String questionObligtMultiple = Console.readLine("Insert Question Obligatoriness: ");
                        String questionExtraInfoMultiple = Console.readLine("Insert Question Extra Info: ");


                        questionList.add(ctr.buildQuestion(questionType, questionIdMultiple, questMultiple.toString(), questInstructionMultiple, questionObligtMultiple, questionExtraInfoMultiple));

                        break;
                    default:
                        continue;
                }

                String cont = Console.readLine("Do you want to add a new Question? (Y/N)");
                while (!cont.equalsIgnoreCase("Y") && !cont.equalsIgnoreCase("N"))
                    cont = Console.readLine("Wrong answer! Do you want to add  a new Question? (Y/N)");
                if (cont.equalsIgnoreCase("Y")) {
                    questionVerify = true;
                } else if (cont.equalsIgnoreCase("N")) {
                    questionVerify = false;
                }

            } while (questionVerify);

            sectionList.add(ctr.buildSection(sectionID, sectionTitle, sectionDescript, sectionObligt, sectionRepeat, questionList));


            String contSect = Console.readLine("Do you want to add a new Section? (Y/N)");
            while (!contSect.equalsIgnoreCase("Y") && !contSect.equalsIgnoreCase("N"))
                contSect = Console.readLine("Wrong answer! Do you want to add a new Section? (Y/N)");
            if (contSect.equalsIgnoreCase("Y")) {
                sectionVerify = true;
            } else if (contSect.equalsIgnoreCase("N")) {
                sectionVerify = false;
            }

        } while (sectionVerify);

        String finalMess = Console.readLine("Insert Questionnaire Final Message: ");

        try {
            ctr.createQuestionnaire(id, title, welcome, sectionList, finalMess);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Create New Questionnaire";
    }
}
