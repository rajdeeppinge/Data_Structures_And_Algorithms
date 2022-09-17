package advancedQ11;

import Q1.linkedList.LinkedList;

public class Stack {
	LinkedList<Integer> llist;
	
	public Stack(){
		llist = new LinkedList<Integer>();
	}
	
	public void push(int data){
		llist.add(data);
	}
	
	public int pop(){
		while(!isEmpty())
			return llist.delete(llist.size()-1);
		System.out.println("Underflow");
		return -100;
	}
	
	public boolean isEmpty(){
		return llist.isEmpty();
	}
	
	public void print() {
		if(!isEmpty()){
			for(int i = 0; i < llist.size(); i++) {
				System.out.print("|" + llist.getElementAtIndex(i));
			}
		}
		else {
			System.out.print("Underflow");
		}
		System.out.println();
	}
}