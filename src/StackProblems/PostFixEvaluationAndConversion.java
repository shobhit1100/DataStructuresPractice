package StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class PostFixEvaluationAndConversion {

	public static int evaluate(char ch , int val1 , int val2)
	{
		if(ch == '+')
		{
			return val1+val2;
		}
		else if(ch == '-')
		{
			return val1-val2;
		}
		else if(ch == '*')
		{
			return val1*val2;
		}
		else if(ch == '/')
		{
			return val1/val2;
		}
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Sample Input -> 264*8/+3-  sample Opuput- > val : 2 , pre : -+2/*6483 , infix : ((2+((6*4)/8))-3)
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Stack<Integer> valst = new Stack<>();
		Stack<String> pre = new Stack<>();
		Stack<String> in = new Stack<>();
		
		// abcd=-*/
		
		for(int i = 0 ; i<str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(Character.isDigit(ch))
			{
				valst.push(ch-'0');
				in.push(ch+"");
				pre.push(ch+"");
			}else {
				
				// for character
				
				int val2 = valst.pop();
				int val1 = valst.pop();
				int res = evaluate(ch,val1,val2);
				valst.push(res);
				
				// for pre
				String preval2 = pre.pop();
				String preval1 = pre.pop();
				pre.push(ch+preval1+preval2+"");
				// for in
				String inval2 = in.pop();
				String inval1 = in.pop();
				in.push("("+inval1+ch+inval2+")");
			}
		}
		System.out.println(valst.pop());
		System.out.println(pre.pop());
		System.out.println(in.pop());
	}

}
