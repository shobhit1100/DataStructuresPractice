package BackTracking;

public class TargetSumSubsets {

	
	
	public static void targetSubsets(int [] arr , int index ,int sum, int target , String sos)
	{
		if(index == arr.length)
		{
			if(target == sum)
			{
				System.out.println(sos);
			}
			return;
		}
		targetSubsets(arr,index+1,sum+arr[index],target,sos+arr[index]+"");
		targetSubsets(arr,index+1,sum,target,sos+"");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {10,20,30,25,15,25,10};
		
		targetSubsets(arr,0, 0 ,30 ,"");
			
		
	}

}
