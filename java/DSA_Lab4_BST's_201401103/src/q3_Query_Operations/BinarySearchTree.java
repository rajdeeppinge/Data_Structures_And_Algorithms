package q3_Query_Operations;

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
	public String search_for_path(int key, String path) {
		return search_for_path(key, root, path);
	}
	
	//encapsulated/private working method
	private String search_for_path(int key, Node currRoot, String path) {
		if(currRoot.getKey() == key) {
			return path;
		}
		else if(key < currRoot.getKey() && currRoot.getLeftChild() != null) {
			path += '0';
			return search_for_path(key, currRoot.getLeftChild(), path); 
		}
		else if(key > currRoot.getKey() && currRoot.getRightChild() != null){
			path += '1';
			return search_for_path(key, currRoot.getRightChild(), path);
		}
		else {
			System.out.println("Element is not present in the tree");
			return null;
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
	
	public Node predecessor(int key) {		
		Node curr = search(key);
		
		if(curr.getLeftChild() != null) {
			return findMax(curr.getLeftChild());
		}
		
		else if(curr == findMin(root)) {
			System.out.println("this element is the minimum in the tree and hence does not have a predecessor");
			return null;
		}
		
		else {
			while(curr.getParent().getLeftChild() == curr) {
				curr = curr.getParent();
			}
			return curr.getParent();
		}
	}
}
