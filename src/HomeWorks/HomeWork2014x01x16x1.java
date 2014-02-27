package HomeWorks;

import java.util.Scanner;

public class HomeWork2014x01x16x1 {
	public static int[] f(int[] a, int[] b) {
		if(a.length < b.length){
			int t = b[a.length];
			int[] c = new int[a.length + 1];
			boolean bu = true;
			for(int i = 0;(i < a.length + 1); i++){
				if(bu){
					if(i < a.length? (t > a[i]):false){
						c[i] = a[i];
					}else{
						c[i] = t;
						bu = false;
					}
				}else{
					c[i] = a[i - 1];
				}
			}
			//			int k = a.length;int s = 0;
			//			for(int i = 0; (i < k)&&(b[k]>a[i]);i++){
			//				s = i;
			//			}
			//			double[] c = new double[k+1];
			//			for(int i = 0; i < k+1;i++){
			//				if(i < s+1){
			//					c[i] = a[i];
			//				}
			//				if(i == s + 1){
			//					c[i] = b[k];
			//				}if(i > s + 1){
			//					c[i] = a[i - 1];
			//				}
			//			}
			return f(c,b);
		}else{
			return a;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		Scanner im = new Scanner(System.in);
		int[] a = new  int[n];
		for(int i = 0; i < n; i++){
			a[i] = im.nextInt();
		}
		int[] e = new int[1];
		e[0] = a[0];
		a = f(e,a);
		for(int i = 0; i < n;i++){
			System.out.println(a[i]);
		}
		im.close();
	}

}
