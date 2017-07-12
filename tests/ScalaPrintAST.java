package tests;
import junit.framework.TestCase;
import AST.*;
import java.util.*;
import utility.AnalysisType;
/**
 * 
 * @author Bing
 * This TestCase will output the AST of a given test case;
 */

public class ScalaPrintAST extends TestCase {

	public void testScalaPrintAST()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t5.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printAST();
	}

}
