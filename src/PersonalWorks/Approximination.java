package PersonalWorks;



public class Approximination {
	public static double function(double xo, double[] x, double[] y) {
		double L =0;
		int n = x.length;
		for(int i =0; i < n; i++){
			double l = y[i];
			for(int j =0; j < n; j++){
				if(i != j){
					l = l * (xo - x[j])/(x[i] - x[j]);
				}
			}
			L = L + l;
		}
		return L;
	}
	
	public static double f(double x) {
		return Math.exp(x);
	}
	public static void main(String[] args) {
		double[] x = new double[4];
		double[] y = new double[4];
		for(int i = 0; i < 4; i++){
//			x[i] = i;
//			y[i] = f(x[i]);
			y[i] = 3;
			x[i] = 3.1 + i * 0.0001;
		}
		
		System.out.println(function(0,x,y));
	}

}
