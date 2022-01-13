package DynamicProgrammingAndGreedy;

public class FibonacciDP {

	public static int fibonacci(int n , int[] dp)
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		
		if(dp[n] != 0)
		{
			return dp[n];
		}
		
		int fib1 = fibonacci(n-1,dp);
		int fib2 = fibonacci(n-2,dp);
		int fib = fib1+fib2;
		dp[n] = fib;
		
		return fib;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int dp [] = new int[11];
		System.out.println(fibonacci(n,dp));
		
	}

}
