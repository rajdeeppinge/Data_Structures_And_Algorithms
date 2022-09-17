package advancedQ3;

import java.util.Scanner;

public class Alternating_MinMax_Heap {

	static int heapSize = 1;
	
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
		
		System.out.println("Alternating Heap: ");
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void build_heap_root_down(int[] arr, int size) {
		for(int i = 1; i < size; i++) {
			insert(arr, arr[i]);
		}
	}
	
	public static void insert(int[] arr, int key) {
		int level = (int)Math.floor(Math.log10(heapSize+1)/Math.log10(2));
		int index = heapSize++;
		
		if(level%2 != 0) {									//if level is odd it follows max-heap property
			if(index > 0 && arr[index] < arr[(index-1)/2]) {	//if this element is less than its parent replace it with parent and now follow min-heap property
				swap(arr, index, (index-1)/2);
				index = (index-1)/2;
				min_heap_property(arr, index, key);
			}
			else {
				max_heap_property(arr, index, key);			//otherwise continue max-heap property
			}
		}
		else {
			if(index > 0 && arr[index] > arr[(index-1)/2]) {
				swap(arr, index, (index-1)/2);
				index = (index-1)/2;
				max_heap_property(arr, index, key);
			}
			else {
				min_heap_property(arr, index, key);
			}
		}
	}
	
	public static void max_heap_property(int[] arr, int index, int key) {				
		while(index > 2 && arr[index] > arr[((index-1)/2 - 1) / 2]) {		//((index-1)/2 - 1) / 2 gives the grandparent of the current node
			swap(arr, index, ((index-1)/2 - 1) / 2);					//go on replacing towards root till correct position is achieved
			index = ((index-1)/2 - 1) / 2;
		}
	}
	
	public static void min_heap_property(int[] arr, int index, int key) {
		while(index > 2 && arr[index] < arr[((index-1)/2 - 1) / 2]) {
			swap(arr, index, ((index-1)/2 - 1) / 2);
			index = ((index-1)/2 - 1) / 2;
		}
	}
	
	public static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
