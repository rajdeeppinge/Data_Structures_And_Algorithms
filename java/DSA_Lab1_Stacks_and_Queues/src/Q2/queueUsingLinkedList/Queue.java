package Q2.queueUsingLinkedList;

import Q1.linkedList.*;

public class Queue<T> {
	LinkedList<T> llist;
	
	public Queue(){
		llist = new LinkedList<T>();
	}
	
	public void enqueue(T data){
		llist.add(data);
	}
	
	public T dequeue(){
		while(!isEmpty())
			return llist.delete(0);
		System.out.println("Queue is Empty");
		return null;
	}
	
	public boolean isEmpty(){
		return llist.isEmpty();
	}
	
	public void print() {
		if(!isEmpty()) {
			System.out.println("Queue formed:");
			llist.print();
		}
		else {
			System.out.println("Queue is Empty");
		}
	}
}
