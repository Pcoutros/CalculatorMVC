import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorController {

	private CalculatorModel model;
	private CalculatorView view;
	private String operand1, operand2 =  "";
	private Operator operator = Operator.NULL;
	private double result;
	
	public CalculatorController(CalculatorView view) {
		//this.model = model;
		this.view = view;
		
		this.view.addFunctionality(new CalculatorListener());
		//this.view.addOperatorFunctionality(new CalculatorListenerOperators());

	}
	
	public class CalculatorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String input = e.getActionCommand();
						
			switch(input) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				if (operator == Operator.NULL) {
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(true);
					}
					if (operand1 == null) {
						operand1 = input; 
					} 
					else {
						operand1 += input;
					}
					view.setText(operand1);
				} 
				else {
					operand2 += input;
					view.setText(operand2);
					view.getEqualsButton().setEnabled(true);
				}
				break;
			case "+":
				if (operator == Operator.NULL) {
					operator = Operator.PLUS;
					view.clearText();
					view.setText("+");
					view.getEqualsButton().setEnabled(false);
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(false);
					}
					for (JButton button : view.getNumberButtons()) {
						button.setEnabled(true);
					}
				}
				break;
			case "-":
				if (operator == Operator.NULL) {
					operator = Operator.MINUS;
					view.clearText();
					view.setText("-");
					view.getEqualsButton().setEnabled(false);
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(false);
					}
					for (JButton button : view.getNumberButtons()) {
						button.setEnabled(true);
					}
				}
				break;
			case "X":
				if (operator == Operator.NULL) {
					operator = Operator.MULTIPLY;
					view.clearText();
					view.setText("X");
					view.getEqualsButton().setEnabled(false);
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(false);
					}
					for (JButton button : view.getNumberButtons()) {
						button.setEnabled(true);
					}
				}
				break;
			case "/":
				if (operator == Operator.NULL) {
					operator = Operator.DIVIDE;
					view.clearText();
					view.setText("/");
					view.getEqualsButton().setEnabled(false);
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(false);
					}
					for (JButton button : view.getNumberButtons()) {
						button.setEnabled(true);
					}
				}
				break;
			case "=":
				view.clearText();
				if (operand1 != null && operator != null && operand2 != null) {
					
					model = new CalculatorModel(Double.parseDouble(operand1), Double.parseDouble(operand2), operator); 
					result = model.getResult();
					
					view.setText(result + "");
					
					operand1 = result + "";
					operand2 = "";
					operator = Operator.NULL;
					
					for (JButton button : view.getOperatorButtons()) {
						button.setEnabled(true);
					}
					for (JButton button : view.getNumberButtons()) {
						button.setEnabled(false);
					}
					
					
				}
				break;
			case "C":
				view.clearText();
				operand1 = "";
				operand2 = "";
				operator = Operator.NULL;
				for (JButton button : view.getOperatorButtons()) {
					button.setEnabled(false);
				}
				for (JButton button : view.getNumberButtons()) {
					button.setEnabled(true);
				}
				view.getEqualsButton().setEnabled(false);
			}
		}			
	}
}
