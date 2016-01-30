package q3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		boolean process = true;
		
		do {
			System.out.println("press\n1: Insert an element\n"
							+	"2: Delete an element\n"
							+	"3: Print BST\n"
							+	"4: Reduce imbalance of a node\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				bst.height_of_node();
				bst.set_balance_of_all_nodes();
				break;
			case 2:
				System.out.println("Enter the element to be deleted");
				key = sc.nextInt();
				bst.delete(key);
				bst.height_of_node();
				bst.set_balance_of_all_nodes();
			case 3:
				System.out.println("BST in level order");
				bst.level_order_traversal();
				break;
			case 4:
				Node temp = bst.find_imbalanced_node();
				
				if(temp.getBalance() < -1) {
					bst.right_rotate(temp);
				}
				else if(temp.getBalance() > 1) {
					bst.left_rotate(temp);
				}
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
