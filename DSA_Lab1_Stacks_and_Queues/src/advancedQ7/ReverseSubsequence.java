package advancedQ7;

import advancedQ6.DoublyLinkedList;
import advancedQ6.Node;

public class ReverseSubsequence<T> {
	DoublyLinkedList<T> dllist;
	
	public ReverseSubsequence(DoublyLinkedList<T> dllist) {
		this.dllist = dllist;
	}
	
	public void reverse(int[] pos) {
		Node<T> temp1, temp2, temp3;
		temp1 = dllist.head;
		temp2 = dllist.tail;
		int count1 = 1, count2 = 1;
		
		for(int i=0; i<pos.length/2; i++) {
			while(count1++ < pos[i]) {
				temp1 = temp1.getNextNode();
			}
		
			while(count2++ <= (dllist.size() - pos[((pos.length-1)-i)])) {
				temp2 = temp2.getPrevNode();
			}
			
			if(temp2.getNextNode() != null)
				temp2.getNextNode().setPrevNode(temp1);
			if(temp1.getPrevNode() != null)
				temp1.getPrevNode().setNextNode(temp2);
			
			if(pos.length % 2 == 0 && temp1.getNextNode() == temp2) {		//limiting condition when two nodes are next to each other. This will only happen if subsequence length is even
				temp1.setNextNode(temp2.getNextNode());					
				temp2.setPrevNode(temp1.getPrevNode());
				temp1.setPrevNode(temp2);
				temp2.setNextNode(temp1);
			}								 
			
			else {
				//swap
				temp2.getPrevNode().setNextNode(temp1);
				temp1.getNextNode().setPrevNode(temp2);
				
				temp3 = temp2.getPrevNode();
				temp2.setPrevNode(temp1.getPrevNode());
				temp1.setPrevNode(temp3);
				
				temp3 = temp2.getNextNode();
				temp2.setNextNode(temp1.getNextNode());
				temp1.setNextNode(temp3);
			}
			
			if(dllist.tail == temp2) {
				dllist.tail = temp1;
			}
			
			if(dllist.head == temp1) {
				dllist.head = temp2;
			}
			
			//keeping temp1 before temp2 so as to reduce complexity to O(n)
			temp3 = temp1;
			temp1 = temp2;
			temp2 = temp3;
			
			//since count has already increased, to avoid swapping same to elements, we move them by 1 position towards centre
			temp1 = temp1.getNextNode();
			temp2 = temp2.getPrevNode();
		}
	}
}
