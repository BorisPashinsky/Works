package ClassWorks;

import java.util.Random;
import java.util.Scanner;

public class SimulatedAnnealing {
	public static int[] x0(int n) {
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i]=i + 1;
		}
		for(int i = 0; i < n; i++){
			randomSwap(a,n);
		}
		return a;
	}

	public static void randomSwap(int[] a, int n) {
		Random r = new Random();
		int i = r.nextInt(n);
		int j = r.nextInt(n);
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}
	public static int E(int[] a,int n) {
		int t = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(Math.abs(j - i) == Math.abs(a[i] - a[j])){
					t++;
				}
			}
		}
		return t / 2;
	}
	public static boolean probability(double x) {
		Random r = new Random();
		double i = r.nextDouble();
		if(i < x){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner im = new Scanner(System.in);
		int n = 50;
		int[] a = new int[n];

		for(int i = 0; i < 2000; i++){
			int[] x = x0(n);
			int t = E(x,n);
			for(int j = 0; j < 1000; j++){
				int[] x1 = x.clone();
				randomSwap(x1,n);
				int t1 = E(x1,n);
				if(t > t1){
					x = x1.clone();
				}else{
					if(probability(-j * Math.abs(t - t1) / 400) ){
						x = x1.clone();
					}
				}
			}
			if((t <= E(a,n))||(i == 0)){
				a = x.clone();
			}

		}
		for(int i = 0; i < n;i++){
			System.out.println(a[i]);
		}
		System.out.println("E = " + E(a,n));
		im.close();
	}
}