import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

	private CalculatorModel model;
	private CalculatorView view;
	
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		
		this.view.addFunctionality(new CalculatorListener());
	}
	
	public class CalculatorListener implements ActionListener {
		
		private CalculatorView view;

		public CalculatorListener() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			double firstNumber, secondNumber = 0;
			//Operator oper = Operator.NULL;
			
			try {
				firstNumber = view.getNumber();
				
				//oper = view.getOper();
			} 
			catch(NumberFormatException nfe) {
				nfe.getMessage();
			}
		}
	}
	
	
	
}
