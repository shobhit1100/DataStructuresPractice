package Practice;

import java.util.Scanner;

public class MagicNumber {

	public static void main(String []  args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int number,sum=0,remainder = 1;
		
		while(n>0 || sum>9)
		{
			if(n==0)
			{
				n = sum;
				sum = 0;
			}
			sum += n%10 ;
			n = n/10;
			
			
		}
		
		
	/*	number = n;
		while(number>9)
		{
			while(number>0)
			{
				remainder = number%10;
				sum +=remainder;
				number = number/10;
			}
			
				number = sum;
				sum = 0;
		}
		*/
		
		if(sum == 1)
		{
			System.out.println("Magic Number");
		}
		else
		{
			System.out.println("Number is not a Magic Number");
		}
		
		
	}
	
}
