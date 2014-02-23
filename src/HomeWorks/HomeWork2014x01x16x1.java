package HomeWorks;

import java.util.Scanner;

public class HomeWork2014x01x16x1 {
	public static double[] f(double[] a, double[] b) {
		if(a.length < b.length){
			int k = a.length;int s = 0;
			for(int i = 0; (i < k)&&(b[k]>a[i]);i++){
				s = i;
			}
			double[] c = new double[k+1];
			for(int i = 0; i < k+1;i++){
				if(i < s){
					c[i] = a[i];
				}
				if(i == s){
					c[i] = b[k];
				}if(i > s){
					c[i] = a[i - 1];
				}
			}
			return f(c,b);
		}else{
			return a;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		Scanner im = new Scanner(System.in);
		double[] a = new  double[n];
		for(int i = 0; i < n; i++){
			a[i] = im.nextDouble();
		}
		double[] f = new  double[n];
		double[] e = new double[1];
		e[0] = a[0];
		f = f(e,a);
		for(int i = 0; i < n;i++){
			System.out.println(f[i]);
		}
		im.close();

	}

}
