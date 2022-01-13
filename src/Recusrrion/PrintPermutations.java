package Recusrrion;

public class PrintPermutations {

	public static void printPermutation(String str , String asf)
	{
		if(str.length() == 0)
		{
			System.out.println(asf);
			return;
		}	
		for(int i = 0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			String lstr = str.substring(0,i);
			String rstr = str.substring(i+1);
			String rmstr = lstr + rstr;
			printPermutation(rmstr, asf+ch);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		printPermutation(str,"");
	}

}
