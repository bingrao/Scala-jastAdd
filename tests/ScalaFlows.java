package tests;
import junit.framework.TestCase;
import AST.*;
/**
 * 
 * @author Bing
 * This TestCase will  verify the label system of test program,
 * 1. initial and final label;
 * 2. the label set of test program;
 * 3. the block set of test program;
 * 4. the flow set of test program;
 */
public class ScalaFlows extends TestCase {

	public void testScalaFlows()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t2.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printUnparse();
		p.printLabelSet(); /*the label set of test program*/
		p.printBlocks();/*the block set of test program*/
		p.printFlows(); /* the flow set of test program*/
	}

}
