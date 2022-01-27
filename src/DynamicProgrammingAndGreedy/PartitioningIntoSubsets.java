package DynamicProgrammingAndGreedy;

public class PartitioningIntoSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// In this program we have to divide the number of people n into the given subsets i.e k
		// So , n - >  number of people
		// and k -> number of subsets
		// Interesting thing to note is that the number of subsets can take the maximum valuse as the nu mber of people
		// why ? because we can not divide the  people in n+1 subsets.
		int n = 4;
		int k = 2;
		int dp[][] = new int[k+1][n+1];
		for(int ks = 1 ; ks < dp.length ; ks++)
		{
			for(int ip = 1 ; ip < dp[0].length ; ip++)
			{
				if(ip == ks)
				{
					dp[ks][ip] = 1;
				}
				else if(ip>ks)
				{
					dp[ks][ip] = dp[ks][ip-1]*ks + dp[ks-1][ip-1];
				}
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}

}
