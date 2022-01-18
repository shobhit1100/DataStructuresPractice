package StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {

	public static int presedence(char ch)
	{
		if(ch == '+' || ch == '-')
		{
			return 1;
		}
		else {
			return 2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		// converting to prefix and infix
		Stack<String> pre = new Stack<>();
		Stack<String> post = new Stack<>();
		Stack<Character> operators = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(ch == '(')
			{
				operators.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				pre.push(ch+"");
				post.push(ch+"");
			}
			else if(ch == ')')
			{
				while(operators.size()>0 && operators.peek()!='(')
				{
					// for pre
					String pre2 = pre.pop();
					String pre1 = pre.pop();
					char op = operators.pop();
					String preres = op+pre1+pre2;
					pre.push(preres);
					// for post
					String pos2 = post.pop();
					String pos1 = post.pop();
					String postres = pos1+pos2+op;
					post.push(postres);
				}
				if(operators.size()>0)
				{
				operators.pop();
				}
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
			{
				while(operators.size()>0 && operators.peek() != '(' && presedence(ch) <= presedence(operators.peek()))
				{
					// for pre
					String pre2 = pre.pop();
					String pre1 = pre.pop();
					char op = operators.pop();
					String preres = op+pre1+pre2;
					pre.push(preres);
					// for post
					String pos2 = post.pop();
					String pos1 = post.pop();
					String postres = pos1+pos2+op;
					post.push(postres);
				}
				operators.push(ch);
			}
		}
		
		while(operators.size()>0)
		{
			// for pre
			String pre2 = pre.pop();
			String pre1 = pre.pop();
			char op = operators.pop();
			String preres = op+pre1+pre2;
			pre.push(preres);
			// for post
			String pos2 = post.pop();
			String pos1 = post.pop();
			String postres = pos1+pos2+op;
			post.push(postres);
		}
		System.out.println(pre.pop());
		System.out.println(post.pop());
		scn.close();
	}
}
