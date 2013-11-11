import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;
import gamer.*;

public class Gamer {
	private static Communicator communicator;
	
	public static void main(String[] args) {
		
		// SETUP
		
		Button.ESCAPE.addButtonListener(new ExitListener());
		
		LCD.drawString("GAMER", 11, 1);
		LCD.drawString("(press button)", 2, 3);
		
		Button.waitForAnyPress();
		LCD.clear();
		
		// INITIALIZE
		
		Bluetooth.setFriendlyName("gamer");
		
		communicator = new Communicator(bluetoothConnect());
		LCD.drawString("* bluetooth up", 0, 0);
		
		UltrasonicPoller left = new UltrasonicPoller(SensorPort.S1, Motor.A);
		LCD.drawString("* left u.p. on", 0, 1);
		
		UltrasonicPoller right = new UltrasonicPoller(SensorPort.S2, Motor.B);
		LCD.drawString("* right u.p. on", 0, 2);
		
		
		// LOCALIZE
		int leftDistance, rightDistance;
		do {
			try { Thread.sleep(250); } catch(Exception e) {}
			
			leftDistance = left.getDistance();
			rightDistance = right.getDistance();
			
			LCD.clear();
			LCD.drawString("distances:", 0, 0);
			LCD.drawString("left:  " + leftDistance, 0, 1);
			LCD.drawString("right: " + rightDistance, 0, 2);
			
			communicator.bluetoothSend("localize:rotate");
		} while(leftDistance < 255 || rightDistance < 255);

		communicator.bluetoothSend("localize:complete");
		/*
		
		while (right.getDistance() < 250 || left.getDistance() < 250) {
					
			try { Thread.sleep(100); } catch(Exception e) {}
		}
		*/
		
		// 
				
		Button.waitForAnyPress();
	}
	
	public static BTConnection bluetoothConnect() {
		LCD.drawString("connecting...", 0, 0);
		RemoteDevice navigator = Bluetooth.getKnownDevice("navigator");
		if (navigator == null) {
			LCD.clear();
			LCD.drawString("ERROR: device not found", 0, 1);
			Button.waitForAnyPress();
			System.exit(1);
		}
		return Bluetooth.connect(navigator);
	}
	
	public static String bluetoothExchange(String message) {
		communicator.bluetoothSend(message);
		return communicator.bluetoothReceive();
	}

}