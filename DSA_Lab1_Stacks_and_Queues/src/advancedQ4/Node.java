package advancedQ4;

public class Node<T> {
	private T key;
	private Node<T> leftChild, rightChild;
	
	public Node(T key){
		this.key = key;
		leftChild = rightChild = null;
	}
	
	public Node(T data, Node<T> left, Node<T> right){
		this.key = data;
		leftChild = left;
		rightChild = right;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T data) {
		this.key = data;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}
}
