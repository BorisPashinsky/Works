package PersonalWorks;


// W. Orlov 13.06.2008

import java.awt.*;

public class platt {

	// Die ganze Sonne wird nicht weiter als ein Punkt verstanden.

	public static void  main(String args[]) {

		double G=6.67428e-11; 
		double Rsonne=696000000., Msonne=1.9891e+30;

		// Merkur:
		double Rp=4.6e+10, Vp=5.898e+4, Ra=6.982e+10, Va=3.886e+4, Mplanet=3.302e+23;  
		int Zahl_uml=415, planet=1;
		// Venus:
		//    double Rp=1.0748e+11, Vp=3.526e+4, Ra=1.0894e+11, Va=3.479e+4, Mplanet=4.8685e+24; 
		//    int Zahl_uml=163, planet=2;
		// Erde:
		//    double Rp=1.4709e+11, Vp=3.029e+4, Ra=1.521e+11, Va=2.929e+4, Mplanet=5.9736e+24;  
		//    int Zahl_uml=100, planet=3;
		// Mars:
		//    double Rp=2.0662e+11, Vp=2.65e+4, Ra=2.4923e+11, Va=2.197e+4, Mplanet=6.4185e+23;  
		//    int Zahl_uml=53, planet=4;

		double d=14800000.;
		double dt=1.;
		double r, bs, M, x, y, x0, y0, vx, vy, xp0, yp0, xp, yp;
		double xiyi=0., xi2=0., A, fehler=0.;
		double yi[]= new double[420];
		int n, uml=-2;

		bs = Math.PI/(180.*60.*60.); // Bogensekunde
		M = Msonne + Mplanet;

		x0 = Rp;  y0 = 0.; 
		x = x0; y = y0; 
		vx = 0.; vy = Vp;
		xp0 = x0; yp0 = y0;
		xp = x0; yp = y0;

		while(uml<=Zahl_uml){

			x = x + vx*dt/2.;
			y = y + vy*dt/2.;   
			r = (x*x + y*y - d*d/4.)/(Math.sqrt(x*x + y*y + d*d/4.));
			vx = vx - dt*G*M*x/(r*r*r);
			vy = vy - dt*G*M*y/(r*r*r);
			x = x + vx*dt/2.;
			y = y + vy*dt/2.;

			if(uml == 0){
				if((xp0*xp0 + yp0*yp0) > (x*x + y*y)){
					xp0 = x;
					yp0 = y;
				}
			}

			if((xp*xp + yp*yp) > (x*x + y*y)){
				xp = x;
				yp = y;
			}

			// Berechnung von absoluter Perihelverschiebung, Regressionsgerade und Standardabweichung

			if(y0>0. && y<=0. || y0>=0. && y<0.){    
				if(uml>0){
					yi[uml] = (Math.atan(yp/xp)-Math.atan(yp0/xp0))/bs;
					xi2 = xi2 + uml*uml;
					xiyi = xiyi + uml*yi[uml];
					A = xiyi/xi2;
					if(uml>1){
						fehler = 0.;
						for(n=1;n<=uml;n++)fehler = fehler + (A*n-yi[n])*(A*n-yi[n]);
						fehler = fehler/(uml-1);
						fehler = Math.sqrt(fehler);
					}
					System.out.println(uml +": " +"P=" +yi[uml] +"\"" +" RG=" + uml*A +"\"" +" +/-" +fehler +"\"");
				}
				uml++;
				xp = 0.;
				yp = Ra;
			}
			x0  = x;
			y0 = y;
		}

		System.out.println();
		switch(planet){
		case 1 : System.out.println("Merkur, d = " +d); break;
		case 2 : System.out.println("Venus, d = " +d); break;
		case 3 : System.out.println("Erde, d = " +d); break;
		case 4 : System.out.println("Mars, d = " +d);
		}

	}
}
