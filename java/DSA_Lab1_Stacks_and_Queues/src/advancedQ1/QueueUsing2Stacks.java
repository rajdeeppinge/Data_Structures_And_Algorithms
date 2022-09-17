package advancedQ1;

import Q3.stackUsingArrays.*;

public class QueueUsing2Stacks {
	private Stack st1, st2;
	private int currentSize, size;
	
	public QueueUsing2Stacks(int size){
		st1 = new Stack(size);
		st2 = new Stack(size);
		this.size = size;
		currentSize = 0;
	}
	
	public void enqueue(int element){
		if(currentSize < size){
			while(!st1.isEmpty()){
				st2.push(st1.pop());
			}
			st1.push(element);				
			while(!st2.isEmpty()){
				st1.push(st2.pop());
			}
			currentSize++;
		}
		else {
			System.out.println("Overflow");
		}
	}
	
	public int dequeue(){
		if(!st1.isEmpty()){
			currentSize--;
			return st1.pop();
		}
		System.out.println("Underflow");
		return -100;
	}
	
	public boolean isEmpty(){
		return st1.isEmpty();
	}
	
	public void print() {
		if(isEmpty()) {
			st1.print();
		}
		else {
			System.out.println("Queue is Empty");
		}
	}
}
