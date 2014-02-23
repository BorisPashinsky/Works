package PersonalWorks;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class prototypeTank extends JFrame{

	public static prototypeTank frame = new prototypeTank();
	public static Canvas canvas;
	public static double x = 100;
	public static boolean[] buttons = new boolean[4];
	public static boolean[] buttons2 = new boolean[2];
	public static double y = 100;
	public static double ugSpeed = Math.PI/270;
	public static double ugSpeed2 = Math.PI/180;
	public static double lowSpeed = 0.5;
	public static double maxSpeed = 3;
	public static double speed = 0;
	public static double ug = 0;
	public static double ug2 = 0;
	public static Image image = Toolkit.getDefaultToolkit().getImage("Безымянный.png");
	public static Image image2 = Toolkit.getDefaultToolkit().getImage("Безымянный2.png");
	public static void main(String[] args) {
		frame.setLayout(null);
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				switch (arg0.getKeyChar()) {
				case 'a': buttons[0] = false; break;
				case 'w': buttons[1] = false; break;
				case 'd': buttons[2] = false; break;
				case 's': buttons[3] = false; break;
				case '6': buttons2[1] = false; break;
				case '4': buttons2[0] = false; break;
				default:
					break;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				switch (arg0.getKeyChar()) {
				case 'a': buttons[0] = true; break;
				case 'w': buttons[1] = true; break;
				case 'd': buttons[2] = true; break;
				case 's': buttons[3] = true; break;
				case '6': buttons2[1] = true; break;
				case '4': buttons2[0] = true; break;
				case ' ': speed = 0; break;
				case '2': speed = 4 * lowSpeed; break;
				case '3': speed = 8 * lowSpeed; break;


				default:
					break;
				}
			}
		});
		canvas = new myCanvas(frame);
		canvas.setBounds(0, 0, 1000, 1000);
		frame.add(canvas);
		
		frame.setVisible(true);
		while (true) {
			
			double newSpeed = Math.max(-maxSpeed, Math.min(maxSpeed, speed + (buttons[1]? 0.1:0) - (buttons[3]? 0.1:0)));
			ug -= ((buttons[0]? 1:0) - (buttons[2]? 1:0)) * ugSpeed;
			ug2 -= ((buttons2[0]? 1:0) - (buttons2[1]? 1:0)) * ugSpeed2;
			x += (speed + newSpeed)/2 * Math.cos(ug);
			y += (speed + newSpeed)/2 * Math.sin(ug);
			speed = newSpeed;
			canvas.paint(canvas.getGraphics());
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class myCanvas extends Canvas{
	private prototypeTank frame;
	public myCanvas (prototypeTank frame) {
		super();
		this.frame = frame; 
		//paint(getGraphics());
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		BufferedImage im = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2d = (Graphics2D) im.getGraphics();
		g2d.setBackground(Color.white);
		g2d.clearRect(0, 0, 1000, 1000);
		g2d.translate(frame.x, frame.y);
		g2d.rotate(frame.ug);
		g2d.drawImage(frame.image, -50, -50, 100, 100, frame);
		g2d.rotate(frame.ug2);
		g2d.drawImage(frame.image2, -50, -50, 100, 100, frame);
		g.drawImage(im, 0, 0, 1000, 1000, frame);
	}

}
