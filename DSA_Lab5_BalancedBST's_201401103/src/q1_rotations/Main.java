package q1_rotations;

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
			System.out.println("press\n1: Insert an element\n"
							+ 	"2: Left Rotate at a node\n"
							+	"3: Right Rotate at a node\n"
							+	"4: Delete an element\n"
							+	"5: Print BST\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				break;
			case 2:
				System.out.println("Enter element");
				key = sc.nextInt();
				bst.left_rotate(key);
				bst.level_order_traversal();
				break;
			case 3:
				System.out.println("Enter element");
				key = sc.nextInt();
				bst.right_rotate(key);
				bst.level_order_traversal();
				break;
			case 4:
				System.out.println("Enter the element to be deleted");
				key = sc.nextInt();
				bst.delete(key);
			case 5:
				bst.level_order_traversal();
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
