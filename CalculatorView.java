import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
					clear, decimal;
	private JButton[] buttons;
	
	public CalculatorView() {
		
		frame = new JFrame("Calculator MVC");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		display = new JTextField();
		
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
		
		buttons = new JButton[] {zero, one, two, three, four, five, six, seven,
				eight, nine, plus, minus, divide, multiply, equals,
				clear, decimal};
		
		addComponents();
		createAndShow();
	}
	
	private void addComponents() {
		
		frame.setLayout(new GridBagLayout());
		frame.setContentPane(contentPanel);
		GridBagConstraints gbc = new GridBagConstraints();
		
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.ipady = 20;
        contentPanel.add(display, gbc);
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < buttons.length; i++) {
        	gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = x;
            gbc.gridy = y;
            
            JButton button = buttons[i];
            contentPanel.add(button, gbc);
            
            x++;
            if (x % 4 == 0) {
                x = 0;
                y++;
            }
        }
	}
	
	private void createAndShow() {
		frame.pack();
        frame.setVisible(true);
	}
	

	public static void main(String[] args) {
		
		CalculatorView cv = new CalculatorView();
		
	}

}
