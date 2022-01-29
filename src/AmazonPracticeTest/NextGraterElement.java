package AmazonPracticeTest;

import java.util.Stack;

public class NextGraterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {7,1,5,3,6,4};
		int [] nge = new int[arr.length];
		// finding right to left
		nge[arr.length-1] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(arr[arr.length-1]);	
		for(int i =arr.length-2 ; i >= 0 ; i--)
		{
			while( st.size() > 0 && arr[i] > st.peek())
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

}
