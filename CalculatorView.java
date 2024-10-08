/**
* This file acts as the View for the calculator. It creates the front end GUI that the user will interact with to perform their desired 
* calculations. It is built using a gridbag layout and is meant to mimic mobile calculator app layouts.
*
* Author: Pete Coutros
* Date: August 2024
*/

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView {
	
	private JFrame frame;
	private JPanel contentPanel;
	private JTextField display;
	private JButton zero, one, two, three, four, five, six, seven,
					eight, nine, plus, minus, divide, multiply, equals,
					clear, decimal, plusMinus, percent;
	private JButton[] buttons, numberButtons, operatorButtons;
	
	public CalculatorView() {
		
		frame = new JFrame("Calculator MVC");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		display = new JTextField(20);
		
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		plus = new JButton("+");
		minus = new JButton("-");
		divide = new JButton("/");
		multiply = new JButton("X");
		equals = new JButton("=");
		clear = new JButton("C");
		decimal = new JButton(".");
		plusMinus = new JButton("+/-");
		percent = new JButton("%");
		
		buttons = new JButton[] {
				clear, plusMinus, percent, multiply,
				seven, eight, nine, divide,
				four, five, six, minus,
				one, two, three, plus,
				zero, decimal, equals};
		
		
		numberButtons = new JButton[] {
				one, two, three, four,
				five, six, seven, eight,
				nine, zero};

		operatorButtons = new JButton[] {
				//plusMinus, percent, 
				multiply, 
				divide, minus, plus};
		
		percent.setEnabled(false);
		plusMinus.setEnabled(false);
		decimal.setEnabled(false);
		//clear.setEnabled(false);
		equals.setEnabled(false);
		
		for (JButton button : operatorButtons) {
			button.setEnabled(false);
		}
		
		addComponents();
		createAndShow();
	}
	
	private void addComponents() {
		
		contentPanel.setLayout(new GridBagLayout());
		frame.setContentPane(contentPanel);
		GridBagConstraints gbc = new GridBagConstraints();
    	gbc.fill = GridBagConstraints.HORIZONTAL;
			
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.ipady = 20;
        gbc.weightx = 0.5;
        contentPanel.add(display, gbc);
        
        int x = 0;
        int y = 1;
        
        for (int i = 0; i < buttons.length; i++) {
        	gbc.fill = GridBagConstraints.HORIZONTAL;
        	gbc.weightx = 0.5;
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;
            if (buttons[i] == zero) {
            	gbc.gridwidth = 2;
            	x += 1;
            }
            
            JButton button = buttons[i];
            contentPanel.add(button, gbc);
            
            x++;
            if  (x == 4) {
            	x = 0;
                y++;
            }
        }
	}
	
	public void addFunctionality(ActionListener actionListener) {
		for (JButton button : buttons) {
			button.addActionListener(actionListener);
		}
	}
	
	public JButton[] getNumberButtons() {
		return numberButtons;
	}
	
	public JButton[] getOperatorButtons() {
		return operatorButtons;
	}
	
	public JButton getClearButton() {
		return clear;
	}
	
	public JButton getEqualsButton() {
		return equals;
	}
	
	private void createAndShow() {
		frame.pack();
        frame.setVisible(true);
	}
	
	public double getNumber() {
		return Double.parseDouble(display.getText());
	}
	
	public void clearText() {
		display.setText(null);
	}
	
	public void setText(String input) {
		display.setText(input);
	}



	
}
