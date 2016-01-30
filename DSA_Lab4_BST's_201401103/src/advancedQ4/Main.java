package advancedQ4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the height of binary tree");
		int height = sc.nextInt();
		
		System.out.print("Number of structurally different binary trees = ");
		
		if(height % 2 == 0) {
			System.out.println( (int) (Math.pow(8, Math.floor(height / 2.0 - 1)) * 3 * 2) );
		}
		
		else {
			System.out.println( (int) (Math.pow(8, Math.floor(height / 2.0)) * 2) );
		}
		
		sc.close();
	}

}
