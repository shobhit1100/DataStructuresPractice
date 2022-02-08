package AmazonPracticeTest;

public class RotateAMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		int [][] temp = new int[3][3];
		for(int i = 0; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[0].length ; j++)
			{
				temp[j][i] = arr[i][j];
			}
		}
		for(int i = 0 ; i < temp.length ; i++)
		{
			for(int j = 0 ; j < temp[0].length ; j++)
			{
				System.out.print(temp[i][j] +" ");
			}
			System.out.println();
		}
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			int li = 0;
			int ri = arr[0].length-1;
			while(li<=ri)
			{
				arr[i][li] = temp[i][ri];
				arr[i][ri] = temp[i][li];
				li++;
				ri--;
			}
		}
		
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr[0].length ; j++)
			{
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
