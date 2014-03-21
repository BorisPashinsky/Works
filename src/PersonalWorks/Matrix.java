package PersonalWorks;

import java.util.Scanner;

public class Matrix {
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
	public static void main(String[] args) {
		double[][] b = new double[2][2];
		Scanner im = new Scanner(System.in);
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				b[i][j] = im.nextInt();
			}
		}
		System.out.println(Determination(b));
		im.close();
	}

}
