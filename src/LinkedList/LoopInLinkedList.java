package LinkedList;

import java.util.HashMap;
import java.util.HashSet;

public class LoopInLinkedList {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head ;
		Node tail ;
		int size ;
		
		public int size()
		{
			return size;
		}
		
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
		
		public void display()
		{
			Node temp = head;
			while(temp != null)
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
		
		public boolean loop()
		{
			if(size == 0 || size == 1)
			{
				System.out.println("List is empty");
				return false;
			}
			
			 Node temp = head;
			 HashSet<Node> hset = new HashSet<>();
			 while(temp != null)
			 {
				 if(hset.contains(temp))
				 {
					 return true;
				 }
				 else {
					hset.add(temp);
					temp = temp.next;
				 }
			 }
			return false;
		}	
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.display();
		
		list.head.next.next.next.next = list.head;
		System.out.println(list.loop());
	}

}
