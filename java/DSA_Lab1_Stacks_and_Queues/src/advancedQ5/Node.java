package advancedQ5;

public class Node<T, E> {
	T key1;
	E key2;
	Node<T, E> nextNode;
	
	public Node(T key1, E key2){
		this.key1 = key1;
		this.key2 = key2;
		nextNode = null;
	}
	
	public Node(T key1, E key2, Node<T, E> next){
		this.key1 = key1;
		this.key2 = key2;
		nextNode = next;
	}

	public E getKey2() {
		return key2;
	}

	public void setKey2(E key2) {
		this.key2 = key2;
	}

	public T getKey1() {
		return key1;
	}

	public void setKey1(T data) {
		this.key1 = data;
	}

	public Node<T, E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T, E> nextNode) {
		this.nextNode = nextNode;
	}
}