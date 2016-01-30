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
	
	public void rank(Node curr) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		if(curr != null) {
			queue.addLast(curr);
		}
		
		while(!queue.isEmpty()) {
			curr = queue.removeFirst();
			
			curr.setRank(curr.getBaseRank() + local_rank(curr) - 1);
			
			if(curr.getLeftChild() != null) {
				queue.addLast(curr.getLeftChild());
			}
			if(curr.getRightChild() != null) {
				queue.addLast(curr.getRightChild());
			}
		}
	}
	
	public int local_rank(Node currRoot) {
		if(currRoot.getLeftChild() != null) {
			return currRoot.getLeftChild().getSizeOfSubtree() + 1;
		}
		
		return 1;
	}
	
	public void base_rank(Node currRoot) {
		if(currRoot.getParent() == null) {
			currRoot.setBaseRank(1);
		}
		
		if(currRoot.getLeftChild() != null) {
			currRoot.getLeftChild().setBaseRank(currRoot.getBaseRank());
			base_rank(currRoot.getLeftChild());
		}
		
		if(currRoot.getRightChild() != null) {
			currRoot.getRightChild().setBaseRank(local_rank(currRoot) + currRoot.getBaseRank());
			base_rank(currRoot.getRightChild());
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
	
	public Node valid_subtree(int i, int j, Node currRoot) {
		if(currRoot.getRank() > j) {
			return valid_subtree(i, j, currRoot.getLeftChild());
		}
		else if(currRoot.getRank() < i) {
			return valid_subtree(i, j, currRoot.getRightChild());
		}
		else if(findMax(currRoot).getRank() == j && findMin(currRoot).getRank() == i) {
			return currRoot;
		}
		else {
			return null;
		}
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
	
	public void pre_order_recursive(Node currRoot) {
		if(currRoot == null) 
			return;
		
		System.out.print(currRoot.getKey() + " ");
		pre_order_recursive(currRoot.getLeftChild());
		pre_order_recursive(currRoot.getRightChild());
	}
}
