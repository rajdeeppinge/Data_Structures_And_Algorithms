package Q1.linkedList;

public class LinkedList<T> {
	public Node<T> head, tail, curr;
	
	public LinkedList() {
		head = tail = curr = null;
	}
	
	public void add(T data){
		Node<T> newNode = new Node<T>(data);
		if(isEmpty())
			head = newNode;
		else
			tail.setNextNode(newNode);
		tail = newNode;
	}
	
	//some extra add methods
	public void addLast(T key){
		Node<T> newNode = new Node<T>(key);
		if(isEmpty())
			head = newNode;
		else {
			tail.setNextNode(newNode);
		}
		tail = newNode;
	}
	
	public void addFirst(T key) {
		Node<T> newNode = new Node<T>(key);
		if(isEmpty())
			tail = newNode;
		else {
			newNode.setNextNode(head);
		}
		head = newNode;
	}
	
	public int[] search(T key){
		int[] indexArr = new int[size()];
		for(int i=0; i<indexArr.length; i++){
			indexArr[i] = -1;
		}
		int index = 0, arrCount = 0;
		curr = head;
		while(curr != null){
			if(curr.getData() == key)
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
			return curr.getData();
		}
		return null;
	}
	
	public T delete(int index){
		Node<T> temp;
		
		if(index <= size()-1 && index >= 0){
			curr = head;
			while(index > 1){
				curr = curr.getNextNode();
				index--;
			}
			
			if(index == 0){
				temp = head;
				head = head.getNextNode();
				return temp.getData();
			}
			
			if(tail == curr.getNextNode()){
				tail = curr;
			}
			
			temp = curr.getNextNode();
			curr.setNextNode(temp.getNextNode());
			return temp.getData();
		}
		
		System.out.println("List is Empty");
		return null;
	}
	
	public void deleteByValue(T data){		
		if(!isEmpty()) {
			Node<T> temp;
			int[] indexArr = search(data);
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
		}
		
		else {
			System.out.println("List is Empty");
		}
	}
	
	public int size(){
		int count = 0;
		curr = head;
		while(curr != null){
			count++;
			curr = curr.getNextNode();
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
				System.out.println(curr.getData());
				curr = curr.getNextNode();
			}
		}
		else {
			System.out.println("List is Empty");
		}
	}
}