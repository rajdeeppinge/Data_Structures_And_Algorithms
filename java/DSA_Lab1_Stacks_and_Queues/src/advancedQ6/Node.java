package advancedQ6;

public class Node<T> {
	private T key;
	private Node<T> prevNode, nextNode;
	
	public Node(T key){
		this.key = key;
		prevNode = nextNode = null;
	}
	
	public Node(T data, Node<T> prev, Node<T> next){
		this.key = data;
		prevNode = prev;
		nextNode = next;
	}

	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T data) {
		this.key = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
}
