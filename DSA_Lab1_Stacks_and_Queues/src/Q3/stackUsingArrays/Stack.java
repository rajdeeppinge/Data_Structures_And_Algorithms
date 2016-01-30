package Q3.stackUsingArrays;

public class Stack {
	private int[] data;
	private int index, size;

	public Stack(int size) {
		this.size = size;
		data = new int[size];
		index = 0;
	}
	
	public void push(int element){
		if(index > size-1){
			System.out.println("Overflow");
			return;
		}
		data[index++] = element;	
	}
	
	public int pop(){
		if(index < 1){
			System.out.println("Underflow");
			return -100;
		}
		return data[--index];
	}
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	public void print() {
		if(!isEmpty()) {
			for(int i = index-1; i >= 0; i--) {		//index-1 since index always points to the location where next element is to be inserted
				System.out.println(data[i]);
			}
		}
		else {
			System.out.println("Stack is Empty");
		}
	}
}
