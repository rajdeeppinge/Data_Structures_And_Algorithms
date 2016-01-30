package advancedQ7;

import java.util.Scanner;

public class Main {

	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of binary minimum heap");
		int size = sc.nextInt();
		
		System.out.println("Enter all the elements of binary minimum heap in order");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		count_swap_pairs(arr, size);
		
		System.out.println("Number of pairs = " + count);
		
		sc.close();
	}
	
	public static void count_swap_pairs(int[] arr, int size) {
		for(int i = 1; i < size-1; i++) {					//we start from 2nd topmost node so that it is compared with all the nodes below and for below nodes this comparison is not needed
															//at any stage a node has been already compared with possible nodes that came before it in the heap
			for(int j = i+1; j < leftChildIndex(i); j++) {	//compare only those nodes which come after this node and are NOT descendants or ancestors of the current node
				if(j < size) {
					compare(i, j, arr);
				}
				else 
					break;
			}
		}
	}
	
	public static void compare(int elementIndex, int compareWith, int[] arr) {
		if(compareWith >= arr.length) {
			return;
		}
		
		//we need to check following 6 conditions to see if two nodes can be swapped
		boolean condition1 = arr[elementIndex] > arr[parentIndex(compareWith)];
		
		boolean condition2 = leftChildIndex(compareWith) >= arr.length || (leftChildIndex(compareWith) < arr.length && arr[elementIndex] < arr[leftChildIndex(compareWith)]);
		
		boolean condition3 = rightChildIndex(compareWith) >= arr.length || (rightChildIndex(compareWith) < arr.length && arr[elementIndex] < arr[rightChildIndex(compareWith)]);
		
		boolean condition4 = arr[compareWith] > arr[parentIndex(elementIndex)];
		
		boolean condition5 = leftChildIndex(elementIndex) >= arr.length || (leftChildIndex(elementIndex) < arr.length && arr[compareWith] < arr[leftChildIndex(elementIndex)]);
		
		boolean condition6 = rightChildIndex(elementIndex) >= arr.length || (rightChildIndex(elementIndex) < arr.length && arr[compareWith] < arr[rightChildIndex(elementIndex)]);
		
		
		if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6)//if all conditions satisfy simultaneously then we can swap those nodes
		{
			count++;
		}
		
		compare(elementIndex, leftChildIndex(compareWith), arr);	//compare left child recursively
		compare(elementIndex, rightChildIndex(compareWith), arr);
		
	}
	
	public static int leftChildIndex(int index) {
		return index*2 + 1;
	}
	
	public static int rightChildIndex(int index) {
		return index*2 + 2;
	}
	
	public static int parentIndex(int index) {
		return (index - 1) / 2;
	}
}
