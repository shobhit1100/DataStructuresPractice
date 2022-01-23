package DynamicProgrammingAndGreedy;

public class BuySellStockTransactionFees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {7,1,5,3,6,4};
		int fees = 3;
		int obost = -arr[0];
		int osost = 0;
		for(int i = 1 ; i < arr.length ; i++)
		{
			int nbost;
			int nsost;
			if((osost - arr[i]) > obost )
			{
				nbost = osost - arr[i];
			}
			else {
				nbost = obost;
			}
			
			if(obost - fees + arr[i]  > osost)
			{
				nsost = obost - fees + arr[i];
			}
			else {
				nsost = osost;
			}
			obost = nbost;
			osost = nsost;
		}
		
		System.out.println(osost);
		
	}

}
