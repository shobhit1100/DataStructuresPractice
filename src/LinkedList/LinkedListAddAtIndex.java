package LinkedList;
import java.util.*;
public class LinkedListAddAtIndex {

	public static class Node{
		int data;
		Node next;
	}
	public static class LinkedList{
		Node head;;
		Node tail;
		int size;
		public void addLast(int val)
		{
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if(size == 0)
			{
				head = tail = temp;
			}
			else {
				tail.next = temp;
				tail =  temp;
			}
			size++;
		}
		public void addFist(int val)
		{
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			if(size == 0)
			{
				head = tail = temp;
			}
			else {
				temp.next = head;
				head = temp;
			}
		}
		public void addAtIndex(int val , int index)
		{
			if(index == 0)
			{
				addFist(val);
			}
			if(index == size-1)
			{
				addLast(val);
			}
			else {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;
			Node tempData = head;
			for(int i = 0 ; i < index-1 ; i++)
			{
				tempData = tempData.next;
			}
			temp.next = tempData.next;
			tempData.next = temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
