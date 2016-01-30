package advancedQ8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of binary minimum heap");
		int size = sc.nextInt();
		
		sc.close();
		
		int noOfLevels = (int)Math.ceil( Math.log10(size+1) / Math.log10(2) );
	
		int maxInversions = 0;
		
		for(int i = 0; i < noOfLevels - 2; i++) {
			int noOfNodesAtLevel_i = (int)Math.pow(2, i);
			maxInversions += ( noOfNodesAtLevel_i * (noOfNodesAtLevel_i-1) ) / 2;
 		}
		
		int noOfNodesAtLastLevel = (int)(size - Math.pow(2, noOfLevels-1) + 1);
		
		maxInversions += ( Math.ceil(noOfNodesAtLastLevel/2.0) * (Math.ceil(noOfNodesAtLastLevel/2.0) - 1) ) / 2;
	
		int ReverseOrderNodes_LastTwoLevels = (int) (Math.pow(2, noOfLevels-2) - Math.ceil(noOfNodesAtLastLevel/2.0) + noOfNodesAtLastLevel);
		
		maxInversions += ReverseOrderNodes_LastTwoLevels * (ReverseOrderNodes_LastTwoLevels - 1) / 2;
		
		System.out.println("Minimum possible inversions = 0");
		System.out.println("Maximum possible Inversions = " + maxInversions);
	}
}
