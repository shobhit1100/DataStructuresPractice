package DynamicProgrammingAndGreedy;
import java.util.*;
public class PaintHouse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int nc = 3;
		int nh = 4;
		int [][] arr = new int[nh][nc];
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j<arr[0].length ; j++)
			{
				arr[i][j] = scn.nextInt();
			}
		}
		int [][] dp = new int[nh][nc];
		dp[0][0] =arr[0][0];
		dp[0][1] =arr[0][1];
		dp[0][2] =arr[0][2];
		for(int i = 1 ; i < dp.length ; i++)
		{
			dp[i][0] = arr[i][0]+ Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2] = arr[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
		}
		System.out.println(Math.min(dp[nh-1][0],Math.min(dp[nh-1][1],dp[nh-1][2])));
		scn.close();
	}

}
