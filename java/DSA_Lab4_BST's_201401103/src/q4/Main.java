package q4;

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
		
		boolean process = true;
		
		do {
			System.out.println("press\n1: To insert an element in BST\n"
							+	"2: To delete an element from BST\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				bst.level_order_traversal();
				break;
			case 2:
				System.out.println("Enter the element to be deleted");
				key = sc.nextInt();
				bst.delete(key);
				System.out.println("BST in level order");
				bst.level_order_traversal();
				System.out.println("BST in pre order");
				bst.pre_order_recursive(bst.getRoot());
				break;
			case 0:
				process = false;
				break;
			}
		}
		while(process);
		
		sc.close();
	}

}
