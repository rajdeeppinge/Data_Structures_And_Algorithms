package q2;

import java.util.Scanner;

public class Main_with_SelectionSort {

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
		
		selection_sort(arr);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void selection_sort(int[] arr) {
		int size = arr.length;
		int min, minPos;
		
		for(int i = 0; i < size-1; i++) {
			min = arr[i];
			minPos = i;
			for(int j = i+1; j < size; j++) {
				if(arr[j] < min) {
					min = arr[j];
					minPos = j;
				}
			}
			
			if(minPos != i) {
				int temp = min;
				arr[minPos] = arr[i];
				arr[i] = temp;
			}
		}
	}

}
