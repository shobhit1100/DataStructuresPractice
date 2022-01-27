package AmazonPracticeTest;

import java.util.Arrays;

public class KthLargestElementFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,4,5,6,7,8,3,3,22,4444,6565,78,990,1000};
		int k = 4;
		Arrays.sort(arr);
		System.out.println(arr[arr.length-k]);
	}

}
