package advancedQ11;

import java.util.Scanner;

public class TowersOfHanoi {
	private static Stack[] st = new Stack[3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		st[0] = new Stack();
		st[1] = new Stack();
		st[2] = new Stack();
		
		System.out.println("Enter total elements to be pushed in stack 1");
		int size = sc.nextInt();
		
		System.out.println("Enter all elements with a space");
		for(int i = 0; i < size; i++) {
			st[0].push(sc.nextInt());
		}
		
		System.out.println("Stack formed:");
		st[0].print();
		System.out.println();
		
		move(size, 0, 1, 2);
		System.out.println("Finally");
		st[0].print();
		st[1].print();
		st[2].print();
		System.out.println();
		
		sc.close();
	}
	
	public static void move(int depth, int one, int two, int three) {
		if(depth > 0) {
			move(depth-1, one, three, two);
			st[three].push(st[one].pop());
			st[0].print();
			st[1].print();
			st[2].print();
			System.out.println("---------------");
			move(depth-1, two, one, three);
		}
	}
}