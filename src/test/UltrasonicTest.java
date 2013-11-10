import lejos.nxt.*;
import gamer.*;

public class UltrasonicTest {

	public static void main(String[] args) {
		Button.ESCAPE.addButtonListener(new ExitListener());
		
		Button.waitForAnyPress();
		
		UltrasonicPoller poller = new UltrasonicPoller(SensorPort.S2, Motor.B);
		
		int edgeAngle = poller.getEdgeAngle(-1);
		
		LCD.drawString("a: " + edgeAngle, 0, 0);
		
		/*
		poller.rotateTo(90);
		
		for (int i=0; i < 100; i++) {
			LCD.clear();
			UltrasonicReading reading = poller.getReading();
			LCD.drawString("d: " + reading.distance, 0, 0);
			LCD.drawString("t: " + reading.angle, 0, 1);
			LCD.drawString("?: " + reading.trustworthy, 0, 2);
			
			try { Thread.sleep(100); } catch(Exception e) {}
		}
		
		poller.rotateTo(0);
		
		for (int i=0; i < 100; i++) {
			LCD.clear();
			UltrasonicReading reading = poller.getReading();
			LCD.drawString("d: " + reading.distance, 0, 0);
			LCD.drawString("t: " + reading.angle, 0, 1);
			LCD.drawString("?: " + reading.trustworthy, 0, 2);
			
			try { Thread.sleep(100); } catch(Exception e) {}
		}
		
		poller.rotateTo(-90);
		
		for (int i=0; i < 100; i++) {
			LCD.clear();
			UltrasonicReading reading = poller.getReading();
			LCD.drawString("d: " + reading.distance, 0, 0);
			LCD.drawString("t: " + reading.angle, 0, 1);
			LCD.drawString("?: " + reading.trustworthy, 0, 2);
			
			try { Thread.sleep(100); } catch(Exception e) {}
		}
		*/
		
		Button.waitForAnyPress();
	}

}