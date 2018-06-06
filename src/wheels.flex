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
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
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

{QUOTATION_MARKS} {return symbol(sym.QUOTATION_MARKS, new String(yytext()));}

{ARRAY} {return symbol(sym.ARRAY);}
{BOOLEAN} {return symbol(sym.BOOLEAN);}
{CALL} {return symbol(sym.CALL);}
{CHAR} {return symbol(sym.CHAR);}
{DECREASE} {return symbol(sym.DECREASE);}
{DEFINE} {return symbol(sym.DEFINE);}
{DOUBLE} {return symbol(sym.DOUBLE);}
{ELSE} {return symbol(sym.ELSE);}
{EMPTY} {return symbol(sym.EMPTY);}
{EQUALS} {return symbol(sym.EQUALS);}
{FALSE} {return symbol(sym.FALSE);}
{FLOAT} {return symbol(sym.FLOAT);}
{FOR} {return symbol(sym.FOR);}
{FUNC} {return symbol(sym.FUNC);}
{IF} {return symbol(sym.IF);}
{INCREASE} {return symbol(sym.INCREASE);}
{INSERT} {return symbol(sym.INSERT);}
{INTERFACE} {return symbol(sym.INTERFACE);}
{INT} {return symbol(sym.INT);}
{LENGTH} {return symbol(sym.LENGTH);}
{LIST} {return symbol(sym.LIST);}
{NOT} {return symbol(sym.NOT);}
{PARAMS} {return symbol(sym.PARAMS);}
{POS} {return symbol(sym.POS);}
{PRINT} {return symbol(sym.PRINT);}
{PRIVATE} {return symbol(sym.PRIVATE);}
{CLASS_DEF} {return symbol(sym.CLASS_DEF);}
{PROC} {return symbol(sym.PROC);}
{PUBLIC} {return symbol(sym.PUBLIC);}
{READ} {return symbol(sym.READ);}
{RETURN} {return symbol(sym.RETURN);}
{SIZE} {return symbol(sym.SIZE);}
{STRING} {return symbol(sym.STRING);}
{THEN} {return symbol(sym.THEN);}
{TO} {return symbol(sym.TO);}
{TRUE} {return symbol(sym.TRUE);}
{VAR} {return symbol(sym.VAR);}
{VOID} {return symbol(sym.VOID);}
{WHILE} {return symbol(sym.WHILE);}
{WITH} {return symbol(sym.WITH);}

{IDENTIFIER} {return symbol(sym.IDENTIFIER, new String(yytext()));}

{SUM} {return symbol(sym.SUM);}
{SUBTRACTION} {return symbol(sym.SUBTRACTION);} 
{DIVISION} {return symbol(sym.DIVISION);}
{MULTIPLICATION} {return symbol(sym.MULTIPLICATION);}
{GREATER_THAN} {return symbol(sym.GREATER_THAN);}
{SMALLER_THAN} {return symbol(sym.SMALLER_THAN);}
{GREATER_THAN_EQUALS} {return symbol(sym.GREATER_THAN_EQUALS);}
{SMALLER_THAN_EQUALS} {return symbol(sym.SMALLER_THAN_EQUALS);}
{AND} {return symbol(sym.AND);}
{OR} {return symbol(sym.OR);}

{NUM}  { return symbol(sym.NUM, new Float(yytext())); }

{CODE_BLOCK_START} {return symbol(sym.CODE_BLOCK_START);}
{CODE_BLOCK_END} {return symbol(sym.CODE_BLOCK_END);}

{PARENTHESIS_RIGHT} {return symbol(sym.PARENTHESIS_RIGHT);}  
{PARENTHESIS_LEFT} {return symbol(sym.PARENTHESIS_LEFT);}
{PARENTHESIS_SQRIGHT} {return symbol(sym.PARENTHESIS_SQRIGHT);}
{PARENTHESIS_SQLEFT} {return symbol(sym.PARENTHESIS_SQLEFT);}

{SIMPLE_QUOTATION} { return symbol(sym.SIMPLE_QUOTATION, new String(yytext()));}
{COMMA} {return symbol(sym.COMMA);}
{DESTROYER_IDENTIFY} {return symbol(sym.DESTROYER_IDENTIFY);}
{ASSIGNMENT} {return symbol(sym.ASSIGNMENT);}
{EOL} {return symbol(sym.EOL);}

{ERRORS}  { return symbol(sym.ERRORS, new String(yytext()));}

{EXIT} { return symbol(sym.EXIT);}

}
	    


