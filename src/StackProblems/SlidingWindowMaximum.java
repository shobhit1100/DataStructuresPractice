package StackProblems;
import java.util.*;
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr =  {7, 5, 2, 6, 4, 3, 8, 1, 5};
		
		// find next grater element from each index
		// if not present then store arr.length there.
		
		int [] nge = new int[arr.length];
		nge[arr.length-1] = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(arr.length-1);
		for(int i = arr.length-2 ; i>=0 ; i--)
		{
			while(st.size()>0 && arr[i] >= arr[st.peek()])
			{
				st.pop();
			}
			if(st.size() == 0)
			{
				nge[i] = arr.length;
			}
			else {
				nge[i] = st.peek();
			}
			st.push(i);
		}
		
		
		for(int m : nge)
		{
			System.out.print(m + " ");
		}
		
		System.out.println();
		int j = 0;
		int k = 4;
		for(int i = 0 ; i<=arr.length-k ; i++)
		{
			if(j<i)
			{
				j = i;
			}
			while(nge[j] < i+k)
			{
				j = nge[j];
			}
			System.out.println(arr[j]);
		}
		
//		 int i = 0;
//		    for (int w = 0; w <= arr.length - k; w++) {
//		      if (i < w) {
//		        i = w;
//		      }
//
//		      while (nge[i] < w + k) {
//		        i = nge[i];
//		      }
//		      System.out.println(arr[i]);
//		    }
		
	}

}	