package advancedQ6;

import java.util.Scanner;

public class Main_with_NewSortingAlgorithm {

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
		
		System.out.println("Enter the fraction > 0.5 such that those many elements will be sorted from beginning and end alternately");
		float f = sc.nextFloat();
		
		newSortingAlgo(arr, f);
		
		System.out.println("Final array:");
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void quick_sort(int[] arr, int left, int right) {
		if(right <= left) {
			return;
		}		
		int index = partition(arr, left, right);
		quick_sort(arr, left, index-1);
		quick_sort(arr, index+1, right);
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		int temp;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		temp = arr[i+1];
		arr[i+1] = pivot;
		arr[right] = temp;
		
		return i+1;
	}
	
	public static void newSortingAlgo(int[] arr, float f) {
		int size = (int) Math.ceil(arr.length*f);
		boolean sortPrefix = true;
		for(int i = 1; i < arr.length/(2*Math.floor(f*arr.length) - arr.length); i++) {
			if(sortPrefix) {
				quick_sort(arr, 0, size-1);
				sortPrefix = false;
				
				for(int j = 0; j < arr.length; j++) { 
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
			else {
				quick_sort(arr, arr.length-size, arr.length-1);
				sortPrefix = true;
			
				for(int j = 0; j < arr.length; j++) { 
					System.out.print(arr[j] + " ");
				}
				System.out.println();
			}
		}
	}
}
