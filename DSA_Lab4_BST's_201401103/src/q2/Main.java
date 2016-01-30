package q2;

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
			System.out.println("press\n1: To insert a node in BST\n"
							+	"2: To find height of node\n"
							+	"3: To find depth of node\n"
							+	"4: To find size of subtree\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				break;
			case 2:
				System.out.println("Enter node to find height of node");
				System.out.println("Height of node is " + bst.height_of_node(sc.nextInt()));
				break;
			case 3:
				System.out.println("Enter node to find depth");
				
				int depth = bst.depth_of_node(sc.nextInt());
				
				if(depth != Integer.MIN_VALUE) {
					System.out.println("Depth odf node is " + depth);
				}
				break;
			case 4:
				System.out.println("Enter node to find size of subtree");
				System.out.println("Size of subtree is " + bst.size_of_subtree(sc.nextInt()));
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
