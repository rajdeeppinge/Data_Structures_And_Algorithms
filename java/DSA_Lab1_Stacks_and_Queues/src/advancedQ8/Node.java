package advancedQ8;

public class Node<T1, T2, T3, T4, T5> {
	T1 key1;
	T2 key2;
	T3 key3;
	T4 key4;
	T5 key5;
	Node<T1, T2, T3, T4, T5> nextNode;
	
	public Node(T1 key1, T2 key2, T3 key3, T4 key4, T5 key5) {
		this.key1 = key1;
		this.key2 = key2;
		this.key3 = key3;
		this.key4 = key4;
		this.key5 = key5;
		nextNode = null;
	}

	public T1 getKey1() {
		return key1;
	}

	public void setKey1(T1 key1) {
		this.key1 = key1;
	}

	public T2 getKey2() {
		return key2;
	}

	public void setKey2(T2 key2) {
		this.key2 = key2;
	}

	public T3 getKey3() {
		return key3;
	}

	public void setKey3(T3 key3) {
		this.key3 = key3;
	}

	public T4 getKey4() {
		return key4;
	}

	public void setKey4(T4 key4) {
		this.key4 = key4;
	}

	public T5 getKey5() {
		return key5;
	}

	public void setKey5(T5 key5) {
		this.key5 = key5;
	}

	public Node<T1, T2, T3, T4, T5> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T1, T2, T3, T4, T5> nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
