package DynamicProgrammingAndGreedy;

public class SubSetsOfabcTypeDP {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcabc";
		
		int a1 = 0;
		int ab2 = 0;
		int abc3 = 0;
		
		for(int i = 0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(ch=='a')
			{
				a1 = (2*a1)+1;  
			}
			else if(ch == 'b')
			{
				ab2 = (2*ab2)+a1;
			}
			else if(ch == 'c')
			{
				abc3 = (2*abc3)+ab2;
			}
		}
		
		System.out.println(abc3);
		
	}

}
