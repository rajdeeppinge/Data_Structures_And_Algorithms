package q1_binary_search;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		
		System.out.println("Enter elements of array in increasing order");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean process = true;
		
		do {
			System.out.println("do you want to search another element?\n"
								+	"1: yes\n"
								+	"2: no");
			int entry = sc.nextInt();
			
			switch(entry) {
				case 1:
					System.out.println("Which binary search method do you want to be used:\n"
										+	"1: Recursive\n"
										+	"2: Iterative");
					int option = sc.nextInt();
					
					System.out.println("Enter the element to be searched");
					int element = sc.nextInt();
					
					switch(option) {
						case 1:
							BinarySearch_Recursive bsr = new BinarySearch_Recursive();
							System.out.println("The index of element is: " + bsr.search(arr, 0, arr.length-1, element));
							break;
						case 2:
							BinarySearch_Iterative bsi = new BinarySearch_Iterative();
							System.out.println("The index of element is: " + bsi.search(arr, 0, arr.length-1, element));
							break;
					}
					
					break;
					
				case 2:
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
