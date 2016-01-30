package advancedQ2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		TreapTree treap = new TreapTree();
		
		System.out.println("Enter size of treap");
		int size = sc.nextInt();
		
		System.out.println("Enter elements in the following form: (key, priority)");
		for(int i = 0; i < size; i++) {
			int key = sc.nextInt();
			int priority = sc.nextInt();
			Node newNode = new Node(priority, key);
			treap.add(newNode);
		}
		
		System.out.println("Treap in In-order form");
		treap.printTree(treap.getRoot());
		
		sc.close();
	}

}
