package advancedQ10;

import java.util.Scanner;

public class Main_with_ModifiedBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of array");
		int size = sc.nextInt();
		
		System.out.println("Enter all the elements of array");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter the number of inversions that you finally want in the array: between 0 and " + size*(size-1)/2);
		int k = sc.nextInt();
		
		modified_bubble_sort(arr, k);
		
		System.out.println("Array with " + k + " inversions is:");
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void modified_bubble_sort(int[] arr, int k) {
		int originalInversions = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					originalInversions++;
				}
			}
		}
		System.out.println("Original inversions = " + originalInversions);
		
		if(k == originalInversions)
			return;
		
		else if(k < originalInversions) {
			while(k < originalInversions) {
				int i = 0;
				for(int j = 0; j < arr.length-1-i; j++) {
					if(arr[j] > arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						k++;
					}
					if(k == originalInversions)
						break;
				}
				i++;
			}
		}
		
		else {
			while(k > originalInversions) {
				int i = 0;
				for(int j = 0; j < arr.length-1-i; j++) {
					if(arr[j] < arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						k--;
					}
					if(k == originalInversions)
						break;
				}
				i++;
			}
		}
	}
}
