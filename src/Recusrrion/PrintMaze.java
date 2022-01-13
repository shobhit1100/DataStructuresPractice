package Recusrrion;

public class PrintMaze {

	public static void printMazePaths(int [][] arr ,int sr , int sc, String path)
	{
		if(sr >arr.length || sc>arr[0].length || sr==arr.length && sc == arr[0].length)
		{
			if(sr == arr.length && sc == arr[0].length)
			{
				System.out.println(path);
			}
			return;
		}
		
		printMazePaths(arr, sr+1, sc, path+"v ");
		printMazePaths(arr, sr, sc+1, path+"h ");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [][] = new int[3][3];
		printMazePaths(arr, 0, 0, "");
	}

}
