package advancedQ3andQ4;

import java.util.Scanner;

public class Main_Q4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		
		System.out.println("Enter elements of array");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] minArr = new int[(size+1)/2];
		int[] maxArr = new int[(size+1)/2];
		int count = 0;
		
		for(int i = 0; i<size; i += 2) {
			if(i+1 == size) {
				minArr[count] = arr[i];		//putting last element in both since we don't know if it is minimum or maximum
				maxArr[count] = arr[i];
				count++;
				break;
			}
			
			if(arr[i] < arr[i+1]) {
				minArr[count] = arr[i];
				maxArr[count] = arr[i+1];
			}
			else {
				minArr[count] = arr[i+1];
				maxArr[count] = arr[i];
			}
			count++;
		}
		
		int min = minArr[0];
		int max = maxArr[0];
		
		for(int i = 1; i < count; i++) {
			if(minArr[i] < min) {
				min = minArr[i];
			}
			
			if(maxArr[i] > max) {
				max = maxArr[i];
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.print(minArr[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < count; i++) {
			System.out.print(maxArr[i] + " ");
		}
		System.out.println();
		
		System.out.println("Minimum element = " + min + "\n" + "Maximum element = " + max);
		
		sc.close();
	}

}
