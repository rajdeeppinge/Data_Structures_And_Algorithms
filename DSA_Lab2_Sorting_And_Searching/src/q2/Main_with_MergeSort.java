package q2;

import java.util.Scanner;

public class Main_with_MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter maximum size of array");
		int size = sc.nextInt();
		
		System.out.println("Enter all the elements of array");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		merge_sort(arr, 0, size-1);
		
		for(int i = 0; i < size; i++) { 
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	public static void merge_sort(int[] arr, int left, int right) {
		if(right <= left) {
			return;
		}
		int mid = (int)Math.floor((left+right)/2);
		merge_sort(arr, left, mid);
		merge_sort(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int ptr1 = left;
		int ptr2 = mid+1;
		int ptr = 0;			//pointer used when one of the subarrays has been 
							//copied completely and we want to copy other but 
							//don't know which has been copied successfully.		
		
		int[] temp = new int[right-left+1];
		int tempptr = 0;
		
		while(ptr1 <= mid && ptr2 <= right) {
			if(arr[ptr1] < arr[ptr2]) {
				temp[tempptr] = arr[ptr1];
				ptr1++;
			}
			else {
				temp[tempptr] = arr[ptr2];
				ptr2++;
			}
			tempptr++;
		}
		
		if(ptr1 > mid) {
			ptr = ptr2;
		}
		else {
			ptr = ptr1;
		}
		
		while(tempptr <= right-left) {
			temp[tempptr] = arr[ptr];
			tempptr++;
			ptr++;
		}	
		
		for(int i = 0; i < temp.length; i++) {
			arr[left++] = temp[i];
		}
	}
}
