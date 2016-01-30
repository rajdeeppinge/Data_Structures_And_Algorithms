package q2;

import java.util.Scanner;

public class Main_with_InsertionSort {

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
		
		insertion_sort(arr);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void insertion_sort(int[] arr) {
		int size = arr.length;
		int j;
		
		for(int i = 0; i < size; i++) {
			int temp = arr[i];
			for(j = i; j > 0; j--) {
				if(temp < arr[j-1])
					arr[j] = arr[j-1];
				else
					break;
			}
			arr[j] = temp;
		}
	}
}
