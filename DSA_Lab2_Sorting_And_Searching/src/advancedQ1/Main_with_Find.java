package advancedQ1;

import java.util.Scanner;

public class Main_with_Find {

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
		
		int minPos = findMin(arr, 0, size-1);
		int maxPos = (minPos-1+size) % size;
		
		System.out.println("Minimum element is at position: " + (minPos + 1) + "\n" +
				"Maximum element is at position: " + (maxPos + 1));
		
		sc.close();
	}
	
	public static int findMin(int[] arr, int lowerIndex, int upperIndex) {
		if(arr[lowerIndex] < arr[upperIndex]) {		//means it is already sorted
			return lowerIndex;
		}
		if(lowerIndex == upperIndex-1) {
			return upperIndex;
		}
		int mid = (lowerIndex + upperIndex) / 2;
		
		if(arr[mid] < arr[lowerIndex]) {
			return findMin(arr, lowerIndex, mid);
		}
		else {
			return findMin(arr, mid, upperIndex);
		}
	}
}
