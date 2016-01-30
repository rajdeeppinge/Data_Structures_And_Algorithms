package advancedQ10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack_Queue_List llist = new Stack_Queue_List();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the stack_queue_list\n"
					+	"2: To Delete element from the stack_queue_list\n"
					+	"3: To print the list\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter value of element to be added");
					llist.add(sc.nextInt());
					break;
				case 2:
					llist.delete();
					break;
				case 3:
					llist.print();
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
