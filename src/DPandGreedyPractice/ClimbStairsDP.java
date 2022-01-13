package DPandGreedyPractice;

public class ClimbStairsDP {

	
	// program for the climbing up the stairs and getting down the stairs will remain same.
	// because the number of steps taken to climb the stairs will be the same to get down from the stairs.
	
	// First solution without the use of DP
	public static int climbStairs(int n)
	{
		if(n<=0)
		{
			if(n == 0)
			{
				return 1;
			}
			return 0;
		}
		int path1 = climbStairs(n-1);
		int path2 = climbStairs(n-2);
		int path3 = climbStairs(n-3);
		int path = path1+path2+path3;
		return path;
	}
	
	// Time Complexity -> O(3^n)
	// Space Complexity -> O(1)
	
	// Second solution with the use of DP
	// technique used is memoization -> to remeber the answer of older paths.
	public static int climbStairsWithDP(int n , int [] dp)
	{
		if(n <= 0)
		{
			if(n == 0)
			{
				return 1;
			}
			return 0;
		}
		if(dp[n] != 0)
		{
			return dp[n];
		}
		int path1 = climbStairsWithDP(n-1,dp);
		int path2 = climbStairsWithDP(n-2,dp);
		int path3 = climbStairsWithDP(n-3,dp);
		int path = path1+path2+path3;
		dp[n] = path;
		return path;
	}
	
	// TimeComplexity -> O(n)
	// Space Complexity -> O(1)
	
	// third method using Tabulation
	
	//3 steps -> 1.Storge and meaning 2. Direction Identification 3. Traverse and solve
	public static void climbStairsWithTabulation(int n)
	{
		 int [] dp = new int[n+1];
		 // we will assign the number of paths at each index in an array .
		 // we will start from left to right and at 0th position we will store the ways of going from 0 to 0 i.e 1.
		 dp[0] = 1;
		 // now we will traverse and solve
		 // from right i.e 0 to n an will add n-1 , n-2 and n-3;
		 for(int i = 1 ; i<=n ; i++ )
		 {
			 if(i == 1)
			 {
				 dp[i] = dp[i-1];
			 }
			 else if(i == 2)
			 {
				 dp[i] = dp[i-1]+dp[i-2];
			 }
			 else {
				 dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			 }
		 }
		 
		 System.out.println(dp[n]);
	}
	
	// get down from the stairs
	public static void getDownFromStairs(int n)
	{
		int [] dp = new int[n+1];
		dp[n] = 1;
		for(int i = n-1 ; i>=0 ; i--)
		{
			if(i == n-1)
			{
				dp[i] = dp[i+1];
			}
			else if(i == n-2)
			{
				dp[i] = dp[i+1]+dp[i+2];
			}
			else {
				dp[i] = dp[i+1]+dp[i+2]+dp[i+3];
			}
		}
		
		System.out.println(dp[0]);
	
	}
	// Time Complexity -> O(n)
	// Space Complexity -> O(1)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(5)); // call for without DP
		System.out.println(climbStairsWithDP(5,new int[6])); // call with the DP
		climbStairsWithTabulation(5); // the catch point is that while climbing up you are moving from left to right so you subtract the paths i.e 1 , 2 , 3 from the index.
		getDownFromStairs(5);// the catch point is that while getting down you are from from right to left so you add the 1,2,3 i.e steps in index
	}

}
