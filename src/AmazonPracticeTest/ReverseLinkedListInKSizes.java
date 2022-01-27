package AmazonPracticeTest;

public class ReverseLinkedListInKSizes {

	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		public void addLast(int data)
		{
			Node temp = new Node();
			temp.data = data;
			
			if(head == null)
			{
				head = tail = temp;
				size++;
				return;
			}
			
			tail.next = temp;
			tail = temp;
			size++;
		}
		
		public void addFirst(Node node)
		{
			if(head == null)
			{
				head = tail = node;
				size++;
				return;
			}
			
			node.next = head;
			head = node;
			size++;
		}
		
		public Node removeNodeFirst()
		{
			if(head == null)
			{
				return null;
			}
			
			Node temp = head;
			head = head.next;
			size--;
			return temp;
		}
		
		// we need two list first is previous and second is next
		// if temp is null that means this will be our first list
		// in that case we will iterate through the list till k size
		// and remove a node from it and add it to the last
		
		public void reverseinKSize(int k)
		{
			LinkedList prev  = null;
			LinkedList next = new LinkedList();
			while(this.size >0)
			{
				if(this.size>k)
				{
					for(int i = 0 ; i < k ; i++)
					{	
					Node tempNode = this.removeNodeFirst();
					next.addFirst(tempNode);
					}
				}
				else {
					int lSize = this.size;
					for(int i = 0 ; i < lSize ; i++)
					{
						Node tempNode = this.removeNodeFirst();
						next.addFirst(tempNode);
					}
				}
				
				if(prev == null)
				{
					prev = next;
				}
				else {
					prev.tail.next = next.head;
					prev.tail = next.tail;
					prev.size += next.size;
				}	
			}
			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
