package q2;

import java.util.Scanner;

public class Main_with_buildHeap_leafUpwards {

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
		
		build_heap_leaf_upwards(arr, size);
		
		System.out.println("Heap using leaf-upwards method");
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
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
	
	public static void build_heap_leaf_upwards(int[] arr, int size) {
		for(int i = (size-1)/2; i >= 0; i--) {
			heapify(arr, i, size);
		}
	}
	
}
