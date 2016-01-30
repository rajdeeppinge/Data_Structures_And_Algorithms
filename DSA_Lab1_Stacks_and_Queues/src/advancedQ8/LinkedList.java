package advancedQ8;

public class LinkedList<T1, T2, T3, T4, T5> {
	public Node<T1, T2, T3, T4, T5> head, tail, curr;
	
	public LinkedList() {
		head = tail = curr = null;
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
	
	public void add(T1 key1, T2 key2, T3 key3, T4 key4, T5 key5){
		Node<T1, T2, T3, T4, T5> newNode = new Node<T1, T2, T3, T4, T5>(key1, key2, key3, key4, key5);
		if(head == null)
			head = newNode;
		if(tail != null)
			tail.setNextNode(newNode);
		tail = newNode;
	}
	
	public LinkedList<T1, T2, T3, T4, T5> search(T1 key1, T2 key2, T3 key3, T4 key4, T5 key5, LinkedList<T1, T2, T3, T4, T5> dupList){
		int count = 0;
		curr = head;
		while(curr != null){
			count = 0;
			if(curr.getKey1().toString().equals(key1.toString().split(" ")[0]))
				count++;
			if(curr.getKey2().toString().equals(key2.toString().split(" ")[0]))
				count++;
			if(curr.getKey3().toString().equals(key3.toString().split(" ")[0]))
				count++;
			if(curr.getKey4().toString().equals(key4.toString().split(" ")[0]))
				count++;
			if(curr.getKey5().toString().equals(key5.toString().split(" ")[0]))
				count++;
			if(count >= 3)
				dupList.add(curr.getKey1(), curr.getKey2(), curr.getKey3(), curr.getKey4(), curr.getKey5());
			curr = curr.getNextNode();
		}
		return dupList;
	}
	
	public Node<T1, T2, T3, T4, T5> getElementAtIndex(int index){
		if(index <= size()-1 && index >= 0){
			curr = head;
			while(index-- > 0)
				curr = curr.getNextNode();
			return curr;
		}
		return null;
	}
	
	public Node<T1, T2, T3, T4, T5> delete(int index){
		Node<T1, T2, T3, T4, T5> temp;
		
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
	
	public void print() {
		if(!isEmpty()) {
			curr = head;
			while(curr != null) {
				System.out.println(curr.getKey1() + " " + curr.getKey2() + " " + curr.getKey3() + " " + curr.getKey4() + " " + curr.getKey5());
				curr = curr.getNextNode();
			}
		}
		else {
			System.out.println("List is Empty");
		}
	}
}
