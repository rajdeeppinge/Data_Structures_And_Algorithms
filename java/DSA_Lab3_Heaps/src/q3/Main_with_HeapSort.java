package q3;

import java.util.Scanner;

public class Main_with_HeapSort {

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
		
		heap_sort(arr, size);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void heap_sort(int[] arr, int size) {
		build_heap(arr, size);
		
		for(int i = arr.length-1; i >= 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			size--;
			heapify(arr, 0, size);
		}
	}
	
	public static void heapify(int[] arr, int pos, int size) {
		int left = 2*pos+1;
		int right = 2*pos+2;
		int largest = pos;
		
		if(left < size && arr[left] > arr[pos])
			largest = left;
		
		if(right < size && arr[right] > arr[largest])
			largest = right;
		
		if(largest != pos) {
			int temp = arr[largest];
			arr[largest] = arr[pos];
			arr[pos] = temp;
			heapify(arr, largest, size);
		}
	}
	
	public static void build_heap(int[] arr, int size) {
		for(int i = (size-2)/2; i >= 0; i--) {
			heapify(arr, i, size);
		}
	}
}
