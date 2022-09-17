package advancedQ3_b;

import Q2.stackUsingLinkedList.*;

public class ReverseContiguousSubsequenceOfStack<T> {
	private Stack<T> st1, st2;
	
	public ReverseContiguousSubsequenceOfStack() {
		st1 = new Stack<T>();
		st2 = new Stack<T>();
	}
	
	public void reverse(int startPos, int endPos, Stack<T> st) {	//Positions are in range [1, sizeOfStack] from top of stack not index
		if(startPos == endPos) 
			return;
		
		else {
			for(int i = 0; i < endPos; i++) {
				st1.push(st.pop());
			}
			
			for(int i = 0; i < endPos - startPos + 1; i++) {
				st2.push(st1.pop());
			}
			
			while(!st2.isEmpty())
				st.push(st2.pop());
			
			while(!st1.isEmpty())
				st.push(st1.pop());
		}
	}
}
