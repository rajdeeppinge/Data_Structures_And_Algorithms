package advancedQ2;

import java.util.Scanner;

public class Main_2Darray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size(rows) of 2D sqare matrix");
		int size = sc.nextInt();
		
		int[][] arr = new int[size][size];
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				arr[i][j] = count++;
			}
		}
		
		System.out.println("Enter the location ([1,n] [1,n]) to find rank of element at that location:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("No of elements less than it = " + (a*b-1));
		System.out.println("No of elements greater than it = " + ((size+1-a)*(size+1-b)-1));		
		System.out.println("Range of rank is " + "[" + a*b + ", " + (size*size-(size+1-a)*(size+1-b)+1) + "]");
		
		System.out.println("Enter the rank of element to find its possible locations");
		int rank = sc.nextInt();
		
		if(rank == 1) 
			System.out.println("(1, 1)");
		else {
			for(int i = 1; i <= size; i++) {
				for(int j = 1; j <= size; j++) {
					if(i*j != 1 && i*j <= rank && rank <= size*size-(size+1-i)*(size+1-j)) {
						System.out.print("(" + i + ", " + j + ")" + " ");
					}
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
}
