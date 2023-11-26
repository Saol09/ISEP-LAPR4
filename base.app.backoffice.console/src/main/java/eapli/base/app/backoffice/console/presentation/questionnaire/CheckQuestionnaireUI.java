package eapli.base.app.backoffice.console.presentation.questionnaire;

import eapli.base.questionnaires.application.QuestionnaireController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Objects;

public class CheckQuestionnaireUI extends AbstractUI {

    private final QuestionnaireController ctr = new QuestionnaireController();

    @Override
    protected boolean doShow() {
        ArrayList<String> arrayList = ctr.allQuestionnaires();
        for (String quest : arrayList) {
            System.out.println("Questionnaire:" + quest);
        }
        boolean correct = false;
        int numQuest = 0;
        do {
            numQuest = Console.readInteger("Choose Questionnaire by the number: ");
            for (String quest : arrayList) {
                if (Objects.equals(quest, String.valueOf(numQuest))) {
                    correct = true;
                }
            }
        } while (!correct);


        String question = ctr.questionnaireWithID(numQuest);
        System.out.println(question);

        String yesNo = null;
        do {
            yesNo = Console.readLine("Do you want to answer the questionnaire [Y/N] ");

        } while (!yesNo.equalsIgnoreCase("N") && !yesNo.equalsIgnoreCase("Y"));

        if (yesNo.equalsIgnoreCase("Y")) {
            ArrayList<String[]> answersList = new ArrayList<>();
            int qt;
            int qId;
            int sId = 0;


            for (String line : ctr.organizeQuestioner(question)) {

                if (line.charAt(0) == 'S') {
                    sId = Integer.parseInt(String.valueOf(line.charAt(12)));
                    System.out.println(line + "\n");
                } else if (line.charAt(0) == 'Q') {
                    qt = Integer.parseInt(String.valueOf(line.charAt(15)));
                    qId = Integer.parseInt(String.valueOf(line.charAt(31)));

                    String answer;
                    System.out.println(line + "\n");

                    if (qt == 2) {
                        String[] spliter = line.split("\r\n");
                        ArrayList<String> an = new ArrayList<>();
                        for (int i = 3; i < spliter.length - 2; i++) {
                            an.add(String.valueOf(spliter[i].charAt(0)));
                        }
                        do {
                            answer = Console.readLine("answer :");
                            if (answer == null) {
                                break;
                            }
                            for (String a : an) {
                                if (answer.equals(a)) {
                                    correct = false;
                                    break;
                                }
                            }
                        } while (correct);
                        String[] questAnswer = {String.valueOf(numQuest), String.valueOf(sId), String.valueOf(qt), String.valueOf(qId), answer};
                        answersList.add(questAnswer);
                    } else {
                        answer = Console.readLine("answer:");

                        String[] questAnswer = {String.valueOf(numQuest), String.valueOf(sId), String.valueOf(qt), String.valueOf(qId), answer};
                        answersList.add(questAnswer);
                    }


                } else {
                    System.out.println(line);
                }


            }

            yesNo = null;
            do {
                yesNo = Console.readLine("save answers? [Y/N] ");

            } while (!yesNo.equalsIgnoreCase("N") && !yesNo.equalsIgnoreCase("Y"));

            if(yesNo.equalsIgnoreCase("Y")){
                String email = Console.readLine("email if you want: ");
                ctr.submitAnswers(answersList,email);
            }


        }


        return false;
    }

    @Override
    public String headline() {
        return "Show Questionnaires";
    }


}
