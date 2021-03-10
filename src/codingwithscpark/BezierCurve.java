package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener {
	private int[] xs = {50, 150, 400, 450};
	private int[] ys = {200, 50, 300, 200};
	private int dragIndex = -1;
	
	public BezierCurve() {
		this.setSize(600, 400);
		this.setTitle("BezierCurve Test");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new BezierPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		this.add(panel);
	}
	
	class BezierPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			// �������� �簢������ �׸���
			g.setColor(Color.black);
			g.fillRect(xs[0]-8, ys[0]-8, 16, 16);
			g.fillRect(xs[3]-8, ys[3]-8, 16, 16);
			g.setColor(Color.red);
			g.fillRect(xs[1]-8, ys[1]-8, 16, 16);
			g.fillRect(xs[2]-8, ys[2]-8, 16, 16);
			// xs�迭, ys�迭�� ��ǥ�� �̿��� ������ ��� �׸���.
			g2.setColor(Color.black);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			g2.draw(path);
			
		}
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// ���õ� ���� �ִ��� ����.. �� dragIndex�� -1�� �ƴ��� ����
		// �ƴ϶�� ���õ� ���� x, y ��ǥ�� �����Ѵ�.
		if (dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
		}
		
		
		repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// �� ���� �� �߿��� � ���� ���õǾ������� üũ

		for (int i = 0; i<4; i++) {
			Rectangle r = new Rectangle(xs[i]-8, ys[i]-8, 16, 16);
			if (r.contains(e.getX(), e.getY()))
				dragIndex = i;
		}
		
		repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
		
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	
	public static void main(String[] args) {
		new BezierCurve();
	}
}
