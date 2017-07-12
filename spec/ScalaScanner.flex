/*
 *user mode and copy this part to class
 */
package AST; // The generated parser will belong to package AST

import AST.ScalaParser.Terminals; // The terminals are implicitly defined in the parser


%%
/*
 * Option and declaration
 */

// define the signature for the generated scanner
%class ScalaScanner
%extends beaver.Scanner
%public
%final

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol  //the scanning method to be declared as returning values of the specied type
%function nextToken  //Causes the scanning method to get the specied name, if not set, the initial name is "yylex"
%yylexthrow beaver.Scanner.Exception
%unicode  //define the set of characters the scanner will work on
/*store line and column information in the tokens*/
%line //switches line counting on (the current line number can be accessed via the variable yyline)
%column  //switches column counting on (current column is accessed via yycolumn)


/*
 *The code included in %{...%} is copied verbatim into the generated lexer class source.
 *Here you can declare member variables and functions that are used inside scanner actions.
 */
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}
/*
 *Macros are abbreviations for regular expressions, used to make lexical specifications easier to read and understand
 *A macro declaration consists of a macro identifier followed by =, then followed by the regular expression it represents
 *This regular expression may itself contain macro usages, for example "WhiteSpace = {LineTerminator} | [ \t\f]"
 */

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

