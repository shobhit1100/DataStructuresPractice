package DynamicProgrammingAndGreedy;

public class TargetSumSubsetsDP {
	
	
	
	// In this recursion with back-tracking method 
	// we have passed a sos that will compare each and every subset for the target sum.
	// when the sum == 0 , then it will print , Otherwise it will return .
	// for each elemnt we have either included it or excluded it .
	// i.e for ist call -> (10+ other call) and (other calls)
	// 
	public static void targetSumSubsetUsingDP(int [] arr , int index , int sos , String set , int target)
	{
		if(index == arr.length)
		{
			if(sos == target)
			{
				System.out.println(set);
			}
		return;
		}
		
		targetSumSubsetUsingDP(arr, index+1, sos+arr[index], set+arr[index]+" ", target);
		targetSumSubsetUsingDP(arr, index+1, sos, set+"", target);
		
		return;
	}
	
	
	static int ways;
	 public static int targetSumSubsetUsingDP1(String str , int index  ,String sos, String target)
	    {
		 
	        if(str.length() == 0)
	        {
	        	 if(sos == target)
		            {
		        		System.out.println(sos);
		                ways = ways +1;
		            }
	        	 return 0;
	        }
	        
	       
	        
	        if(sos.equals(target))
	            {
	        		System.out.println(sos);
	                ways = ways +1;
	            }
	        for(int i = 0 ; i < str.length() ; i++)
	        {
	        	
	        	char ch = str.charAt(i);
	        	String fh = str.substring(0 ,i);
	        	String sh = str.substring(i);
	        	String rm = fh+sh;
	        targetSumSubsetUsingDP1(rm, index+1 ,sos+ch, target);
	        targetSumSubsetUsingDP1(rm, index+1 ,sos, target);
	        }
	        return ways;
	    }
	    
	
	//using the 2D array solution now
	public static void targetSumSubsets(int [] arr, int tar)
	{
		boolean dp[][] = new boolean[arr.length+1][tar+1];
		for(int i = 0 ; i < dp.length ; i++)
		{
//			String str ="";
			for(int j = 0 ; j < dp[0].length ; j++)
			{
				
				if(i == 0 && j == 0)
				{
					dp[i][j] = true;
				}
				else if(i == 0)
				{
					dp[i][j] = false;
				}
				else if(j == 0)
				{
					dp[i][j] = true;
				}
				else {
					if(dp[i-1][j] == true)
					{
						dp[i][j] = true;
					}
					else {
						int val = arr[i-1];
						if(j>=val && dp[i][j-val] == true)
						{
							dp[i][j] = true;
						}
					}
				}
			}
//			System.out.println(str);
//			str = "";
		}
		System.out.println(dp[arr.length][tar]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ways = 0;
		int [] arr = {10,20,30,40,50,60,70,25,25};
		targetSumSubsetUsingDP(arr, 0, 0, "",50);
		targetSumSubsets(arr,50);
		System.out.println( targetSumSubsetUsingDP1("cccc",0,"","ccc"));	
	}
}