package advancedQ5;

import java.util.Scanner;

public class Main_with_SecondLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of array");
		int size = sc.nextInt();
		int[] tempArr = new int[((int)Math.pow(2, Math.ceil(Math.log(size)/Math.log(2))+1 )) - 1];
		
		System.out.println("Enter all the elements of array");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int tempCount = tempArr.length/2;
		for(int i = 0; i < size; i++) {
			tempArr[tempCount++] = arr[i]; 
		}
		
//		System.out.println(tempCount);
		
		while(tempCount != 0) {
			for(int i = tempCount/2; i<tempCount; i += 2) {
				if(i+1 == tempCount) {
					tempArr[i/2] = tempArr[i];
					break;
				}
				
				if(tempArr[i] < tempArr[i+1]) {
					tempArr[i/2] = tempArr[i+1];
				}
				else {
					tempArr[i/2] = tempArr[i];
				}
			}
			
			tempCount /= 2;
		}
		
/*		for(int i = 0; i < tempArr.length; i++) { 
			System.out.print(tempArr[i] + " ");
		}
*/
		
		int secondLargest = 0;
		int currIndex = 0;
		int largest = tempArr[currIndex];
		
		while(currIndex < tempArr.length/2) {
			if(tempArr[currIndex] == tempArr[2*currIndex+1]) {
				if(secondLargest < tempArr[2*currIndex+2])
					secondLargest = tempArr[2*currIndex+2];
				currIndex = 2 * currIndex + 1;
			}
			else {
				if(secondLargest < tempArr[2*currIndex+1])
					secondLargest = tempArr[2*currIndex+1];
				currIndex = 2 * currIndex + 2;
			}
		}
		
		if(tempArr[currIndex] == largest) {
			if(secondLargest < tempArr[currIndex+1])
				secondLargest = tempArr[currIndex+1];
		}
		else {
			if(secondLargest < tempArr[currIndex])
				secondLargest = tempArr[currIndex];
		}
		
		System.out.println("Second largest element is: " + secondLargest);
		
		sc.close();
	}

}