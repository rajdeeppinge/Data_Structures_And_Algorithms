package advancedQ2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of elements that you want to insert in the tree");
		int size = sc.nextInt();
		
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Enter the elements");
		for(int i = 0; i < size; i++) {
			bst.insert(sc.nextInt());
		}
		
		sc.close();
		
		bst.size_of_subtree();
		
		System.out.println("BST in level order:");
		bst.level_order_traversal();
		
		System.out.println("Inversions per node:");
		int totalInversions = bst.total_inversions();
		System.out.println("Total Inversions = " + totalInversions);
	}

}
