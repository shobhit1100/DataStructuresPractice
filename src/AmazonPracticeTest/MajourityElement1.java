package AmazonPracticeTest;

import java.util.HashMap;
import java.util.Map;

public class MajourityElement1 {

	// we will be using moore's voting algorithm to solve this particular question
	// firstly we will iterate through the array and get the candidate element from the array 
	// Candidate element is the one which can be the majority element but it is not sure
	// then we just need to iterate through the array once more and get the count
	// if the count is grater than n/2 the it will be an majority element
	// else it will not be
	
	public static void majorityElementCandidate(int [] arr)
	{
		int element = arr[0];
		int count = 1;
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i] == element)
			{
				count++;
			}
			else {
				count--;
			}
			if(count == 0)
			{
				element = arr[i];
				count = 1;
			}
		}
		
		int countfinal = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(element == arr[i])
			{
				countfinal++;
			}
		}
		if(countfinal >= arr.length/2)
		{
			System.out.println(element);
		}
		else {
			System.out.println("None");
		}
	}
	
	
	public static void printMajorityElement2(int [] arr)
	{
		int maxElement = arr[0];
		int count = 1;
		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i] == maxElement)
			{
				count++;
			}
			else {
				count--;
			}
			if(count== 0)
			{
				maxElement = arr[i];
				count = 1;
			}
		}
		
		int maxCount = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(maxElement == arr[i])
			{
				maxCount++;
			}
		}
		
		if(maxCount == arr.length/3)
		{
			System.out.println(maxElement);
		}		
	}
	
	// this problem is to find all the elements that appear more than n/3 times
	public static void findMajorityElement3(int [] arr,int k)
	{
		HashMap<Integer,Integer> hmap = new HashMap<>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(hmap.containsKey(arr[i]))
			{
				int val = hmap.get(arr[i]);
				val = val+1;
				hmap.put(arr[i], val);
			}
			else {
				hmap.put(arr[i],1);
			}
		}
		for(Map.Entry<Integer, Integer> map : hmap.entrySet())
		{
			if(map.getValue() >= arr.length/k)
			{
				System.out.println(map.getKey());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //int a[] = new int[] { 1, 3, 3, 1, 2 };
		 //int a1[] = {2,2,2,2,5,5,2,3,3};
		 //majorityElementCandidate(a);
		 //majorityElementCandidate(a1);
		 
		 int arr1[] = { 4, 5, 6, 7, 8, 4, 4 , 5 , 5 };
		 findMajorityElement3(arr1, 3);
	}

}
