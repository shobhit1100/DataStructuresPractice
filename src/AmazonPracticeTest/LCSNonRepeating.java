package AmazonPracticeTest;

import java.util.Map;
import java.util.TreeMap;

public class LCSNonRepeating {
	
	// this idea is to store the frequency of each of the elements in the array1 in th e sirted order.
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,3,1,3,2,4,6,7,9,2,19};
		int arr1 [] = {2,1,4,3,9,6};
		TreeMap<Integer , Integer> map = new TreeMap<>();
		for(int i : arr)
		{
			if(map.containsKey(i))
			{
				int val = map.get(i);
				val++;
				map.put(i, val);
			}
			else {
				map.put(i, 1);
			}
		}
		
		int arr2[] = new int[arr.length];
		int index = 0;
		for(int i : arr1)
		{
			if(map.containsKey(i))
			{
				int k = map.get(i);
				while(k != 0)
				{
					arr2[index] = i;
					k--;
					index++;
				}
				map.remove(i);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry  :map.entrySet())
		{
			int j = entry.getValue();
			while(j > 0 )
			{
				arr2[index++] = entry.getKey();
				j--;
			}
		}
		
		for(int i : arr2)
		{
			System.out.println(i);
		}
		 
	}

}
