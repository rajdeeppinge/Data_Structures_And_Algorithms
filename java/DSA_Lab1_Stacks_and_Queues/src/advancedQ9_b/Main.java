package advancedQ9_b;

import java.util.Scanner;
import Q3.stackUsingArrays.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of the stack");
		int size = sc.nextInt();
		
		Stack st = new Stack(size);
		
		ChangeSequenceOfElementsOfStack chgSt = new ChangeSequenceOfElementsOfStack(size);

		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the top of the stack\n"
					+	"2: To pop an element from the stack\n"
					+	"3: To print the stack\n"
					+	"4: To change sequence of elements of stack\n"
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
					System.out.println("Enter the permutation of positions in which you want to order the stack");
					int[] permutation = new int[size];
					for(int i=0; i<size; i++) {
						permutation[i] = sc.nextInt();
					}
					chgSt.change(permutation, st);
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
