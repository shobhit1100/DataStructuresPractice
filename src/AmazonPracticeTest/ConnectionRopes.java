package AmazonPracticeTest;

import java.util.PriorityQueue;

public class ConnectionRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {4,3,2,6};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : arr)
		{
			pq.add(i);
		}
		
		int profit = 0;
		
		while(pq.size() != 1)
		{
			int val1 = pq.remove();
			int val2 = pq.remove();
			int ans = val1 + val2;
			profit += ans;
			pq.add(ans);
		}
		//pq.remove();
		System.out.println(profit);
	}

}
