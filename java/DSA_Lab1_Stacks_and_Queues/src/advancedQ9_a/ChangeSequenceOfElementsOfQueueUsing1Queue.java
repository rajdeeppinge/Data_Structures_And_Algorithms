package advancedQ9_a;

import Q3.queueUsingArrays.Queue;

public class ChangeSequenceOfElementsOfQueueUsing1Queue {
	private Queue tempQ;
	private int size;
	
	public ChangeSequenceOfElementsOfQueueUsing1Queue(int size) {
		tempQ = new Queue(size);
		this.size = size;
	}
	
	public void change(int[] permutation, Queue queue) {
		while(!queue.isEmpty()) {
			tempQ.enqueue(queue.dequeue());
		}
		
		for(int j=0; j<size; j++) {
			for(int i = 1; i < permutation[j]; i++) {
				tempQ.enqueue(tempQ.dequeue());
			}
			
			int temp = tempQ.dequeue();
			queue.enqueue(temp);
			tempQ.enqueue(temp);
			
			for(int i = size; i > permutation[j]; i--) {
				tempQ.enqueue(tempQ.dequeue());
			}
		}
	}
}
