package DynamicProgrammingAndGreedy;

public class tileM1 {

	public static void printM1(int n , int m )
	{
		int dp [] = new int[n+1];
		for(int i = 1 ; i < dp.length ; i++)
		{
			if(i < m)
			{
				dp[i] = i;
			}
			else if(i == m)
			{
				dp[i] = 2;
			}
			else {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printM1(7,2);
	}

}
