package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class BuySellStockWithTransactionsAllowed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input -> 30 40 43 50 45 20 26 40 80 50 30 15 10 20 40 45 71 50 55
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = scn.nextInt();
		}
		
		int pist [] = new int[n];
		int msf = arr[0];
		int op = 0;
		for(int i = 1 ; i < n ; i++)
		{
			if(msf > arr[i])
			{
				msf = arr[i];
			}
			int currentProfit = arr[i] - msf;
			if(op < currentProfit)
			{
				op = currentProfit;
			}
			pist[i] = op;
		}
		// pist after calculation for the given input-> 0 10 13 20 20 20 20 20 60 60 60 60 60 60 60 60 61 61 61
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print(pist[i] +" ");
		}
		
		int [] psat = new int[n];
		int maxsf = arr[n-1];
		int op1 = 0;
		for(int i = n-2 ; i >=0 ; i--)
		{
			if(maxsf < arr[i])
			{
				maxsf = arr[i];
			}
			
			int currentProfit = maxsf - arr[i];
			if(currentProfit >op1)
			{
				op1 = currentProfit;
			}
			psat[i] = op1;
		}
		// output of the psat -> 61 61 61 61 61 61 61 61 61 61 61 61 61 51 31 26 5 5 0 
//		for(int i = 0 ; i < n ; i++)
//		{
//			System.out.print(psat[i] +" ");
//		}
		
		int max = 0 ;
		for(int i = 0 ; i <n ; i++)
		{
			int tempmax = pist[i] + psat[i];
			if(tempmax > max)
			{
				max =tempmax;
			}
		}	
		System.out.println(max);
	}

}
