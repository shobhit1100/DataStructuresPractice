package DynamicProgrammingAndGreedy;

public class BuySellStockInfiniteTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This question is a variant of stock problem with one transactions allowed 
		// To solve this we can can simply collect all the upstrokes
		// And the sum of all the upstrokes will be our answer.
		// So msf is also needed here as well.
		int [] arr = {7,1,5,3,6,4};
		int bon = 0;
		int son = 0;
		int msf = arr[0];
		int op = 0;
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i-1] > arr[i])
			{ 
				int profit =  arr[son]-arr[bon];
				op += profit;
				bon = son = i;
			}
			else {
				son++;
			}
		}
		System.out.println(op);
	}

}
