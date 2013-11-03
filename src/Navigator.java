import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import javax.bluetooth.*;


public class Navigator {
	private static Communicator communicator;
	
	public static void main(String[] args) {
		Button.waitForAnyPress();
		
		communicator = new Communicator(bluetoothConnect());
		
		Button.waitForAnyPress();
	}
	
	public static BTConnection bluetoothConnect() {
		return Bluetooth.waitForConnection();
	}
	
	public static String bluetoothExchange(String message) {
		String receivedMessage = communicator.bluetoothReceive();
		communicator.bluetoothSend(message);
		return receivedMessage;
	}

}