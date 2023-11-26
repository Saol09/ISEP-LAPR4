// Generated from D:/Users/User/Documentos/lei21_22_s4_2df_03/base.core/src/main/java/eapli/base/questionnaires/domain\questionnaire.g4 by ANTLR 4.10.1
package eapli.base.questionnaires.domain;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuestionnaireParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TK_NUMBER=11, TK_WORD=12, TK_NEWLINE=13, TK_QUESTIONMARK=14, 
		TK_SPECIALCHARS=15, TK_MANDATORY=16, TK_OPTIONAL=17, TK_DEPENDENT=18, 
		TK_WS=19;
	public static final int
		RULE_questionnaire = 0, RULE_section = 1, RULE_question = 2, RULE_param = 3, 
		RULE_paramSection = 4, RULE_paramQuestion = 5, RULE_extraInfo = 6, RULE_quest = 7, 
		RULE_multiple = 8, RULE_instruction = 9, RULE_questionMultiple = 10, RULE_questionFreeAnswer = 11, 
		RULE_repeat = 12, RULE_finalMessage = 13, RULE_wordNumber = 14, RULE_obligatoriness = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"questionnaire", "section", "question", "param", "paramSection", "paramQuestion", 
			"extraInfo", "quest", "multiple", "instruction", "questionMultiple", 
			"questionFreeAnswer", "repeat", "finalMessage", "wordNumber", "obligatoriness"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ID: '", "'Title: '", "'Final Message: '", "'Section ID: '", "'Section Title: '", 
			"'Question Type: 2'", "'Question ID: '", "'Extra Info: '", "'Question Type: 1'", 
			"'Section Repeat: '", null, null, "'\\n'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "TK_NUMBER", 
			"TK_WORD", "TK_NEWLINE", "TK_QUESTIONMARK", "TK_SPECIALCHARS", "TK_MANDATORY", 
			"TK_OPTIONAL", "TK_DEPENDENT", "TK_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "questionnaire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionnaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QuestionnaireContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QuestionnaireParser.EOF, 0); }
		public QuestionnaireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionnaire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterQuestionnaire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitQuestionnaire(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestionnaire(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionnaireContext questionnaire() throws RecognitionException {
		QuestionnaireContext _localctx = new QuestionnaireContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_questionnaire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			param();
			setState(33);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionContext extends ParserRuleContext {
		public ParamSectionContext paramSection() {
			return getRuleContext(ParamSectionContext.class,0);
		}
		public TerminalNode TK_NEWLINE() { return getToken(QuestionnaireParser.TK_NEWLINE, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			paramSection();
			setState(36);
			match(TK_NEWLINE);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				question();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 || _la==T__8 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public ParamQuestionContext paramQuestion() {
			return getRuleContext(ParamQuestionContext.class,0);
		}
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			paramQuestion();
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(43);
					match(TK_NEWLINE);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public FinalMessageContext finalMessage() {
			return getRuleContext(FinalMessageContext.class,0);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				match(TK_NUMBER);
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_NUMBER );
			setState(55);
			match(TK_NEWLINE);
			setState(56);
			match(T__1);
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				match(TK_WORD);
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TK_NUMBER) {
				{
				{
				setState(62);
				match(TK_NUMBER);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(TK_NEWLINE);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				match(TK_WORD);
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			setState(74);
			match(TK_NEWLINE);
			setState(75);
			match(TK_NEWLINE);
			setState(77); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(76);
				section();
				}
				}
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(81);
			match(TK_NEWLINE);
			setState(82);
			match(T__2);
			setState(83);
			finalMessage();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamSectionContext extends ParserRuleContext {
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public RepeatContext repeat() {
			return getRuleContext(RepeatContext.class,0);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public ParamSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterParamSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitParamSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitParamSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamSectionContext paramSection() throws RecognitionException {
		ParamSectionContext _localctx = new ParamSectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__3);
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				match(TK_NUMBER);
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_NUMBER );
			setState(91);
			match(TK_NEWLINE);
			setState(92);
			match(T__4);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				match(TK_WORD);
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TK_NUMBER) {
				{
				{
				setState(98);
				match(TK_NUMBER);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(TK_NEWLINE);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				match(TK_WORD);
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			setState(110);
			match(TK_NEWLINE);
			setState(111);
			obligatoriness();
			setState(112);
			match(TK_NEWLINE);
			setState(113);
			repeat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamQuestionContext extends ParserRuleContext {
		public QuestionMultipleContext questionMultiple() {
			return getRuleContext(QuestionMultipleContext.class,0);
		}
		public QuestionFreeAnswerContext questionFreeAnswer() {
			return getRuleContext(QuestionFreeAnswerContext.class,0);
		}
		public ParamQuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramQuestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterParamQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitParamQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitParamQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamQuestionContext paramQuestion() throws RecognitionException {
		ParamQuestionContext _localctx = new ParamQuestionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramQuestion);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				questionMultiple();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				questionFreeAnswer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtraInfoContext extends ParserRuleContext {
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public ExtraInfoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extraInfo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterExtraInfo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitExtraInfo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitExtraInfo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtraInfoContext extraInfo() throws RecognitionException {
		ExtraInfoContext _localctx = new ExtraInfoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_extraInfo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				match(TK_WORD);
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestContext extends ParserRuleContext {
		public TerminalNode TK_NEWLINE() { return getToken(QuestionnaireParser.TK_NEWLINE, 0); }
		public List<TerminalNode> TK_QUESTIONMARK() { return getTokens(QuestionnaireParser.TK_QUESTIONMARK); }
		public TerminalNode TK_QUESTIONMARK(int i) {
			return getToken(QuestionnaireParser.TK_QUESTIONMARK, i);
		}
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public QuestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterQuest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitQuest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==TK_NUMBER || _la==TK_WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_NUMBER || _la==TK_WORD );
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				match(TK_QUESTIONMARK);
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_QUESTIONMARK );
			setState(134);
			match(TK_NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultipleContext extends ParserRuleContext {
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public List<TerminalNode> TK_SPECIALCHARS() { return getTokens(QuestionnaireParser.TK_SPECIALCHARS); }
		public TerminalNode TK_SPECIALCHARS(int i) {
			return getToken(QuestionnaireParser.TK_SPECIALCHARS, i);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public MultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleContext multiple() throws RecognitionException {
		MultipleContext _localctx = new MultipleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(137); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(136);
							match(TK_WORD);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(139); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==TK_SPECIALCHARS) {
						{
						{
						setState(141);
						match(TK_SPECIALCHARS);
						}
						}
						setState(146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(147);
						_la = _input.LA(1);
						if ( !(_la==TK_NUMBER || _la==TK_WORD) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(150); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==TK_NUMBER || _la==TK_WORD );
					setState(152);
					match(TK_NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(155); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public TerminalNode TK_WORD() { return getToken(QuestionnaireParser.TK_WORD, 0); }
		public TerminalNode TK_NEWLINE() { return getToken(QuestionnaireParser.TK_NEWLINE, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instruction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_WORD) {
				{
				setState(157);
				match(TK_WORD);
				}
			}

			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_NEWLINE) {
				{
				setState(160);
				match(TK_NEWLINE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionMultipleContext extends ParserRuleContext {
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public MultipleContext multiple() {
			return getRuleContext(MultipleContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public ExtraInfoContext extraInfo() {
			return getRuleContext(ExtraInfoContext.class,0);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public QuestionMultipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionMultiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterQuestionMultiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitQuestionMultiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestionMultiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionMultipleContext questionMultiple() throws RecognitionException {
		QuestionMultipleContext _localctx = new QuestionMultipleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_questionMultiple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__5);
			setState(164);
			match(TK_NEWLINE);
			setState(165);
			match(T__6);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(TK_NUMBER);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_NUMBER );
			setState(171);
			match(TK_NEWLINE);
			setState(172);
			quest();
			setState(173);
			multiple();
			setState(174);
			instruction();
			setState(175);
			obligatoriness();
			setState(176);
			match(TK_NEWLINE);
			setState(177);
			match(T__7);
			setState(178);
			extraInfo();
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(179);
					match(TK_NEWLINE);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionFreeAnswerContext extends ParserRuleContext {
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public ExtraInfoContext extraInfo() {
			return getRuleContext(ExtraInfoContext.class,0);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public QuestionFreeAnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionFreeAnswer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterQuestionFreeAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitQuestionFreeAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitQuestionFreeAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionFreeAnswerContext questionFreeAnswer() throws RecognitionException {
		QuestionFreeAnswerContext _localctx = new QuestionFreeAnswerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_questionFreeAnswer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__8);
			setState(186);
			match(TK_NEWLINE);
			setState(187);
			match(T__6);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				match(TK_NUMBER);
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_NUMBER );
			setState(193);
			match(TK_NEWLINE);
			setState(194);
			quest();
			setState(195);
			instruction();
			setState(196);
			obligatoriness();
			setState(197);
			match(TK_NEWLINE);
			setState(198);
			match(T__7);
			setState(199);
			extraInfo();
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200);
					match(TK_NEWLINE);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatContext extends ParserRuleContext {
		public TerminalNode TK_NUMBER() { return getToken(QuestionnaireParser.TK_NUMBER, 0); }
		public TerminalNode TK_NEWLINE() { return getToken(QuestionnaireParser.TK_NEWLINE, 0); }
		public RepeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterRepeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitRepeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitRepeat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatContext repeat() throws RecognitionException {
		RepeatContext _localctx = new RepeatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(206);
				match(T__9);
				}
			}

			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_NUMBER) {
				{
				setState(209);
				match(TK_NUMBER);
				}
			}

			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(212);
				match(TK_NEWLINE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalMessageContext extends ParserRuleContext {
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public List<TerminalNode> TK_NEWLINE() { return getTokens(QuestionnaireParser.TK_NEWLINE); }
		public TerminalNode TK_NEWLINE(int i) {
			return getToken(QuestionnaireParser.TK_NEWLINE, i);
		}
		public FinalMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterFinalMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitFinalMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitFinalMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalMessageContext finalMessage() throws RecognitionException {
		FinalMessageContext _localctx = new FinalMessageContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_finalMessage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(215);
				match(TK_WORD);
				}
				}
				setState(218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TK_WORD );
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TK_NEWLINE) {
				{
				{
				setState(220);
				match(TK_NEWLINE);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WordNumberContext extends ParserRuleContext {
		public List<TerminalNode> TK_WORD() { return getTokens(QuestionnaireParser.TK_WORD); }
		public TerminalNode TK_WORD(int i) {
			return getToken(QuestionnaireParser.TK_WORD, i);
		}
		public List<TerminalNode> TK_NUMBER() { return getTokens(QuestionnaireParser.TK_NUMBER); }
		public TerminalNode TK_NUMBER(int i) {
			return getToken(QuestionnaireParser.TK_NUMBER, i);
		}
		public WordNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterWordNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitWordNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitWordNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordNumberContext wordNumber() throws RecognitionException {
		WordNumberContext _localctx = new WordNumberContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_wordNumber);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_WORD) {
					{
					{
					setState(226);
					match(TK_WORD);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_NUMBER) {
					{
					{
					setState(232);
					match(TK_NUMBER);
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_NUMBER) {
					{
					{
					setState(238);
					match(TK_NUMBER);
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_WORD) {
					{
					{
					setState(244);
					match(TK_WORD);
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_WORD) {
					{
					{
					setState(250);
					match(TK_WORD);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TK_NUMBER) {
					{
					{
					setState(256);
					match(TK_NUMBER);
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObligatorinessContext extends ParserRuleContext {
		public TerminalNode TK_MANDATORY() { return getToken(QuestionnaireParser.TK_MANDATORY, 0); }
		public TerminalNode TK_OPTIONAL() { return getToken(QuestionnaireParser.TK_OPTIONAL, 0); }
		public TerminalNode TK_DEPENDENT() { return getToken(QuestionnaireParser.TK_DEPENDENT, 0); }
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionnaireListener) ((QuestionnaireListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionnaireVisitor) return ((QuestionnaireVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_obligatoriness);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TK_MANDATORY) | (1L << TK_OPTIONAL) | (1L << TK_DEPENDENT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013\u010b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001\'\b\u0001\u000b\u0001\f\u0001(\u0001\u0002\u0001\u0002"+
		"\u0005\u0002-\b\u0002\n\u0002\f\u00020\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0004\u00034\b\u0003\u000b\u0003\f\u00035\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0004\u0003;\b\u0003\u000b\u0003\f\u0003<\u0001\u0003\u0005\u0003"+
		"@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"G\b\u0003\u000b\u0003\f\u0003H\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003N\b\u0003\u000b\u0003\f\u0003O\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0004\u0004X\b\u0004\u000b\u0004"+
		"\f\u0004Y\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004_\b\u0004\u000b"+
		"\u0004\f\u0004`\u0001\u0004\u0005\u0004d\b\u0004\n\u0004\f\u0004g\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004k\b\u0004\u000b\u0004\f\u0004l\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0003\u0005v\b\u0005\u0001\u0006\u0004\u0006y\b\u0006\u000b\u0006"+
		"\f\u0006z\u0001\u0007\u0004\u0007~\b\u0007\u000b\u0007\f\u0007\u007f\u0001"+
		"\u0007\u0004\u0007\u0083\b\u0007\u000b\u0007\f\u0007\u0084\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0004\b\u008a\b\b\u000b\b\f\b\u008b\u0001\b\u0005"+
		"\b\u008f\b\b\n\b\f\b\u0092\t\b\u0001\b\u0004\b\u0095\b\b\u000b\b\f\b\u0096"+
		"\u0001\b\u0004\b\u009a\b\b\u000b\b\f\b\u009b\u0001\t\u0003\t\u009f\b\t"+
		"\u0001\t\u0003\t\u00a2\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00a8"+
		"\b\n\u000b\n\f\n\u00a9\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0005\n\u00b5\b\n\n\n\f\n\u00b8\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00be\b\u000b\u000b\u000b"+
		"\f\u000b\u00bf\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ca\b\u000b\n\u000b"+
		"\f\u000b\u00cd\t\u000b\u0001\f\u0003\f\u00d0\b\f\u0001\f\u0003\f\u00d3"+
		"\b\f\u0001\f\u0003\f\u00d6\b\f\u0001\r\u0004\r\u00d9\b\r\u000b\r\f\r\u00da"+
		"\u0001\r\u0005\r\u00de\b\r\n\r\f\r\u00e1\t\r\u0001\u000e\u0005\u000e\u00e4"+
		"\b\u000e\n\u000e\f\u000e\u00e7\t\u000e\u0001\u000e\u0005\u000e\u00ea\b"+
		"\u000e\n\u000e\f\u000e\u00ed\t\u000e\u0001\u000e\u0005\u000e\u00f0\b\u000e"+
		"\n\u000e\f\u000e\u00f3\t\u000e\u0001\u000e\u0005\u000e\u00f6\b\u000e\n"+
		"\u000e\f\u000e\u00f9\t\u000e\u0001\u000e\u0005\u000e\u00fc\b\u000e\n\u000e"+
		"\f\u000e\u00ff\t\u000e\u0001\u000e\u0005\u000e\u0102\b\u000e\n\u000e\f"+
		"\u000e\u0105\t\u000e\u0003\u000e\u0107\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0002\u0001\u0000\u000b"+
		"\f\u0001\u0000\u0010\u0012\u0121\u0000 \u0001\u0000\u0000\u0000\u0002"+
		"#\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u00061\u0001"+
		"\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nu\u0001\u0000\u0000\u0000"+
		"\fx\u0001\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u0099"+
		"\u0001\u0000\u0000\u0000\u0012\u009e\u0001\u0000\u0000\u0000\u0014\u00a3"+
		"\u0001\u0000\u0000\u0000\u0016\u00b9\u0001\u0000\u0000\u0000\u0018\u00cf"+
		"\u0001\u0000\u0000\u0000\u001a\u00d8\u0001\u0000\u0000\u0000\u001c\u0106"+
		"\u0001\u0000\u0000\u0000\u001e\u0108\u0001\u0000\u0000\u0000 !\u0003\u0006"+
		"\u0003\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001\u0000\u0000\u0000"+
		"#$\u0003\b\u0004\u0000$&\u0005\r\u0000\u0000%\'\u0003\u0004\u0002\u0000"+
		"&%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000()\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*.\u0003"+
		"\n\u0005\u0000+-\u0005\r\u0000\u0000,+\u0001\u0000\u0000\u0000-0\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/\u0005\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000013\u0005\u0001"+
		"\u0000\u000024\u0005\u000b\u0000\u000032\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u000078\u0005\r\u0000\u00008:\u0005\u0002\u0000\u0000"+
		"9;\u0005\f\u0000\u0000:9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=A\u0001\u0000\u0000"+
		"\u0000>@\u0005\u000b\u0000\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001"+
		"\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DF\u0005\r\u0000\u0000EG\u0005"+
		"\f\u0000\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"JK\u0005\r\u0000\u0000KM\u0005\r\u0000\u0000LN\u0003\u0002\u0001\u0000"+
		"ML\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0005\r\u0000"+
		"\u0000RS\u0005\u0003\u0000\u0000ST\u0003\u001a\r\u0000T\u0007\u0001\u0000"+
		"\u0000\u0000UW\u0005\u0004\u0000\u0000VX\u0005\u000b\u0000\u0000WV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005\r\u0000"+
		"\u0000\\^\u0005\u0005\u0000\u0000]_\u0005\f\u0000\u0000^]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ae\u0001\u0000\u0000\u0000bd\u0005\u000b\u0000\u0000"+
		"cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000hj\u0005\r\u0000\u0000ik\u0005\f\u0000\u0000ji\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\r\u0000\u0000op\u0003"+
		"\u001e\u000f\u0000pq\u0005\r\u0000\u0000qr\u0003\u0018\f\u0000r\t\u0001"+
		"\u0000\u0000\u0000sv\u0003\u0014\n\u0000tv\u0003\u0016\u000b\u0000us\u0001"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000v\u000b\u0001\u0000\u0000"+
		"\u0000wy\u0005\f\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\r\u0001\u0000"+
		"\u0000\u0000|~\u0007\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081\u0083\u0005"+
		"\u000e\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0005"+
		"\r\u0000\u0000\u0087\u000f\u0001\u0000\u0000\u0000\u0088\u008a\u0005\f"+
		"\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u0090\u0001\u0000\u0000\u0000\u008d\u008f\u0005\u000f"+
		"\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000"+
		"\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0093\u0095\u0007\u0000\u0000\u0000\u0094\u0093\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u009a\u0005\r\u0000\u0000\u0099\u0089\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u0011\u0001\u0000\u0000"+
		"\u0000\u009d\u009f\u0005\f\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a2\u0005\r\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u0013\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0005\u0006\u0000\u0000\u00a4\u00a5\u0005\r\u0000\u0000\u00a5\u00a7"+
		"\u0005\u0007\u0000\u0000\u00a6\u00a8\u0005\u000b\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\r\u0000\u0000\u00ac\u00ad\u0003"+
		"\u000e\u0007\u0000\u00ad\u00ae\u0003\u0010\b\u0000\u00ae\u00af\u0003\u0012"+
		"\t\u0000\u00af\u00b0\u0003\u001e\u000f\u0000\u00b0\u00b1\u0005\r\u0000"+
		"\u0000\u00b1\u00b2\u0005\b\u0000\u0000\u00b2\u00b6\u0003\f\u0006\u0000"+
		"\u00b3\u00b5\u0005\r\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u0015\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\t\u0000\u0000\u00ba\u00bb"+
		"\u0005\r\u0000\u0000\u00bb\u00bd\u0005\u0007\u0000\u0000\u00bc\u00be\u0005"+
		"\u000b\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005"+
		"\r\u0000\u0000\u00c2\u00c3\u0003\u000e\u0007\u0000\u00c3\u00c4\u0003\u0012"+
		"\t\u0000\u00c4\u00c5\u0003\u001e\u000f\u0000\u00c5\u00c6\u0005\r\u0000"+
		"\u0000\u00c6\u00c7\u0005\b\u0000\u0000\u00c7\u00cb\u0003\f\u0006\u0000"+
		"\u00c8\u00ca\u0005\r\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u0017\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005\n\u0000\u0000\u00cf\u00ce"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u000b\u0000\u0000\u00d2\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d6\u0005\r\u0000\u0000\u00d5\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u0019\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d9\u0005\f\u0000\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00df\u0001\u0000"+
		"\u0000\u0000\u00dc\u00de\u0005\r\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u001b\u0001\u0000\u0000"+
		"\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e4\u0005\f\u0000\u0000"+
		"\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e6\u00eb\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0005\u000b\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u0107\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f0\u0005\u000b\u0000\u0000"+
		"\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f7\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f6\u0005\f\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f8\u0107\u0001\u0000\u0000\u0000\u00f9"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fa\u00fc\u0005\f\u0000\u0000\u00fb\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u0107"+
		"\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0102"+
		"\u0005\u000b\u0000\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105"+
		"\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0106\u00e5\u0001\u0000\u0000\u0000\u0106\u00f1"+
		"\u0001\u0000\u0000\u0000\u0106\u00fd\u0001\u0000\u0000\u0000\u0106\u0103"+
		"\u0001\u0000\u0000\u0000\u0107\u001d\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0007\u0001\u0000\u0000\u0109\u001f\u0001\u0000\u0000\u0000%(.5<AHOY"+
		"`eluz\u007f\u0084\u008b\u0090\u0096\u009b\u009e\u00a1\u00a9\u00b6\u00bf"+
		"\u00cb\u00cf\u00d2\u00d5\u00da\u00df\u00e5\u00eb\u00f1\u00f7\u00fd\u0103"+
		"\u0106";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}