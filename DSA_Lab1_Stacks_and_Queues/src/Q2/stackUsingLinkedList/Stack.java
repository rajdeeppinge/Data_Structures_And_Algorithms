package Q2.stackUsingLinkedList;

import Q1.linkedList.*;

public class Stack<T> {
	LinkedList<T> llist;
	
	public Stack(){
		llist = new LinkedList<T>();
	}
	
	public void push(T data){
		llist.add(data);
	}
	
	public T pop(){
		while(!isEmpty())
			return llist.delete(llist.size()-1);
		System.out.println("Stack is Empty");
		return null;
	}
	
	public boolean isEmpty(){
		return llist.isEmpty();
	}
	
	public void print() {
		if(!isEmpty()) {
			System.out.println("Stack formed:");
			for(int i=llist.size()-1; i >= 0; i--) {
				System.out.println(llist.getElementAtIndex(i));
			}
		}
		else {
			System.out.println("Stack is Empty");
		}
	}
}
