package advancedQ3andQ4;

import java.util.Scanner;

public class Main_Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		
		System.out.println("Enter elements of array");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min, max;
		min = max = arr[0];
		
		for(int i = 1; i < size; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			else if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println("Minimum element = " + min + "\n" + "Maximum element = " + max);
		
		sc.close();
	}
	
}
