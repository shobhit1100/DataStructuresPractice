package DynamicProgrammingAndGreedy;
import java.util.*;
public class MinCostMazeTraversal {

	// used DP to solve this question 
	// created an array and calculated the cost of traversing the maze from last cell to the top cell.
	// moves allowed are vertical (V) and horizontal (H).
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] maze  = new int [5][5];
		
		Scanner scn = new Scanner(System.in);
		for(int i = 0 ; i < 5 ; i++)
		{
			for(int j = 0 ; j < 5 ; j++)
			{
				maze[i][j] = scn.nextInt();
			}
		}
		
		int [][]mazedp = new int[5][5];
		
		for(int row = mazedp.length-1 ; row>=0 ; row--)
		{

			for(int column = mazedp[0].length-1 ;column>=0;column--)
			{
				if(row == maze.length-1 && column == maze[0].length-1)
				{
					mazedp[row][column] = maze[row][column];
				}
				else if(row == maze.length-1)
				{
					mazedp[row][column] = maze[row][column]+mazedp[row][column+1];
				}
				else if(column == maze[0].length-1)
				{
					mazedp[row][column] = mazedp[row+1][column] +maze[row][column];
				}
				else {
					System.out.println(row+1);
					System.out.println(column+1);
					mazedp[row][column] = Math.min(mazedp[row+1][column],mazedp[row][column+1])+maze[row][column];
				}
			}
		}
		
		System.out.println(mazedp[0][0]);
		
		scn.close(); 
	}

}
