package q2;

import java.util.Scanner;

public class Main_with_buildHeap_RootDown {
	
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
	
		build_heap_root_down(arr, size);
		
		System.out.println("Heap using root_down method");
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

		
	public static void build_heap_root_down(int[] arr, int size) {
		for(int i = 1; i < size; i++) {
			int heapSize = i;
			while(heapSize > 0 && arr[heapSize] > arr[(heapSize-1)/2]) {
				int temp = arr[heapSize];
				arr[heapSize] = arr[(heapSize-1)/2];
				arr[(heapSize-1)/2] = temp;
				heapSize = (heapSize-1)/2;
			}
		}
	}	
}
