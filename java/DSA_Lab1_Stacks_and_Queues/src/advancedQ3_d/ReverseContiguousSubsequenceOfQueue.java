package advancedQ3_d;

import advancedQ1.StackUsing2Queues;
import Q3.queueUsingArrays.Queue;

//instead of using two queues directly, I am using stack made by two queues earlier in advancedQ1
public class ReverseContiguousSubsequenceOfQueue {
	StackUsing2Queues stack;
	
	public ReverseContiguousSubsequenceOfQueue(int size) {
		stack = new StackUsing2Queues(size);
	}
	
	public void reverse(int startPos, int endPos, Queue queue) {
		for(int i=1; i<startPos; i++) {
			queue.enqueue(queue.dequeue());
		}
		
		for(int i=startPos; i<=endPos; i++) {
			stack.push(queue.dequeue());
		}
		
		while(!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		
		for(int i=0; i<queue.size()-endPos; i++) {
			queue.enqueue(queue.dequeue());
		}
 	}
}
