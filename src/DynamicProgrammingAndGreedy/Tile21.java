package DynamicProgrammingAndGreedy;

public class Tile21 {

	public static void setM1tile(int n)
	{
		int [] dp = new int[n+1];
		// dp[i] will store the number of ways in which the tiles can be fit in the floor for ith lenght floor .
		// tile size -> 2*1
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3 ; i < dp.length ; i++)
		{
			dp[i] = dp[i-2]+dp[i-1];
		}
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// calling the function for length 7
		setM1tile(7);
	}

}
