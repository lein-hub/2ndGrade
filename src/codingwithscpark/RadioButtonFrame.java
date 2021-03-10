package codingwithscpark;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class RadioButtonFrame extends JFrame implements ActionListener {
	
	private JRadioButton small, medium, large;
	private JLabel text;
	private JPanel topPanel, sizePanel, resultPanel;
	
	public RadioButtonFrame() {
		this.setTitle("���� ��ư �׽�Ʈ");
		this.setSize(310, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		JLabel label = new JLabel("� ũ���� Ŀ�Ǹ� �ֹ��Ͻðڽ��ϱ�?");
		topPanel.add(label);
		this.add(topPanel, BorderLayout.NORTH);
		
		sizePanel = new JPanel();
		small = new JRadioButton("Small size");
		medium = new JRadioButton("Medium size");
		large = new JRadioButton("Large size");
		
		ButtonGroup size = new ButtonGroup();
		size.add(small);
		size.add(medium);
		size.add(large);
		
		small.addActionListener(this);
		small.setFocusable(false);
		medium.addActionListener(this);
		medium.setFocusable(false);
		large.addActionListener(this);
		large.setFocusable(false);
		
		sizePanel.add(small);
		sizePanel.add(medium);
		sizePanel.add(large);
		Border border = BorderFactory.createTitledBorder("ũ��");
		sizePanel.setBorder(border);
		
		this.add(sizePanel, BorderLayout.CENTER);
		
		resultPanel = new JPanel();
		text = new JLabel("ũ�Ⱑ ���õ��� �ʾҽ��ϴ�");
		text.setForeground(Color.red);
		resultPanel.add(text);
		
		this.add(resultPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small)
			text.setText("Small ����");
		if (e.getSource() == medium)
			text.setText("Medium ����");
		if (e.getSource() == large)
			text.setText("Large ����");
		
	}
	
	public static void main(String[] args) {
		new RadioButtonFrame();
	}
	
}
