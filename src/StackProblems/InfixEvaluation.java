package StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {

	public static int presedence(char ch)
	{
		if(ch == '*' || ch == '/')
		{
			return 2;
		}
		else if(ch == '+' || ch == '-')
		{
			return 1;
		}
		else {
			return -1;
		}
	}
	public static int evaluate(int val1 , int val2 , char op)
	{
		if(op == '+')
		{
			return val1+val2;
		}
		else if(op == '-')
		{
			return val1-val2;
		}
		else if(op == '*')
		{
			return val1*val2;
		}else {
			return val1/val2;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str  = scn.nextLine();
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operators = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(ch =='(')
			{
				operators.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				operand.push(ch-'0');
			}
			else if(ch == ')')
			{
				while(operators.peek() != '(')
				{
					int val2 = operand.pop();
					int val1 = operand.pop();
					char oper = operators.pop();
					int res = evaluate(val1, val2, oper);
					operand.push(res);
				}
				operators.pop();
			}
			else if(ch == '+'|| ch == '-'||ch == '*' || ch == '/')
			{
				while(operators.size() > 0 && operators.peek()!= '(' && presedence(ch)<=presedence(operators.peek()))
				{
					int val2 = operand.pop();
					int val1 = operand.pop();
					char oper = operators.pop();
					int res = evaluate(val1, val2, oper);
					operand.push(res);
				}
				operators.push(ch);
			}
		}
		while(operators.size()>0)
		{
			int val2 = operand.pop();
			int val1 = operand.pop();
			char oper = operators.pop();
			int res = evaluate(val1, val2, oper);
			operand.push(res);
		}
		System.out.println(operand.peek());
	}

}
