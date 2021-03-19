package codingwithscpark;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements KeyListener, ActionListener {
	Ball ball;
	Racquet rac1;
	JButton easy, hard;
	JPanel panel;
	static boolean isStarted = false;
	
	public GameBoard() {
		panel = new JPanel();
		easy = new JButton("easy");
		hard = new JButton("hard");
		panel.add(easy);
		panel.add(hard);
		
		easy.addActionListener(this);
		hard.addActionListener(this);
		
//		ball = new Ball(this, Color.red);
//		this.setBackground(Color.green);
//		rac1 = new Racquet(this, 10, 150, 560, 150, Color.blue, Color.yellow);
		this.add(panel);
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		rac1.keyTyped(e);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		rac1.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		rac1.keyReleased(e);
		
	}
	
	private void move() {
		ball.move();
		rac1.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2 = (Graphics2D) g;
		if (isStarted) {
			ball.draw(g2);
			rac1.draw(g2);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.easy) {
			ball = new Ball(this, 20, Color.red, false);
			this.setBackground(Color.green);
			rac1 = new Racquet(this, 10, 150, 560, 150, Color.blue, Color.yellow, false);
			
		} else if (e.getSource() == this.hard) {
			ball = new Ball(this, 15, Color.red, true);
			this.setBackground(Color.green);
			rac1 = new Racquet(this, 10, 150, 560, 150, Color.blue, Color.yellow, true);
			
		}
		isStarted = true;
		this.remove(panel);
		
	}
	
	public static void main (String[] args) {
		JFrame fr = new JFrame("Pong °ÔÀÓ");
		fr.setSize(600, 400);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard game = new GameBoard();
		fr.add(game);
		
		while (true) {
			if (isStarted) {
				game.move();
			}
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}

class Racquet {
	private int width = 10, height = 80;
	double x = 0, a = 0;
	double y = 0, b = 0;
	Color color1, color2;
	double xspeed = 0, aspeed = 0;
	double yspeed = 0, bspeed = 0;
	double speed = 3;
	private GameBoard game;
	
	public Racquet(GameBoard game, int x, int y, int a, int b, Color color1, Color color2, boolean isHard) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		this.color1 = color1;
		this.color2 = color2;
		if (isHard)
			height = 60;
	}
	
	public void move() {
		if (y + yspeed > 0 && y + yspeed < game.getHeight()-height) {
			y = y + yspeed;
		}
		if (b + bspeed > 0 && b + bspeed < game.getHeight()-height) {
			b = b + bspeed;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color1);
		g.fillRect((int)x, (int)y, width, height);
		
		g.setColor(color2);
		g.fillRect((int)a, (int)b, width, height);
	}
	
	public void keyReleased(KeyEvent e) {
		yspeed = 0;
		bspeed = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			yspeed = -speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			yspeed = speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			bspeed = -speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			bspeed = speed;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		this.keyPressed(e);
	}
	
	public Rectangle getBounds1() {
		return new Rectangle((int)x, (int)y ,width, height);
	}
	
	public Rectangle getBounds2() {
		return new Rectangle((int)a, (int)b, width, height);
	}
}
class Ball {
	private int radius;
	double x;
	double y;
	double xspeed;
	double yspeed;
	int score1 = 0;
	int score2 = 0;
	private GameBoard game;
	Color color;
	boolean player1;
	boolean isHard;
	
	public Ball(GameBoard game, int radius, Color color, boolean isHard) {
		this.game = game;
		this.color = color;
		this.radius = radius;
		this.isHard = isHard;
		x = 250;
		y = 150;
		xspeed = Math.random() < 0.5 ? -1 : 1;
		yspeed = Math.random() < 0.5 ? -1 : 1;
		player1 = xspeed == 1 ? true : false;
		System.out.println("First x: " + x);
		System.out.println("First y: "+ y);
	}
	
	void move() {
		while (x < -30) {
			x = game.getWidth() / 2 - 2*radius;
			y = game.getHeight() / 2 - 2*radius;
			xspeed = Math.random() < 0.5 ? -1 : 1;
			yspeed = Math.random() < 0.5 ? -1 : 1;
			player1 = xspeed == 1 ? true : false;
		}
		if (x < 0 && x > -15) {
			xspeed = 1;
			yspeed = Math.random() < 0.5 ? -1 : 1;
			player1 = true;
			game.rac1.speed = 3;
			x = game.getWidth() / 2 - 2*radius;
//			y = game.getHeight() / 2 - 2*radius;
			score2++;
		}else if (x + 2*radius > game.getWidth() && x + 2*radius < game.getWidth() + 15) {
			xspeed = -1;
			yspeed = Math.random() < 0.5 ? -1 : 1;
			player1 = false;
			game.rac1.speed = 3;
			x = game.getWidth() / 2 - 2*radius;
//			y = game.getHeight() / 2 - 2*radius;
			score1++;
		}else if (y + yspeed < 0) {
			yspeed *= -1;
		}else if (y + 2*radius > game.getHeight()) {
			yspeed *= -1;
		}else if (collision()) {
			xspeed *= -1.1;
			yspeed *= 1.1;
			game.rac1.speed *= 1.1;
			player1 = !player1;
		}
		if (isHard) {
			x += xspeed*1.2;
			y += yspeed*1.2;
		} else {
			x += xspeed;
			y += yspeed;
		}
		System.out.println("x: "+x);
		System.out.println("y: "+y);
	}
	
	private boolean collision() {
		boolean col1 = game.rac1.getBounds1().intersects(getBounds());
		boolean col2 = game.rac1.getBounds2().intersects(getBounds());
		
		if (col1 && !player1)
			return col1;
		else if (col2 && player1)
			return col2;
		return false;
	}
	
	public void draw (Graphics2D g) {
		g.setColor(color);
		g.fillOval((int)x,(int) y, 2*radius, 2*radius);
		
		g.setColor(Color.gray);
		g.setFont(new Font("SansSerif", Font.BOLD, 50));
		g.drawString(String.valueOf(score1)+":"+String.valueOf(score2), 250, 50);
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int)y,2*radius, 2*radius);
	}
}