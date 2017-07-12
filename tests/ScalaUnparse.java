package tests;
import junit.framework.TestCase;
import AST.*;
/**
 * 
 * @author Bing
 * This Program will unparse the AST of a given test program.
 */
public class ScalaUnparse extends TestCase {

	public void testScalaUnparse()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t6.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printUnparse();
	}

}
