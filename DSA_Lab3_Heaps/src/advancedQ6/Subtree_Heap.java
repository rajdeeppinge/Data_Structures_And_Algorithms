package advancedQ6;

import java.util.Scanner;

public class Subtree_Heap {

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
		
		find_heap(arr, size);
		
		sc.close();
	}
	
	public static void find_heap(int[] arr, int size) {
		int[] maxHeapSize = new int[size];				//this is needed to check if there are multiple heaps of maximum size
		int maxSize = 1;
		
		for(int i=0; i < size; i++) {
			maxHeapSize[i] = 1;
		}
		
		for(int i = (size-2)/2; i >= 0; i--) {
			Queue queue = new Queue();
			
			//to check if it has a min-heap
			if(2*i+1 < size && arr[i] <= arr[2*i+1]) {
				queue.enqueue(2*i+1);					//if left child follows property, enqueue it and increment size
				maxHeapSize[i]++;
				if(2*i+2 < size) {						//if left child follows then only check for right child
					if(arr[i] <= arr[2*i+2]) {
						queue.enqueue(2*i+2);
						maxHeapSize[i]++;
					}
					else {
						continue;
					}
				}
				
				while(!queue.isEmpty()) {				//same as above but to check for whole subtree below the node
					int j = queue.dequeue();
					if(2*j+1 < size && arr[j] <= arr[2*j+1]) {
						queue.enqueue(2*j+1);
						maxHeapSize[i]++;
						if(2*j+2 < size) {
							if(arr[j] <= arr[2*j+2]) {
								queue.enqueue(2*j+2);
								maxHeapSize[i]++;
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
				}
				
				if(maxHeapSize[i] > maxSize) {
					maxSize = maxHeapSize[i];
				}
			}
			
			//to check if it has a max-heap
			else if(2*i+1 < size && arr[i] >= arr[2*i+1]) {
				queue.enqueue(2*i+1);						
				maxHeapSize[i]++;
				if(2*i+2 < size) {
					if(arr[i] >= arr[2*i+2]) {
						queue.enqueue(2*i+2);
						maxHeapSize[i]++;
					}
					else {
						continue;
					}
				}
				
				while(!queue.isEmpty()) {											
					int j = queue.dequeue();
					if(2*j+1 < size && arr[j] >= arr[2*j+1]) {
						queue.enqueue(2*j+1);
						maxHeapSize[i]++;
						if(2*j+2 < size) {
							if(arr[j] >= arr[2*j+2]) {
								queue.enqueue(2*j+2);
								maxHeapSize[i]++;
							}
							else {
								break;
							}
						}
					}
					else {
						break;
					}
				}
				
				if(maxHeapSize[i] > maxSize) {
					maxSize = maxHeapSize[i];
				}
			}
			
		}//for loop ends
		
		System.out.println("Size of largest heap = " + maxSize);
		
		for(int i = 0; i < size; i++) {
			if(maxHeapSize[i] == maxSize) {
				print(arr, i, maxSize);
			}
		}
		
	}//method ends
	
	public static void print(int arr[], int index, int maxSize) {
		Queue queue = new Queue();
		System.out.println("Maximum size heap formed ((given in the form (index, value))) is:");
		queue.enqueue(index);
		for(int i = 0; i < maxSize; i++) {
			int heapNode = queue.dequeue(); 
			System.out.print("("+ (heapNode) + ", " + arr[heapNode] + ")" + " ");
			if(2*heapNode+1<arr.length) {
				queue.enqueue(2*heapNode+1);
			}
			if(2*heapNode+2<arr.length) {
				queue.enqueue(2*heapNode+2);
			}
		}
		System.out.println();
	}
}
