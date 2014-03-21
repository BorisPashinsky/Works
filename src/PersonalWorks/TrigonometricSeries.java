package PersonalWorks;

import java.util.Scanner;

public class TrigonometricSeries {
	public static class TrigonometricSequence {
		double a[];
		TrigonometricSequence(double a[]) {
			this.a = a;
		}
		public int length(){
			return this.a.length;
		}
		public String toString() {
			String S = "";
			int n = this.length();
			for(int j = 0; j < n; j++){
				String s = "";
				if(Math.abs(a[j]) != 0){
					if(j == 0){
						s = s + a[j];

					}else{
						if(a[j] > 0){
							s = "+";
						}
						if(j % 2 == 0){
							s = s + a[j] + "cos( " + (j  / 2) + "x )";

						}else{
							s = s + a[j] + "sin( " + ((j + 1) / 2) + "x )";
						}
					}
				}
				S = S + s;
			}	
			return S;
		}

	}
	public static TrigonometricSequence CreationSeries(double[] x, double[] y) {
		int n = x.length;
		if(n == y.length){
			double[][] b = new double[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(i == 0){
						b[i][j] = 1;
					}else{
						if(i % 2 == 0){
							b[i][j] = Math.cos((i  / 2)* x[j]);
						}else{
							b[i][j] = Math.sin(((i  + 1)/ 2) * x[j]);
						}
					}
				}
			}
			double[] a = Solving(b,y);
			TrigonometricSequence v = new TrigonometricSequence(a);
			return v;
		}else{
			return null;
		}
	}
	
	public static double f(double x) {
		return Math.sin(x) - Math.cos(x);
	}
	public static double Determination(double a[][]) {
		if(a.length>1){
			double d = 0;
			for(int i = 0; i < a.length;i++){
				d = d + Math.pow(-1,i)*a[i][0]*Determination(Minor(a,i));
			}
			return d;
		}else{
			return a[0][0];
		}
	}
	public static double[][] Minor(double a[][], int k) {
		double[][] b = new double[a.length - 1][a.length - 1];
		for(int i = 0; i < b.length;i++){
			for(int j = 0; j < b.length;j++){
				if(i < k){
					b[i][j] = a[i][j + 1];
				}else{
					b[i][j] = a[i + 1][j + 1];
				}
			}
		}
		return b;
	}
	public static double[] Solving(double a[][], double c[]) {
		double[] x = new double[c.length];
		double t = Determination(a);
		for(int i = 0; i < x.length;i++){
			x[i] = Determination(Special(a,c,i))/t;
		}
		return x;
	}
	public static double[][] Special(double a[][], double c[], int k) {
		double[][] b = new double[a.length][a.length];
		for(int j = 0; j < c.length;j++){
			for(int i = 0; i < c.length;i++){
				if(j == k){
					b[k][i] = c[i];
				}else{
					b[j][i] = a[j][i];
				}
			}
		}
		return b;
	}
	public static void main(String[] args) {
		int n = 9;
		double[] c = new double[n];
		double[] x = new double[n];
		Scanner im = new Scanner(System.in);
		for(int j = 0; j < n; j++){
			x[j] = im.nextDouble() * Math.PI / 180;
		}
		for(int j = 0; j < n; j++){
			c[j] = f(x[j]);
		}
		TrigonometricSequence v = CreationSeries(x,c);
		System.out.println(v);
		im.close();
	}
}
