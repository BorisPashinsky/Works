package PersonalWorks;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 
@SuppressWarnings("serial")
public class GraficRedactor extends Applet{
   int width, height;
   Image backbuffer;
   Graphics backg; 
   double w = 20;
   double h = 20;
   public void init() {
      width = getSize().width;
      height = getSize().height;
      backbuffer = createImage( width, height );
      backg = backbuffer.getGraphics();
      backg.setColor( Color.red );
      backg.drawLine(width/2, 0, width/2, height);
      backg.drawLine(0,height/2,width,height/2);
      backg.setColor( Color.black );
      for(int i = 0; i < width;i++){
    	  double x = (i - width/2.0) * 2 * w / width;
    	  int j = y(x);
    	  int g = y(x + 2 * w / width);
    	  backg.drawLine(i,j,i + 1,g);
      }
      repaint();
   }
   public int y(double x) {
	   return (int)Math.round(-f(x) * height /  (2 * h) + height/2);
   }
   public int round(double x){
	   int g = (int) (x - x%1 + x / Math.abs(x));
	   return g;
   }
   public double f(double x) {
	   if(Math.abs(x)<=1){
		   return x * x;
	   }else{
		   double g = x / round(x);
		   return Math.pow(f(x / round(x)), round(x));
	   }
	   
   }
   public void paint( Graphics g ) {
	   g.drawImage( backbuffer, 0, 0, this );
   }
}
