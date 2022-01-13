package DPandGreedyPractice;

public class ZeroOneKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] wts = {};
		int [] vals = {};
		int target = 7;
		int [][] dp = new int [wts.length+1][target+1];
		for(int i = 1 ; i<wts.length ; i++)
		{
			
			for(int j = 1 ; j<dp[0].length ; j++)
			{
				if(j >= wts[i-1])
				{
					dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j-wts[i-1]]+vals[i-1]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[wts.length][target]);
	}

}
