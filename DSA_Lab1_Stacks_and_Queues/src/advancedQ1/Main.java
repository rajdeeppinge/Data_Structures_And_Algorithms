package advancedQ1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean running = true;
		
		do {
			System.out.println("Enter the data structure that you want to use:\n1:Queue\n2:Stack\n0:Exit");
			int type = sc.nextInt();
			
			switch(type) {
				case 1:
					System.out.println("Enter the maximum size of queue");
					int size = sc.nextInt();
					
					QueueUsing2Stacks queue = new QueueUsing2Stacks(size);
					
					boolean process = true;
					
					do {
						System.out.println("Press\n1: To add an element to the queue at the back\n"
								+	"2: To delete an element from the queue\n"
								+	"3: To print the queue\n"
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
							case 0:
								process = false;
								break;
							default:
								break;
						}
					}
					while(process);
					break;
			
				case 2:
					System.out.println("Enter maximum size of the stack");
					size = sc.nextInt();
					
					StackUsing2Queues st = new StackUsing2Queues(size);
			
					process = true;
					
					do {
						System.out.println("Press\n1: To add an element to the top of the stack\n"
								+	"2: To pop an element from the stack\n"
								+	"3: To print the stack\n"
								+	"0: To Exit");
						int option = sc.nextInt();
						switch(option) {
							case 1:
								System.out.println("Enter element to be pushed on to the stack");
								st.push(sc.nextInt());
								break;
							case 2:
								st.pop();
								break;
							case 3:
								st.print();
								break;
							case 0:
								process = false;
								break;
							default:
								break;
						}
					}
					while(process);
					break;
					
				case 0:
					running = false;
					break;
					
				default:
					break;
			}
		}
		while(running);
		
		sc.close();
	}
}
