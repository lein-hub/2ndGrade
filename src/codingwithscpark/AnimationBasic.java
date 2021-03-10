package codingwithscpark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener {
	/*
	 * 
	 */
	private BufferedImage image;
	private Timer timer;
	private final int START_X=0, START_Y=250;
	private int x = START_X, y = START_Y, WIDTH=500, HEIGHT=300;
	private String direction = "ne";
	
	public AnimationBasic() {
		// �̹��������� �о image ��ü�� ����
		// 20ms ���� �̺�Ʈ�� �߻���Ű�� timer ��ü�� �����ϰ� timer�� start ��ŵ�ϴ�.
		
		try {
			image = ImageIO.read(new File("spaceship2.png"));
		} catch(IOException e) {
			e.printStackTrace();  //���� ������ ǥ������
			System.exit(1);
		}
		
		timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// x, y ��ǥ�� ����
		switch (direction) {
		case "ne" :
			x += 1;
			y -= 1;
			if (x+image.getWidth() > WIDTH)
				direction = "nw";
			if (y < 0)
				direction = "se";
			break;
		case "se" :
			x += 1;
			y += 1;
			if (x+image.getWidth() > WIDTH)
				direction = "sw";
			if (y+image.getHeight() > HEIGHT)
				direction = "ne";
			break;
		case "sw" :
			x -= 1;
			y += 1;
			if (x < 0)
				direction = "se";
			if (y+image.getHeight() > HEIGHT)
				direction = "nw";
			break;
		case "nw" :
			x -= 1;
			y -= 1;
			if (x < 0)
				direction = "ne";
			if (y < 0)
				direction = "sw";
			break;
		}
		
		
		repaint();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// x, y ��ǥ�� �̹����� �׸���.
		super.paintComponent(g);
		
		g.drawImage(image, x, y, this);
	}
	
	public static void main (String[] args) {
		JFrame fr = new JFrame();
		fr.add(new AnimationBasic());
		fr.setTitle("Animation Test");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(500, 300);
		fr.setVisible(true);
	}
	
}
