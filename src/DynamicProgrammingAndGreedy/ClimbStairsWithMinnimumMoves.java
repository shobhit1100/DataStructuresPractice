package DynamicProgrammingAndGreedy;

public class ClimbStairsWithMinnimumMoves {
	
	// in this question we are climbing the stairs under minimum moves with the variable jumps at each index of the stairs.
	//so we identified that the smaller problem is on the right side of the dp . i.e the minimum steps to reach the top of the stairs from the top step is 0.
	// Now we iterate from the last index of the array 
	// and created a nested jump array inside the array iteration loop.
	// i.e for the 5th index if we jump 1 , i.e 1+5 = 6 which satisfies the condition -> less than and equal to the height of the array
	// then we have taken the min of the arr[i+j] and min variable ->(# Note : assign the Integer.MAX_VALUE to the min as its identitiy)
	// after the condition check of the min != Integer.Max_Value then we have got the minnmum paths and add 1 to it . i.e our ongoing path from 
	// source index to destination index.
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int [] arr = {2,4,1,0,2,3};
		Integer [] dp = new Integer[arr.length+1];
		dp[arr.length] = 0;

		for(int i = arr.length-1 ; i>=0 ; i--)
		{
			if(arr[i]>0)
			{
				int min = Integer.MAX_VALUE;
				for(int j = 1 ; j <= arr[i] && i+j<=arr.length;j++)
				{
					if(dp[i+j] != null)
					{
						min = Math.min(min, dp[i+j]);
					}
				}
				if(min != Integer.MAX_VALUE)
				{
					dp[i] = min+1;
				}
			}
		}
		System.out.println(dp[0]);
	}
	
	// Time complexity -> O(n*m) where n = number of the elements in the array of steps and m = number of jumps allowed.
	// Spce Complexity -> O(1).
}
