import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;
import navigator.*;

public class Navigator {
	private static Communicator communicator;
	
	public static void main(String[] args) {
		
		// SETUP
		
		Button.ESCAPE.addButtonListener(new ExitListener());
		
		LCD.drawString("NAVIGATOR", 0, 1);
		LCD.drawString("(press button)", 0, 3);
		
		Button.waitForAnyPress();
		LCD.clear();
		
		// INITIALIZE
		
		Bluetooth.setFriendlyName("navigator");
		communicator = new Communicator(bluetoothConnect());
		LCD.drawString("* bluetooth up", 0, 0);
		
		TwoWheeledRobot robot = new TwoWheeledRobot(Motor.A, Motor.B);
		LCD.drawString("* robot motorized", 0, 1);
		
		Odometer odometer = new Odometer(robot, true);
		LCD.drawString("* odometer on", 0, 2);
		
		// LOCALIZE
		
		while (true) {
			String message = communicator.bluetoothReceive();
			LCD.clear();
			LCD.drawString(message, 0, 0);
			
			if (message.equals("localize:rotate")) {
				robot.setSpeeds(0.0, 90.0);
			} else if (message.equals("localize:ultrasonic")) {
				LCD.drawString("waiting...", 0, 1);
			} else if (message.equals("localize:complete")) {
				LCD.drawString("light localize", 0, 1);
			} else {
				LCD.drawString("ERROR", 0, 1);
				LCD.drawString("unrecognized", 0, 2);
			}			
		
			try { Thread.sleep(100); } catch(Exception e) {}
		}
		
		// Button.waitForAnyPress();
	}
	
	public static BTConnection bluetoothConnect() {
		LCD.drawString("connecting...", 0, 0);
		return Bluetooth.waitForConnection();
	}
	
	public static String bluetoothExchange(String message) {
		String receivedMessage = communicator.bluetoothReceive();
		communicator.bluetoothSend(message);
		return receivedMessage;
	}

}