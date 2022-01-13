package BackTracking;
import java.util.*;
public class FloodFill {

	public static void floodFillFunctionHelper(int [][] arr, int sr, int sc, String asf , boolean [][] visited)
	{
		if(sr<0 || sc<0 || sr>arr.length || sr>arr[0].length || arr[sr][sc] == 1 || visited[sr][sc] == true)
		{
			return;
		}
		
		if(sr == arr.length-1 && sc == arr[0].length-1)
		{
			System.out.println(asf);
			return;
		}
		
		visited[sr][sc] = true;
		floodFillFunctionHelper(arr,sr-1,sc,asf+"t ",visited);
		floodFillFunctionHelper(arr,sr,sc-1,asf+"l ",visited);
		floodFillFunctionHelper(arr,sr+1,sc,asf+"d ",visited);
		floodFillFunctionHelper(arr,sr-1,sc+1,asf+"r ",visited);
		visited[sr][sc] = false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
