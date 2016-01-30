package advancedQ1;

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
		
		boolean process = true;
		
		do {
			System.out.println("press\n1: To find height of node\n"
							+	"2: To find depth of node\n"
							+	"3: To find size of subtree\n"
							+	"4: To find rank of an element\n"
							+	"5: To find if subtree with given ranks exists\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter node to find height of node");
				System.out.println("Height of node is " + bst.height_of_node(sc.nextInt()));
				break;
			case 2:
				System.out.println("Enter node to find depth");
				
				int depth = bst.depth_of_node(sc.nextInt());
				
				if(depth != Integer.MIN_VALUE) {
					System.out.println("Depth odf node is " + depth);
				}
				break;
			case 3:
				System.out.println("Enter node to find size of subtree");
				Node temp = bst.search(sc.nextInt());
				System.out.println("Size of subtree is " + temp.getSizeOfSubtree());
				break;
			case 4:
				System.out.println("Enter node to find its rank");
				temp = bst.search(sc.nextInt());
				System.out.println("Rank of node is " + temp.getRank());
				break;
			case 5:
				System.out.println("Enter start and end rank");
				int i = sc.nextInt();
				int j = sc.nextInt();
				temp = bst.valid_subtree(i, j, bst.getRoot());
				if(temp != null) {
					System.out.println("It is a valid subtree");
					bst.level_order_traversal(temp);
					bst.pre_order_recursive(temp);
				}
				else {
					System.out.println("It is not a valid subtree");
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
