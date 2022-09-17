package advancedQ3;

import java.util.LinkedList;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}

	//interface method
	public void insert(int key) {
		Node newNode = new Node(key);
		
		if(root == null) {
			root = newNode;
		}
		else {
			insert(newNode, root);
		}
	}
	
	//encapsulated/private working method
	private void insert(Node newNode, Node currRoot) {
		if(newNode.getKey() <= currRoot.getKey()) {
			if(currRoot.getLeftChild() != null) {
				insert(newNode, currRoot.getLeftChild());
			}
			else {
				currRoot.setLeftChild(newNode);
				newNode.setParent(currRoot);
			}
		}
		
		else {
			if(currRoot.getRightChild() != null) {
				insert(newNode, currRoot.getRightChild());
			}
			else {
				currRoot.setRightChild(newNode);
				newNode.setParent(currRoot);
			}
		}
	}
	
	//interface method
	public Node search(int key) {
		return search(key, root);
	}
	
	//encapsulated working method
	private Node search(int key, Node currRoot) {
		if(currRoot.getKey() == key) {
			return currRoot;
		}
		else if(key < currRoot.getKey() && currRoot.getLeftChild() != null) {
			return search(key, currRoot.getLeftChild());
		}
		else if(key > currRoot.getKey() && currRoot.getRightChild() != null) {
			return search(key, currRoot.getRightChild());
		}
		else {
			System.out.println("Element is not present in the tree");
			return null;
		}
	}
	
	public void size_of_subtree() {	
		Node curr = root;
		
		size_of_subtree(curr);
	}
	
	private int size_of_subtree(Node currNode) {
		int size = 1;
		
		if(currNode.getLeftChild() == null && currNode.getRightChild() == null) {
			currNode.setSizeOfSubtree(size);
			return size;
		}
		
		if(currNode.getLeftChild() != null) {
			size = size_of_subtree(currNode.getLeftChild());
			currNode.setSizeOfSubtree(size);
		}
		
		if(currNode.getRightChild() != null) {
			size = size_of_subtree(currNode.getRightChild());
			currNode.setSizeOfSubtree(currNode.getSizeOfSubtree() + size);
		}
		
		currNode.setSizeOfSubtree(currNode.getSizeOfSubtree() + 1);
		
		return currNode.getSizeOfSubtree();
	}
	
	public void level_order_traversal(Node curr) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();
			if(curr.getLeftChild() != null) {
				queue.addLast(curr.getLeftChild());
			}
			if(curr.getRightChild() != null) {
				queue.addLast(curr.getRightChild());
			}
			System.out.print(curr.getKey() + " ");
		}
		System.out.println();
	}
	
	public Node split_tree(int k) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		Node curr = root;
		int size = size_of_subtree(curr);
		
		int minDist = Integer.MAX_VALUE;
		Node min = null;	
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();
			
			if(Math.abs(curr.getSizeOfSubtree() - size/k) < minDist) {
				min = curr;
				minDist = Math.abs(curr.getSizeOfSubtree() - size/k);
			}
			
			if(curr.getLeftChild() != null) {
				queue.addLast(curr.getLeftChild());
			}
			if(curr.getRightChild() != null) {
				queue.addLast(curr.getRightChild());
			}
		}
		
		if(min == min.getParent().getLeftChild()) {
			min.getParent().setLeftChild(null);
		}
		else {
			min.getParent().setRightChild(null);
		}
		
		min.setParent(null);
		
		return min;
	}
}