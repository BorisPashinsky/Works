package HomeWorks;

import java.util.Scanner;

public class HeapSort {
	static int n = 5;
	public static int[] SiftUp(int x, int[] a) {
		if(x == 1){
			return a;
		}else{
			if(a[x] > a[x / 2]){
				return a;
			}else{
				int t = a[x / 2];
				int u = a[x];
				a[x/2] = u;
				a[x] = t;
				return SiftUp(x / 2,a);
			}
		}

	}
	public static int[] SiftDown(int x, int[] a, int i) {
		if(x < i - 1){
			int l = ((2 * x + 1)>=i? a[2 * x ]:Math.min(a[2 * x ],a[2 * x + 1]));
			if(a[x] < l){
				return a;
			}else{
				int r = 0;
				if(l == a[2*x]){
					r = 2 * x;
				}else{
					r = 2 * x + 1;
				}
				int t = a[r];
				int u = a[x];
				a[r] = u;
				a[x] = t;
				return SiftDown(r,a, i);
			}
		}else{
			return a;
		}

	}
	public static int[] add(int[] a, int x, int i) {
		a[i] = x;
		return SiftUp(i, a);
	}
	public static int extractMin(int[] a, int i) {
		int t = a[1];
		a[1] = a[i - 1];
		SiftDown(1, a, i - 1);
		return t;
	}
	public static void main(String[] args) {
		Scanner im = new Scanner(System.in);
		int[] a = new int[1000];
		for(int i = 0; i < n; i++){
			a[i] = im.nextInt();
		}
		int[] b = new int[1000];
		b[1] = a[0];
		for(int i = 2; i <= n; i++){
			add(b, a[i - 1], i);
		}
		for(int i = n; i >= 0; i--){
			a[i] = extractMin(b, i + 1);
		}
		for(int i = 1; i <= n;i++){
			System.out.println(a[i]);
		}
		im.close();
	}

}
