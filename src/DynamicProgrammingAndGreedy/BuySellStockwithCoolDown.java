package DynamicProgrammingAndGreedy;

import java.util.Scanner;

public class BuySellStockwithCoolDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = scn.nextInt();
		}
		
		int coldown = 0;
		int obt = -arr[0];
		int ost = 0;
		
		for(int i = 1 ; i < arr.length ; i++)
		{
			int ncoldown;
			int nbt;
			int nst;
			if(ost -arr[i] > obt)
			{
				nbt = obt;
			}
			else{
				nbt = obt;
			}
			if(obt + arr[i] > ost)
			{
				nst = obt+arr[i];
			}
			else {
				nst = ost;
			}
			if(ost > coldown)
			{
				ncoldown = ost;
			}
			else {
				ncoldown = coldown;
			}
			obt = nbt;
			ost = nst;
			coldown = ncoldown;
		}
		
		System.out.println(ost);
	}

}
