package codingwithscpark;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JPanel implements ActionListener {
	private JPanel panel;
	private JTextField text;
	private JButton[] buttons;
	private String[] labels = {"Backspace", "", "", "CE", "C", "7", "8", "9", "/", "sqrt", "4", "5", "6", "x", "%", "1", "2", "3", "-", "1/x", "0", "-/+", ".", "+", "=" };
	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	
	public Calculator() {
		text = new JTextField(35);
		panel = new JPanel();
		text.setText("0.0");
		
		panel.setLayout(new GridLayout(0,5,3,3));
		buttons = new JButton[25];
		int index = 0;
		for (int rows = 0; rows<5; rows++) {
			for (int cols = 0; cols<5; cols++) {
				buttons[index] = new JButton(labels[index]);
				if (cols >=3) 
					buttons[index].setForeground(Color.red);
				else
					buttons[index].setForeground(Color.blue);
				buttons[index].setBackground(Color.DARK_GRAY);
				panel.add(buttons[index]);
				buttons[index++].addActionListener(this);
			}
		}
		
		this.add(text, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
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
		// TODO Auto-generated method stub
		
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