IdChar = ([:letter:]|['_])
Identifier = {IdChar}({IdChar} | [:digit:])*


DecIntegerLiteral = [0-9] | [1-9][0-9]*

Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"


/*The last part of the second section in our lexical specication is a lexical state declaration*/
/*a lexical state STRING that can be used in the "lexical rules" part of the specification*/
%state STRING, CHARLITERAL

%%
/*
 * The "lexical rules" section of a JFlex specication contains regular expressions and actions (Java code) that 
 * are executed when the scanner matches the associated regular expression
 */
 
{Comment}     { /* discard token */ }
{WhiteSpace}  { /* discard token */ }
<YYINITIAL> {
	{DecIntegerLiteral} 		   { return sym(Terminals.NUMBER); }
	
	/*Data type*/
	"Byte"			{ return sym(Terminals.BYTE); }
	"Int"			{ return sym(Terminals.INT); }	
	"Short"			{ return sym(Terminals.SHORT); }
	"Long"			{ return sym(Terminals.LONG); }
	"Float"			{ return sym(Terminals.FLOAT); }
	"Double"		{ return sym(Terminals.DOUBLE); }
	"Char"			{ return sym(Terminals.CHAR); }
	"String"		{ return sym(Terminals.STRING); }
	"Boolean"		{ return sym(Terminals.BOOLEAN); }
	"Unit"			{ return sym(Terminals.UNIT); }
	"Null"			{ return sym(Terminals.NULL); }
	"Nothing"		{ return sym(Terminals.NOTHING); }
	"Any"			{ return sym(Terminals.ANY); }
	"AnyRef"		{ return sym(Terminals.ANYREF); }
	
	/*Variable type*/
	"val"			{ return sym(Terminals.VAL); }
	"var"			{ return sym(Terminals.VAR); }
	//"final"			{ return sym(Terminals.FINAL); }
	
	/*Class Property*/
	"Class"			{ return sym(Terminals.CLASS); }
	"public"		{ return sym(Terminals.PUBLIC); }
	"abstract"		{ return sym(Terminals.ABSTRACT); }
	"private"		{ return sym(Terminals.PRIVATE); }
	"protected"		{ return sym(Terminals.PROTECTED); }
	//"extends"		{ return sym(Terminals.EXTENDS); }
	"object"		{ return sym(Terminals.OBJECT); }
	//"super"			{ return sym(Terminals.SUPER); }
	//"this"			{ return sym(Terminals.THIS); }
	"case"			{ return sym(Terminals.CASE); }
	//"with"			{ return sym(Terminals.WITH); }
	//"match"			{ return sym(Terminals.MATCH); }
	
	
	/*Function Property*/
	"def"			{ return sym(Terminals.DEF); }
	//"return"		{ return sym(Terminals.RETURN); }
	//"override"		{ return sym(Terminals.OVERRIDE); }
	
	/*statement*/
	"while"			{ return sym(Terminals.WHILE); }
	//"do"			{ return sym(Terminals.DO); }
	//"for"			{ return sym(Terminals.FOR); }
	//"forSome"		{ return sym(Terminals.FORSOME); }
	"if"			{ return sym(Terminals.IF); }
	"else"			{ return sym(Terminals.ELSE); }
	//"Try"			{ return sym(Terminals.TRY); }
	//"catch"			{ return sym(Terminals.CATCH); }
	//"finally"		{ return sym(Terminals.FINALLY); }
	
	/*Package*/
	//"package"		{ return sym(Terminals.PACAKGE); }
	//"import"		{ return sym(Terminals.IMPORT); }	
	
	
	/* boolean literals */
	"true"                         { return sym(Terminals.TRUE); }
	"false"                        { return sym(Terminals.FALSE); }
	

	/* separators */
	"("                            { return sym(Terminals.LPAREN); }
	")"                            { return sym(Terminals.RPAREN); }
	"{"                            { return sym(Terminals.LBRACE); }
	"}"                            { return sym(Terminals.RBRACE); }
	//"["                            { return sym(Terminals.LBRACK); }
	//"]"                            { return sym(Terminals.RBRACK); }
	";"                            { return sym(Terminals.SEMICOLON); }
	","                            { return sym(Terminals.COMMA); }
	//"."                            { return sym(Terminals.DOT); }
	
	/* Arithmetic operators */
	"+"                            { return sym(Terminals.PLUS); }
	"-"                            { return sym(Terminals.MINUS); }
	"*"                            { return sym(Terminals.MULT); }
	"/"                            { return sym(Terminals.DIV); }
//	"++"                           { return sym(Terminals.PLUSPLUS); }
//	"--"                           { return sym(Terminals.MINUSMINUS); }
	"="                            { return sym(Terminals.EQ); }
	"%"                            { return sym(Terminals.MOD); }
	"<<"                           { return sym(Terminals.LSHIFT); }
	">>"                           { return sym(Terminals.RSHIFT); }
	">>>"                          { return sym(Terminals.URSHIFT); }
	"+="                           { return sym(Terminals.PLUSEQ); }
	"-="                           { return sym(Terminals.MINUSEQ); }
	"*="                           { return sym(Terminals.MULTEQ); }
	"/="                           { return sym(Terminals.DIVEQ); }
	"&="                           { return sym(Terminals.ANDEQ); }
	"|="                           { return sym(Terminals.OREQ); }
	"^="                           { return sym(Terminals.XOREQ); }
	"%="                           { return sym(Terminals.MODEQ); }
	"<<="                          { return sym(Terminals.LSHIFTEQ); }
	">>="                          { return sym(Terminals.RSHIFTEQ); }
	">>>="                         { return sym(Terminals.URSHIFTEQ); }
	
	/*Relational Operators*/
	">"                            { return sym(Terminals.GT); }
	"<"                            { return sym(Terminals.LT); }
	"!"                            { return sym(Terminals.NOT); }
	"~"                            { return sym(Terminals.COMP); }
	"?"                            { return sym(Terminals.QUESTION); }
	":"                            { return sym(Terminals.COLON); }
	"=="                           { return sym(Terminals.EQEQ); }
	"<="                           { return sym(Terminals.LTEQ); }
	">="                           { return sym(Terminals.GTEQ); }
	"!="                           { return sym(Terminals.NOTEQ); }
	"&&"                           { return sym(Terminals.ANDAND); }
	"||"                           { return sym(Terminals.OROR); }

	/*Boolean Operators*/
	"&"                            { return sym(Terminals.AND); }
	"|"                            { return sym(Terminals.OR); }
	"^"                            { return sym(Terminals.XOR); }
		
/*Other options*/
	{Identifier} 				   { return sym(Terminals.IDENTIFIER); }

}
<<EOF>>       					   { return sym(Terminals.EOF); }