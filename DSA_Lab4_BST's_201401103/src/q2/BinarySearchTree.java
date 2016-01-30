package q2;

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
	
	public int height_of_node(int key) {
		Node curr = search(key);
		
		if(curr != null) {
			return height_of_node(curr);
		}
		
		return -1;
	}
	
	private int height_of_node(Node currNode) {
		if(currNode == null) {
			return -1;
		}
		
		return 1 + Math.max( height_of_node(currNode.getLeftChild()), height_of_node(currNode.getRightChild()) );
	}
	
	public int depth_of_node(int key) {
		String path = "e";
		path = search_for_path(key, path);
		if(path != null) {
			int depth = path.length()-1;
			return depth;
		}
		else {
			System.out.println("The node is not in the tree");
		
			return Integer.MIN_VALUE;
		}
	}
	
	public int size_of_subtree(int key) {	
		Node curr = search(key);
		
		int size = 1;
		
		return size_of_subtree(curr, size);
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
}
