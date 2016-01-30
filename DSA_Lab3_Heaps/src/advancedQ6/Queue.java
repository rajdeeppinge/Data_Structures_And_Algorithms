package advancedQ6;

import java.util.LinkedList;

public class Queue {
	LinkedList<Integer> llist;
	
	public Queue(){
		llist = new LinkedList<Integer>();
	}
	
	public void enqueue(Integer data){
		llist.add(data);
	}
	
	public int dequeue(){
		while(!isEmpty())
			return llist.remove(0);
		System.out.println("Queue is Empty");
		return -1;
	}
	
	public int peek() {
		return llist.get(0);
	}
	
	public boolean isEmpty(){
		return llist.isEmpty();
	}
	
	public void print() {
		if(!isEmpty()) {
			System.out.println("The jobs in queue are: ");
			for(int i = 0; i < llist.size(); i++) {
				System.out.print(llist.get(i) + " ");
			}
			System.out.println();
		}
		else {
			System.out.println("Queue is Empty");
		}
	}
}
