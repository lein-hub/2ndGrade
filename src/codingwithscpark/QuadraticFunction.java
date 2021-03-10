package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuadraticFunction extends JPanel implements ActionListener {
	JTextField a, b, c;
	double A, B, C;
	
	public QuadraticFunction() {
		a = new JTextField(10);
		b = new JTextField(10);
		c = new JTextField(10);
		this.add(a);
		this.add(b);
		this.add(c);
		
		JButton bt = new JButton("DRAW");
		
		this.add(bt);
		bt.addActionListener(this);
		
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawLine(0, 200, 400, 200);
		g2.drawLine(200, 0, 200, 400);
		g2.setPaint(Color.red);
		for (int i=-200; i<200; i++) {
			int x = i;
			int y = (int) (A*x*x + B*x + C);
			g2.fillOval(200+x -2, 200-y -2, 4, 4);
			
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		A = Double.parseDouble(a.getText());
		B = Double.parseDouble(b.getText());
		C = Double.parseDouble(c.getText());
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		fr.add(new QuadraticFunction());
		fr.setSize(500, 400);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
