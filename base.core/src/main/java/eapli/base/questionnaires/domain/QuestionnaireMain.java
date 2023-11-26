package eapli.base.questionnaires.domain;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * The type Questionnaire main.
 */
public class QuestionnaireMain {


    /**
     * Parse with visitor.
     *
     * @param file the file
     */
    public static void parseWithVisitor(String file) throws IOException {

        try {
            QuestionnaireLexer lexer = new QuestionnaireLexer(CharStreams.fromFileName(file));
            lexer.removeErrorListeners();
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuestionnaireParser parser = new QuestionnaireParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());
            ParseTree tree = parser.questionnaire();
            QuestionnaireVisitor eval = new QuestionnaireMainVisitor();
            eval.visit(tree);
            System.out.println("\nThe Questionnaire is in the right format.");
        } catch (IOException e) {
            System.out.println("\nMake sure the file has the correct path");
            throw new IOException();
        } catch (ParseCancellationException e) {
            System.out.println("\nThe Questionnaire does not follow the required format.");
        }

    }

    public boolean parseWithVisitorBoolean(String file) {

        try {
            QuestionnaireLexer lexer = new QuestionnaireLexer(CharStreams.fromFileName(file));
            lexer.removeErrorListeners();
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QuestionnaireParser parser = new QuestionnaireParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new ErrorListener());
            ParseTree tree = parser.questionnaire();
            QuestionnaireVisitor eval = new QuestionnaireMainVisitor();
            eval.visit(tree);
            return true;
        } catch (IOException | ParseCancellationException e) {
            return false;
        }
    }


}
