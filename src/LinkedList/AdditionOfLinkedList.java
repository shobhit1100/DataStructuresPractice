package LinkedList;

public class AdditionOfLinkedList {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		public void addFirst(int val)
		{
			Node temp = new Node();
			temp.data = val;
			if(size == 0)
			{
				head = tail = temp;
			}
			else
			{
				temp.next = head;
				head = temp;
			}
			size++;
		}
		
		public int size()
		{
			return size;
		}
		
		public void display()
		{
			Node temp = head;
			int index = 0;
			while(index<size)
			{
				System.out.println(temp.data);
				temp = temp.next;
				index++;
			}
		}
		
		public int listAdderHelper(Node Fnode , int pv1 , Node Snode , int pv2 , LinkedList res)
		{
			if(Fnode == null && Snode == null)
			{
				return 0;
			}
			int sum = 0;
			if(pv1>pv2)
			{
				int oc = listAdderHelper(Fnode.next , pv1-1 , Snode , pv2,res);
				sum = Fnode.data+oc;
				
			}
			
			if(pv2>pv1)
			{
				int oc = listAdderHelper(Fnode , pv1 , Snode.next , pv2-1,res);
				sum = Snode.data+oc;				
			}
			else {
				int oc = listAdderHelper(Fnode.next, pv1-1, Snode.next, pv2-1, res);
				sum = oc+Fnode.data+Snode.data;
			}
			
			int digit = sum%10;
			int c = sum/10;
			res.addFirst(digit);
			return c;
			
		}
		
		public LinkedList addList(LinkedList one , LinkedList two)
		{
			LinkedList res = new LinkedList();
			int oc = listAdderHelper(one.head,one.size ,two.head, two.size ,res );
			if(oc > 0)
			{
				res.addFirst(oc);
			}
			return res;
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
