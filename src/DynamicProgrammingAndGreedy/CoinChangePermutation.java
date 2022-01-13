package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class CoinChangePermutation {
		
	
	
	
	// in permutation -> all the coins were needed tp be tested for each index of the dp multiple times.
	// Therefore , the dp array will be outside.
	// And the coins array will be inside.
	// dp[0] = 1 because only one way of getting the sum 0 i.e by not giving and not taking any coins from the array.
	public static void main(String[] args) {
		int [] arr = {2,3,5,6};
		int target = 10;
		int [] dp = new int[target+1];
		dp[0] = 1;
		for(int i = 1 ; i < dp.length ; i++)
		{
			for(int coins : arr)
			{
				if(i>=coins)
				{
				int rem = i-coins;
				dp[i] += dp[rem];
				}
			}
		}
		System.out.println(dp[target]);
	}
}
