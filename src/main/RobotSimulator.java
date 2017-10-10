package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class RobotSimulator {
	   /**
	    * Was thinking of using a factory pattern that returns different implementations for Robot but it might be an overkill for this
	    * use case particularly when we do not know about other implementations.
	    */
	   private static Coordinates c = new Coordinates(5, 5);
	   private static Robot r  = new RobotManager(c);
	   public static void main(String[] args) throws Exception{
		   /**
		    * Read from the file and pass the commands read onto a helper function
		    */
		   BufferedReader br = null;
		   String currentLine;
		   URL path = RobotSimulator.class.getResource("Robot.txt");
		   File f = new File(path.getFile());
			try {
				
				br = new BufferedReader(new FileReader(f));
				while ((currentLine = br.readLine()) != null) 
				{
					handleRobot(currentLine);
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
	   
	   /**
	    * This function handles the different commands that are read from file and instructs the robot manager to act accordingly
	    * @param command
	    */
	   
	   private static void handleRobot(String command) {
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
