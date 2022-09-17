package advancedQ2;

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
		int size = 0;
		
		if(currNode.getLeftChild() == null && currNode.getRightChild() == null) {
			currNode.setSizeOfSubtreeMinusOne(size);
			return size;
		}
		
		if(currNode.getLeftChild() != null) {
			size = size_of_subtree(currNode.getLeftChild()) + 1;
			currNode.setSizeOfSubtreeMinusOne(size);
		}
		
		if(currNode.getRightChild() != null) {
			size = size_of_subtree(currNode.getRightChild()) + 1;
			currNode.setSizeOfSubtreeMinusOne(currNode.getSizeOfSubtreeMinusOne() + size);
		}
		
		return size;
	}
	
	public void level_order_traversal() {
		LinkedList<Node> queue = new LinkedList<Node>();
		Node curr = root;
		
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
	
	public int total_inversions() {
		LinkedList<Node> queue = new LinkedList<Node>();
		Node curr = root;
		int level = 0;
		curr.setLevelNo(level);
		
		int sizeOfPrevNodes = 0;
		int sizeOfLeftSubtree = 0;
		int noOfInversions = 0;
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();		
			
			if(curr.getLevelNo() != level) {
				level++;
				sizeOfPrevNodes = 0;
			}
			
			if(curr.getLeftChild() != null) {
				sizeOfLeftSubtree = curr.getLeftChild().getSizeOfSubtreeMinusOne() + 1;
				curr.getLeftChild().setLevelNo(level + 1);
				queue.addLast(curr.getLeftChild());
			}
			else {
				sizeOfLeftSubtree = 0;
			}
			
			if(curr.getRightChild() != null) {
				curr.getRightChild().setLevelNo(level + 1);
				queue.addLast(curr.getRightChild());
			}
			
			noOfInversions += sizeOfLeftSubtree + sizeOfPrevNodes;
			
			System.out.print((sizeOfLeftSubtree + sizeOfPrevNodes) + " ");
			
			sizeOfPrevNodes += curr.getSizeOfSubtreeMinusOne();
		}
		
		System.out.println();

		return noOfInversions;
	}
}
