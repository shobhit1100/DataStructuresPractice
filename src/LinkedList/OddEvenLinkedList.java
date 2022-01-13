package LinkedList;
import java.util.*;
public class OddEvenLinkedList {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
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
		
		public int getFirst()
		{
			if(size == 0)
			{
				return -1;
			}
			else{
				return head.data;
			}
		}
		
		public void removeFirst()
		{
			if(size == 0)
			{
				return;
			}
			else {
				head = head.next;
				size--;
			}
		}
		
		public void OddEvenList()
		{
			LinkedList odl = new LinkedList();
			LinkedList evl = new LinkedList();
			
			while(this.size > 0)
			{
				int data = this.getFirst();
				this.removeFirst();
				if(data%2 == 0)
				{
					evl.addLast(data);
				}
				else {
					odl.addLast(data);
				}
			}
			if(odl.size > 0 && evl.size > 0 )
			{
				odl.tail.next = evl.head;
				this.head = odl.head;
				this.tail = evl.tail;
				this.size = odl.size+evl.size;
			}
			else if(odl.size>0)
			{
				this.head = odl.head;
				this.tail = odl.tail;
				this.size = odl.size;
			}
			else if(evl.size > 0)
			{
				this.head = evl.head;
				this.tail = evl.head;
				this.size = evl.size;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
