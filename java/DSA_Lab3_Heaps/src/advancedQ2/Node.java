package advancedQ2;

public class Node {
	private Node left, right;
	private int priority;
	private int key;
	
	public Node(int priority, int key) {
		left = right = null;
		this.priority = priority;
		this.key = key;
	}
	
	public Node(Node left, Node right, int priority, char key) {
		this.left = left;
		this.right = right;
		this.priority = priority;
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
