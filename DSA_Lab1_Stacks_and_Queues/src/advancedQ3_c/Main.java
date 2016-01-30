package advancedQ3_c;

import java.util.Scanner;

import Q2.queueUsingLinkedList.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> queue = new Queue<Integer>();
		
		ExchangeTwoElementsOfQueue<Integer> ex = new ExchangeTwoElementsOfQueue<Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the queue at the back\n"
					+	"2: To delete an element from the queue\n"
					+	"3: To print the queue\n"
					+	"4: To exchange two elements of the queue\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter element to be added to queue at the back");
					queue.enqueue(sc.nextInt());
					break;
				case 2:
					queue.dequeue();
					break;
				case 3:
					queue.print();
					break;
				case 4:
					System.out.println("Enter positions of elements from start which you need to exchange");
					int pos1 = sc.nextInt();
					int pos2 = sc.nextInt();
					ex.exchange(pos1, pos2, queue);
					break;
				case 0:
					process = false;
					break;
				default:
					break;
			}
		}
		while(process);
		
		sc.close();
	}

}
