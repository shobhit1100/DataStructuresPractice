package BackTracking;
import java.util.*;
public class NQueens {

	public static void nQueens(int [][] arr , String qsf , int row)
	{
		
		if(row == arr.length)
		{
			System.out.println(qsf);
			return;
		}
		
		for(int i = 0 ; i < arr[0].length ; i++)
		{
			arr[row][i] = 1;
			nQueens(arr , qsf + row +"-" + i + " , " , row+1);
			arr[row][i] = 0;
		}
	}
	
	public static boolean isQueenSafe(int [][] arr , int row , int col)
	{
		for(int i = row-1, j = col-1 ; i>=0 && j>=0  ; i--,j--)
		{
			if(arr[i][j] == 1)
			{
				return false;
			}
		}
		
		for(int i = row-1 ; i>= 0 ; i--)
		{
			if(arr[i][col] == 1)
			{
				return false;
			}
		}
		
		for(int i = row-1 , j = col+1 ; i >= 0 && j <= arr.length ; i-- , j++ )
		{
			if(arr[i][j] == 1)
			{
				return false;
			}
		}
		for(int i = row , j = col-1 ; j>=0 ; i++)
		{
			if(arr[i][j] == 1)
			{
				return true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[2][2];
		nQueens(arr,"",0);
	}

}
