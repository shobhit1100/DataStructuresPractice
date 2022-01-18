package BackTracking;

public class TargetSumSubsetsaArray {


	public static void TargetSumSubsetsPrint(int [] arr,int index,int sos,String set , int tar)
	{
		
		if(index == arr.length)
		{
			if(sos == tar)
			{
				System.out.println(set);
			}
			return;
		}
		
		TargetSumSubsets(arr,index+1,sos+arr[index],set+arr[index]+",",tar);
		TargetSumSubsets(arr,index+1,sos,set+",",tar);
	}
	
	public static int TargetSumSubsets(int [] arr,int index,int sos,String set , int tar)
	{
		
		if(index == arr.length)
		{
			if(sos == tar)
			{
				return 1;
			}
			else {
			return 0;
			}
		}
		
		int s=TargetSumSubsets(arr,index+1,sos+arr[index],set+arr[index]+",",tar);
		int t=TargetSumSubsets(arr,index+1,sos,set+",",tar);
		return s+t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {10,20,30,25,15,25};
		TargetSumSubsetsPrint(arr, 0, 0, "", 30);
		System.out.println(TargetSumSubsets(arr,0,0,"",30));
		
	}


	
}


