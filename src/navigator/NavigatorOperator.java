public class NavigatorOperator extends Operator {
	
	public NavigatorOperator(NavigatorController[] controllers) {
		super(controllers);
		for (NavigatorController controller : controllers) {
			controller.setOperator(this);
		}
	}
	
}