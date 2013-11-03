public class Controller {
	public Controller() {}
	
	// override these methods
	public void setup() {}
	public boolean ok() { return true; }
	
	// don't override this method
	public boolean next() {
		setup(); return ok();
	}
}