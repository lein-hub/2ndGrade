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
		// 이미지파일을 읽어서 image 객체로 생성
		// 20ms 마다 이벤트를 발생시키는 timer 객체를 생성하고 timer를 start 시킵니다.
		
		try {
			image = ImageIO.read(new File("spaceship2.png"));
		} catch(IOException e) {
			e.printStackTrace();  //에러 내역을 표시해줌
			System.exit(1);
		}
		
		timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// x, y 좌표를 변경
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
		// x, y 좌표에 이미지를 그린다.
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
