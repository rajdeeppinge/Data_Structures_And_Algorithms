package advancedQ2_reversingSinglyLL;

import Q1.linkedList.*;

public class AdvancedLinkedList<T> extends LinkedList<T>{
	
	public AdvancedLinkedList(){
		super();
	}
	
	public void reverse(){
		Node<T> prev = null;
		Node<T> curr = head;
		Node<T> next = curr.getNextNode();
		head = tail;
		tail = curr;
		
		while (curr != null){
			curr.setNextNode(prev);
			prev = curr;
			curr = next;
			if(next != null)
				next = next.getNextNode();
		}
	}
}
