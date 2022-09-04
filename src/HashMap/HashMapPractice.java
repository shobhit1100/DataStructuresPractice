package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class HashMapPractice {

	public int findHighestFrequencyNumber(HashMap<Integer,Integer> hmap)
	{
		Set<Integer> keySet= hmap.keySet();
		int max = Integer.MIN_VALUE;
		for(int i : keySet)
		{
			int iniKey = hmap.get(i);
			if(max < iniKey)
			{
				max = iniKey;
			}
		}
		return max;
	}
	
	public void printCommonElements(HashMap<Integer,Integer> hmap,int [] arr)
	{
		
		for(int i : arr)
		{
			if(hmap.containsKey(i))
			{
				System.out.println(hmap.get(i));
				hmap.remove(i);
			}
		}
	}
	
	public void printCommonElements2(HashMap<Integer,Integer> hmap, int [] arr)
	{
		for(int i : arr)
		{
			if(hmap.containsKey(i) && hmap.get(i)>=1)
			{
				int oldVal = hmap.get(i);
				int newVal = oldVal-1;
				System.out.println(i);
				hmap.put(i, newVal);
			}
		}	
	}

	
	public void printLargest(int [] arr, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i : arr)
		{
			if(i > k)
			{
				pq.add(i);
			} else {
				if(pq.peek() < i)
				{
					pq.remove();
					pq.add(i);
				}
			}
		}
		
		while(pq.size()>0)
		{
			System.out.println(pq.remove());
		}
	}
	
	
	public void kSortedArray(int [] arr , int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < k ; i++)
		{
			pq.add(arr[i]);
		}
		
		for(int i = k ; i < arr.length ; i++ )
		{
			System.out.println(pq.remove());
			pq.add(arr[i]);
		}
		
		while(pq.size()>0)
		{
			System.out.println(pq.remove());
		}
		
	}
	public void lcs(int [] arr)
	{
		
		HashMap<Integer,Boolean> trueMap = new HashMap<>();
		
		// putting all the keys with value as true
		
		for(int i : arr)
		{
			if(!trueMap.containsKey(i))
			{
				trueMap.put(i,true);
			}
		} //O(n)
		
		for(int i : arr)
		{
			if(!trueMap.containsKey(i-1))
			{
				trueMap.put(i,false);
			}
		} // O(n)
		
		int max = Integer.MIN_VALUE;
		for(int i : arr)
		{
			int ti = i+1;
			if(trueMap.get(i))
			{
				while(trueMap.containsKey(ti))
				{
					ti++;
				}
				max = ti;
			}
		} //O(n^2)
		System.out.println(max);
		// Time Complexity -> O(n + n + n^2) -> O( N + m^2) -> N -> Number of the elements in the hashmap , M -> Number of elements in the subsequences.
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {1,2,3,4};
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i : input)
		{
			if(!map.containsKey(i))
			{
				map.put(i,1);
			}
			else {
				int val = map.get(i);
				map.put(i,val+1);
			}
		}
	}

}
