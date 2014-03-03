package HomeWorks;

import java.util.Scanner;

public class insertionSort {

	public static void main(String[] args) {
		Scanner im = new Scanner(System.in);
		int n = 5;
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = im.nextInt();
		}
		for(int i = 1; i < a.length; i++){
			int c = a[i];
			int k = i - 1;
			while(k >= 0 && a[k] > c){
				a[k + 1] = a[k];
				a[k] = c;
				k = k - 1; 
			}
		}
		for(int i = 0; i < n;i++){
			System.out.println(a[i]);
		}
		im.close();
	}

}
