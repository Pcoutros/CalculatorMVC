/**
* This file acts as the Model for the calculator and handles the back-end calculations. It is intended to be used by the CalculatorController, which
* gets the user's input from the GUI created by CalculatorView.
*
* Author: Pete Coutros
* Date: August 2024
*/

public class CalculatorModel {
	
	private double result;
	private double input1, input2;
	private Operator oper;
	
	public CalculatorModel(double input1, double input2, Operator oper) {
		
		this.input1 = input1;
		this.input2 = input2;
		this.oper = oper;
		calculateResult();
	}
	
	public void calculateResult() {
		
		switch (oper) {
		case DIVIDE:
			if (input2 == 0) {
				//Tech Debt: need better error handling
				System.out.println("undefined");
			} else {
				result = input1 / input2;
			}
			break;
		case MINUS:
			result = input1 - input2;
			break;
		case MULTIPLY:
			result = input1 * input2;
			break;
		case PLUS:
			result = input1 + input2;
			break;
		case NULL:
			break;
		default:
			result = 0;
			break;
		}
	}
	
	public double getResult() {
		
		return result;
	}

}
