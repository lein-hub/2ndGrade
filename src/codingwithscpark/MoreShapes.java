package codingwithscpark;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoreShapes extends JFrame {

	public MoreShapes() {
		this.setSize(600, 130);
		this.setTitle("Java 2D Shapes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new MyPanel();
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MoreShapes();
	}

}

class MyPanel extends JPanel {
	ArrayList<Shape> shapeList = new ArrayList<>();
	
	public MyPanel() {
		Shape s;
		
		s = new Rectangle2D.Float(10, 10, 70, 80);
		shapeList.add(s);
		s = new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20);
		shapeList.add(s);
		s = new Ellipse2D.Float(210, 10, 80, 80);
		shapeList.add(s);
		s = new Arc2D.Float(310, 10, 80, 80, 90, 90, Arc2D.OPEN);
		shapeList.add(s);
		s = new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD);
		shapeList.add(s);
		s = new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE);
		shapeList.add(s);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(3));
		for (Shape s : shapeList) {
			g2.draw(s);
		}
		g2.setColor(Color.red);
		for (int i=0; i<shapeList.size(); i+=2) {
			g2.fill(shapeList.get(i));
		}
		
		GradientPaint gp = new GradientPaint(0, 10, Color.white, 0, 70, Color.red);
		g2.setPaint(gp);
		for (int i=1; i<shapeList.size(); i+=2) {
			g2.fill(shapeList.get(i));
		}
	}
	
	
}