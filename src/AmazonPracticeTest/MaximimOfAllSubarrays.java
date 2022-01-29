package AmazonPracticeTest;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximimOfAllSubarrays {

	// this particular question can have many solutions
	// we are trying to do it by two most popular solutions
	// First Solution using a max heap
	// Second one will be using a sliding window technique 
	
	// First Solution
	// The idea is to just add the one value get the max and then remove the first value from the front
	public static void findMaxOfSubarrays(int [] arr , int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ; i < k ; i++)
		{
			pq.add(arr[i]);
		}
		System.out.println(pq.peek());
		pq.remove(arr[0]);
		
		int index = 1;
		for(int i = k ; i < arr.length ; i++)
		{
			pq.add(arr[i]);
			System.out.println(pq.peek());
			pq.remove(arr[index++]);
		}
	
		
		// Time Complexity -> (n-k-1)Logn ~ nlogn
		// Space Complexity -> logn 
	}
	
	// Second solution
	// The idea is to use Sliding Window Technique
	// Now in this solution what we need to take care in mind is that we will traverse only till the arraylength
	
	public static void printMaximumInSubArray(int [] arr , int k)
	{
		int nge [] = new int[arr.length];
		nge[arr.length-1] = arr.length-1; // for last element storing the last element as the greatest element instead of -1 
											   // because we want this to be considered as well
		Stack<Integer> st = new Stack<>();
		st.push(arr.length-1);
		for(int i = arr.length-2 ; i>= 0 ; i--)
		{
			while(st.size()>0 && arr[i] > arr[st.peek()])
			{
				st.pop();
			}
			if(st.size() == 0){
				nge[i] = arr.length-1;
			}
			else {
				nge[i] = st.peek();
			}
			st.push(i);
		}
		
		for(int temp : nge)
		{
		System.out.println(arr[temp] + "test");
		}
		//int j = 0;
		for(int i = 0 ; i <=arr.length-k ; i++)
		{
//			if(j<i)
//			{
//				j = i; 
//			}
			int j = i;
			if(nge[j] <= i+k)
			{
				j = nge[j];
			}
			System.out.println(arr[j]);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {7,1,5,3,6,4,8,9,40,2,3,22,1};
		findMaxOfSubarrays(arr,4);
		System.out.println("**************************");
		printMaximumInSubArray(arr, 4);
		
	}

}
