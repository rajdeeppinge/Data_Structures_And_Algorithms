package q2;

import java.util.LinkedList;

public class BalancedBST {
	private Node root;
	
	public BalancedBST() {
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
			insert_restore_AVL_prop(newNode);
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
	
	public void insert_restore_AVL_prop(Node curr) {
		curr.setHeight(-1);
		curr.setBalance(0);
		
		while(curr != null && curr.getBalance() == 0) {
			curr.setHeight(curr.getHeight() + 1);
			
			computeBalance(curr);
			
			curr = curr.getParent();
		}
		
		if(curr != null) {
			computeBalance(curr);
			
			if(curr.getBalance() == -2) {
				if(curr.getLeftChild().getBalance() == 1) {

					left_rotate(curr.getLeftChild());
					height_of_node(curr.getLeftChild());
					computeBalance(curr.getLeftChild());
					computeBalance(curr.getLeftChild().getLeftChild());
				}
				
				right_rotate(curr);
				height_of_node(curr.getParent());
				computeBalance(curr);
				computeBalance(curr.getParent());
			}
			
			else if(curr.getBalance() == 2) {
				if(curr.getRightChild().getBalance() == -1) {
					
					right_rotate(curr.getRightChild());
					height_of_node(curr.getRightChild());
					computeBalance(curr.getRightChild());
					computeBalance(curr.getRightChild().getRightChild());
				}
				
				left_rotate(curr);
				height_of_node(curr.getParent());
				computeBalance(curr);
				computeBalance(curr.getParent());
			}
		}
	}
	
	private void computeBalance(Node curr) { 
		int leftHeight = -1, rightHeight = -1;
		if(curr.getLeftChild() != null) {
			leftHeight = curr.getLeftChild().getHeight();
		}	
		if(curr.getRightChild() != null) {
			rightHeight = curr.getRightChild().getHeight();
		}
		curr.setBalance(rightHeight - leftHeight);
	}
	
	public int height_of_node() {
		Node curr = root;
		
		if(curr != null) {
			return height_of_node(curr);
		}
		
		return -1;
	}
	
	private int height_of_node(Node currNode) {
		if(currNode == null) {
			return -1;
		}
		
		currNode.setHeight(1 + Math.max( height_of_node(currNode.getLeftChild()), height_of_node(currNode.getRightChild()) ));
		return currNode.getHeight();
	}
	
	public void set_balance_of_all_nodes() {
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
			
			computeBalance(curr);
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
	
	public void left_rotate(Node curr) {
		if(curr != null) {
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
	}
	
	public void right_rotate(Node curr) {
		if(curr != null) {
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
		Node restore = null;
		
		if(curr != null) {
			if(curr.getLeftChild() == null && curr.getRightChild() == null) {
				if(curr.getParent().getLeftChild() == curr)
					curr.getParent().setLeftChild(null);
				else
					curr.getParent().setRightChild(null);
				delete_restore_AVL_prop(curr.getParent());
			}
			
			else if(curr.getLeftChild() == null) {
				transplant(curr, curr.getRightChild());
				delete_restore_AVL_prop(curr.getParent());
			}
			
			else if(curr.getRightChild() == null) {
				transplant(curr, curr.getLeftChild());
				delete_restore_AVL_prop(curr.getParent());
			}
			
			else {
				Node successor = successor(curr.getKey());
				//since we have already handled the case of node to be deleted being leaf, the successor that we get know will be the minimum of right subtree and hence won't have any left child
				if(successor.getParent() != curr) {
					transplant(successor, successor.getRightChild());	//since successor doesn't have left child, we delete it and replace it by its right child
					successor.setRightChild(curr.getRightChild());
					successor.getRightChild().setParent(successor);
					restore = successor.getParent();
				}
				else {
					restore = successor;
				}
				transplant(curr, successor);
				successor.setLeftChild(curr.getLeftChild());
				successor.getLeftChild().setParent(successor);
				delete_restore_AVL_prop(restore);
			}
		}
	}
	
	public void delete_restore_AVL_prop(Node curr) {
		height_of_node(curr);
		
		while(curr != null) {
			computeBalance(curr);
			
			if(curr.getBalance() == -2) {
				if(curr.getLeftChild().getBalance() == 1) {
					
					left_rotate(curr.getLeftChild());
					height_of_node(curr.getLeftChild());
					computeBalance(curr.getLeftChild());
					computeBalance(curr.getLeftChild().getLeftChild());
				}
				
				right_rotate(curr);
				height_of_node(curr.getParent());
				computeBalance(curr);
				computeBalance(curr.getParent());
				
				curr = curr.getParent();
			}
			
			else if(curr.getBalance() == 2) {
				if(curr.getRightChild().getBalance() == -1) {
					
					right_rotate(curr.getRightChild());
					height_of_node(curr.getRightChild());
					computeBalance(curr.getRightChild());
					computeBalance(curr.getRightChild().getRightChild());
				}
				
				left_rotate(curr);
				height_of_node(curr.getParent());
				computeBalance(curr);
				computeBalance(curr.getParent());
				
				curr = curr.getParent();
			}
			
			curr = curr.getParent();
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
