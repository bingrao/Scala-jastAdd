package tests;
import junit.framework.TestCase;
import AST.*;
import utility.AnalysisType;

public class ScalaLVTest extends TestCase {

	public void testScalaLVTest()
	{
		ScalaCompiler compiler = new ScalaCompiler("input/t11.txt");
		Program p = compiler.run();
		runPreErrorCheck(p);
	}
	
	public void runPreErrorCheck(Program p) {
		p.printAnalysisResult(AnalysisType.LV);
	}
}
