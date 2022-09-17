package advancedQ1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		boolean process = true;
		
		do {
			System.out.println("press\n1: Insert an element\n"
							+ 	"2: Left Rotate at a node and recompute average depth\n"
							+	"3: Delete an element\n"
							+	"4: Print BST\n"
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
				
				bst.depth_of_node(bst.getRoot(), 0);
				
				double oldAvg = bst.computeTotalDepth() / (double) bst.size_of_subtree(bst.getRoot().getKey());
				bst.left_rotate(key);
				
				bst.depth_of_node(bst.getRoot(), 0);
				
				double newAvg = bst.computeTotalDepth() / (double) bst.size_of_subtree(bst.getRoot().getKey());
								
				System.out.println("Original Average Depth = " + oldAvg);
				System.out.println("New Average Depth = " + newAvg);
				System.out.println("Difference in average depth = " + (newAvg-oldAvg));
				
				bst.level_order_traversal();
				break;
			case 3:
				System.out.println("Enter the element to be deleted");
				key = sc.nextInt();
				bst.delete(key);
				bst.depth_of_node(bst.getRoot(), 0);
			case 4:
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
