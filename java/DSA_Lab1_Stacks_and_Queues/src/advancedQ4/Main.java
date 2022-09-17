package advancedQ4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter total no of nodes that are there in the tree");
		int totalNodes = sc.nextInt();
		
		System.out.println("Enter the all the edges in the format: 'parent child', where both parent and child are integers, in the order from top to bottom");
		int root = -100;
		int[][] adjMatrix = new int[totalNodes][totalNodes];
		for(int i = 0; i < totalNodes-1; i++) {
			int parent = sc.nextInt();
			if(i == 0) {	//storing the root so that we don't have to find it again
				root = parent;
			}
			int child = sc.nextInt();
			adjMatrix[parent-1][child-1] = 1;
		}
		
		BinaryTree bt = new BinaryTree(totalNodes);
		bt.generateFromArbitraryRootedTree(adjMatrix, root);
		
		System.out.println("Generated Binary Tree");
		bt.print();
		
		//converting back to arbitrary rooted tree from binary tree
		
		int[][] tempMatrix = bt.convertToArbitraryRootedTree();
		
		System.out.println("Reversing back to adjacency matrix of arbitrary rooted tree");
		
		for(int i = 0; i <= totalNodes; i++) {
			for(int j = 0; j <= totalNodes; j++) {
				if(j == 0) {
					System.out.print(i + "|");
				}
				else if(i == 0 && j != 0) {
					System.out.print(j + "_");
				}
				else
					System.out.print(tempMatrix[i-1][j-1] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
