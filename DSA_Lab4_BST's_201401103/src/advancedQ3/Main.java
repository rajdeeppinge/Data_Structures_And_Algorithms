package advancedQ3;

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
		
		System.out.println("BST in level order:");
		bst.level_order_traversal(bst.getRoot());
		
		Node tree1 = bst.split_tree(3);
		
		Node tree2 = bst.split_tree(2);
		
		Node tree3 = bst.getRoot();
				
		System.out.println("Tree 1 in level order");
		bst.level_order_traversal(tree1);
		System.out.println("Tree 2 in level order");
		bst.level_order_traversal(tree2);
		System.out.println("Tree 3 in level order");
		bst.level_order_traversal(tree3);
	}

}
