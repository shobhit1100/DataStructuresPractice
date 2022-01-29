package AmazonPracticeTest;

public class AddtTwoNumbersRepresentedByLinkedList {

	// to add the two linked list first we need to go at the last node of both the node
	// after that we need to add both the node data
	// after that put the remained in the node 
	// and return the quotient
	// add the quotient in the next node and if tthe first linked list is empty 
	// then the second which has the node left will be used in addition
	
	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		int size()
		{
			return size;
		}
		
		public void addFirst(int val)
		{
			Node temp = new Node();
			temp.data = val;
			if(size == -1)
			{
				head = tail = temp;
				return;
			}
			temp.next = head;
			head = temp;
		}
		
		public int addLinkedList(Node l1 , int pv1 , Node l2 , int pv2 , LinkedList res)
		{
			if(l1 == null && l2 == null)
			{
				return 0;
			}
			
			int data = 0;
			if(pv1 > pv2)
			{
				int oc = addLinkedList(l1.next, pv1-1, l2, pv2,res);
				data = oc + l1.data;
			}
			else if(pv2 > pv1)
			{
				int oc1 = addLinkedList(l1,pv1,l2.next,pv2-1,res);
				data = oc1+l2.data;
				
			}
			else {
				int oc2 = addLinkedList(l1.next,pv1-1,l2.next,pv2-1,res);
				data = oc2+l1.data+l2.data;
			}
			
			
			int c = data/10;
			int r = data%10;
			res.addFirst(r);
			return c;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
