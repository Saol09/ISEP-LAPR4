grammar questionnaire;

questionnaire: param EOF;

section: paramSection TK_NEWLINE question+;

question: paramQuestion TK_NEWLINE*; //answer+;

param: 'ID: ' TK_NUMBER+ TK_NEWLINE
       'Title: ' TK_WORD+ TK_NUMBER* TK_NEWLINE
       TK_WORD+ TK_NEWLINE//welcome message
       TK_NEWLINE section+ TK_NEWLINE
       'Final Message: 'finalMessage;

paramSection: 'Section ID: ' TK_NUMBER+ TK_NEWLINE
              'Section Title: ' TK_WORD+ TK_NUMBER* TK_NEWLINE
              TK_WORD+  TK_NEWLINE //description
              obligatoriness TK_NEWLINE
              repeat ; //repetição ???


paramQuestion: questionMultiple
              | questionFreeAnswer
              ; //ID QUESTAO INSTRUCTION TYPE OBLI EXTRA

extraInfo: TK_WORD+ ;

quest:(TK_WORD|TK_NUMBER)+ TK_QUESTIONMARK+ TK_NEWLINE;

multiple: (TK_WORD+ TK_SPECIALCHARS* (TK_WORD|TK_NUMBER)+ TK_NEWLINE)+;

instruction: TK_WORD? TK_NEWLINE?;

questionMultiple: 'Question Type: 2' TK_NEWLINE
                   'Question ID: ' TK_NUMBER+ TK_NEWLINE
                    quest
                    multiple
                    instruction
                    obligatoriness TK_NEWLINE
                    'Extra Info: 'extraInfo TK_NEWLINE*; //ID QUESTAO INSTRUCTION TYPE OBLI EXTRA;

questionFreeAnswer: 'Question Type: 1' TK_NEWLINE
                    'Question ID: ' TK_NUMBER+ TK_NEWLINE
                    quest
                    instruction
                    obligatoriness TK_NEWLINE
                    'Extra Info: 'extraInfo TK_NEWLINE*; //ID QUESTAO INSTRUCTION TYPE OBLI EXTRA;

repeat:  'Section Repeat: '? TK_NUMBER? TK_NEWLINE?;

finalMessage: TK_WORD+ TK_NEWLINE*;

wordNumber: TK_WORD* TK_NUMBER*
           |TK_NUMBER* TK_WORD*
           | TK_WORD*
           |TK_NUMBER*
           ;

obligatoriness: TK_MANDATORY
              | TK_OPTIONAL
              | TK_DEPENDENT
              ;


TK_NUMBER : '0'..'9';
TK_WORD : [a-zA-Z]+TK_SPECIALCHARS*[a-zA-Z]*;
TK_NEWLINE:'\n';
TK_QUESTIONMARK: '?';
TK_SPECIALCHARS:(':'|';'|','|'.'|')'|'(');
TK_MANDATORY : '{'[Mm][Aa][Nn][Dd][Aa][Tt][Oo][Rr][Yy]'}';
TK_OPTIONAL : '{'[Oo][Pp][Tt][Ii][Oo][Nn][Aa][Ll]'}';
TK_DEPENDENT : '{'[Dd][Ee][Pp][Ee][Nn][Dd][Ee][Nn][Tt]'}';
TK_WS : [ \t]+ -> skip ;
