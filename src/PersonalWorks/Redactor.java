package PersonalWorks;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;

public class Redactor extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
	Image backbuffer;
	Graphics backg;
	int[] x;
	int[] y;
	int i = 0;
	double w = 100;
	double h = 100;
	MouseListener al;

	public void init() {
		width = getSize().width;
		height = getSize().height;
		backbuffer = createImage( width, height );
		backg = backbuffer.getGraphics();
		backg.setColor( Color.red );
		backg.drawLine(width/2, 0, width/2, height);
		backg.drawLine(0,height/2,width,height/2);
		backg.setColor( Color.black );
		x = new int[1000];
		y = new int[1000];
		JLabel f = new JLabel("");
		f.setBounds(0,0,0,0);
		this.add(f);
		al = new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {//нажато и отпущено в одном и том же месте

			}
			@Override
			public void mouseEntered(MouseEvent e) {//по идеи здесь должно выскакивать значения x и y для точки касания
				JLabel f = new JLabel(e.getX() + " " + e.getY());
				f.setBounds(e.getX(),e.getY(),50,50);
			}
			@Override
			public void mouseExited(MouseEvent e) {//при выходе за границы апплета

			}
			@Override
			public void mousePressed(MouseEvent e) {//при нажатии
				int xo = e.getX();
				int yo = e.getY();
				backg.setColor( Color.orange );
				backg.fillOval(xo-1,yo-1,2,2);
				x[i] = xo;
				y[i] = yo;
				i = i + 1;
				repaint();
				System.out.println("работает");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
					System.out.println("работает");
			}
		};
		this.addMouseListener(al);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println("работает1");
				double[] x1 = new double[i];
				double[] y1 = new double[i];
				for(int j = 0; j < i; j++){
					x1[j] = (x[j] - width/2.0) * 2 * w / width;
					y1[j] = (height/2.0 - y[j]) * 2 * h / height;
				}
				backg.setColor( Color.black );
				for(int k = 0; k < width;k++){
					double xo = (k - width/2.0) * 2 * w / width;
					int j = y(xo,x1,y1);
					int g = y(xo + 2 * w / width,x1,y1);
					backg.drawLine(k,j,k + 1,g);
				}
				repaint();
				System.out.println("работает2");
			}
		});

	}
	public int y(double xo, double[] x, double[] y) {
		return (int)Math.round(-f(xo, x, y) * height /  (2 * h) + height/2);
	}

	public static double f(double xo, double[] x, double[] y) {
		double L = 0;
		int n = x.length;
		for(int k = 0; k < n; k++){
			double l = y[k];
			for(int j =0; j < n; j++){
				if(k != j){
					l = l * (xo - x[j])/(x[k] - x[j]);
				}
			}
			L = L + l;
		}
		return L;
	}

	public void paint( Graphics g ) {
		g.drawImage( backbuffer, 0, 0, this );
	}

}

