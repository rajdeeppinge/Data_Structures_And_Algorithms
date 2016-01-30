package q1_binary_search;

public class BinarySearch_Iterative {
	
	public int search(int[] arr, int lowerIndex, int upperIndex, int element) {
		while(lowerIndex <= upperIndex) {
			int mid = (lowerIndex + upperIndex) / 2;
			if(arr[mid] == element) {
				return mid;
			}
			else if(arr[mid] > element) {
				upperIndex = mid - 1;
			}
			else {
				lowerIndex = mid + 1;
			}
		}			
		return -1;
	}
}
