package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class GoldMineDPProblem {

	// calculate the maximum amount of the goldmine problem.
	public static void calculateMaxAmountGoldMine(int [][] arr)
	{
		
		int [][] dp = new int[arr.length][arr[0].length];
		
		if(arr.length<=0 && arr[0].length<=0)
		{
			System.out.println("Please enter the amounts of each cell");
		}
		
		for(int j = arr[0].length-1 ; j>=0 ; j--)
		{
			for(int i = 0 ; i < arr.length ; i++)
			{
				if(j == arr[0].length-1) // last column and all rows
				{
					dp[i][j] = arr[i][j];
				}
				else if(i == arr.length-1) // last row and column with 0 to arr[0].length-2 -> Max( right side cell of dp and diagonal up cell of dp ) 
				{
					dp[i][j] = arr[i][j]+Math.max(dp[i][j+1], dp[i-1][j+1]);
				}
				else if(i == 0) // first row and column from o to arr[0].length-2 -> max (right cell and diagonally below cell of dp)
				{
					dp[i][j] = arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
				}
				else 
				{
					dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1],Math.max(dp[i][j+1], dp[1+1][j+1]));
				}
			}
		}
		
		int max_amount = Integer.MIN_VALUE;
		for(int j = 0 ; j<dp[0].length ; j++)
		{
			if(max_amount<dp[0][j])
			{
				max_amount = dp[0][j];
			}
		}
		
		System.out.println(max_amount);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int [][] arr = new int[5][5];
		for(int i = 0 ; i < 5 ; i++)
		{
			for(int j = 0 ; j < 5 ; j++)
			{
				arr[i][j] = scn.nextInt();
			}
		}
		calculateMaxAmountGoldMine(arr);
		scn.close();

	}

}
