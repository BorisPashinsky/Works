package PersonalWorks;

import java.applet.*;
import java.awt.*;


@SuppressWarnings("serial")
public class DrawingParameticFunctions extends Applet{
	int width, height;
	Image backbuffer;
	Graphics backg; 
	double w = 4;
	double h = 4;
	double e = 0.1;
	double start = 0;
	double finish = 2 * Math.PI;
	public void init() {
		width = getSize().width;
		height = getSize().height;
		backbuffer = createImage( width, height );
		backg = backbuffer.getGraphics();
		backg.setColor( Color.red );
		backg.drawLine(width/2, 0, width/2, height);
		backg.drawLine(0,height/2,width,height/2);
		backg.setColor( Color.black );
		for(double t = start; t < finish;t = t + e){
			backg.drawLine(x(t),y(t),x(t + e),y(t + e));
		}
		repaint();
	}
	public int y(double t) {
		return (int)(-f(t) * height /  (2 * h) + height/2);
	}
	public int x(double t) {
		return (int)Math.round(g(t) * width /  (2 * w) + width/2);
	}
	public double f(double t) {
		return Math.sin(t);
	}
	public double g(double t) {
		return 2*Math.cos(t);
	}
	
	public void paint( Graphics g ) {
		g.drawImage( backbuffer, 0, 0, this );
	}
}