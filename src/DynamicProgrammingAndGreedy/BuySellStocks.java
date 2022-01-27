package DynamicProgrammingAndGreedy;

public class BuySellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// In buy sell stock , this is for one transaction
		// we need to but the stock at the minimum point
		// and sell at the highest point
		// i.e buying the stock at the minimum price 
		// and selling the stock at the maximum price
		// the difference between the minimum and maximum price of the stock becomes our profit
		// and that profit will always be maximum
		// so what do we need -> a min and a max and the difference of them is to be stored in profit
		// one more thing we need to update out overall profit also every time we came across a point when the new proft
		// is more than the current overall profit.
		
		int [] arr = {7,1,5,3,6,4};
		int msf = arr[0]; // 7 -> 1 
		int op = 0; // 0 -> 4 -> 2 ? 4 and 4 is the max so 4 will remain ->5  
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i] <= msf)
			{
				msf = arr[i];
			}
			else {
				int profit = arr[i] - msf;
				if(op < profit)
				{
					op = profit;
				}
			}	
		}
		
		System.out.println(op);
		
	}

}
