package AmazonPracticeTest;

import java.util.HashSet;

public class RemoveLoopLinkedList {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size = -1;
		public void addLast(int val)
		{
			Node temp = new Node();
			temp.data = val;
			if(head == null)
			{
				head = tail = temp;
				size++;
				return;
			}
			tail.next = temp;
			size++;
		}
		public void size()
		{
			System.out.println("The size of the linked list is : "+size);
		}
		public boolean detectLoop()
		{
			if(this.head == null)
			{
				return false;
			}
			
			Node slow = this.head;
			Node fast = this.head;
			while(fast.next != null && fast.next.next != null)
			{
				if(slow == fast)
				{
					return true;
				}
				slow = slow.next;
				fast = fast.next.next;
			}
			return false;
		}
		 
		// for the removal of the loop using hashset
		public boolean detectandRemoveLoopInLinkedList()
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return false;
			}
			HashSet<Node> set = new HashSet<>();
			Node temp = head;
			Node prev = null;
			while(temp.next != null)
			{
				if(set.contains(temp))
				{
					prev.next = null;
					return true;
				}
				else {
					set.add(temp);
					prev = temp;
					temp = temp.next;
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
