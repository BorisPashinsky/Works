package PersonalWorks;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Diffur extends Applet{
	int width, height;
	Image backbuffer;
	Graphics backg; 
	double w = 20;
	double h = 20;
	double a = 0.01;
	double b = 0.01;
	double c = 0.1;
	double d = 0.01;
	public void init() {
		width = getSize().width;
		height = getSize().height;
		backbuffer = createImage( width, height );
		backg = backbuffer.getGraphics();
		backg.setColor( Color.red );
		backg.drawLine(0, 0, 0, height);
		backg.drawLine(0,height-1,width,height-1);
		backg.setColor( Color.black );

		double f[] = new double[width];
		double g[] = new double[width];
		f[0] = 10;
		g[0] = 20;
		for( int i = 0; i < width; i++){
			f[i] = f[i - 1] + (a * f[ i - 1 ] * g[i - 1] - b * f[i - 1]) * 2 * w / width;
			g[i] = g() + (c * g(x  - 2 * w / width) - d * f(x - 2 * w / width) * g(x  - 2 * w / width)) * 2 * w / width;
		}
		for(int i = 0; i < width;i++){
			double x = (i) * 2 * w / width;
			int j = y(x);
			int d = y(x + 2 * w / width);
			backg.drawLine(i,j,i + 1,d);
		}
		repaint();
	}
	public int y(double x) {
		return (int)Math.round(-f(x) * height /  (2 * h) + height);
	}

	public double f(double x) {
		if(x == 0){
			return 10;
		}else{
			return f(x - 2 * w / width) + (a * f(x - 2 * w / width) * g(x - 2 * w / width) - b * f(x - 2 * w / width)) * 2 * w / width;
		}
	}
	public double g(double x) {
		if(x == 0){
			return 20;
		}else{
			return g(x - 2 * w / width) + (c * g(x  - 2 * w / width) - d * f(x - 2 * w / width) * g(x  - 2 * w / width)) * 2 * w / width;
		}
	}

	public void paint( Graphics g ) {
		g.drawImage( backbuffer, 0, 0, this );
	}
}