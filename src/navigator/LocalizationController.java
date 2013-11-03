public class LocalizationController extends NavigatorController {
	boolean localized = false;
	
	public LocalizationController() {
		super();
	}
	
	@Override
	public void setup() {
		
	}
	
	@Override
	public boolean ok() {
		return localized;
	}

}