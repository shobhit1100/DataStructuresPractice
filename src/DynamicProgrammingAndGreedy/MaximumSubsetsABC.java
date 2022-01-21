package DynamicProgrammingAndGreedy;

public class MaximumSubsetsABC {

	public static void subsets(String str , String asf)
	{
		if(str.length() == 0)
		{
			System.out.println(asf);
			return;
		}
		
		for(int i = 0 ; i <str.length() ; i++)
		{
			char ch = str.charAt(i);
			String ls = str.substring(0,i);
			String rs = str.substring(i+1);
			String ros = ls+rs;
			subsets(ros , asf+ch);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsets("abcabc","");
	}

}
