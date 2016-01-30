package Q3.queueUsingArrays;

public class Queue {
	private int[] data;
	private int startIndex, size, endIndex, currentSize;
	
	public Queue(int size){
		this.size = size;
		data = new int[size];
		startIndex = endIndex = 0;
		currentSize = 0;
	}
	
	public void enqueue(int element){
		if(currentSize == size){
			System.out.println("Overflow");
			return;
		}
		data[endIndex++] = element;
		currentSize++;
		endIndex = endIndex % size;
	}
	
	public int dequeue(){
		if(!isEmpty()){
			currentSize--;
			int temp = data[startIndex++];
			startIndex = startIndex % size;
			return temp;
		}
		System.out.println("Underflow");
		return -100;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public int size() {
		return currentSize;
	}
	
	public void print() {
		if(!isEmpty()) {
			for(int i = 0; i < currentSize; i++) {
				System.out.println(data[(startIndex + i) % size]);
			}
		}
		else {
			System.out.println("Queue is Empty");
		}
	}
}