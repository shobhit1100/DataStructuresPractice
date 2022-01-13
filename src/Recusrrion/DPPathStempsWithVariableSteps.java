package Recusrrion;

public class DPPathStempsWithVariableSteps {

	public static int climbPath(int [] arr , int index , int len)
	{
		if(index == len)
		{
			return 1;
		}
		
		int count = 0;
		
		for(int jump = 1 ; jump <= arr[index] ; jump++)
		{
			if((jump+index) <= len)
			{
				count += climbPath(arr,index+jump,len);
			}
			else {
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,3,0,1,2,3};
		System.out.println(climbPath(arr, 0, arr.length));
	}

}
