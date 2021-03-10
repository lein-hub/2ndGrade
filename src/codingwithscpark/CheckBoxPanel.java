package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxPanel extends JPanel implements ItemListener{
	
	private JCheckBox[] boxes = new JCheckBox[3];
	private String[] fruits = {"apple", "grape", "orange"};
	private JLabel[] pictureLabel = new JLabel[3];
	private ImageIcon[] icon = new ImageIcon[3];
	
	public CheckBoxPanel() {
		super(new GridLayout(0, 4));
		
		for (int i=0; i<boxes.length; i++) {
			boxes[i] = new JCheckBox(fruits[i]);
			boxes[i].addItemListener(this);
			pictureLabel[i] = new JLabel(fruits[i] + ".gif");
			icon[i] = new ImageIcon(fruits[i] + ".gif");
		}
		
		JPanel boxPanel = new JPanel(new GridLayout(0, 1));
		
		for (int i=0; i<boxes.length; i++) {
			boxPanel.add(boxes[i]);
		}
		
		this.add(boxPanel);
		this.add(pictureLabel[0]);
		this.add(pictureLabel[1]);
		this.add(pictureLabel[2]);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		ImageIcon image = null;
		Object source = e.getItemSelectable();
		
		for (int i=0; i<boxes.length; i++) {
			if (source == boxes[i]) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					pictureLabel[i].setIcon(icon[i]);
				} else {
					pictureLabel[i].setIcon(null);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame fr = new JFrame("CehckBoxDemo");
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckBoxPanel panel = new CheckBoxPanel();
		panel.setOpaque(true);
		fr.add(panel);
		fr.setSize(500, 200);
		fr.setVisible(true);
	}
	
}
