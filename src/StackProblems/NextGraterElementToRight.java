package StackProblems;

import java.util.Stack;

public class NextGraterElementToRight {

	
	// using an array and a max variable
	
	public static void findNexGrater(int [] arr)
	{
		int max = arr[arr.length-1];
		System.out.println(max);
		for(int i = arr.length-2 ; i >= 0 ; i--)
		{
			if(max < arr[i])
			{
				max = arr[i];
				System.out.println("0");
			}
			else {
			System.out.println(max);
			}
		}
	}
	
	
	// first pop till value 
	// then check after pop for stack empty condition if yes the , puy nge [i] == -1.
	// else push the nge with st.peek() 
	// then and in the end pust the current interated value int the stack.
	
	public static void newxGraterElementToTheRightStackSolution(int [] arr)
	{
		 int nge [] = new int[arr.length];
		 nge[arr.length-1] = arr[arr.length-1];
		 Stack<Integer> st = new Stack<>();
		 st.push(arr[arr.length-1]);
		 for(int i = arr.length-2 ; i >= 0 ; i--)
		 {
			 while( st.size()>0 && arr[i] >= st.peek())
			 {
				 st.pop();
			 }
			 
			 if(st.size() == 0)
			 {
				 nge[i] = -1;
			 }
			 else {
				 nge[i] = st.peek();
			 }
			 
			 st.push(arr[i]);
		 }
		 
		 for(int j : nge)
		 {
			 System.out.println(j);
		 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,1,5,4,7,8,9,0,2};
		//findNexGrater(arr);
		newxGraterElementToTheRightStackSolution(arr);
	}

}
