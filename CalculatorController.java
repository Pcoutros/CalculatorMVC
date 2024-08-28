/**
* This class will be the controller for the MVC and will pass info between the view and model
*/
public class CalculatorController {

	private CalculatorModel model;
	private CalculatorView view;
	
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		
		this.model = model;
		this.view = view;
	}
	
	
}
