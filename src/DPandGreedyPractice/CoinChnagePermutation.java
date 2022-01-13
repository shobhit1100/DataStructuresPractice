package DPandGreedyPractice;

public class CoinChnagePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,5,7};
		int target = 7;
		int [] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 1 ; i<dp.length ; i++)
		{
			for(int coins : arr)
			{
				if(i >= coins)
				{
					dp[i] += dp[i-coins];
				}
			}
		}
		System.out.println(dp[target]);
	}

}
