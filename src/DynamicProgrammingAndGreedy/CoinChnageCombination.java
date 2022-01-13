package DynamicProgrammingAndGreedy;

public class CoinChnageCombination {

	
	// in combination the number of coins loop was kept outside.
	// the inner loop was for the dp , the size of the dp will be the the size of Target+1
	// the loop will iterate and ensure the the effect of two will come only once i.e the effect of one element should come only once in the array of dp
	// the value at the 0th index of dp is 1 . because for 0 rupees there is 1 combination i.e do not take/choose any coin.
	
	
	// ########### combination -> coins first -> pd last
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {3,2,3,5};
		int target = 7;
		int [] dp = new int [target+1];
		dp[0] = 1;
		for(int i = 1 ; i<arr.length ; i++)
		{
			for(int j = arr[i] ; j <= target ; j++)
			{
				dp[j] += dp[j-arr[i]];
			}
		}
		System.out.println(dp[target]);
		
	}

}
