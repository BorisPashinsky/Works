package PersonalWorks;

import java.util.Scanner;

public class SolvingSystemOfLinearEquations {
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
		double[][] b = new double[2][2];
		double[] c = new double[2];
		Scanner im = new Scanner(System.in);
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				b[i][j] = im.nextInt();
			}
		}
		for(int j = 0; j < 2; j++){
			c[j] = im.nextInt();
		}
		double[] a = Solving(b,c);
		for(int j = 0; j < 2; j++){
			System.out.println(a[j]);
		}
		im.close();
	}

}
