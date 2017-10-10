# Robot

### Description
- The application is a simultion of a toy robot moving on a square tabletop
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement
that would result in the robot falling from the table must be prevented, however further valid movement commands must still
be allowed.

#### How to Run Code
- Simply click on RobotSimulator inside src/main and run as Java Application
- The input file is Robot.txt

#### Code Organization
The main driver file is RobotSimulator

**The classes are organized as follows**
- RobotSimulator that calls RobotManager
- RobotManager is the implementation of Robot Interface
- RobotManager 
  - Has four methods- Place, left, right and Move to manage Robot Movement
  - Until a valid place move is issued , no other movement will happen
  - It uses two classes, a Directions.java that is an enum which has all possible directions and returns an enum given a string
direction. It returns null if direction is not found. The other class in Table.java that stores the position x, y of the Robot
along with its direction. It has helper methods to get and set Directions if the x, y coordinates supplied are valid. 
- Two Junit Tests to test the classes RobotManager and Coordinates are also provided
- The test case name in JUnit File indicates what is being tested
