package PersonalWorks;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class GRAVITY extends Applet implements ActionListener {
	double vy = 0;
	double g0 = 2;
	double vx = 5;
	double x;
	double y;
	Timer timer = new Timer(60,this);
	{
		timer.start();
	}

	@Override
	public void paint(Graphics g){
//		super.paint(g);
		BufferedImage yu = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g2 = yu.getGraphics();
		if((y <= this.getHeight())&&(x <= this.getWidth())&&(x >= 0)&&(y>=0)){
			vy = vy + g0;
		}
		if((y > this.getHeight())||(y < 0)){
			vy = - 0.95 * vy;
			vx = 0.95 * vx;
			
		}
		if((x < 0)||(x >= this.getWidth())){
			vx = - 0.95 * vx;
			vy = 0.95 * vy;
		}
		x = x + vx;
		y = y + vy;
		g2.setColor(Color.WHITE);
		g2.fillRect(0,0,this.getWidth(),this.getHeight());
		g2.setColor(Color.BLACK);
		g2.fillOval((int) x, (int)y, 20, 20);
		g.drawImage(yu, 0, 0,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			repaint();
		}

	}

}
