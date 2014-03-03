package HomeWorks;

import java.util.Scanner;

public class bubbleSort {

	public static void main(String[] args) {
		Scanner im = new Scanner(System.in);
		int n = 5;
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = im.nextInt();
		}
		for(int i = 0; i < n; i++){
			for(int k = 1; k < n; k++){
				if(a[k] > a[k - 1]){
					int r = a[k - 1];
					a[k - 1] = a[k];
					a[k] = r;
				}
			}
		}
		for(int i = 0; i < n;i++){
			System.out.println(a[i]);
		}
		im.close();
	}

}