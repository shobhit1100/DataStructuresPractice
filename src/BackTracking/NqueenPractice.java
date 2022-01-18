package BackTracking;

public class NqueenPractice {

	public static boolean isQueenSafe(int [][] arr, int sr , int sc)
	{
		for(int i = sr-1 , j = sc; i >= 0 ; i--)
		{
			if(arr[i][j] == 1)
			{
				return false;
			}
		}
		
		for(int i = sr-1 ,j = sc-1 ; i >=0 && j >=0 ; i-- , j--)
		{
			if(arr[i][j] == 1)
			{
				return false;
			}
		}
		
		for(int i = sr-1 , j = sc+1 ; i >=0 && j <arr.length ; i-- ,j++)
		{
			if(arr[i][j] == 1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void PrintNQueens(int [][] arr , String qsf , int row)
	{
		if(row == arr.length)
		{
			System.out.println(qsf);
		}
		
		for(int col = 0 ; col < arr.length ; col++)
		{
			if(arr[row][col] == 0 && isQueenSafe(arr, row, col))
			{
				arr[row][col] = 1;
				PrintNQueens(arr, qsf + row +"-"+ col, row+1);
				arr[row][col] = 0;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
