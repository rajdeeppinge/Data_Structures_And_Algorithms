package advancedQ5;

public class JobManagement {
	private Queue queue1, queue2;
	private int minPriority = Integer.MAX_VALUE;
	
	public JobManagement() {
		queue1 = new Queue();
		queue2 = new Queue();
	}
	
	public void insertJob(int priority) {
		if(priority <= minPriority) {
			minPriority = priority;
			if(queue1.isEmpty()) {
				queue2.enqueue(priority);
			}
			else {
				queue1.enqueue(priority);
			}
		}
		
		//else job has priority greater than min priority and hence must be inserted somewhere in between
		else if(queue1.isEmpty()) {
			while(priority <= queue2.peek()) {
				queue1.enqueue(queue2.dequeue());
			}
			queue1.enqueue(priority);
			while(!queue2.isEmpty()) {
				queue1.enqueue(queue2.dequeue());
			}
		}
		else {
			while(priority <= queue1.peek()) {
				queue2.enqueue(queue1.dequeue());
			}
			queue2.enqueue(priority);
			while(!queue1.isEmpty()) {
				queue2.enqueue(queue1.dequeue());
			}
		}
	}
	
	public int finishJob() {
		if(queue1.isEmpty()) {
			return queue2.dequeue();
		}
		else {
			return queue1.dequeue();
		}
	}
	
	public void printJobList() {
		if(queue1.isEmpty()) {
			queue2.print();
		}
		else {
			queue1.print();
		}
	}
}
