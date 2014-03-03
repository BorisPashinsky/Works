package PersonalWorks;

import java.applet.*;
import java.awt.*;
 
@SuppressWarnings("serial")
public class Diffur extends Applet{
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
      backg.drawLine(0, 0, 0, height);
      backg.drawLine(0,height-1,width,height-1);
      backg.setColor( Color.black );
      for(int i = 0; i < width;i++){
    	  double x = i * w / width;
    	  int j = y(x);
    	  int g = y(x + w / width);
    	  backg.drawLine(i,j,i + 1,g);
      }
      repaint();
   }
   public int y(double x) {
	   return (int)(-f(x) * height /  (h) + height);
   }
   public double f(double x) {
	   if(x <= (h) / height ){
		   return 1+x;
	   }else{
	return f(x - (h) / height) * (1 + (h) / (height));
	   }
   }
   public double g(double x) {
	   return f(x - (h) / height);
   }
   public void paint( Graphics g ) {
	   g.drawImage( backbuffer, 0, 0, this );
   }
}