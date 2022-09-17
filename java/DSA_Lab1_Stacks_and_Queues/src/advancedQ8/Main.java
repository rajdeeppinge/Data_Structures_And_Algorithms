package advancedQ8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LinkedList<String, Integer, Integer, String, Integer> llist = new LinkedList<String, Integer, Integer, String, Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the list\n"
					+	"2: To search an element\n"
					+	"3: To get element at given index\n"
					+	"4: To Delete element at given index\n"
					+	"5: To print the list\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter name, age, id, hostel wing, room no. of element to be added");
					llist.add(sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt());
					sc.nextLine();
					break;
				case 2:
					System.out.println("Enter the name, age, id, hostel wing, room no. of element to be searched");
					LinkedList<String, Integer, Integer, String, Integer> dupList = new LinkedList<String, Integer, Integer, String, Integer>();
					llist.search(sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), dupList);
					sc.nextLine();
					System.out.println("List of elements having three or more fields matching is:");
					dupList.print();
					break;
				case 3:
					System.out.println("Enter index to get element at that index");
					Node<String, Integer, Integer, String, Integer> temp = llist.getElementAtIndex(sc.nextInt());
					System.out.println(temp.getKey1() + " " + temp.getKey2() + " " + temp.getKey3() + " " + temp.getKey4() + " " + temp.getKey5());
					break;
				case 4:
					System.out.println("Enter index of element to be deleted");
					llist.delete(sc.nextInt());
					break;
				case 5:
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
