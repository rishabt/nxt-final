import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;

public class Slave {
	
	public static void main(String[] args) {
		Button.waitForAnyPress();
		
		LCD.drawString("Connecting...", 0, 0);
		
		RemoteDevice device = Bluetooth.getKnownDevice("master");
		if (device == null) {
			LCD.clear();
			LCD.drawString("ERROR: device not found", 0, 1);
			Button.waitForAnyPress();
			System.exit(1);
		}
		
		BTConnection connection = Bluetooth.connect(device);
		if (connection == null) {
			LCD.clear();
			LCD.drawString("ERROR: connection failed", 0, 1);
			Button.waitForAnyPress();
			System.exit(1);
		}
		
		DataInputStream inStream = connection.openDataInputStream();
		DataOutputStream outStream = connection.openDataOutputStream();
		
		try {
			outStream.writeUTF("hello!");
			outStream.flush();
		} catch (IOException e) {}
		
		try {
			inStream.close();
			outStream.close();
			connection.close();
		} catch (IOException e) {}
		
		Button.waitForAnyPress();
	}

}