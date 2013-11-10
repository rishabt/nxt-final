package gamer;

public class UltrasonicReading {
	
	public int distance = 255, angle = 0;
	public boolean trustworthy = false;
	
	// distance (cm)
	// angle (deg)
	public UltrasonicReading(int distance, int angle) {
		this.distance = distance;
		this.angle = angle % 360;
		this.trustworthy = distance > 10 && distance < 100;
	}
	
}