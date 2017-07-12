package tests;
import junit.framework.TestCase;
import AST.*;
/**
 * 
 * @author Bing
 * This TestCase will output all non-trivial expressions of a given test program. 
 */

public class ScalaNonExp extends TestCase {

	public void testScalaFlows()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t8.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printAexps();
	}

}