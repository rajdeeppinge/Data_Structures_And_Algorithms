package advancedQ7;

import java.util.LinkedList;

public class BinarySearchTree_Modified {
	private Node root;
	
	public BinarySearchTree_Modified() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}

	//interface method
	public void insert(int key) {
		Node newNode = new Node(key);
		boolean evenLevel = true;
		
		if(root == null) {
			root = newNode;
		}
		else {
			insert(newNode, root, evenLevel);
		}
	}
	
	//encapsulated/private working method
	private void insert(Node newNode, Node currRoot, boolean evenLevel) {
		if(evenLevel) {
			if(newNode.getKey() <= currRoot.getKey()) {
				if(currRoot.getLeftChild() != null) {
					insert(newNode, currRoot.getLeftChild(), false);
				}
				else {
					currRoot.setLeftChild(newNode);
					newNode.setParent(currRoot);
				}
			}
			
			else {
				if(currRoot.getRightChild() != null) {
					insert(newNode, currRoot.getRightChild(), false);
				}
				else {
					currRoot.setRightChild(newNode);
					newNode.setParent(currRoot);
				}
			}
		}
		
		else {
			if(newNode.getKey() > currRoot.getKey()) {
				if(currRoot.getLeftChild() != null) {
					insert(newNode, currRoot.getLeftChild(), true);
				}
				else {
					currRoot.setLeftChild(newNode);
					newNode.setParent(currRoot);
				}
			}
			
			else {
				if(currRoot.getRightChild() != null) {
					insert(newNode, currRoot.getRightChild(), true);
				}
				else {
					currRoot.setRightChild(newNode);
					newNode.setParent(currRoot);
				}
			}
		}
	}
	
	//interface method
	public String search_for_path(int key, String path) {
		return search_for_path(key, root, path, true);
	}
	
	//encapsulated/private working method
	private String search_for_path(int key, Node currRoot, String path, boolean evenLevel) {
		if(evenLevel) {
			if(currRoot.getKey() == key) {
				return path;
			}
			else if(key < currRoot.getKey() && currRoot.getLeftChild() != null) {
				path += '0';
				return search_for_path(key, currRoot.getLeftChild(), path, false); 
			}
			else if(key > currRoot.getKey() && currRoot.getRightChild() != null){
				path += '1';
				return search_for_path(key, currRoot.getRightChild(), path, false);
			}
			else {
				System.out.println("Element is not present in the tree");
				return null;
			}
		}
		
		else {
			if(currRoot.getKey() == key) {
				return path;
			}
			else if(key < currRoot.getKey() && currRoot.getRightChild() != null) {
				path += '1';
				return search_for_path(key, currRoot.getRightChild(), path, true); 
			}
			else if(key > currRoot.getKey() && currRoot.getLeftChild() != null){
				path += '0';
				return search_for_path(key, currRoot.getLeftChild(), path, true);
			}
			else {
				System.out.println("Element is not present in the tree");
				return null;
			}
		}
	}
	
	//interface method
	public Node search(int key) {
		return search(key, root, true);
	}
	
	//encapsulated working method
	private Node search(int key, Node currRoot, boolean evenLevel) {
		if(evenLevel) {
			if(currRoot.getKey() == key) {
				return currRoot;
			}
			else if(key < currRoot.getKey() && currRoot.getLeftChild() != null) {
				return search(key, currRoot.getLeftChild(), false);
			}
			else if(key > currRoot.getKey() && currRoot.getRightChild() != null) {
				return search(key, currRoot.getRightChild(), false);
			}
			else {
				System.out.println("Element is not present in the tree");
				return null;
			}
		}
		
		else {
			if(currRoot.getKey() == key) {
				return currRoot;
			}
			else if(key < currRoot.getKey() && currRoot.getRightChild() != null) {
				return search(key, currRoot.getRightChild(), true);
			}
			else if(key > currRoot.getKey() && currRoot.getLeftChild() != null) {
				return search(key, currRoot.getLeftChild(), true);
			}
			else {
				System.out.println("Element is not present in the tree");
				return null;
			}
		}
	}
	
	public Node findMax(Node currRoot, boolean evenLevel) {
		Node curr = currRoot;
		
		while((evenLevel && curr.getRightChild() != null) || (!evenLevel && curr.getLeftChild() != null)) {
			if(evenLevel) {
				curr = curr.getRightChild();
				evenLevel = false;
			}
			else {
				curr = curr.getLeftChild();
				evenLevel = true;
			}
		}
		return curr;
	}
	
	public Node findMin(Node currRoot, boolean evenLevel) {
		Node curr = currRoot;
		
		while((evenLevel && curr.getLeftChild() != null) || (!evenLevel && curr.getRightChild() != null)) {
			if(evenLevel) {
				curr = curr.getLeftChild();
				evenLevel = false;
			}
			else {
				curr = curr.getRightChild();
				evenLevel = true;
			}
		}
		return curr;
	}
	
	public Node successor(int key) {		
		Node curr = search(key);
		
		if(curr.getRightChild() != null && curr.getRightChild().getKey() > curr.getKey()) {
			return findMin(curr.getRightChild(), false);
		}
		else if(curr.getLeftChild() != null && curr.getLeftChild().getKey() > curr.getKey()) {
			return findMin(curr.getLeftChild(), true);
		}
		
		else if(curr == findMax(root, true)) {
			System.out.println("this element is the maximum in the tree and hence does not have a successor");
			return null;
		}
		
		else {
			boolean evenLevel;
			
			if(curr.getParent().getRightChild() == curr && curr.getParent().getKey() < curr.getKey()  
					|| curr.getParent().getLeftChild() == curr && curr.getParent().getKey() > curr.getKey()) {
				evenLevel = true;
			}
			else {
				evenLevel = false;
			}
			
			while( (evenLevel && curr.getParent().getRightChild() == curr) || (!evenLevel && curr.getParent().getLeftChild() == curr) ) {
				curr = curr.getParent();
				if(evenLevel) {
					evenLevel = false;
				}
				else {
					evenLevel = true;
				}
			}
			return curr.getParent();
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
}
