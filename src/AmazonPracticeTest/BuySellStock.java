package AmazonPracticeTest;

public class BuySellStock {

	public static void buySellStockOneTransaction(int [] arr)
	{
		int maxProfit = 0;
		int minsf = arr[0];
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(minsf > arr[i])
			{
				minsf = arr[i];
			}
			else {
				int tempProfit = arr[i] - minsf;
				if(tempProfit > maxProfit)
				{
					maxProfit = tempProfit;
				}
			}
		}
		System.out.println(maxProfit);
	}
	
	public static void buySellStockInfiniteTransaction(int [] arr)
	{
		// every time the value goes down , collect the profit and update msf
		int minsf = arr[0];
		int totalSum = 0;
		int maxsf = arr[0];
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(minsf > arr[i])
			{
				totalSum += minsf + maxsf;
				minsf = maxsf = arr[i];
			}
			else {
				maxsf = arr[i];
			}
		}
		System.out.println(totalSum);
	}
	
	public static void butSellTransactionFees(int [] arr , int k)
	{
		int ibost = -arr[0];
		int isost = 0;
		for(int i = 1;i<arr.length;i++)
		{
			int nbost = 0;
			int nsost = 0;
			if(isost - arr[i] > ibost)
			{
				nbost = isost - arr[i] - k;
			}
			else {
				nbost = ibost;
			}
			if(ibost - k + arr[i]> isost)
			{
				nsost = ibost - k + arr[i];
			}
			else {
				nsost = isost;
			}
			ibost = nbost;
			isost = nsost;
		}
		System.out.println(isost);
	}
	
	public void buySellStockWithCoolDown(int [] arr)
	{
		int ibost = -arr[0];
		int isost = 0;
		int icost = 0;
		for(int i = 1 ; i < arr.length ; i++)
		{
			int nbost;
			int nsost;
			int ncost;
			if(isost-arr[i] > ibost)
			{
				nbost = isost - arr[i];
			}
			else{
				nbost = ibost;
			}
			if(ibost + arr[i] > isost)
			{
				nsost = ibost + arr[i];
			}
			else {
				nsost = isost;
			}
			if(icost < isost)
			{
				ncost = isost;
			}
			else {
				ncost = icost;
			}
			ibost = nbost;
			isost = nsost;
			icost = ncost;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
