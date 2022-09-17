package advancedQ3_c;

import Q2.queueUsingLinkedList.Queue;

public class ExchangeTwoElementsOfQueue<T> {
	private Queue<T> q1, q2;
	
	public ExchangeTwoElementsOfQueue() {
		q1 = new Queue<T>();
		q2 = new Queue<T>();
	}
	
	public void exchange(int pos1, int pos2, Queue<T> queue) {		//indicates position from start of the queue in range [1, size] not index
		if(pos1 == pos2)
			return;
		
		else{
			int pos = 1;
			while(pos != pos1 && pos != pos2) {
				q1.enqueue(queue.dequeue());
				pos++;
			}
			
			q2.enqueue(queue.dequeue());
			pos++;
			
			while(pos != pos1 && pos != pos2) {
				q1.enqueue(queue.dequeue());
				pos++;
			}
			
			q1.enqueue(q2.dequeue());
			q2.enqueue(queue.dequeue());
			
			while(!queue.isEmpty()) {
				q1.enqueue(queue.dequeue());
			}
			
			pos = 1;
			while(pos != pos1 && pos != pos2) {
				queue.enqueue(q1.dequeue());
				pos++;
			}
			
			queue.enqueue(q2.dequeue());
			
			while(!q1.isEmpty()){
				queue.enqueue(q1.dequeue());
			}
		}
	}
}
