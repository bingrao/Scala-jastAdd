package tests;

import AST.*;
import java.io.*;
import junit.framework.TestCase;
import beaver.*;
/**
 * 
 * @author Bing
 * This TestCase will verify the source code lexicial problem.
 */
public class ScannerTests extends TestCase {

  public void testValidKeywords() {
      assertScannerOk("{var x:String = 3;}");
      assertScannerOk("{if(3){x =3 ;} else{y = x}}");
      assertScannerOk("{x = 3;}");
      assertScannerOk("{x = 3+4;}");
      assertScannerOk("{x = 3+y;}");
      assertScannerOk("{x = x||y;}");  
  }
  
  public void testClass()
  {
	  assertScannerOk("t1");
	  
  }
  // utilitity asserts to test scanner
  protected static void assertScannerOk(String s) {
    try {
      scan(s);
    } catch (Throwable t) {
      fail(t.getMessage());
    }
  }
  
  protected static void assertScannerError(String s) {
    try {
      scan(s);
    } catch (Throwable t) {
      return;
    }
    fail("Expected to find parse error in " + s);
  }
  
  protected static void scan(String s) throws Throwable { 
    Reader reader = new StringReader(s);
    ScalaScanner scanner = new ScalaScanner(new BufferedReader(reader));
    Symbol symbol;
    do {
      symbol = scanner.nextToken();
     // System.out.println(":"+symbol.getId());
    } while (symbol.getId() != ScalaParser.Terminals.EOF);
    reader.close();
  }
}