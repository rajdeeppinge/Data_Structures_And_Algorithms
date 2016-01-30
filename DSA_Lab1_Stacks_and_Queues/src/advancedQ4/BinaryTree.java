package advancedQ4;

import Q2.queueUsingLinkedList.Queue;

public class BinaryTree {
	public Node<Integer> head, curr;
	private int totalNodes;
	
	public BinaryTree(int totalNodes) {
		head = curr = null;
		this.totalNodes = totalNodes;
	}
	
	public void generateFromArbitraryRootedTree(int[][] adjMatrix, int root) {
		Queue<Node<Integer>> nodeQueue = new Queue<Node<Integer>>();
		
		Node<Integer> newNode = new Node<Integer>(root);
		head = newNode;
		nodeQueue.enqueue(head);
		
		while(!nodeQueue.isEmpty()) {
			curr = nodeQueue.dequeue();
			Node<Integer> temp = null;
		
			for(int col = 0; col < totalNodes; col++) {
				if(adjMatrix[curr.getKey()-1][col] != 0) {
					newNode = new Node<Integer>(col+1);

					if(curr.getLeftChild() == null) {
						curr.setLeftChild(newNode);
						temp = curr.getLeftChild();
					}
					else {
						temp.setRightChild(newNode);
						temp = temp.getRightChild();
					}
					nodeQueue.enqueue(temp);
				}
			}
		}
	}
	
	public int[][] convertToArbitraryRootedTree() {
		int[][] adjMatrix = new int[totalNodes][totalNodes];
		Queue<Node<Integer>> nodeQueue = new Queue<Node<Integer>>();
		nodeQueue.enqueue(head);
		
		while(!nodeQueue.isEmpty()) {
			curr = nodeQueue.dequeue();
			Node<Integer> temp = null;

			if(curr.getLeftChild() != null) {
				temp = curr.getLeftChild();
				adjMatrix[curr.getKey()-1][temp.getKey()-1] = 1;
				nodeQueue.enqueue(temp);
			}
			
			while(temp != null && temp.getRightChild() != null) {
				temp = temp.getRightChild();
				adjMatrix[curr.getKey()-1][temp.getKey()-1] = 1;
				nodeQueue.enqueue(temp);
			}		
		}
		
		return adjMatrix;
	}
	
	public void print() {
		int[] count = new int[totalNodes];	//needed to print the tree appropriately
		int countIndex = 0;
		
		Queue<Node<Integer>> nodeQueue = new Queue<Node<Integer>>();
		nodeQueue.enqueue(head);
		System.out.println(head.getKey());
		count[countIndex] = 1;
		
		while(!nodeQueue.isEmpty()) {
			curr = nodeQueue.dequeue();
			count[countIndex]--;

			if(curr.getLeftChild() != null) {
				System.out.print("L " + curr.getLeftChild().getKey() + " ");
				nodeQueue.enqueue(curr.getLeftChild());
				count[countIndex+1]++;
			}
			
			if(curr.getRightChild() != null) {
				System.out.print("R " + curr.getRightChild().getKey() + " ");
				nodeQueue.enqueue(curr.getRightChild());
				count[countIndex+1]++;
			}
			
			System.out.print("| ");
			
			if(curr.getLeftChild() != null || curr.getRightChild() != null) {
				if(count[countIndex] <= 0) {
					countIndex++;
					System.out.println();
				}
			}
		}

		System.out.println();
	}
}
