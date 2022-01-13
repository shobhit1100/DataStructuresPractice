package Recusrrion;
import java.util.*;
public class PrintMazePathsWithJump {

	public static void Maze_with_Jumps(int [][] arr , int sr , int sc , int dr , int dc , String path)
	{
		if(sr>dc || sc>dc)
		{
			return;
		}
		if(sr == dr && sc == dc)
		{
			System.out.println(path);
		}
		
		for(int move = 1 ; move <= dc-sc ; move++)
		{
			Maze_with_Jumps(arr, sr, sc+move, dr, dc, path+move+ " ");
		}
		
		for(int move = 1 ; move <= dr - sr ; move++)
		{
			Maze_with_Jumps(arr, sr+move, sc, dr, dc, path+move+ " ");
		}
		
		for(int move = 1 ; move <= dc-sc && move<dr-sr ; move++)
		{
			Maze_with_Jumps(arr, sr+move, sc+move, dr, dc, path+move+ " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[3][3];
		//Maze_with_Jumps(arr, 0, 0, arr.length, arr[0].length, "");
		printMazePaths(0, 0, arr.length, arr[0].length,"");
	}
	
	
	 public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

		    if (sr == dr && sc == dc) {
		      System.out.println(psf);
		      return;
		    }

		    for (int move = 1; move <= dc - sc; move++) {
		      printMazePaths(sr, sc + move, dr, dc, psf + "h" + move);
		    }

		    for (int move = 1; move <= dr - sr; move++) {
		      printMazePaths(sr + move, sc, dr, dc, psf + "v" + move);
		    }

		    for (int move = 1; move <= dc - sc && move <= dr - sr; move++) {
		      printMazePaths(sr + move, sc + move, dr, dc, psf + "d" + move);
		    }
		  }

}
