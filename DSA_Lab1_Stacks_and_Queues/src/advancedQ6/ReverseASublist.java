package advancedQ6;

public class ReverseASublist<T> {
	private DoublyLinkedList<T> dllist;
	
	public ReverseASublist(DoublyLinkedList<T> dllist) {
		this.dllist = dllist;
	}
	
	public void reverse(int pos1, int pos2) {
		int pos = 1;
		dllist.curr = dllist.head;
		
//		System.out.println(dllist.head.getKey() + " " + dllist.tail.getKey());
		
		Node<T> firstPos, lastPos, prevFirstPos, nextLastPos;
		
		while(pos != pos1 && pos != pos2) {
			dllist.curr = dllist.curr.getNextNode();
			pos++;
		}
		
		firstPos = dllist.curr;
		prevFirstPos = firstPos.getPrevNode();
		pos++;
		dllist.curr = dllist.curr.getNextNode();
		
		while(pos != pos1 && pos != pos2) {
			dllist.curr = dllist.curr.getNextNode();
			pos++;
		}
		
		lastPos = dllist.curr;
		nextLastPos = lastPos.getNextNode();
		
		if(prevFirstPos != null) {
			prevFirstPos.setNextNode(lastPos);
		}
		if(nextLastPos != null) {
			nextLastPos.setPrevNode(firstPos);
		}
		
		while(firstPos != lastPos) {
			lastPos.setNextNode(lastPos.getPrevNode());
			lastPos.setPrevNode(prevFirstPos);
			
			if(prevFirstPos == null) {
				prevFirstPos = lastPos;
				dllist.head = prevFirstPos;
			}
			else {
				prevFirstPos = prevFirstPos.getNextNode();
			}
			lastPos = lastPos.getNextNode();
		}
		
		lastPos.setNextNode(nextLastPos);
		lastPos.setPrevNode(prevFirstPos);
	
		if(nextLastPos == null)
			dllist.tail = firstPos;
	}
}
