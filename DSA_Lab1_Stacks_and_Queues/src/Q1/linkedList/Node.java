package Q1.linkedList;

public class Node<T> {
	T data;
	Node<T> nextNode;
	
	public Node(T data){
		this.data = data;
		nextNode = null;
	}
	
	public Node(T data, Node<T> next){
		this.data = data;
		nextNode = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
}