package advancedQ3_a;

import Q2.stackUsingLinkedList.*;

public class ExchangeTwoElementsOfStack<T> {
	private Stack<T> st1, st2;
	
	public ExchangeTwoElementsOfStack() {
		st1 = new Stack<T>();
		st2 = new Stack<T>();
	}
	
	public void exchange(int pos1, int pos2, Stack<T> st) {		//indicates position from top of the stack in range [1, size] not index
		if(pos1 == pos2)
			return;
		
		else{
			int pos = 1;
			while(pos != pos1 && pos != pos2) {
				st1.push(st.pop());
				pos++;
			}
			
			st2.push(st.pop());
			pos++;
			
			while(pos != pos1 && pos != pos2) {
				st1.push(st.pop());
				pos++;
			}
			
			st1.push(st.pop());
			st.push(st2.pop());
			st2.push(st1.pop());
			pos--;
			
			while(pos != pos1 && pos != pos2) {
				st.push(st1.pop());
				pos--;
			}
			
			st.push(st2.pop());
			pos--;
			
			while(!st1.isEmpty()){
				st.push(st1.pop());
			}
		}
	}
}
