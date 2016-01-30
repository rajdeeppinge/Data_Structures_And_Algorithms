package q2;

import java.util.Scanner;

public class Main_with_BubbleSort {

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
		
		bubble_sort(arr);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void bubble_sort(int[] arr) {
		int size = arr.length;
		
		for(int i = 0; i < size-1; i++) {
			boolean done = true;			//if the array is sorted at an intermediate level, then the function stops instead of doing all n*n operations
			for(int j = 0; j < size-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					done = false;
				}
			}
			
			if(done)
				return;
		}
	}
}
