package advancedQ6;

public class DoublyLinkedList<T> {
	public Node<T> head, tail, curr;
	
	public DoublyLinkedList() {
		head = tail = curr = null;
	}
	
	public void addLast(T key){
		Node<T> newNode = new Node<T>(key);
		if(isEmpty())
			head = newNode;
		else {
			tail.setNextNode(newNode);
			newNode.setPrevNode(tail);
		}
		tail = newNode;
	}
	
	public void addFirst(T key) {
		Node<T> newNode = new Node<T>(key);
		if(isEmpty())
			tail = newNode;
		else {
			head.setPrevNode(newNode);
			newNode.setNextNode(head);
		}
		head = newNode;
	}
	
	public void add(T key, int pos) {
		if(isEmpty() || pos == 1) {
			addFirst(key);
		}
		else if(pos > size()) {
			addLast(key);
		}
		else {
			Node<T> newNode = new Node<T>(key);
			curr = head;
			int posCount = 1;
			while(posCount < pos-1) {
				curr = curr.getNextNode();
				posCount++;
			}
			newNode.setNextNode(curr.getNextNode());
			newNode.setPrevNode(curr);
			curr.getNextNode().setPrevNode(newNode);
			curr.setNextNode(newNode);
		}
	}
	
	public int[] search(T key){
		int[] indexArr = new int[100];
		for(int i=0; i<indexArr.length; i++){
			indexArr[i] = -1;
		}
		int index = 0, arrCount = 0;
		curr = head;
		while(curr != null){
			if(curr.getKey() == key)
				indexArr[arrCount++] = index;
			index++;
			curr = curr.getNextNode();
		}
		return indexArr;
	}
	
	public T getElementAtIndex(int index){
		if(index <= size()-1 && index >= 0){
			curr = head;
			while(index-- > 0)
				curr = curr.getNextNode();
			return curr.getKey();
		}
		return null;
	}
	
	public T deleteFirst() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return null;
		}
		else {
			Node<T> temp = head;
			head = head.getNextNode();
			if(isEmpty())
				tail = null;
			else
				head.setPrevNode(null);
			return temp.getKey();
		}
	}
	
	public T deleteLast() {
		if(isEmpty()) {
			System.out.println("List is Empty");
			return null;
		}
		else {
			Node<T> temp = tail;
			tail = tail.getPrevNode();
			if(tail == null)
				head = null;
			else
				tail.setNextNode(null);
			return temp.getKey();
		}
	}
	
	public T delete(int pos){
		if(pos <= size() && pos >= 1){
			if(isEmpty() || pos == 1){
				return deleteFirst();
			}
			else if(pos >= size()) {
				return deleteLast();
			}
			else {
				Node<T> temp;
				curr = head;
				while(pos > 2){
					curr = curr.getNextNode();
					pos--;
				}
				
				temp = curr.getNextNode();
				curr.setNextNode(temp.getNextNode());
				temp.getNextNode().setPrevNode(curr);
				return temp.getKey();
			}
		}
		System.out.println("List is Empty");
		return null;
	}
	
/*	public void deleteByKey(T key) {
		Node<T> temp;
		int[] indexArr = search(key);
		int arrCount = indexArr.length-1;
		
		while(indexArr[arrCount] == -1){
			arrCount--;
		}
			
		while(arrCount >= 0){
			curr = head;
			while(indexArr[arrCount] > 1){
				curr = curr.getNextNode();
				indexArr[arrCount]--;
			}
			
			if(indexArr[arrCount] == 0) {
				head = head.getNextNode();
			}
			
			if(tail == curr.getNextNode()){
				tail = curr;
			}
			
			temp = curr.getNextNode();
			if(temp!=null)
				curr.setNextNode(temp.getNextNode());
			arrCount--;
		}
		
	}*/
	
	public int size(){
		int count = 0;
		curr = head;
		while(curr != null){
			curr = curr.getNextNode();
			count++;
		}
		return count;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void print() {
		if(!isEmpty()) {
			curr = head;
			while(curr != null) {
				System.out.println(curr.getKey());
				curr = curr.getNextNode();
			}
		}
		else {
			System.out.println("List is Empty");
		}
	}
}
