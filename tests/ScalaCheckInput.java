package tests;

import AST.*;
import java.io.*;
import junit.framework.TestCase;
/**
 * 
 * @author Bing
 * This TestCase will verify the function that read a file as input from 
 * local file system.
 */
public class ScalaCheckInput extends TestCase {
	public void testReadFile(){
		String path = "input/t1.txt"; 
		try {
			ScalaParser parser = new ScalaParser();
			Reader reader = new FileReader(path);
		    ScalaScanner scanner = new ScalaScanner(new BufferedReader(reader));
		    Program p = (Program)parser.parse(scanner);
		    reader.close();
		    runPreErrorCheck(p);
		}catch (IOException e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} catch (beaver.Parser.Exception e) {
			System.err.println("error (PrettyPrint) : " + e.getMessage());
			e.printStackTrace();
		} 
	  }
	public void runPreErrorCheck(Program p) {
		System.out.println("input file tesk is ok");
	}
}
