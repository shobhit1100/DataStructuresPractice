package DPandGreedyPractice;

public class CoinCombinationDP {

	// coin change means coins loop will be first. 
	// And inner loop will be for the dp.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {2,3,5,7};
		int target = 7;
		int [] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = arr[i] ; j<dp.length ; j++)
			{
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[target]);
	}

}
