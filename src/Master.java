import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;


public class Master {	

	public static void main(String[] args) {
		Button.waitForAnyPress();
		
		LCD.drawString("Connecting...", 0, 0);
		
		BTConnection connection = Bluetooth.waitForConnection();

		if (connection == null) {
			LCD.clear();
			LCD.drawString("ERROR: connection failed", 0, 1);
			Button.waitForAnyPress();
			System.exit(1);
		}
		
		DataInputStream inStream = connection.openDataInputStream();
		DataOutputStream outStream = connection.openDataOutputStream();
		
		try {
			String message = inStream.readUTF();
			LCD.drawString(message, 0, 2);
		} catch (IOException e) {}
		
		try {
			inStream.close();
			outStream.close();
			connection.close();
		} catch (IOException e) {}
		
		Button.waitForAnyPress();
	}

}