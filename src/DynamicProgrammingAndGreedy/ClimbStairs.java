package DynamicProgrammingAndGreedy;

public class ClimbStairs {

	public static int path(int n , int [] dp)
	{
		if(n == 0)
		{
			return 1;
		}
		if(n<0)
		{
			return 0;
		}
		
		if(dp[n] != 0 )
		{
			return dp[n];
		}
		
		int path1 = path(n-1,dp);
		int path2 = path(n-2,dp);
		int path3 = path(n-3,dp);
		int tpath = path1+path2+path3;
		dp[n] = tpath;
		return tpath;
	}
	
	public static int pathMemoization(int n)
	{
		int [] dp = new int[n+1];
		dp[0] = 1;
		for(int i = 1 ; i <= n ; i++)
		{
			if(i == 1)
			{
				dp[i] = dp[i-1];
			}
			else if(i ==2)
			{
				dp[i] = dp[i-1]+dp[i-2];
			}
			else {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.out.println(path(5,new int[6]));
		System.out.println(pathMemoization(5));

	}

}
