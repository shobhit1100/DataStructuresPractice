package DynamicProgrammingAndGreedy;
import java.util.*;
public class UnboundedKnapsack {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] wts = new int[n];
		int [] vals = new int[n];
		for(int i = 0 ; i<n ;i++)
		{
			wts[i] = scn.nextInt();
		}
		for(int i = 0 ; i<n ;i++)
		{
			vals[i] = scn.nextInt();
		}
		int capacity = scn.nextInt();
		int [] dp = new int[capacity+1];
		dp[0] = 0;
		for(int i = 1 ; i<dp.length ; i++)
		{
			int max = 0;
			for(int j = 0 ; j < wts.length ; j++)
			{
				if(i >= wts[j])
				{
					int remcap = i - wts[j];
					int rbval = dp[remcap];
					int tbagval = rbval + vals[j];
					if(max<tbagval)
					{
						max =  tbagval;
					}  
					
//					int tbagval = dp[j-wts[i]] + vals[j];
//					if(max<tbagval)
//					max =  Math.max(max,tbagval );  
				}
			}
			dp[i] = max;
		}
		System.out.println(dp[capacity]);
	}
}

//input :
//	5
//	2
//	5
//	1
//	3
//	4
//	15
//	14
//	10
//	45
//	30
//	7
