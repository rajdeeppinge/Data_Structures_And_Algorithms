package q3_Query_Operations;

import java.util.Scanner;

public class Main_with_Query_Operations {

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
			System.out.println("press\n1: To search for an element in BST\n"
							+	"2: To find maximum element in the BST\n"
							+	"3: To find minimum element in the BST\n"
							+	"4: To find successor of an element\n"
							+	"5: To find predecessor of an element\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be searched");
				int key = sc.nextInt();
				
				Node search = bst.search(key);
				
				if(search != null) {	
					System.out.println("Node with entered key exists");
					String path = "e";
					
					path = bst.search_for_path(key, path);
					
					if(path != null) {
						System.out.println("The path to node is in {e, 0, 1} form where e: root node, 0: go to the left, 1: go to the right");
						System.out.println(path);
					}
				}
				break;
			case 2:
				System.out.println("The maximum element is " + bst.findMax(bst.getRoot()).getKey());
				break;
			case 3:
				System.out.println("The minimum element is " + bst.findMin(bst.getRoot()).getKey());
				break;
			case 4:
				System.out.println("Enter element to find successor");
				Node successor = bst.successor(sc.nextInt());
				if(successor != null)
					System.out.println("The successor is " + successor);
				break;
			case 5:
				System.out.println("Enter element to find predecessor");
				Node predecessor = bst.predecessor(sc.nextInt());
				if(predecessor != null)
					System.out.println("The predecessor is " + predecessor);
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
