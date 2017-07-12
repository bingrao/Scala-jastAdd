package tests;

import junit.framework.TestCase;
import AST.*;


/**
 * 
 * @author Bing
 * This TestCase will verify the function that check whether or not a given variable has been 
 * defined in the test program.
 */
public class ScalaVarCheck extends TestCase{

	public void testCheckVarExist()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t7.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.typeCheckExist("y");
	}
}
