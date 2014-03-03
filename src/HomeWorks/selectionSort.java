package HomeWorks;

import java.util.Scanner;

public class selectionSort {
	public static int min( int[] a, int to, int from){
		int c = a[to];
		int t = 0;
		for(int i = to; i< from; i++){
			if(a[i]< c){
				c = a[i];
				t = i;
			}
		}
		return t;

	}

	public static void main(String[] args) {
		Scanner im = new Scanner(System.in);
		int n = 5;
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = im.nextInt();
		}
		int[] b = new int[n];
		for(int i = 0; i < n; i++){
			int f = min(a,0,a.length);
			b[i] = a[f];
			a[f] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < n;i++){
			System.out.println(b[i]);
		}
		im.close();
	}

}
