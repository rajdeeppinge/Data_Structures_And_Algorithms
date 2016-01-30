package q1;

import java.util.LinkedList;

public class BinarySearchTree {
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void in_order_recursive(Node currRoot) {
		if(currRoot == null) 
			return;
		
		in_order_recursive(currRoot.getLeftChild());
		System.out.print(currRoot.getKey() + " ");
		in_order_recursive(currRoot.getRightChild());
	}
	
	public void post_order_recursive(Node currRoot) {
		if(currRoot == null) 
			return;
		
		post_order_recursive(currRoot.getLeftChild());
		post_order_recursive(currRoot.getRightChild());
		System.out.print(currRoot.getKey() + " ");
	}
	
	public void pre_order_recursive(Node currRoot) {
		if(currRoot == null) 
			return;
		
		System.out.print(currRoot.getKey() + " ");
		pre_order_recursive(currRoot.getLeftChild());
		pre_order_recursive(currRoot.getRightChild());
	}
	
	public void in_order_iterative(Node currRoot) {
		currRoot = findMin(currRoot);
		while(currRoot != null) {
			System.out.print(currRoot.getKey() + " ");
			currRoot = successor(currRoot.getKey());
		}
		System.out.println();
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
	
	public void zig_zag_traversal() {
		Node curr = root;
		
		LinkedList<Node> stOdd = new LinkedList<Node>();
		LinkedList<Node> stEven = new LinkedList<Node>();
		
		LinkedList<Node> currStack = stEven;
		LinkedList<Node> otherStack = stOdd;
		
		stEven.addFirst(curr);
		
		while(!stEven.isEmpty() || !stOdd.isEmpty()) {
			if(currStack == stEven) {
				curr = currStack.removeFirst();
				if(curr.getLeftChild() != null)
					otherStack.addFirst(curr.getLeftChild());
				if(curr.getRightChild() != null)
					otherStack.addFirst(curr.getRightChild());
			}
			else {
				curr = currStack.removeFirst();
				if(curr.getRightChild() != null)
					otherStack.addFirst(curr.getRightChild());
				if(curr.getLeftChild() != null)
					otherStack.addFirst(curr.getLeftChild());
			}
			
			System.out.print(curr.getKey() + " ");
			
			if(currStack.isEmpty()) {
				LinkedList<Node> temp = currStack;
				currStack = otherStack;
				otherStack = temp;
			}
		}
		System.out.println();
	}
	
	public void pre_order_iterative() {
		Node curr = root;
		int state = 1;
		
		while(curr != null) {
			switch(state) {
				//state 1 indicates no child has been traversed so go left
				//state 2 indicates left child has been traversed so go right
				//state 3 indicates both childeren have been traversed so go above to the parent
				case 1:
					System.out.print(curr.getKey() + " ");
					if(curr.getLeftChild() != null) {
						curr = curr.getLeftChild();
					}
					else if(curr.getRightChild() != null) {
						curr = curr.getRightChild();
					}
					else {
						if(curr == curr.getParent().getLeftChild())
							state = 2;
						else
							state = 3;
						curr = curr.getParent();
					}
					break;
				case 2:
					if(curr.getRightChild() != null) {
						state = 1;
						curr = curr.getRightChild();
					}
					else {
						if(curr == curr.getParent().getLeftChild())
							state = 2;
						else
							state = 3;
						curr = curr.getParent();
					}
					break;
				case 3:
					if(curr.getParent() != null && curr == curr.getParent().getRightChild())
						state = 3;
					else
						state = 2;
					curr = curr.getParent();
					break;
			}
		}
	}
	
	public void post_order_iterative() {
		Node curr = root;
		int state = 1;
		
		while(curr != null) {
			switch(state) {
			case 1:				
				if(curr.getLeftChild() != null) {
					curr = curr.getLeftChild();
				}
				else if(curr.getRightChild() != null) {
					curr = curr.getRightChild();
				}
				else {
					System.out.print(curr.getKey() + " ");
					if(curr == curr.getParent().getLeftChild())
						state = 2;
					else
						state = 3;
					curr = curr.getParent();
				}
				break;
			case 2:
				if(curr.getRightChild() != null) {
					state = 1;
					curr = curr.getRightChild();
				}
				else {
					System.out.print(curr.getKey() + " ");
					if(curr == curr.getParent().getLeftChild())
						state = 2;
					else
						state = 3;
					curr = curr.getParent();
				}
				break;
			case 3:
				System.out.print(curr.getKey() + " ");
				if(curr.getParent() != null && curr == curr.getParent().getRightChild())
					state = 3;
				else
					state = 2;
				curr = curr.getParent();
				break;
			}
		}
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
			return null;
		}
		
		else {
			while(curr.getParent().getRightChild() == curr) {
				curr = curr.getParent();
			}

			return curr.getParent();
		}
	}
}