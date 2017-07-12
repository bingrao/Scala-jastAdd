package tests;
import junit.framework.TestCase;
import AST.*;
import utility.AnalysisType;

public class ScalaVBTest extends TestCase {

	public void testScalaVBTest()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t10.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printAnalysisResult(AnalysisType.VB);
	}
}
