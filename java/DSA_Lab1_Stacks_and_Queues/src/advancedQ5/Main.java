package advancedQ5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LinkedList<String, Integer> llist = new LinkedList<String, Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the list\n"
					+	"2: To search an element\n"
					+	"3: To search element by key 1\n"
					+	"4: To search by key 2\n"
					+	"5: To get element at given index\n"
					+	"6: To Delete element at given index\n"
					+	"7: To print the list\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter name, id of element to be added");
					llist.add(sc.next(), sc.nextInt());
					sc.nextLine();
					break;
				case 2:
					System.out.println("Enter the name, id of element to be searched");
					int[] search = llist.search(sc.next(), sc.nextInt());
					sc.nextLine();
					System.out.println("Index/indices of element is/are:");
					for(int i=0; i<search.length; i++){
						if(search[i] != -1)
							System.out.println(search[i]);
					}
					break;
				case 3:
					System.out.println("Enter value to search element by key 1");
					LinkedList<String, Integer> dupList = new LinkedList<String, Integer>();
					llist.searchBykey1(sc.next(), dupList);
					System.out.println("Matching List is:");
					dupList.print();
					break;
				case 4:
					System.out.println("Enter value to search element by key 2");
					dupList = new LinkedList<String, Integer>();
					llist.searchBykey2(sc.nextInt(), dupList);
					System.out.println("Matching List is:");
					dupList.print();					
					break;
				case 5:
					System.out.println("Enter index to get element at that index");
					Node<String, Integer> temp = llist.getElementAtIndex(sc.nextInt());
					System.out.println(temp.getKey1() + " " + temp.getKey2());
					break;
				case 6:
					System.out.println("Enter index of element to be deleted");
					llist.delete(sc.nextInt());
					break;
				case 7:
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
