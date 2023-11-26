// Generated from D:/Users/User/Documentos/lei21_22_s4_2df_03/base.core/src/main/java/eapli/base/questionnaires/domain\questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaires.domain;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionnaireParser}.
 */
public interface QuestionnaireListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(QuestionnaireParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QuestionnaireParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionnaireParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(QuestionnaireParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(QuestionnaireParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#paramSection}.
	 * @param ctx the parse tree
	 */
	void enterParamSection(QuestionnaireParser.ParamSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#paramSection}.
	 * @param ctx the parse tree
	 */
	void exitParamSection(QuestionnaireParser.ParamSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#paramQuestion}.
	 * @param ctx the parse tree
	 */
	void enterParamQuestion(QuestionnaireParser.ParamQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#paramQuestion}.
	 * @param ctx the parse tree
	 */
	void exitParamQuestion(QuestionnaireParser.ParamQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#extraInfo}.
	 * @param ctx the parse tree
	 */
	void enterExtraInfo(QuestionnaireParser.ExtraInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#extraInfo}.
	 * @param ctx the parse tree
	 */
	void exitExtraInfo(QuestionnaireParser.ExtraInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#quest}.
	 * @param ctx the parse tree
	 */
	void enterQuest(QuestionnaireParser.QuestContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#quest}.
	 * @param ctx the parse tree
	 */
	void exitQuest(QuestionnaireParser.QuestContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#multiple}.
	 * @param ctx the parse tree
	 */
	void enterMultiple(QuestionnaireParser.MultipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#multiple}.
	 * @param ctx the parse tree
	 */
	void exitMultiple(QuestionnaireParser.MultipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(QuestionnaireParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(QuestionnaireParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionMultiple}.
	 * @param ctx the parse tree
	 */
	void enterQuestionMultiple(QuestionnaireParser.QuestionMultipleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionMultiple}.
	 * @param ctx the parse tree
	 */
	void exitQuestionMultiple(QuestionnaireParser.QuestionMultipleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#questionFreeAnswer}.
	 * @param ctx the parse tree
	 */
	void enterQuestionFreeAnswer(QuestionnaireParser.QuestionFreeAnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#questionFreeAnswer}.
	 * @param ctx the parse tree
	 */
	void exitQuestionFreeAnswer(QuestionnaireParser.QuestionFreeAnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#repeat}.
	 * @param ctx the parse tree
	 */
	void enterRepeat(QuestionnaireParser.RepeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#repeat}.
	 * @param ctx the parse tree
	 */
	void exitRepeat(QuestionnaireParser.RepeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void enterFinalMessage(QuestionnaireParser.FinalMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#finalMessage}.
	 * @param ctx the parse tree
	 */
	void exitFinalMessage(QuestionnaireParser.FinalMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#wordNumber}.
	 * @param ctx the parse tree
	 */
	void enterWordNumber(QuestionnaireParser.WordNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#wordNumber}.
	 * @param ctx the parse tree
	 */
	void exitWordNumber(QuestionnaireParser.WordNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void enterObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionnaireParser#obligatoriness}.
	 * @param ctx the parse tree
	 */
	void exitObligatoriness(QuestionnaireParser.ObligatorinessContext ctx);
}