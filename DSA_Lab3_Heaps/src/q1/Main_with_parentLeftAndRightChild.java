package q1;

import java.util.Scanner;

public class Main_with_parentLeftAndRightChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of binary heap");
		int size = sc.nextInt();
		
		System.out.println("Enter all the elements of binary heap in order");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter an index such that we can find the chilren and parent of that element");
		int index = sc.nextInt();
		
		//parent
		int parent = (index-1)/2;
		if(parent <= 0) {
			System.out.println("Parent doesn't exist");
		}
		else {
			System.out.println("Parent is: " + arr[parent]);
		}
		
		//left child
		int leftChild = 2*index+1;
		if(leftChild >= arr.length) {
			System.out.println("Left child doesn't exist");
		}
		else {
			System.out.println("left child is: " + arr[leftChild]);
		}

		//right child
		int rightChild = 2*index+2;
		if(rightChild >= arr.length) {
			System.out.println("Right child doesn't exist");
		}
		else {
			System.out.println("right child is: " + arr[rightChild]);
		}

		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}

}
