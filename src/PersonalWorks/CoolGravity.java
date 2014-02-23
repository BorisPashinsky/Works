package PersonalWorks;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class CoolGravity extends Applet implements ActionListener {
	double vy = 0;
	double vx = 0;
	double x;
	double y;
	Timer timer = new Timer(100,this);
	{
		timer.start();
	}

	@Override
	public void paint(Graphics gr){
		super.paint(gr);
		gr.fillOval(300, 300, 50, 50);
		double r = Math.sqrt((x-300) * (x-300) + (y-300) * (y-300));
		if(r >20){
		double g = - 1000/ (r * r);
		double gx = (x-300) * g /r;
		double gy = (y-300) * g/r;
		vy = vy + gy;
		vx = vx + gx;
		x = x + vx;
		y = y + vy;
		gr.fillOval((int) x, (int) y, 20, 20);
		System.out.println(vx + " " + vy);
		}else{
			gr.fillOval((int) x, (int) y, 20, 20);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer){
			repaint();
		}

	}

}