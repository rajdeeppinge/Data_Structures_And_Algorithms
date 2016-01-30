package advancedQ3_b;

import java.util.Scanner;

import Q2.stackUsingLinkedList.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> st = new Stack<Integer>();
		
		ReverseContiguousSubsequenceOfStack<Integer> rev = new ReverseContiguousSubsequenceOfStack<Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the top of the stack\n"
					+	"2: To pop an element from the stack\n"
					+	"3: To print the stack\n"
					+	"4: Reverse a contiguous subsequence of stack\n"
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
					System.out.println("Enter boundries of subsequence from top of stack which you want to reverse");
					int startPos = sc.nextInt();
					int endPos = sc.nextInt();		
					rev.reverse(startPos, endPos, st);				
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
