package q3;

import java.util.Scanner;

public class Main_with_RankOfAnElement {

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
		
		System.out.println("Enter the element whose rank is to be found out");
		int element = sc.nextInt();
		int rank = 1;
		
		for(int i = 0; i < size; i++) { 
			if(arr[i] < element) {
				rank++;
			}
		}
		
		System.out.println("Rank of " + element + " is " + rank);
		
		sc.close();
	}
}