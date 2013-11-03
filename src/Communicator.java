import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;

public class Communicator {
	protected BTConnection connection;
	protected DataInputStream inStream;
	protected DataOutputStream outStream;
	
	public Communicator(BTConnection connection) {
		LCD.drawString("Connecting...", 0, 0);
		if (connection == null) {
			LCD.clear();
			LCD.drawString("ERROR: connection failed", 0, 1);
			Button.waitForAnyPress();
			System.exit(1);
		}
		this.connection = connection;
		this.inStream = connection.openDataInputStream();
		this.outStream = connection.openDataOutputStream();
	}
	
	public void bluetoothClose() {
		try {
			inStream.close();
			outStream.close();
			connection.close();
		} catch (IOException e) {}
	}
	
	public void bluetoothSend(String message) {
		try {
			outStream.writeUTF(message);
			outStream.flush();
		} catch (IOException e) {}
	}
	
	public String bluetoothReceive() {
		String message = "";
		try { message = inStream.readUTF(); } catch (IOException e) {}
		return message;
	}
}