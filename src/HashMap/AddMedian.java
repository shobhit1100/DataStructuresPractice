package HashMap;

import java.util.PriorityQueue;

public class AddMedian {

	public static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
	public static PriorityQueue<Integer> pq2 = new PriorityQueue<>();
	
	public static void add(int i)
	{
		if(pq2.size()>0 && pq2.peek()>i)
		{
			pq2.add(i);
		}
		else {
			pq1.add(i);
		}
		handleBalance();
	}
	
	public static void handleBalance()
	{
		if(pq1.size()-pq2.size()==2)
		{
			pq2.add(pq1.remove());
		}
		else if(pq2.size() - pq1.size() == 2) {
			pq1.add(pq1.remove());
		}
	}
	
	public static int peek()
	{
		if(pq1.size() >= pq2.size())
		{
			return pq1.peek();
		}
		else
		{
			return pq2.peek();
		}
	}
	
	public int size()
	{
		return pq1.size()+pq2.size();
	}
	
	public static void remove()
	{
		if(pq1.size() >= pq2.size())
		{
			pq1.remove();
		}
		else {
			pq2.remove();
		}
	}
}
