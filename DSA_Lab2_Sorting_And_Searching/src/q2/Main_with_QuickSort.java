package q2;

import java.util.Scanner;

public class Main_with_QuickSort {

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
		
		quick_sort(arr, 0, size-1);
		
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
}
