package q1;

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
			System.out.println("press\n1: Insert\n"
							+	"2: In order traversal\n"
							+	"3: Pre order traversal\n"
							+	"4: Post order traversal\n"
							+	"5: Level order traversal\n"
							+	"6: Zig-zag traversal\n"
							+	"7: In order iterative\n"
							+	"8: Pre order iterative\n"
							+	"9: Post order iterative\n"
							+	"0: Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("Enter element to be inserted");
				int key = sc.nextInt();
				bst.insert(key);
				break;
			case 2:
				bst.in_order_recursive(bst.getRoot());
				System.out.println();
				break;
			case 3:
				bst.pre_order_recursive(bst.getRoot());
				System.out.println();
				break;
			case 4:
				bst.post_order_recursive(bst.getRoot());
				System.out.println();
				break;
			case 5:
				bst.level_order_traversal();
				break;
			case 6:
				bst.zig_zag_traversal();
				break;
			case 7:
				bst.in_order_iterative(bst.getRoot());
				break;
			case 8:
				bst.pre_order_iterative();
				System.out.println();
				break;
			case 9:
				bst.post_order_iterative();
				System.out.println();
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
