package advancedQ1;

import Q3.queueUsingArrays.*;

public class StackUsing2Queues {
	private Queue q1, q2;
	private int currentSize, size;
	
	public StackUsing2Queues(int size){
		q1 = new Queue(size);
		q2 = new Queue(size);
		this.size = size;
		currentSize = 0;
	}
	
	public void push(int element) {
		if(currentSize < size) {
			while(!q1.isEmpty()){
				q2.enqueue(q1.dequeue());
			}
			q1.enqueue(element);
			while(!q2.isEmpty()){
				q1.enqueue(q2.dequeue());
			}
			currentSize++;
		}
		else {
			System.out.println("Overflow");
		}
	}
	
	public int pop(){
		if(!q1.isEmpty()){
			currentSize--;
			return q1.dequeue();
		}
		System.out.println("Underflow");
		return -100;
	}
	
	public boolean isEmpty(){
		return q1.isEmpty();
	}
	
	public int size() {
		return currentSize;
	}
	
	public void print() {
		if(!isEmpty())
			q1.print();
		else
			System.out.println("Stack is Empty");
	}
}
