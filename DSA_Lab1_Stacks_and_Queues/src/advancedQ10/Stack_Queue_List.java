package advancedQ10;

import Q1.linkedList.*;
 
public class Stack_Queue_List extends LinkedList<Integer>{		//extends linked list formed in basics Q1
	private int size;
	
	public Stack_Queue_List() {
		super();
		size = 0;
	}
	
	public void add(int data) {
		super.addLast(data);
		size++;
	}
	
	public void delete() {
		if(size > 8) {
			super.delete(size()-1);
		}
		else {
			super.delete(0);
		}
		size--;
	}
	
	public void print() {
		if(!super.isEmpty()) {
			curr = head;
			while(curr != null) {
				System.out.print(curr.getData() + " ");
				curr = curr.getNextNode();
			}
		}
		else {
			System.out.print("List is Empty");
		}
		System.out.println();
	}
}
