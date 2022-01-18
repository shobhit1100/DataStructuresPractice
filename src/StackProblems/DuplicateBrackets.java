package StackProblems;
import java.util.*;
public class DuplicateBrackets {

	// code for duplicate brackets 
	
	public static boolean containsDuplicateBrackets(String str)
	{
		Stack<Character> st = new Stack<>();
		for(int i = 0 ; i < str.length();i++)
		{
		
			if(str.charAt(i) != ')')
			{
			st.push(str.charAt(i));
			}
			else {
				
				if(st.peek() == '(')
				{
					return true;
				}
				
				while(st.size()>0 && st.peek() != '(')
				{
					st.pop();
				}
				st.pop();
			}
		}
		
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "((a)+b)";
		System.out.println(containsDuplicateBrackets(str));
	}

}
