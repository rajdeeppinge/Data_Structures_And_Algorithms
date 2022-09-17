package advancedQ9_a;

import java.util.Scanner;

import Q3.queueUsingArrays.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of queue");
		int size = sc.nextInt();
		
		Queue queue = new Queue(size);
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the queue at the back\n"
					+	"2: To delete an element from the queue\n"
					+	"3: To print the queue\n"
					+	"4: To change sequence of elements of queue\n"
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
					System.out.println("Press\n1: To change sequence of elements using 1 queue\n"
							+	"2: To change sequence of elements using 2 queues");
					int num = sc.nextInt();
					
					System.out.println("Enter the permutation of positions in which you want to order the queue");
					int[] permutation = new int[size];
					for(int i=0; i<size; i++) {
						permutation[i] = sc.nextInt();
					}
					
					switch(num) {
						case 1:
							ChangeSequenceOfElementsOfQueueUsing1Queue q1q = new ChangeSequenceOfElementsOfQueueUsing1Queue(size);
							q1q.change(permutation, queue);
							break;
						case 2:
							ChangeSequenceOfElementsOfQueueUsing2Queues q2q = new ChangeSequenceOfElementsOfQueueUsing2Queues(size);
							q2q.change(permutation, queue);
							break;
						default:
							break;
					}
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
