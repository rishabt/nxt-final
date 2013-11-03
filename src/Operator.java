import lejos.util.Timer;
import lejos.util.TimerListener;

public class Operator implements TimerListener {
	public static final int PERIOD = 5;
	private Timer timer;
	
	private Controller[] controllers;
	
	public Operator(Controller[] controllers) {
		this.controllers = controllers;
		this.timer = new Timer(PERIOD, this);
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public void timedOut() {
		
		// sequentially call next() for each controller, which calls
		// setup() and returns ok()
		for (Controller controller : controllers) {
			if (!controller.next()) return;
		}
	}
	
}
