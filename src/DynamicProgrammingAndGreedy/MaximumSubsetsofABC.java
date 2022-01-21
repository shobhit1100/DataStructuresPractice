package DynamicProgrammingAndGreedy;

import java.util.ArrayList;

public class MaximumSubsetsofABC {

	
	public static void maximumSubsets(String str)
	{
		
		int a = 0;
		int ab = 0;
		int abc = 0;
		for(int i = 0 ; i < str.length() ; i ++)
		{
			char ch = str.charAt(i);
			if(ch == 'a')
			{
				a = 2*a +1;
			}
			else if(ch == 'b')
			{
				ab = 2*ab + a;
			}
			else if(ch == 'c')
			{
				abc = 2*abc+ab;
			}
		}
		
		System.out.println("Total number of subsets are " + abc);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcabc";
		
		maximumSubsets(str );
	}

}
