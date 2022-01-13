package Recusrrion;

public class PrintStairsPaths {

	public static void printPaths(int n , String path)
	{
		if(n<=0)
		{
			if(n == 0 )
			{
				System.out.println(path);
			}
			return;
		}
		
		printPaths(n-1,path+1+" ");
		printPaths(n-2,path+2+" ");
		printPaths(n-3,path+3+" "); 
		
		
	}
	// DP for stairs paths
	public static String printPathsDP(int n , String path,String [] dp)
	{
		if(n<=0)
		{
			if(n == 0 )
			{
				System.out.println(path);
			}
			return null;
		}
		
		if(dp[n] != null)
		{
			return dp[n];
		}
		
		printPaths(n-1,path+1+" ");
		printPaths(n-2,path+2+" ");
		printPaths(n-3,path+3+" ");
		
		dp[n] = path;
		return path;
	}
	
//	public static void printPathsMemoization(int n)
//	{
//		String [] pathres = new String[n+1];
//		
//		pathres[0] = "1";
//		
//		for(int i = 1 ; i <= n ; i++)
//		{
//			if(i == 1)
//			{
//				pathres[i] += pathres[i-1];
//			}
//			else if(i == 2)
//			{
//				pathres[i] += pathres[i-2]+"2";
//			}
//			else {
//				pathres[i] += pathres[i-3]+"3";
//			}
//		}
//		
//		System.out.println(pathres[n]);
//		
//	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPaths(5,"");
		
		System.out.println("Dp");
		printPathsDP(5,"",new String[6]);
	}
}
