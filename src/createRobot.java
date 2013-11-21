import javax.tools.*;
import java.io.*;
/* 
 * Create Robot
 * Creates and compiles Robocode Java file to test 
 * 
 */

public class createRobot {

	public static void create(double[] chromo) {
		createRobotFile(chromo); // create file
		compile(); // now compile it
	}
	
	public static void compile () {
		String fileToCompile = "robots/custom/SamBot.java"; // which file to compile * rhyming :) *
	    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	    compiler.run(null, null, null, fileToCompile); // run compile
	}
	
	public static void createRobotFile(double[] chromo){
		try {
			FileWriter fstream = new FileWriter("robots/custom/SamBot.java"); // file name to create
			BufferedWriter out = new BufferedWriter(fstream);
			
			//start code
			out.write("package custom; \n " +
				"import robocode.*; \n" +
				"import robocode.Robot;\n" +
				"import java.awt.Color;\n" +
				"public class SamBot extends Robot {\n");
			
					// build up robot logic in here
					// access chromosomes from array to set as variables
			
					out.append("int foo = (int)" + chromo[0] + ";\n");
					
					// end of robot

			out.append("\n}");
			  
			out.close(); // close output stream
			
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}