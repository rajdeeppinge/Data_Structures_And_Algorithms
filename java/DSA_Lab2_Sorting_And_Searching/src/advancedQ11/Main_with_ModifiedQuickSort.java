package advancedQ11;

import java.util.Scanner;

public class Main_with_ModifiedQuickSort {

	/**
	 * @param args
	 */
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
		
		int[] exchanges_comparisons = new int[2];			//exchanges_comparisons[0] counts exchanges while exchanges_comparisons[1] counts comparisons
															//we need an array to pass value by reference
		quick_sort(arr, 0, size-1, exchanges_comparisons);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println("comparisons = " + exchanges_comparisons[1]);
		
		System.out.println("exchanges = " + exchanges_comparisons[0]);
		
		sc.close();
	}

	public static void quick_sort(int[] arr, int left, int right, int[] exchanges_comparisons) {
		if(right <= left) {
			return;
		}
		
		int index = partition(arr, left, right, exchanges_comparisons);
		quick_sort(arr, left, index-1, exchanges_comparisons);
		quick_sort(arr, index+1, right, exchanges_comparisons);
	}
	
	public static int partition(int[] arr, int left, int right, int[] exchanges_comparisons) {
			int pivot = arr[right];
			int i = left-1;
			int temp;
			
			for(int j = left; j < right; j++) {
				exchanges_comparisons[1]++;
				if(arr[j] <= pivot) {
					i++;
					if(i+1 < j) {				//if i+1 == j then it is the same element and hence no need to exchange
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						exchanges_comparisons[0]++;
					}
				}
			}
			
			if(i+1 < right) {				//if there is only one element then there is no need to shift pivot and hence no exchange takes place
				temp = arr[i+1];
				arr[i+1] = pivot;
				arr[right] = temp;
				exchanges_comparisons[0]++;
			}
			
			return i+1;
	}
}
