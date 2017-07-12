package tests;
import junit.framework.TestCase;
import AST.*;
import utility.AnalysisType;

public class ScalaRDTest extends TestCase {

	public void testScalaRDTest()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t9.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printAnalysisResult(AnalysisType.RD);
	}
}
