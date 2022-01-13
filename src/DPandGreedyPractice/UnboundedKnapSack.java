package DPandGreedyPractice;

public class UnboundedKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] wts = {};
		int [] vals = {};
		int target = 7;
		int [] dp = new int[target+1];
		dp[0]=0;
		for(int i = 1 ; i<dp.length ; i++)
		{
			int max = 0;
			for(int j = 0 ; i<wts.length ; j++)
			{
				if(i>= wts[j])
				{
					int rembagcap = i-wts[j];
					int rembagval = vals[rembagcap];
					int totbagcap = rembagval+vals[j];
					if(max<totbagcap)
					{
						max = totbagcap;
					}
				}
			}
			dp[i] = max;
		}
	}

}
