package advancedQ9_a;

import advancedQ1.StackUsing2Queues;
import Q3.queueUsingArrays.Queue;

//since this has also been done using a single queue instead of repeating that procedure I am doing this by Stack Using 2 queues implemented earlier
//can also be done using the method of 1 temp queue bur instead having 2 queues 
public class ChangeSequenceOfElementsOfQueueUsing2Queues {
	private StackUsing2Queues st;
	private int size;
	
	public ChangeSequenceOfElementsOfQueueUsing2Queues(int size) {
		st = new StackUsing2Queues(size);
		this.size = size;
	}
	
	public void change(int[] permutation, Queue queue) {
		for(int j=0; j<size; j++) {
			for(int i = 1; i < permutation[size-1-j]; i++) {
				queue.enqueue(queue.dequeue());
			}
			
			int temp = queue.dequeue();
			queue.enqueue(temp);
			st.push(temp);
			
			for(int i = size; i > permutation[size-1-j]; i--) {
				queue.enqueue(queue.dequeue());
			}
		}
		
		while(!queue.isEmpty()) {
			queue.dequeue();
		}
		
		while(!st.isEmpty()) {
			queue.enqueue(st.pop());
		}
	}
}
