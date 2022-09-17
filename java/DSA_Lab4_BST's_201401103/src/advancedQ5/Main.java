package advancedQ5;

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
		
		System.out.println("Total number of orderings = " + orderings(bst.getRoot()));
	}

	public static long factorial(long num) {
		if(num <= 1) {
			return 1;
		}
		return num*factorial(num-1);
	}
	
	public static long combination_nCr(long n, long r) {
		return factorial(n)/(factorial(r) * factorial(n-r));
	}
	
	public static long orderings(Node currRoot) {
		if(currRoot.getSizeOfSubtree() <= 1) {
			return 1;
		}
		
		long orderingsInLeftSubtree = 1;
		if(currRoot.getLeftChild() != null) {
			orderingsInLeftSubtree = orderings(currRoot.getLeftChild());
		}
		
		long orderingsInRightSubtree = 1;
		if(currRoot.getRightChild() != null) {
			orderingsInRightSubtree = orderings(currRoot.getRightChild());
		}
		
		if(currRoot.getRightChild() != null) {
			return combination_nCr(currRoot.getSizeOfSubtree() - 1, currRoot.getRightChild().getSizeOfSubtree()) * orderingsInLeftSubtree * orderingsInRightSubtree;
		}
		
		else {
			return combination_nCr(currRoot.getSizeOfSubtree() - 1, currRoot.getLeftChild().getSizeOfSubtree()) * orderingsInLeftSubtree * orderingsInRightSubtree;
		}
	}
}
