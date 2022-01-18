package StackProblems;
import java.util.*;
public class prefixEvaluationAndConversion {

	public static int solverValue(int val1 , int val2 ,char ch)
	{
		if(ch =='+')
		{
			return val1+val2;
		}
		else if(ch =='*')
		{
			return val1*val2;
		}
		else if(ch =='/')
		{
			return val1/val2;
		}
		else if(ch == '-')
		{
			return val1-val2;
		}
		else {	
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Stack<String> post = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<Integer> eval = new Stack<>();
		for(int i = str.length()-1 ; i > 0 ; i--)
		{
			char ch = str.charAt(i);
			
			if(Character.isDigit(ch))
			{
				post.push(ch+"");
				infix.push(ch+"");
				eval.push(ch-'0');
				
			}
			else {
				int val1 = eval.pop();
				int val2 = eval.pop();
				int res = solverValue(val1, val2, ch);
				eval.push(res);
				
				// for postfix
				String postval1 = post.pop();
				String postval2 = post.pop();
				String resPostVal = postval1+postval2+ch+"";
				post.push(resPostVal);
				//for infix
				String infixVal1 = infix.pop();
				String infixVal2 = infix.pop();
				String infixVal3 = "("+infixVal1 + ch + infixVal2 +")";
				infix.push(infixVal3);
			}
		}
		System.out.println(eval.pop());
		System.out.println(post.pop());
		System.out.println(infix.pop());
	}

}
