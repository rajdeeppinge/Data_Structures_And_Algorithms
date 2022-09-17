package advancedQ9_b;

import Q3.stackUsingArrays.Stack;
import advancedQ1.QueueUsing2Stacks;

public class ChangeSequenceOfElementsOfStack {
	QueueUsing2Stacks queue;				// instead of two stacks we will use queue made by two stacks in advanced question1
	int size;
	
	public ChangeSequenceOfElementsOfStack(int size) {
		queue = new QueueUsing2Stacks(size);
		this.size = size;
	}
	
	public void change(int[] permutation, Stack st) {
		while(!st.isEmpty()) {
			queue.enqueue(st.pop());
		}
		
		for(int j=0; j<size; j++) {
			for(int i = 1; i < permutation[size-1-j]; i++) {
				queue.enqueue(queue.dequeue());
			}
			
			int temp = queue.dequeue();
			st.push(temp);
			queue.enqueue(temp);
			
			for(int i = size; i > permutation[size-1-j]; i--) {
				queue.enqueue(queue.dequeue());
			}
		}
	}
}
