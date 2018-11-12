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
		System.out.println("Criou o robo");
		compile(); // now compile it
		System.out.println("aqui compilou");
	}
	
	public static void compile () {
		System.out.println("entrou no compile()");
		System.out.println(System.getProperty("java.home"));
		
		// robots/custom/JoselitoBot.java
        // D:\Documentos\UFCG\IA\robocode-jgap-template\robots\custom
		String fileToCompile = "robots/custom/JoselitoBot.java"; // which file to compile * rhyming :) *
	    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	    System.out.println("vai rodar o run()?");
	    compiler.run(null, null, null, fileToCompile); // run compile
	    System.out.println("rodou!");
	}
	
	public static void createRobotFile(double[] chromo){
		try {
			FileWriter fstream = new FileWriter("robots/custom/JoselitoBot.java"); // file name to create
			BufferedWriter out = new BufferedWriter(fstream);
			
			//start code
			out.write("package custom; \n " +
				"import robocode.util.Utils; \n" +	
				"import robocode.*; \n" +
				"import java.awt.Color;\n" +
				"public class JoselitoBot extends Robot {\n");
			
					// build up robot logic in here
					// access chromosomes from array to set as variables
			
					out.append("int foo = (int)" + chromo[1] + ";\n");
					out.append("\n public void run() {" +
						"\n" +
						"\nsetAdjustGunForRobotTurn(true);" +
						"\nsetAdjustRadarForGunTurn(true);" +
						"\n" +
						"\n		setColors(Color.red,Color.blue,Color.green);" +	
						"\n     while(true) {"
						+ " turnRadarLeft(Double.POSITIVE_INFINITY);" 
						+ "}" +
						"\n" +	
						"\n	}");
					
					out.append("\n	public void onScannedRobot(ScannedRobotEvent e) {" +
							"\n" +
							"\n"  +
							"\n		ahead(" + chromo[0] + ");" +
							"\n" +
							"\n" +
							"\n		turnRight("+ chromo[2] +");"  +
							"\n" +
							"\n " +
							"\n		turnGunRight("+ chromo[6] +");"  +
							"\n" +
							"\n " +
							"\n		turnRadarRight("+ chromo[4] +");"  +
							"\n" +
							"\n" +
							"\n		fire("+ chromo[1] +");"
							+ "\n" +
							"\n		turnLeft("+ chromo[3] +");"  +
							"\n" +
							"\n " +
							"\n		turnGunLeft("+ chromo[7] +");"
						+ "\n		fire("+ chromo[1] +");}");
					
					out.append("\npublic void onHitWall(HitWallEvent e) {" +
							"\n    back(" + chromo[0] + ");" +
							"\n		turnLeft("+ chromo[3] +");"  +
							"\n    ahead(" + chromo[7] + ");" +
							"\n}");
					
					out.append("\npublic void onHitByBullet(HitByBulletEvent e) {" +
					"\n    turnRight(" + chromo[2] + ");" +
					"\n    ahead(" + chromo[0] + " * -1);" +
					"\n}");
					
					// end of robot

			out.append("\n}");
			  
			out.close(); // close output stream
			
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}