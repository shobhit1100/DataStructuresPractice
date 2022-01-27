package DynamicProgrammingAndGreedy;

public class friedsPairng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// we are given with the number of friends 
		// we have to tell the nummber of friends in which these friends can pair up
		
		int n = 3;
		
		int dp[] = new int[n+1];
		dp[1] = 1;
		for(int i = 2 ; i < dp.length ; i++)
		{
			dp[i] = dp[i-1] + dp[i-2]*(i-1);
		}
		System.out.println(dp[n]);
	}

}
