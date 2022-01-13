package DynamicProgrammingAndGreedy;

public class ClimbStairsWithVariablePaths {

	
	// Since the paths are variable so in this question we will use two technique first is memoization.
	// But here also we will be using the loop to first get each path and then for each path we will call the function.
	// In this way each array index is traversed
	//####### loop will be made only this the index of the array #####################
	// because if the ist index is 0 the there will be no jump and hence there will be no path.
	public static int climbStairsVariablePathMemoization(int [] arr , int index , int  length)
	{
		if(index == length)
		{
			return 1;
		}
		
		int count = 0;
		
		for(int  jump = 1 ; jump <= arr[index] ; jump++)
		{
			if((jump + index) <= length)
			{
				count += climbStairsVariablePathMemoization(arr, index+jump, length);
			}
			else {
				break;
			} 
		}
		return count;
	}
	
	// using DP
	public static int getVariablePathUsingDP(int [] arr ,int index , int length, int [] dp)
	{
		if(index == length)
		{
			return 1;
		}
		
		if(dp[index] != 0)
		{
			return dp[index];
		}
		
		int counter = 0;
		for(int jump = 1 ; jump<=arr[index] ; jump++)
		{
			if((jump+index) <= length)
			{
				counter += getVariablePathUsingDP(arr, index+jump, length, dp);
			}
			else {
				break;
			}
		}
		dp[index] = counter; 
		return counter;
	}
	
	// with Tabulation
	//storage at nth index of DP and meaning is that at a particular index it stored he number of paths to climb the stairs from the particular path or index.
	// started with right to left direction
	// traversed and solved
	public static void climbStrairsWithTabilation(int [] arr,int index,int n)
	{
		int [] dp = new int[arr.length+1];
		dp[n] = 1;
		for(int i = arr.length-1; i>=0 ; i--)
		{
			for(int j = 1 ; j<=arr[i] && i+j < dp.length ; j++)
			{
				dp[i] +=dp[i+j]; 
			}
		}
		System.out.println(dp[0]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,4,1,0,2,3};
		System.out.println(climbStairsVariablePathMemoization(arr, 0, arr.length));
		System.out.println(getVariablePathUsingDP(arr, 0, arr.length, new int[arr.length+1]));
		climbStrairsWithTabilation(arr, 0, arr.length);
	}
}
