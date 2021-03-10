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
		this.setTitle("라디오 버튼 테스트");
		this.setSize(310, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		topPanel = new JPanel();
		JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
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
		Border border = BorderFactory.createTitledBorder("크기");
		sizePanel.setBorder(border);
		
		this.add(sizePanel, BorderLayout.CENTER);
		
		resultPanel = new JPanel();
		text = new JLabel("크기가 선택되지 않았습니다");
		text.setForeground(Color.red);
		resultPanel.add(text);
		
		this.add(resultPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == small)
			text.setText("Small 선택");
		if (e.getSource() == medium)
			text.setText("Medium 선택");
		if (e.getSource() == large)
			text.setText("Large 선택");
		
	}
	
	public static void main(String[] args) {
		new RadioButtonFrame();
	}
	
}
