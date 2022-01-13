package LinkedList;
import java.util.*;
public class k_NodeFromLast {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinekdList{
		Node head;
		Node tail;
		int size;
		
		public void addLast(int val)
		{
			Node temp = new Node();
			temp.data = val;
			if(size == 0)
			{
				head = tail = temp;
			}
			else {
				tail.next = temp;
				tail = temp;
			}
			size++;
		}
		public int kthfromLast(int k)
		{
			Node fast = head;
			Node slow = head;
			
			for(int i = 0 ; i < k ; i++)
			{
				fast = fast.next;
			}
			
			while(fast != tail)
			{
				fast = fast.next;
				slow = slow.next;
			}
			return slow.data;
		}
		
		public void mid_LinkedList()
		{
			Node slow = head;
			Node fast = head;
			while(fast.next != null && fast.next.next != null)
			{
				slow = slow.next;
				fast = fast.next.next;
			}
			System.out.println("Mid of thr linked list	 is : " + slow.data);
		}
		
	}
	
	
	public static void main(String [] args)
	{
		LinekdList list = new LinekdList();
		Scanner scn = new Scanner(System.in);
		int i = 0;
		
		while(i != 1 )
		{
			int val = scn.nextInt();
			list.addLast(val);
			System.out.println("to exit enter 1");
			i = scn.nextInt();
		}
		
	     System.out.println(list.kthfromLast(3));
	     
	     list.mid_LinkedList();
	}
	
}
