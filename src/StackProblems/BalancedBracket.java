package StackProblems;
import java.util.*;
public class BalancedBracket {

	public static boolean isBalancedBracket(String str)
	{
		Stack<Character> st = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{')
			{
				st.push(ch);
			}
			else if(ch == ')' || ch == ']' || ch == '}')
			{
				if(st.size() == 0)
				{
					return false;
				}
				st.pop();
			}
			else {
				continue;
			}
		}
		
		if(st.size()>0)
		{
			return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		String str = "[(a+b)]]";
		System.out.println(isBalancedBracket(str));
	}
}
