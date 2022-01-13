package DynamicProgrammingAndGreedy;
import java.util.*;
public class ZeroOneKnapsack {

	// this is assumes as a onde day match team selection
	// in test match team selection problem if the upper team has made the run then we take true directly
	// if the are not able to do it then we need to take part and make the runs again by ourselves.
	// but here it is very different 
	// here we take the maximum of the run made by the earlier team and the rums make by the team by the balls left if he will play the match
	// In this way we need to ensure that at any given point of time a slow player should not enter inside the team.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] wts = new int[n];
		int [] vals = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			wts[i] = scn.nextInt();
		}
		for(int i = 0 ; i < n ; i++)
		{
			vals[i] = scn.nextInt();
		}
		int capacity = scn.nextInt();
		int [][] dp = new int[n+1][capacity+1];
		for(int i = 1 ; i<dp.length ; i++)
		{
			for(int j = 1 ; j<dp[0].length ; j++)
			{
				if(j>=wts[i-1]) 
				{
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-wts[i-1]]+ vals[i-1]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][capacity]);
		scn.close();
	}

}
