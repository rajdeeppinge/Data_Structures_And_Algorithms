package advancedQ3_d;

import java.util.Scanner;

import Q3.queueUsingArrays.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the maximum size of queue");
		int size = sc.nextInt();
		
		Queue queue = new Queue(size);
		
		ReverseContiguousSubsequenceOfQueue rev = new ReverseContiguousSubsequenceOfQueue(size);
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the queue at the back\n"
					+	"2: To delete an element from the queue\n"
					+	"3: To print the queue\n"
					+	"4: To reverse contiguous subsequence of queue\n"
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
					System.out.println("Enter start and end position of subsequence from start which you need to reverse");
					int startPos = sc.nextInt();
					int endPos = sc.nextInt();
					rev.reverse(startPos, endPos, queue);
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
