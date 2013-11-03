public class GamerOperator extends Operator {
	
	public GamerOperator(GamerController[] controllers) {
		super(controllers);
		for (GamerController controller : controllers) {
			controller.setOperator(this);
		}
	}
	
}