package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class RobotSimulator {
	   private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
	   // Can be improved if we have different versions for Robot Manager
	   private static Robot r  = new RobotManager(5, 5);
	   public static void main(String[] args) throws Exception{
		   BufferedReader br = null;
		   String currentLine;
		   RobotSimulator rs = new RobotSimulator();
		   URL path = RobotSimulator.class.getResource("Robot.txt");
		   File f = new File(path.getFile());
			try {
				
				br = new BufferedReader(new FileReader(f));
				while ((currentLine = br.readLine()) != null) 
				{
					rs.handleRobot(currentLine);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch(Exception e) {
				System.out.println("Exception "+e.getMessage());;
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	   }
	   
	   private void handleRobot(String command) {
		   if (command.contains("PLACE")) {
			   String[] commandParts = command.split(",");
			   r.place(Integer.parseInt(commandParts[0].substring(commandParts[0].length()-1)), Integer.parseInt(commandParts[1]), commandParts[2]);
		   } else {
			   switch(command) {
				   case "MOVE":
					   r.move();
					   break;
				   case "LEFT":
					   r.left();
					   break;
				   case "RIGHT":
					   r.right();
					   break;
				   case "REPORT":
					   r.report();
					   break;
			   }
		   }
	   }
}
