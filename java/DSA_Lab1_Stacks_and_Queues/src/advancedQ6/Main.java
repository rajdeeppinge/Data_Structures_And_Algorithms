package advancedQ6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		DoublyLinkedList<Integer> dllist = new DoublyLinkedList<Integer>();
		
		ReverseASublist<Integer> rev = new ReverseASublist<Integer>(dllist);
		
		boolean process = true;
		
		do {
			System.out.println("Press\na: To add an element at the start of the list\n"
					+	"b: To add an element at the end of the list\n"
					+	"c: To add an element at a given position in the list\n"
					+	"d: To enter an element to be searched\n"
					+	"e: To get element at given index\n"
					+	"f: To delete first element\n"
					+	"g: To delete last element\n"
					+	"h: To Delete element at given position\n"
					+	"i: To print the list\n"
					+	"j: To reverse a sublist in the list\n"
					+	"0: To Exit");
			String option = sc.next();
			sc.nextLine();
			switch(option) {
				case "a":
					System.out.println("Enter value of element to be added");
					dllist.addFirst(sc.nextInt());
					break;
				case "b":
					System.out.println("Enter value of element to be added");
					dllist.addLast(sc.nextInt());
					break;
				case "c":
					System.out.println("Enter value of element and the position at which it needs to be added");
					dllist.add(sc.nextInt(), sc.nextInt());
					break;
				case "d":
					System.out.println("Enter the value of element to be searched");
					int[] search = dllist.search(sc.nextInt());
					System.out.println("Index/indices of element is/are:");
					for(int i=0; i<search.length; i++){
						if(search[i] != -1)
							System.out.println(search[i]);
					}
					break;
				case "e":
					System.out.println("Enter index to get element at that index");
					System.out.println(dllist.getElementAtIndex(sc.nextInt()));
					break;
				case "f":
					dllist.deleteFirst();
					break;
				case "g":
					dllist.deleteLast();
					break;
				case "h":
					System.out.println("Enter position of element to be deleted");
					dllist.delete(sc.nextInt());
					break;
				case "i":
					dllist.print();
					break;
				case "j":
					System.out.println("Enter the start and end position of sublist which is to be reversed");
					rev.reverse(sc.nextInt(), sc.nextInt());
					break;
				case "0":
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
