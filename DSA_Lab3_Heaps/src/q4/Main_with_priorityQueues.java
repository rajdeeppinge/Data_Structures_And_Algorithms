package q4;

import java.util.Scanner;

public class Main_with_priorityQueues {
	
	static int heapSize;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of array");
		heapSize = sc.nextInt();
		
		System.out.println("Enter all the elements of array");
		int[] arr = new int[heapSize+100];
		for(int i = 0; i < heapSize; i++) {
			arr[i] = sc.nextInt();
		}
		
		build_heap_leaf_upwards(arr);
		
		boolean process = true;
		
		while(process) {
			System.out.println("Press\n1: To insert an element in heap\n"
								+	"2: To delete most prioritised element from heap\n"
								+	"3: To increase key of an element\n"
								+ 	"4: To decrease key of an element\n"
								+	"5: To print heap in form of array\n"
								+	"0: To exit");
			
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Enter the key to be inserted");
					int key = sc.nextInt();
					insert(arr, key);
					break;
				case 2:
					int max = delete(arr);
					System.out.println("deleted element is: " + max);
					break;
				case 3:
					System.out.println("Enter the index and corresponding new key value to be increased");
					int index = sc.nextInt();
					key = sc.nextInt();
					keyValueIncrease(arr, index, key);
					break;
				case 4:
					System.out.println("Enter the index and corresponding new key value to be decreased");
					index = sc.nextInt();
					key = sc.nextInt();
					keyValueDecrease(arr, index, key);
					break;
				case 5:
					for(int i = 0; i < heapSize; i++) { 
						System.out.print(arr[i] + " ");
					}
					System.out.println();
					break;
				case 0:
					process = false;
					break;
			}
		}
		
		System.out.println("Heap using leaf-upwards method");
		for(int i = 0; i < heapSize; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void heapify(int[] arr, int pos) {
		int left = 2*pos+1;
		int right = 2*pos+2;
		int largest = pos;
		
		if(left < heapSize && arr[left] > arr[pos])
			largest = left;
		
		if(right < heapSize && arr[right] > arr[largest])
			largest = right;
		
		if(largest != pos) {
			int temp = arr[largest];
			arr[largest] = arr[pos];
			arr[pos] = temp;
			heapify(arr, largest);
		}
	}
	
	public static void build_heap_leaf_upwards(int[] arr) {
		for(int i = (heapSize-1)/2; i >= 0; i--) {
			heapify(arr, i);
		}
	}
	
	public static void insert(int[] arr, int key) {
		arr[heapSize] = Integer.MIN_VALUE;
		heapSize++;
		keyValueIncrease(arr, heapSize-1, key);
	}
	
	public static int delete(int[] arr) {
		if(heapSize <= 0) {
			System.out.println("Heap is empty");
			return -1;
		}
		int max = arr[0];
		heapSize--;
		arr[0] = arr[heapSize];
		heapify(arr, 0);
		return max;
	}
	
	public static void keyValueIncrease(int[] arr, int index, int key) {
		if(arr[index] < key) {
			arr[index] = key;
			while(index > 0 && arr[index] > arr[(index-1)/2]) {
				int temp = arr[index];
				arr[index] = arr[(index-1)/2];
				arr[(index-1)/2] = temp;
				index = (index-1)/2;
			}
		}
		else {
			System.out.println("New key is smaller than current key");
			return;
		}
	}
	
	public static void keyValueDecrease(int[] arr, int index, int key) {
		if(arr[index] > key) {
			arr[index] = key;
			heapify(arr, index);
		}
		else {
			System.out.println("New key is larger than current key");
			return;
		}
	}
}
