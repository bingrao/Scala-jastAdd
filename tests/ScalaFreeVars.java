package tests;
import junit.framework.TestCase;
import AST.*;
/**
 * 
 * @author Bing
 * This TestCase will print the whole Free Variables
 * In this tool, I use a pair of key/value set to represent 
 * the name and type of a variable. 
 * Unfortunatelly, I have finised this task because of time issue for now.
 * TODO  Finish this before end of this sememster.
 */
public class ScalaFreeVars extends TestCase {

	public void testScalaFreeVars()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t3.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printFV();
	}
}
