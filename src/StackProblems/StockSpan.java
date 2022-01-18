package StackProblems;
import java.util.*;
public class StockSpan {

	// a variation of Next grater element , think NGE i.e Next Grater element as the small brother of this question
	// the small brother was happy with finding the next vale , hende we had the value only.
	// the big brither wanted even the difference of the values , hence it is stck span.
	
	public static void stockspanSolution(int [] arr)
	{
		int [] span = new int [arr.length];
		span[0] = 1;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1 ; i < arr.length ; i++)
		{
			while(st.size() > 0 && arr[i]>= arr[st.peek()])
			{
				st.pop();
			}
			
			if(st.size() == 0)
			{
				span[i] = i + 1;
			}
			else {
				span[i] = i - st.peek();
			}
			
			st.push(i);
		}
		
		for(int i : span)
		{
			System.out.println(i);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,1,5,4,7,8,9,0,2};
		stockspanSolution(arr);
	}

}
