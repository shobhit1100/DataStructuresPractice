package DynamicProgrammingAndGreedy;

public class PaintHouseManyColors {

	// in this problem we will first take the input same as it was initially for the first row.
	// Now , at this point of time , we will need to check the minimum of the row just above it. i.e for i it will be i-1th row.
	// first intuition is to use the nested loop approach and skipping the current index value from the i-1th row
	
	public static void paintHouses(int [][] arr)
	{
		
		// colours are represented by columns and the houses are represented by rows
		int dp[][] = new int[arr.length][arr[0].length];
		
		for(int j =0 ; j < dp[0].length ; j++)
		{
			dp[0][j] = arr[0][j];
		}
		
		for(int i = 1 ; i < dp.length; i ++)
		{
			for(int j = 0 ; j <dp[0].length ; j++)
			{
				int min = Integer.MAX_VALUE;
				for(int k = 0 ; k < dp[0].length ; k++)
				{
					if(k!=j)
					{
						if(min > dp[i-1][k])
						{
							min = dp[i-1][k];
						}
					}
						
				}
				dp[i][j] = arr[i][j] + min;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = dp[0].length-1 ; i>= 0 ; i--)
		{
			if(ans>dp[dp.length-1][i])
			{
				ans = dp[dp.length-1][i];
			}
		}
		System.out.println(ans);
	}
	
	// ********************************************************************************************************************
	
	// Now we are optimising the solution we had so far .
	// Instead of just finding the min in every iteration
	// we figured out that we need min of the i-1th row for the initial for calculation and in case if the vale of min 
	// is equal to the initial row same index value , then we can need another min i.e the second min.
	// Hence we will also maintain a second min as well.
	
	public static void minCostManyColors(int [][] arr)
	{
		int [][] dp = new int[arr.length][arr[0].length];
		int min = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;
		for(int j = 0 ; j < dp[0].length ; j++)
		{
			if(min > arr[0][j])
			{
				smin = min;
				min = arr[0][j];
			}
			else if(smin > arr[0][j])
			{
				smin = arr[0][j];
			}
			dp[0][j] = arr[0][j];
		}
		for(int i = 1 ; i < dp.length ; i++)
		{
			int nmin = Integer.MAX_VALUE;
			int nsmin = Integer.MAX_VALUE;
			for(int j = 0 ; j < dp[0].length ; j++)
			{
				if(arr[i-1][j] > min)
				{
					dp[i][j] = arr[i][j] + smin; 
				}
				else {
					dp[i][j] = arr[i][j] + min;
				}
				
				if(nmin > arr[i][j])
				{
					nsmin = nmin;
					nmin = arr[i][j];
				}
				else if(nsmin > arr[i][j])
				{
					nsmin = arr[i][j];
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
