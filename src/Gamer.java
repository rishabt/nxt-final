import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;

public class Gamer {
	private static Communicator communicator;
	
	public static void main(String[] args) {
		Button.waitForAnyPress();
		
		communicator = new Communicator(bluetoothConnect());
				
		Button.waitForAnyPress();
	}
	
	public static BTConnection bluetoothConnect() {
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