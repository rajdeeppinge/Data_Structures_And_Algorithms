package q1_binary_search;

public class BinarySearch_Recursive {
	
	public int search(int[] arr, int lowerIndex, int upperIndex, int element) {
		if(lowerIndex > upperIndex) {
			return -1;
		}
		int mid = (lowerIndex + upperIndex) / 2;
		if(arr[mid] == element) {
			return mid;
		}
		else if(arr[mid] < element) {
			return search(arr, mid+1, upperIndex, element);
		}
		else {
			return search(arr, lowerIndex, mid-1, element);
		}
	}
}
