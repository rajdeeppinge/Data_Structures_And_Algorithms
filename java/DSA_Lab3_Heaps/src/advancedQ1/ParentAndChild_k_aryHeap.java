package advancedQ1;

import java.util.Scanner;

public class ParentAndChild_k_aryHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of children k each node has");
		int k = sc.nextInt();
		
		System.out.println("Enter maximum size of k-ary heap");
		int size = sc.nextInt();
		
		System.out.println("Enter all the elements of k-ary heap in order");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Enter an index such that we can find the chilren and parent of that element");
		int index = sc.nextInt();
		
		//parent
		int parent = (int)Math.ceil((index-1)/(float)k);
		if(parent <= 0) {
			System.out.println("Parent doesn't exist");
		}
		else {
			System.out.println("Parent is: " + arr[parent]);
		}

		for(int i = 1; i <= k; i++) {
			int childIndex = k*index + i;
			if(childIndex >= arr.length) {
				System.out.println("child doesn't exist");
				break;
			}
			else {
				System.out.println("child is: " + arr[childIndex]);
			}
		}
		
		sc.close();
	}

}
