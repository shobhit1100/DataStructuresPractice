package AmazonPracticeTest;

public class KadanceAlgotihm {

	
	// this algorithm is used to find largest sum of contigous subarrays
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {-2,-3,4,-1,-2,1,5,-3};
		int maxSoFar  = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			maxEndingHere += arr[i];
			if(maxEndingHere > maxSoFar)
			{
				maxSoFar = maxEndingHere;
			}
			if(maxEndingHere < 0)
			{
				maxEndingHere = 0;
			}
		}
		System.out.println(maxSoFar);
	}

}
