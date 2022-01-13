package Recusrrion;

public class PrintMazePaths {

	public static void PrintPaths(int n, String path)
	{
		
		if(n<= 0)
		{
			if(n == 0)
			{
				System.out.println(path);
			}
			return;
		}
		
		PrintPaths(n-1,path+"1");
		PrintPaths(n-2,path+"2");
		PrintPaths(n-3,path+"3");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPaths(3,"");
	}

}
