public class GamerController extends Controller {
	private GamerOperator operator;
	
	public GamerController() {
		super();
	}
	
	public void setOperator(GamerOperator operator) {
		this.operator = operator;
	}
}