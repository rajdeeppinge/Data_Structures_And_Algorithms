package advancedQ4;

import java.util.Scanner;

public class ValidArrangements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of binary heap");
		int size = sc.nextInt();
		
		sc.close();
		
		System.out.println("Number of valid arrangements = " + validArrangements(size));
	}

	public static long factorial(long num) {
		if(num <= 1) {
			return 1;
		}
		return num*factorial(num-1);
	}
	
	public static long combination_nCr(long n, long r) {
		return factorial(n)/(factorial(r) * factorial(n-r));
	}
	
	public static long validArrangements(long noOfNodes) {
		if(noOfNodes <= 1) {
			return 1;
		}
		
		int height = (int) Math.floor(Math.log(noOfNodes)/Math.log(2));
		
		long nodesInLeftSubtree = (long)(Math.pow(2, height-1) - 1) /*nodes till 2nd last level*/ + (long)Math.min(noOfNodes - (Math.pow(2, height) - 1), Math.pow(2, height-1)); //nodes in last level, either less than(if total nodes in last level are less than half) or equal to half the total nodes in last level. Hence Math.min of whatever that is less
		long nodesInRightSubtree = noOfNodes - nodesInLeftSubtree - 1;
		
		return (long)combination_nCr(noOfNodes-1, nodesInLeftSubtree) * validArrangements(nodesInLeftSubtree) * validArrangements(nodesInRightSubtree);
	}
}
