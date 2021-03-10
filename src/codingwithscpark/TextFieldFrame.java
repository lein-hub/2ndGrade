package codingwithscpark;

import javax.swing.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame {
	private JButton button;
	private JTextField text, result;
	
	public TextFieldFrame() {
		this.setSize(300, 130);
		this.setTitle("제곱 계산하기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력: "));
		text = new JTextField(15);
		text.addActionListener(listener);
		panel.add(text);
		
		panel.add(new JLabel("제곱한 값: "));
		result = new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		button = new JButton("OK");
		panel.add(button);
		button.addActionListener(listener);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldFrame();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == text || e.getSource() == button) {
				int num = Integer.parseInt(text.getText());
				result.setText(String.valueOf(num*num));
			}
			
		}
		
	}

}
