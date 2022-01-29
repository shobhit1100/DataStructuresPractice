package AmazonPracticeTest;

public class EditDistance {

	// Edit distance is the problem of converting into another string
	// Now the question is how ?
	// well the answer is pretty simple but very interesting
	// let us assume a 2D array with the string to be converted as the columns
	// the string in which we have to convert as the rows
	// now let us assume that for the first character of the rows the count of conversion will be i++ every time
	// so it will be increasing every time
	// now for the next row , if the data are same, then copy the diagonal vale
	// else take the min of i-1 , j || i-1,j-1 || i,j-1 and add 1 becase one more step has to be done 
	// in this way we will travel for all the cells in the DP
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "abcdef";
		String str2 = "acdef";
		// Initailising a dp array
		int [][] dp = new int[str2.length()+1][str1.length()+1];
		for(int i = 1 ; i < dp.length ; i++)
		{
			for(int j = 1 ; j < dp[0].length ; j++)
			{
				if(str2.charAt(i-1) == str1.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j] , dp[i-1][j-1]))+1;
				}
			}
		}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
	}

}
