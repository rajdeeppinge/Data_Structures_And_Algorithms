package q4;

import java.util.Scanner;

public class Main_with_ElementOfGivenRank {

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
		
		System.out.println("Enter the Rank: ");
		int rank = sc.nextInt();
		
		int element = elementGivenRank(arr, 0, size-1, rank);
		
		System.out.println("Element at rank " + rank + " is: " + element);
		sc.close();
	}
	
	public static int elementGivenRank(int[] arr, int left, int right, int rank) {		
		int index = partition(arr, left, right);
		if(index == rank-1) {
			return arr[index];
		}
		else if(index > rank-1) {
			return elementGivenRank(arr, left, index-1, rank);
		}
		else
			return elementGivenRank(arr, index+1, right, rank);
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		int temp;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		temp = arr[i+1];
		arr[i+1] = pivot;
		arr[right] = temp;
		
		return i+1;
	}
}
