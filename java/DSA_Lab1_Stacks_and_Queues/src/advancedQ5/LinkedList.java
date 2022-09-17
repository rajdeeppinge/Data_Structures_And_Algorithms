package advancedQ5;

public class LinkedList<T, E> {
	public Node<T, E> head, tail, curr;
	
	public LinkedList() {
		head = tail = curr = null;
	}
	
	public void add(T key1, E key2){
		Node<T, E> newNode = new Node<T, E>(key1, key2);
		if(head == null)
			head = newNode;
		if(tail != null)
			tail.setNextNode(newNode);
		tail = newNode;
	}
	
	public int[] search(T key1, E key2){
		int[] indexArr = new int[size()];
		for(int i=0; i<indexArr.length; i++){
			indexArr[i] = -1;
		}
		int index = 0, arrCount = 0;
		curr = head;
		while(curr != null){
			if(curr.getKey1().toString().equals(key1.toString().split(" ")[0]) && curr.getKey2().toString().equals(key2.toString().split(" ")[0]))
				indexArr[arrCount++] = index;
			index++;
			curr = curr.getNextNode();
		}
		return indexArr;
	}
	
	public LinkedList<T, E> searchBykey1(T key1, LinkedList<T, E> dupList) {
		curr = head;
		while(curr != null) {
			if(curr.getKey1().toString().equals(key1.toString().split(" ")[0])) {	//since input can be a string also, in which case '==' won't work
				dupList.add(curr.getKey1(), curr.getKey2());
			}
			curr = curr.getNextNode();
		}
		return dupList;
	}
	
	public LinkedList<T, E> searchBykey2(E key2, LinkedList<T, E> dupList) {
		curr = head;
		while(curr != null) {
			if(curr.getKey2().toString().equals(key2.toString().split(" ")[0])) {
				dupList.add(curr.getKey1(), curr.getKey2());
			}
			curr = curr.getNextNode();
		}
		return dupList;
	}
	
	public Node<T, E> getElementAtIndex(int index){
		if(index <= size()-1 && index >= 0){
			curr = head;
			while(index-- > 0)
				curr = curr.getNextNode();
			return curr;
		}
		return null;
	}
	
	public Node<T, E> delete(int index){
		Node<T, E> temp;
		
		if(index <= size()-1 && index >= 0){
			curr = head;
			while(index > 1){
				curr = curr.getNextNode();
				index--;
			}
			
			if(index == 0){
				temp = head;
				head = head.getNextNode();
				return temp;
			}
			
			if(tail == curr.getNextNode()){
				tail = curr;
			}
			
			temp = curr.getNextNode();
			curr.setNextNode(temp.getNextNode());
			return temp;
		}
		
		return null;
	}
	
/*	public void delete(T data){
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
		
	}*/
	
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
				System.out.println(curr.getKey1() + " " + curr.getKey2());
				curr = curr.getNextNode();
			}
		}
		else {
			System.out.println("List is Empty");
		}
	}
}