package StackProblems;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[4][4];
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			st.push(i);
		}
		
		while(st.size()>1)
		{
			int i = st.pop();
			int j = st.pop();
			if(arr[i][j] == 1)
			{
				st.push(j);
			}
			else
			{
				st.push(i);
			}
		}
		int pot = st.pop();
		boolean flag = true;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(i!=pot)
			{
				if(arr[pot][i] != 0 && arr[i][pot] !=1)
				{
					flag = false;
				}
			}
		}
		
		if(flag)
		{
			System.out.println("Yes Celebrity : " + pot);
		}
		else 
		{
			System.out.println("No celebrity is found");
		}
	}

}
