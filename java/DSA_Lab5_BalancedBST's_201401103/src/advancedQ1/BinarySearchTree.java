package advancedQ1;

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
	
	public Node findMax(Node currRoot) {
		Node curr = currRoot;
		while(curr.getRightChild() != null) {
			curr = curr.getRightChild();
		}
		return curr;
	}
	
	public Node findMin(Node currRoot) {
		Node curr = currRoot;
		while(curr.getLeftChild() != null) {
			curr = curr.getLeftChild();
		}
		return curr;
	}
	
	public Node successor(int key) {		
		Node curr = search(key);
		
		if(curr.getRightChild() != null) {
			return findMin(curr.getRightChild());
		}
		else if(curr == findMax(root)) {
			System.out.println("this element is the maximum in the tree and hence does not have a successor");
			return null;
		}
		
		else {
			while(curr.getParent().getRightChild() == curr) {
				curr = curr.getParent();
			}

			return curr.getParent();
		}
	}
	
	public void transplant(Node curr, Node replace) {
		if(curr.getParent() == null)
			root = replace;
		else if(curr == curr.getParent().getLeftChild()){
			curr.getParent().setLeftChild(replace);
		}
		else {
			curr.getParent().setRightChild(replace);
		}
		if(replace != null)
			replace.setParent(curr.getParent());
	}
	
	public void delete(int key) {
		Node curr = search(key);
		
		if(curr != null) {
			if(curr.getLeftChild() == null && curr.getRightChild() == null) {
				if(curr.getParent().getLeftChild() == curr)
					curr.getParent().setLeftChild(null);
				else
					curr.getParent().setRightChild(null);
			}
			
			else if(curr.getLeftChild() == null) {
				transplant(curr, curr.getRightChild());
			}
			
			else if(curr.getRightChild() == null) {
				transplant(curr, curr.getLeftChild());
			}
			
			else {
				Node successor = successor(curr.getKey());
				//since we have already handled the case of node to be deleted being leaf, the successor that we get know will be the minimum of right subtree and hence won't have any left child
				if(successor.getParent() != curr) {
					transplant(successor, successor.getRightChild());	//since successor doesn't have left child, we delete it and replace it by its right child
					successor.setRightChild(curr.getRightChild());
					successor.getRightChild().setParent(successor);
				}
				transplant(curr, successor);
				successor.setLeftChild(curr.getLeftChild());
				successor.getLeftChild().setParent(successor);
			}
		}
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
	
	public void left_rotate(int key) {
		Node curr = search(key);
		
		if(curr.getRightChild() == null) {
			System.out.println("Cannot rotate left since right child is not present");
			return;
		}
		
		Node rotateWith = curr.getRightChild();
		rotateWith.setParent(curr.getParent());
		
		if(curr.getParent() != null) {
			Node currParent = curr.getParent();
			if(curr == currParent.getLeftChild())
				currParent.setLeftChild(rotateWith);
			else
				currParent.setRightChild(rotateWith);
		}
		else {
			root = rotateWith;
		}
		
		curr.setRightChild(rotateWith.getLeftChild());
		
		if(rotateWith.getLeftChild() != null)
			rotateWith.getLeftChild().setParent(curr);
		
		rotateWith.setLeftChild(curr);
		curr.setParent(rotateWith);
	}
	
	public void right_rotate(int key) {
		Node curr = search(key);
		
		if(curr.getLeftChild() == null) {
			System.out.println("Cannot rotate right since left child is not present");
			return;
		}
		
		Node rotateWith = curr.getLeftChild();
		rotateWith.setParent(curr.getParent());
		
		if(curr.getParent() != null) {
			Node currParent = curr.getParent();
			if(curr == currParent.getLeftChild())
				currParent.setLeftChild(rotateWith);
			else
				currParent.setRightChild(rotateWith);
		}
		else {
			root = rotateWith;
		}
		
		curr.setLeftChild(rotateWith.getRightChild());
		
		if(rotateWith.getRightChild() != null)
			rotateWith.getRightChild().setParent(curr);
		
		rotateWith.setRightChild(curr);
		curr.setParent(rotateWith);
	}
	
	public void depth_of_node(Node currRoot, int depth) {		
		currRoot.setDepth(depth);
		depth++;
		
		if(currRoot.getLeftChild() != null) {
			depth_of_node(currRoot.getLeftChild(), depth);
		}
		
		if(currRoot.getRightChild() != null) {
			depth_of_node(currRoot.getRightChild(), depth);
		}
	}
	
	public int size_of_subtree(int key) {	
		Node curr = search(key);
		
		int size = 1;
		
		if(curr != null)
			return size_of_subtree(curr, size);
		
		return -1;
	}
	
	private int size_of_subtree(Node currNode, int size) {
		if(currNode.getLeftChild() == null && currNode.getRightChild() == null) {
			return size;
		}
		
		if(currNode.getLeftChild() != null) {
			size++;
			size = size_of_subtree(currNode.getLeftChild(), size);
		}
		
		if(currNode.getRightChild() != null) {
			size++;
			size = size_of_subtree(currNode.getRightChild(), size);
		}
		
		return size;
	}
	
	public int computeTotalDepth() {
		LinkedList<Node> queue = new LinkedList<Node>();
		Node curr = root;
		int totalDepth = 0;
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();
			totalDepth += curr.getDepth();
			
			if(curr.getLeftChild() != null) {
				queue.addLast(curr.getLeftChild());
			}
			if(curr.getRightChild() != null) {
				queue.addLast(curr.getRightChild());
			}
		}
		return totalDepth;
	}
}