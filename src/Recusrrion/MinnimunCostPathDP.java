package Recusrrion;
import java.util.*;
public class MinnimunCostPathDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int [3][3];
		
		int [][] dp = new int [3][3];

		for(int i = dp.length-1;i>=0 ; i--)
		{
			for(int j = dp[0].length ; j>= 0 ; j--)
			{
				if(i == dp.length-1 && j == dp.length-1)
				{
					dp[i][j] = arr[i][j];
				}
				else if(i == dp.length-1)
				{
					dp[i][j] = dp[i][j-1]+arr[i][j];
				}
				else if(j == dp[0].length-1)
				{
					dp[i][j] = dp[i-1][j]+arr[i][j];
				}
				else {
					dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j],dp[i][j+1]));
				}
			}
		}
		
		System.out.println(dp[0][0]);
		
	}

}
