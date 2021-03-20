package codingwithscpark;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JPanel implements ActionListener {
	private JPanel panel;
	private JTextField text;
	private JButton[] buttons;
	private String[] labels = {"%", "CE", "C", "¡ç", "1/x", "x©÷", "©÷¡îx", "¡À", "7", "8", "9", "¡¿", "4", "5", "6", "-", "1", "2", "3", "+", "+/-", "0", ".", "="};
	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	
	public Calculator() {
		this.setLayout(new BorderLayout());
		text = new JTextField(35);
		panel = new JPanel();
		text.setText("0.0");
		
		panel.setLayout(new GridLayout(0,4,3,3));
		panel.setBackground(new Color(221,226,229));
		buttons = new JButton[25];
		int index = 0;
		for (int rows = 0; rows<6; rows++) {
			for (int cols = 0; cols<4; cols++) {
				buttons[index] = new JButton(labels[index]);
				if (rows<2 || rows>1 && cols>2) {
					buttons[index].setBackground(new Color(229,232,234));
					buttons[index].setFont(new Font("SansSerif", Font.PLAIN, 20));
				}
				else {
					buttons[index].setBackground(new Color(250,250,250));
					buttons[index].setFont(new Font("SansSerif", Font.BOLD, 20));
				}
				panel.add(buttons[index]);
				buttons[index++].addActionListener(this);
			}
		}
		this.setBackground(new Color(221,226,229));
		this.add(text, BorderLayout.NORTH);
		this.add(panel, BorderLayout.SOUTH);
	}
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		
		if (com.equals("C")) {
			startOfNumber = true;
			result = 0;
			operator = "=";
			text.setText("0.0");
		} else if (com.length() == 1 && Character.isDigit(com.charAt(0))) {
			if (startOfNumber)
				text.setText(com);
			else
				text.setText(text.getText()+com);
			startOfNumber = false;
		} else if (com.equals("¡ç")) {
			if (text.getText().length()>0 && !startOfNumber)
			text.setText(text.getText().substring(0, text.getText().length()-1));
		} else {
			if (startOfNumber) {
				if (com.equals("-")) {
					text.setText(com);
					startOfNumber = false;
				} else {
					operator = com;
				}
			} else {
				double x = Double.parseDouble(text.getText());
				calculate(x);
				operator = com;
				startOfNumber = true;
			}
		}
		
	}
	
	private void calculate(double x) {
		switch (operator) {
		case "+":
			result += x; break;
		case "-":
			result -= x; break;
		case "¡¿":
			result *= x; break;
		case "¡À":
			result /= x; break;
		case "=":
			result = x; break;
		}
		text.setText(String.valueOf(result));
	}


	public static void main(String[] args) {
		JFrame fr = new JFrame();
		JPanel calc = new Calculator();
		fr.add(calc);
		fr.setTitle("°è»ê±â");
		fr.pack();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
}
