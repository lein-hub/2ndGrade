package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class ImageLabelTest extends JFrame implements ActionListener{

	private JPanel panel;
	private JLabel label;
	private JButton button;
	
	public ImageLabelTest() {
		
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		label = new JLabel("이미지를 보려면 버튼을 누르세요");
		button = new JButton("이미지 보기");
		
		ImageIcon icon = new ImageIcon("icon.gif");
		button.setIcon(icon);
		
		panel.add(label);
		panel.add(button);
		
		this.add(panel);
		this.setVisible(true);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon dog = new ImageIcon("dog.gif");
		label.setIcon(dog);
		label.setText(null);
		
	}
	
	public static void main (String[] args) {
		new ImageLabelTest();
	}
	
}
