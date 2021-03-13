package codingwithscpark;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SliderFrame extends JFrame implements ChangeListener {
	
	static final int INIT_VALUE = 15;
	private JButton btnOK, btn;
	private JSlider slider;
	
	public SliderFrame() {
		JPanel panel;
		
		this.setTitle("�����̴� �׽�Ʈ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();;
		JLabel label = new JLabel("�����̴��� ������������", JLabel.CENTER	);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		
		slider = new JSlider(0, 30, INIT_VALUE);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		panel.add(slider);
		
		btn = new JButton(" ");
		ImageIcon icon = new ImageIcon("dog.gif");
		btn.setIcon(icon);
		btn.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
		panel.add(btn);
		this.add(panel);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (source.getValueIsAdjusting()) {
			int value = (int) source.getValue();
			btn.setSize(value * 10, value * 10);
		}
		
	}
	
	public static void main(String[] args) {
		new SliderFrame();
	}

}
