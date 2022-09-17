package Q1.linkedList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		boolean process = true;
		
		do {
			System.out.println("Press\n1: To add an element to the list\n"
					+	"2: To enter an element to be searched\n"
					+	"3: To get element at given index\n"
					+	"4: To Delete element at given index\n"
					+	"5: To Delete element with given key\n"
					+	"6: To print the list\n"
					+	"0: To Exit");
			int option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter value of element to be added");
					llist.add(sc.nextInt());
					break;
				case 2:
					System.out.println("Enter the value of element to be searched");
					int[] search = llist.search(sc.nextInt());
					System.out.println("Index/indices of element is/are:");
					for(int i=0; i<search.length; i++){
						if(search[i] != -1)
							System.out.println(search[i]);
					}
					break;
				case 3:
					System.out.println("Enter index to get element at that index");
					System.out.println(llist.getElementAtIndex(sc.nextInt()));
					break;
				case 4:
					System.out.println("Enter index of element to be deleted");
					llist.delete(sc.nextInt());
					break;
				case 5:
					System.out.println("Enter element to be deleted");
					llist.deleteByValue(sc.nextInt());
					break;
				case 6:
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
