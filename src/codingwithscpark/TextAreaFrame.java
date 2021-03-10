package codingwithscpark;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

public class TextAreaFrame extends JFrame implements ActionListener { 
	private JTextArea area;
	private JTextField text;
	
	public TextAreaFrame() {
		this.setTitle("Text Area Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text = new JTextField(30);
		text.addActionListener(this);
		
		area = new JTextArea(10, 30);
		area.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(area);
		
		this.add(text, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == text) {
			area.append(text.getText()+"\n");
			text.selectAll();
		}
		
	}
	
	public static void main(String[] args) {
		new TextAreaFrame();
	}
	
	

}
