package DPandGreedyPractice;

public class fibonacciDP {

	// Without dp
	public static int fibonacciWithoutDP(int n)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		
		int fib1 = fibonacciWithoutDP(n-1);
		int fib2 = fibonacciWithoutDP(n-2);
		int fib = fib1+fib2;
		return fib;
	}
	// Time complexity -> O(2^n)
	// Space complexity -> O(1)
	
	// With DP

	public static int fibonacciWithDP(int n , int [] dp)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		
		if(dp[n] != 0)
		{
			return dp[n];
		}
		
		int fib1 = fibonacciWithDP(n-1, dp);
		int fib2 = fibonacciWithDP(n-2, dp);
		int fib = fib1+fib2;
		dp[n] = fib;
		return fib;
	}
	
	// Time Complexity -> O(n)
	// Space Complexity -> O(1)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacciWithoutDP(10)); // (<- without dp call)
		System.out.println(fibonacciWithDP(10,new int[11])); // (<- with dp call)
	}

}
