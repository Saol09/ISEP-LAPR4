package eapli.base.questionnaires.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionnaires.domain.*;
import eapli.base.questionnaires.repository.QuestionnaireRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * The type Create questionnaire controller.
 */
public class CreateQuestionnaireController {

    private final QuestionnaireRepository repo = PersistenceContext.repositories().questionnaireRepository();

    private AuthorizationService authz = AuthzRegistry.authorizationService();

    QuestionnaireServices services = new QuestionnaireServices();

    private QuestionnaireString questionnaireString;

    /**
     * Validate questionnaire questionnaire.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void validateQuestionnaire(final String file) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);
        QuestionnaireMain.parseWithVisitor(file);
    }


    public void createQuestionnaire(int id, String title, String welcomeMess, List<Section> sections, String finalMessg) throws FileNotFoundException {

        File file = new File("Questionnaire" + id + ".txt");
        PrintWriter writer = new PrintWriter(file);

        //questionnaire
        writer.println("ID: " + id);
        writer.println("Title: " + title);
        writer.println(welcomeMess+"\n");

        //section
        for (Section section : sections) {

            writer.println("Section ID: " + section.getSectionId());
            writer.println("Section Title: " + section.getSectionTitle());
            writer.println(section.getSectionDescription());
            writer.println("{" + section.getObligatoriness() + "}");

            //optional
            if (section.getRepeatability() > 1) {
                writer.println("Section Repeat: " + section.getRepeatability());
            } else {
                writer.println("");
            }

            for (Question question : section.getContent()) {
                //question
                writer.println("Question Type: " + question.getQuestionType());
                writer.println("Question ID: " + question.getQuestionId());
                writer.println(question.getQuestion());

                //optional
                if (!question.getInstruction().equals("")) {
                    writer.println(question.getInstruction());
                } else {
                    writer.print("");
                }
                writer.println("{" + question.getObligatoriness() + "}");
                writer.println("Extra Info: " + question.getExtraInfo()+"\n");
            }
        }
        writer.println("Final Message: " + finalMessg);
        writer.close();
    }

    public Section buildSection(long sectionId, String sectionTitle, String sectionDescription, String obligatoriness, int repeatability, List<Question> content) {
        Section section = new Section(sectionId, sectionTitle, sectionDescription, obligatoriness, repeatability, content);
        return section;
    }

    public Question buildQuestion(Integer quetionType, long questionId, String question, String instruction, String obligatoriness, String extraInfo) {
        Question quest = new Question(quetionType, questionId, question, instruction, obligatoriness, extraInfo);
        return quest;
    }


    public boolean checkQuestionnaireId(String id) {
        QuestionnaireString questFound = services.findByQuestId(id);

        return questFound != null;
    }

    public QuestionnaireString findQuestionnaire(String id) {
        QuestionnaireString questF = services.findByQuestId(id);

        return questF;
    }

    public void saveQuestionnaireString(final String file) throws IOException {
        Path filePath = Path.of(file);

        String questionnaire = Files.readString(filePath);
        questionnaireString = new QuestionnaireString(questionnaire);
    }

    public void saveQuest(final String file) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_MANAGER, BaseRoles.POWER_USER, BaseRoles.ADMIN);
        QuestionnaireMain questionnaireMain = new QuestionnaireMain();
        if (questionnaireMain.parseWithVisitorBoolean(file) && questionnaireString != null) {
            repo.save(questionnaireString);
            System.out.println("\nThis Questionnaire has been saved into database.");
        } else {
            System.out.println("\nThis Questionnaire will not be saved into database.");
        }

    }

}