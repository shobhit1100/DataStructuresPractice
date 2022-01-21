package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class MaximumSumNonAdjacentElement {
 // maximum sum of non adjacent elements using include exclude approach but with the class
// Intuition was to find the string while including and excluding a string .
// time complexity -> O(n);
// space complexity -> O(2n) that is O(n) ;
	public static class incexc{
		String string;
		int sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {5,10,10,100,5};
		
		incexc [][] dp = new incexc[2][arr.length];
		
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			dp[0][i] = new incexc();
			dp[1][i] = new incexc();
		}
		
		dp[0][0].sum = arr[0];
		dp[0][0].string = arr[0]+"";
		dp[1][0].sum = 0;
		dp[1][0].string = "";
		
		for(int i = 1 ; i < arr.length ; i++)
		{
			dp[0][i].sum += dp[1][i-1].sum + arr[i];
			dp[0][i].string += dp[1][i-1].string == null?arr[i]+"": dp[1][i-1].string+arr[i] +" ";
			
			// for exclude we are finding the maximum
			incexc temp = new incexc();
			if(dp[0][i-1].sum > dp[1][i-1].sum)
			{
				temp.sum = dp[0][i-1].sum;
				temp.string = dp[0][i-1].string;
			}
			else {
				temp.sum = dp[1][i-1].sum;
				temp.string = dp[1][i-1].string;
			}
			
			// now assigning the maximum to the  
			
			dp[1][i].sum = temp.sum;
			dp[1][i].string += temp.string+"";
		}
		
		if(dp[0][arr.length-1].sum > dp[1][arr.length-1].sum)
		{
			String ans = dp[0][arr.length-1].string.replaceAll("null", "");
			System.out.println(ans);
			System.out.println(dp[0][arr.length-1].sum);
		}
		else {
			String ans = dp[1][arr.length-1].string.replaceAll("null", "");
			System.out.println(ans);
			System.out.println(dp[1][arr.length-1].sum);
		}
//		System.out.println("<----------------------The First row values ------------------->");
//		System.out.println(dp[0][arr.length-1].string);
//		System.out.println(dp[0][arr.length-1].sum);
//		System.out.println("<----------------------The second row values ------------------->");
//		System.out.println(dp[1][arr.length-1].string);
//		System.out.println(dp[1][arr.length-1].sum);
		
//		int inc = arr[0];
//		int exc = 0;
//		for(int i = 1 ; i < arr.length ; i++)
//		{
//			int temp = inc;
//			inc = arr[i]+exc;
//			exc = Math.max(exc, temp);
//		}
//		
//		System.out.println(Math.max(inc,exc));
//
	}

}
