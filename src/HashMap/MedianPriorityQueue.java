package HashMap;
import java.util.*;
import java.io.*;
public class MedianPriorityQueue {

	
	public static class MedianClass{
		PriorityQueue<Integer> lpq ;
		PriorityQueue<Integer> rpq ;
		public MedianClass()
		{
			lpq = new PriorityQueue<>(Collections.reverseOrder());
			rpq = new PriorityQueue<>();
		}
		public void add(int val)
		{
			if(rpq.size()>0 && rpq.peek()<val)
			{
				rpq.add(val);
			}
			else {
				lpq.add(val);
			}
			
			if(lpq.size() - rpq.size() == 2)
			{
				rpq.add(lpq.remove());
			}
			else if(rpq.size() - lpq.size() == 2)
			{
				lpq.add(rpq.remove());
			}
			
		}
		public int remove()
		{
			if(this.size() == 0)
			{
				System.out.println("Underflow");
				return -1;
			}
			else if(lpq.size()>=rpq.size())
			{
				return lpq.remove();
			}
			else {
				return rpq.remove();
			}			
		}
		public int size()
		{
			return lpq.size() + rpq.size();
		}
		public int peek()
		{
			if(this.size() == 0)
			{
				System.out.println("Underflow");
				return -1;
			}
			else if(lpq.size()>=rpq.size())
			{
				return lpq.peek();
			}
			else {
				return rpq.peek();
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
