package tests;

import AST.*;
import java.io.*;
import junit.framework.TestCase;
/**
 * 
 * @author Bing
 * This TestCase will verify the Parser function of Scala.
 * 
 * Requirment for input Scala code style:
 * 1. Block should be enbraced by "{" and "}". For example: { x=3; } or { if(x>y) { x = 5;}else{y = 7;}}
 * 2. Every statement should end with ";". For example: { x=3; }
 * 3. Just only support "if(){} else {} ", not support "if(){ }";
 */
public class ParserTests extends TestCase {
 

  public void testSimpleBlock() {
    assertParseOk("public Class t{x=y;}");
  }
  
  public void testVarDef() {
	    assertParseOk("public Class t{ var x:Int = 5;}");
  }
  
  public void testAssignment() {
	    assertParseOk("public Class t{  }");
	    assertParseOk("public Class t{x = a+b;}");
	    assertParseOk("public Class t{x = !(3+a);}");
	    assertParseOk("public Class t{x = !(3+a) > 3;}");
  }
  
  public void testIf() {
	    assertParseOk("public Class t{if(x>y){x = 5;}else{y = 7;}}");
  }
  public void testWhileStatment() {
	    assertParseOk("public Class t{ while(x>y){ x = 5; y = 6;}}");
  }
  
  
  public void testFunction()
  {
	  assertParseOk("public Class name { if(x>y){x =3;}else{y=4;} }"); 
  }
	
  
  
  protected static void assertParseOk(String s) {
    try {
      parse(s);
    } catch (Throwable t) {
      fail(t.getMessage());
    }
  }
  
  protected static void assertParseError(String s) {
    try {
      parse(s);
    } catch (Throwable t) {
      return;
    }
    fail("Expected to find parse error in " + s);
  }
  
  protected static void parse(String s) throws Throwable {
    ScalaParser parser = new ScalaParser();
    Reader reader = new StringReader(s);
    ScalaScanner scanner = new ScalaScanner(new BufferedReader(reader));
    Program p = (Program)parser.parse(scanner);
    reader.close();
  }
}
