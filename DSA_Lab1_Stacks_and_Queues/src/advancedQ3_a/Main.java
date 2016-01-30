package advancedQ3_a;

import java.util.Scanner;

import Q2.stackUsingLinkedList.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> st = new Stack<Integer>();
		
		ExchangeTwoElementsOfStack<Integer> ex = new ExchangeTwoElementsOfStack<Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the top of the stack\n"
					+	"2: To pop an element from the stack\n"
					+	"3: To print the stack\n"
					+	"4: Exchange two elements of stack\n"
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
				case 4:
					System.out.println("Enter positions of elements from top which you need to exchange");
					int pos1 = sc.nextInt();
					int pos2 = sc.nextInt();				
					ex.exchange(pos1, pos2, st);
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
