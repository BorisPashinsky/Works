package PersonalWorks;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class VeryCoolGravity extends Applet implements ActionListener {
	double vy = 1;
	double vx = 1;
	double x0 = 0;
	double y0 = 300;
	double x = x0;
	double y = y0;
	double i;
	Timer timer = new Timer(60,this);
	{
		timer.start();
	}

	@Override
	public void paint(Graphics gr){
		super.paint(gr);
		gr.fillOval(300, 300, 50, 50);
		double r = Math.sqrt((x-300)*(x-300)+(y-300)*(y-300));
		if(r > 25){
			double r1 = 300/(1+0.1*Math.sin(i / 10));
			x = x0 - 300 + r1 * Math.cos(i / 10);
			y = y0 + 300 -r1 * Math.sin(i / 10);
			gr.fillOval((int)x, (int)y, 20, 20);
			System.out.println(vx + " " + vy);
			i++;
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