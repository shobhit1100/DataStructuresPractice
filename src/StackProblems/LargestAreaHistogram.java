package StackProblems;
import java.util.*;
public class LargestAreaHistogram {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {6,2,5,4,5,1,6};
		
		// nse from right -> left
		int [] nse1 = new int [arr.length];
		Stack<Integer> st1 = new Stack<>();
		nse1[arr.length-1] = arr.length;
		st1.push(arr.length-1);
		for(int i = arr.length-1; i >= 0 ; i-- )
		{
			while(st1.size()>0 && arr[i] < arr[st1.peek()])
			{
				st1.pop();
			}
			if(st1.size() == 0)
			{
				nse1[i] = arr.length;
			}
			else {
				nse1[i] = st1.peek();
			}
			st1.push(i);
		}
		// nse from left -> right
		int [] nse2 = new int[arr.length];
		Stack<Integer> st2 = new Stack<>();
		nse1[0] = -1;
		st2.push(0);
		for(int i = 1 ; i < arr.length ; i++ )
		{
			while(st2.size()>0 && arr[i] < arr[st2.peek()])
			{
				st2.pop();
			}
			if(st2.size() == 0)
			{
				nse2[i] = -1;;
			}
			else {
				nse2[i] = st2.peek();
			}
			st2.push(i);
		}
		
		// calculate area;
		int maxArea = 0;
		for(int i = 0;i<arr.length;i++)
		{
			int temparea = arr[i]*(nse1[i] - nse2[i] - 1);
			if(temparea>maxArea)
			{
				maxArea = temparea;
			}
		}
		System.out.println("Largest Area of Histogram is " + maxArea);
	}

}
