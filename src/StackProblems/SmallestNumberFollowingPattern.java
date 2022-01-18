package StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input -> ddidddid
		// output -> 321765498
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int nums = 1;
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i < str.length(); i++)
		{
			char ch = str.charAt(i);
			if(ch == 'd')
			{
				st.push(nums);
				nums++;
			}
			else {
				st.push(nums);
				nums++;
				while(st.size()>0)
				{
					System.out.print(st.pop());
				}
			}
		}
		st.push(nums);
		while(st.size()>0)
		{
			System.out.print(st.pop());
		}

	}

}
