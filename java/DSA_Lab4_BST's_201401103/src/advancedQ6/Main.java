package advancedQ6;

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
		
		bst.size_of_subtree();
		
		bst.base_rank(bst.getRoot());
		
		bst.rank(bst.getRoot());
		
		System.out.println("BST in level order");
		bst.level_order_traversal(bst.getRoot());
		
		int k = 0;
		for(k = size-1; k >= 2; k--) {
			Node temp1 = bst.valid_subtree(1, k, bst.getRoot());
			Node temp2 = bst.valid_subtree(size - k + 1, size, bst.getRoot());
			if(temp1 != null && temp2 != null) {
				System.out.println("largest k = " + k);
				System.out.println("Subtree 1:");
				bst.level_order_traversal(temp1);
				System.out.println("Subtree 2:");
				bst.level_order_traversal(temp2);
				break;
			}
		}
		
		if(k==1) {
			System.out.println("No value of k is possible");
		}
		
		System.out.println();
		
		alternate_method(bst);
		
		sc.close();
	}
	
	public static void alternate_method(BinarySearchTree bst) {
		Node leftRoot = bst.getRoot().getLeftChild();
		Node rightRoot = bst.getRoot().getRightChild();
		
		while(leftRoot != null || rightRoot != null) {
			if(leftRoot.getSizeOfSubtree() == rightRoot.getSizeOfSubtree()) {
				if(leftRoot.getSizeOfSubtree() > 1) {
					System.out.println("largest k = " + leftRoot.getSizeOfSubtree());
					System.out.println("Subtree 1:");
					bst.level_order_traversal(leftRoot);
					System.out.println("Subtree 2:");
					bst.level_order_traversal(rightRoot);
				}
				break;
			}
				
			else if(leftRoot.getSizeOfSubtree() > rightRoot.getSizeOfSubtree()) {
				leftRoot = leftRoot.getLeftChild();
			}
			
			else {
				rightRoot = rightRoot.getRightChild();
			}
		}
		
		if(leftRoot == null || rightRoot == null || leftRoot.getSizeOfSubtree() == 1) {
			System.out.println("No value of k is possible");
		}
	}
}
