// Generated from D:/Users/User/Documentos/lei21_22_s4_2df_03/base.core/src/main/java/eapli/base/questionnaires/domain\questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaires.domain;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionnaireParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionnaireVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(QuestionnaireParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#paramSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamSection(QuestionnaireParser.ParamSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#paramQuestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamQuestion(QuestionnaireParser.ParamQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#extraInfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtraInfo(QuestionnaireParser.ExtraInfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuest(QuestionnaireParser.QuestContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#multiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple(QuestionnaireParser.MultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(QuestionnaireParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionMultiple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionMultiple(QuestionnaireParser.QuestionMultipleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#questionFreeAnswer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionFreeAnswer(QuestionnaireParser.QuestionFreeAnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#repeat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat(QuestionnaireParser.RepeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#finalMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalMessage(QuestionnaireParser.FinalMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#wordNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWordNumber(QuestionnaireParser.WordNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
}