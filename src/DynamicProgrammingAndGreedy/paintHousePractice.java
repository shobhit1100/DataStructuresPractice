package DynamicProgrammingAndGreedy;

public class paintHousePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] colors = {{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
		
		int [][] dp = new int[colors.length][colors[0].length];
		
		dp[0][0] = colors[0][0];
		dp[0][1] = colors[0][1];
		dp[0][2] = colors[0][2];
		
		for(int i = 1 ; i<colors.length ; i++)
		{
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + colors[i][0];
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + colors[i][1];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][0]) + colors[i][2];
		}
		int min = Integer.MAX_VALUE;
		for(int j = 0 ; j < colors[0].length ; j++)
		{
			if(min > dp[dp.length-1][j])
			{
				min = dp[dp.length-1][j];
			}
		}
		
		System.out.println(min);
	}

}
