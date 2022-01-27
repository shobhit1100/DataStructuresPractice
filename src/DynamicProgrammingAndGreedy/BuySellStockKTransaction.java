package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class BuySellStockKTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner scn = new Scanner(System.in);
	int k= scn.nextInt();
	int n = scn.nextInt();
	int [] arr = new int[n];
	for(int i = 0 ; i < n ; i++)
	{
		arr[i] = scn.nextInt();
	}
		
	int [][] dp = new int[k+1][n+1];
	
	for(int t = 1; t <= k ; t++ )
	{
		for(int d = 1; d <=n ; d++)
		{
			int min = dp[t][d-1];
			for(int j = 0 ; j < d ; j++)
			{
				if((dp[t-1][j]+d-j) > min)
				{
					min = (dp[t-1][j]+d-j);
				}
			}
			
		}
	}
	
	}

}
