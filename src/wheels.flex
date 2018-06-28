/*
  File Name: wheels.flex
  To Create: > jflex wheels.flex
  and then after the parser is created
  > javac Lexer.java
*/
   
/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
/* 
   The name of the class JFlex will create will be Lexer.
   Will write the code to the file Lexer.java. 
*/
%class Lexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* 
   Will switch to a CUP compatibility mode to interface with a CUP
   generated parser.
*/
%cup

/*
  Declarations
   
  Code between %{ and %}, both of which must be at the beginning of a
  line, will be copied letter to letter into the lexer class source.
  Here you declare member variables and functions that are used inside
  scanner actions.  
*/
%{   
    /* To create a new java_cup.runtime.application.symbolTable.application.symbolTable.Symbols with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbols(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.application.symbolTable.application.symbolTable.Symbols with information
       about the current token, but this object has a value. */
    private Symbol symbols(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

NUM =    (\+|\-)?[0-9]+(\.[0-9]+)?


ARRAY = "Array"
BOOLEAN = "boolean"
CALL = "call"
CHAR = "char"
DECREASE = "decrease"
DEFINE = "define"
DOUBLE = "double"
ELSE = "else"
EMPTY = "empty"
EQUALS = "equals"
FALSE = "false"
FLOAT = "float"
FOR = "for"
FUNC = "func"
IF = "if"
INCREASE = "increase"
INSERT = "insert"
INT = "int"
INTERFACE = "interface"
LENGTH = "length"
LIST = "List"
NOT = "not"
PARAMS = "params"
POS = "pos"
PRINT = "print"
PRIVATE = "private"
PROC = "proc"
CLASS_DEF = "class"
PUBLIC = "public"
READ = "read"
RETURN = "return"
SIZE = "size"
STRING = "string"
THEN = "then"
TO = "to"
TRUE = "true"
VAR = "var"
VOID = "void"
WHILE = "while"
WITH = "with"
AND = "and"
OR = "or"

PARENTHESIS_RIGHT = (")")
PARENTHESIS_LEFT = ("(")

PARENTHESIS_SQRIGHT = ("]")
PARENTHESIS_SQLEFT= ("[")

IDENTIFIER = ([a-z]|[A-Z])+((\_)*([a-z]|[A-Z]|[0-9])+)*

SUM = ("+")
SUBTRACTION = ("-")
DIVISION = ("/")
MULTIPLICATION = ("*")
GREATER_THAN = (">")
SMALLER_THAN = ("<")
GREATER_THAN_EQUALS = (">=")
SMALLER_THAN_EQUALS = ("<=")

SIMPLE_QUOTATION = ("'")
COMMA = (",")
DESTROYER_IDENTIFY = ("~")
ASSIGNMENT = ("=")
EOL = (";")

CODE_BLOCK_START= ("{")
CODE_BLOCK_END= ("}")

LINE_COMMENT = \/\/(.)*
BLOCK_COMMENT = \/\*[^*]*\*\/
COMMENTS = {LINE_COMMENT} | {BLOCK_COMMENT}
QUOTATION_MARKS = \"[^\"]*\"
ERROR1 = (\_+([a-z]|[0-9])+)
ERROR2 = ([0-9]+(\_|[a-z])+)
ERROR3 = [0-9|A-Z|a-z]*([\!-\&]|\:|\?|\@|\^|\.)+[0-9|A-Z|a-z]*
ERROR4 = ([a-z]|[A-Z])+([a-z]|[A-Z]|[0-9])*(\_)*
ERROR5 = \S
ERRORS = {ERROR1} | {ERROR2} | {ERROR3} |{ERROR4} |{ERROR5}
NL  = \r|\n|\r\n
WhiteSpace     = {NL} | [ \t\f]

EXIT = "exit"

%%

<YYINITIAL> {

/* newline */
{WhiteSpace}   { /*Do nothing*/}

{COMMENTS} {/*Do nothing*/}

{QUOTATION_MARKS} {return symbols(sym.QUOTATION_MARKS, new String(yytext()));}

{ARRAY} {return symbols(sym.ARRAY);}
{BOOLEAN} {return symbols(sym.BOOLEAN);}
{CALL} {return symbols(sym.CALL);}
{CHAR} {return symbols(sym.CHAR);}
{DECREASE} {return symbols(sym.DECREASE);}
{DEFINE} {return symbols(sym.DEFINE);}
{DOUBLE} {return symbols(sym.DOUBLE);}
{ELSE} {return symbols(sym.ELSE);}
{EMPTY} {return symbols(sym.EMPTY);}
{EQUALS} {return symbols(sym.EQUALS);}
{FALSE} {return symbols(sym.FALSE);}
{FLOAT} {return symbols(sym.FLOAT);}
{FOR} {return symbols(sym.FOR);}
{FUNC} {return symbols(sym.FUNC);}
{IF} {return symbols(sym.IF);}
{INCREASE} {return symbols(sym.INCREASE);}
{INSERT} {return symbols(sym.INSERT);}
{INTERFACE} {return symbols(sym.INTERFACE);}
{INT} {return symbols(sym.INT);}
{LENGTH} {return symbols(sym.LENGTH);}
{LIST} {return symbols(sym.LIST);}
{NOT} {return symbols(sym.NOT);}
{PARAMS} {return symbols(sym.PARAMS);}
{POS} {return symbols(sym.POS);}
{PRINT} {return symbols(sym.PRINT);}
{PRIVATE} {return symbols(sym.PRIVATE);}
{CLASS_DEF} {return symbols(sym.CLASS_DEF);}
{PROC} {return symbols(sym.PROC);}
{PUBLIC} {return symbols(sym.PUBLIC);}
{READ} {return symbols(sym.READ);}
{RETURN} {return symbols(sym.RETURN);}
{SIZE} {return symbols(sym.SIZE);}
{STRING} {return symbols(sym.STRING);}
{THEN} {return symbols(sym.THEN);}
{TO} {return symbols(sym.TO);}
{TRUE} {return symbols(sym.TRUE);}
{VAR} {return symbols(sym.VAR);}
{VOID} {return symbols(sym.VOID);}
{WHILE} {return symbols(sym.WHILE);}
{WITH} {return symbols(sym.WITH);}

{IDENTIFIER} {return symbols(sym.IDENTIFIER, new String(yytext()));}

{SUM} {return symbols(sym.SUM);}
{SUBTRACTION} {return symbols(sym.SUBTRACTION);}
{DIVISION} {return symbols(sym.DIVISION);}
{MULTIPLICATION} {return symbols(sym.MULTIPLICATION);}
{GREATER_THAN} {return symbols(sym.GREATER_THAN);}
{SMALLER_THAN} {return symbols(sym.SMALLER_THAN);}
{GREATER_THAN_EQUALS} {return symbols(sym.GREATER_THAN_EQUALS);}
{SMALLER_THAN_EQUALS} {return symbols(sym.SMALLER_THAN_EQUALS);}
{AND} {return symbols(sym.AND);}
{OR} {return symbols(sym.OR);}

{NUM}  { return symbols(sym.NUM, new Float(yytext())); }

{CODE_BLOCK_START} {return symbols(sym.CODE_BLOCK_START);}
{CODE_BLOCK_END} {return symbols(sym.CODE_BLOCK_END);}

{PARENTHESIS_RIGHT} {return symbols(sym.PARENTHESIS_RIGHT);}
{PARENTHESIS_LEFT} {return symbols(sym.PARENTHESIS_LEFT);}
{PARENTHESIS_SQRIGHT} {return symbols(sym.PARENTHESIS_SQRIGHT);}
{PARENTHESIS_SQLEFT} {return symbols(sym.PARENTHESIS_SQLEFT);}

{SIMPLE_QUOTATION} { return symbols(sym.SIMPLE_QUOTATION, new String(yytext()));}
{COMMA} {return symbols(sym.COMMA);}
{DESTROYER_IDENTIFY} {return symbols(sym.DESTROYER_IDENTIFY);}
{ASSIGNMENT} {return symbols(sym.ASSIGNMENT);}
{EOL} {return symbols(sym.EOL);}

{ERRORS}  { return symbols(sym.ERRORS, new String(yytext()));}

{EXIT} { return symbols(sym.EXIT);}

}
	    


