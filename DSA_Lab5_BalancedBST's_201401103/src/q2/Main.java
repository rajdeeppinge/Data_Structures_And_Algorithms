package q2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BalancedBST bst = new BalancedBST();
		
		boolean process = true;
		
		do {
			System.out.println("press\n1: Insert an element\n"
							+	"2: Delete an element\n"
							+	"3: Print BST\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				break;
			case 2:
				System.out.println("Enter the element to be deleted");
				key = sc.nextInt();
				bst.delete(key);
			case 3:
				System.out.println("Balanced BST in level order");
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
