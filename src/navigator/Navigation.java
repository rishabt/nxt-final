package Navigator;

import lejos.nxt.*;


public class Navigation {
	// put your navigation code here 
	// NAVIGATION USED AS A MIX FROM LAST LAB AND FROM THE GIVEN CODE AND SOME EXTRA METHODS ADDED
	
	private Odometer odo;
	private TwoWheeledRobot robot;
	private int ROTATE_SPEED = 50;
	private double leftRadius = 2.95;
	private double rightRadius = 2.95;
	private double width = 15.4;
	public double[] position = new double[3];
	public int ROTATION_SPEED = 150;
	final static int FAST = 200, SLOW = 100;
	final static double DEG_ERR = 1.0, CM_ERR = 1.0;

	
	public Navigation(Odometer odo) {
		this.odo = odo;
		this.robot = odo.getTwoWheeledRobot();
	}
	
	public void travelTo(double x, double y) {
		// USE THE FUNCTIONS setForwardSpeed and setRotationalSpeed from TwoWheeledRobot!
		
		double requiredAngle;
		
		while (Math.abs(x - odo.getX()) > CM_ERR || Math.abs(y - odo.getY()) > CM_ERR) {
			
			requiredAngle = (Math.atan2(y - odo.getY(), x - odo.getX())) * (180.0 / Math.PI);
			
			if (requiredAngle < 0)
				requiredAngle += 360.0;
			
			turnTo(requiredAngle);
			robot.setForwardSpeed(30);
		}
		robot.setForwardSpeed(0);

		
	}
	
	public void turnTo(double angle) {
		// USE THE FUNCTIONS setForwardSpeed and setRotationalSpeed from TwoWheeledRobot!
		
		double error = 3;

		while (Math.abs(error) > DEG_ERR) {

				odo.getPosition(position);
				
				error = Math.abs(angle - position[2]);
				
				robot.setRotationSpeed(30);		
						
		}
		
		robot.setRotationSpeed(0);
		
	}
	
	public void goForward(){
		
		Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		
		Motor.A.forward();
		Motor.B.forward();
	}
	
	public void goBackward(){
		
		Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		
		Motor.A.backward();
		Motor.B.backward();
	}
	
	public void startRotating(){											//Some helper methods created
		robot.setRotationSpeed(ROTATE_SPEED);
	}
	
	public void startRotatingCounter(){
		robot.setRotationSpeed(-10);
	}
	
	public static int convertDistance(double radius, double distance) {							//Copied same from Lab 2 
		return (int) ((180.0 * distance) / (Math.PI * radius));
	}

	public static int convertAngle(double radius, double width, double angle) {
		return convertDistance(radius, Math.PI * width * angle / 360.0);
	}
}
