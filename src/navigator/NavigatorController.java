public class NavigatorController extends Controller {
	private NavigatorOperator operator;
	
	public NavigatorController() {
		super();
	}
	
	public void setOperator(NavigatorOperator operator) {
		this.operator = operator;
	}
}