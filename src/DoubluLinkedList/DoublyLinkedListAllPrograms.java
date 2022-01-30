package DoubluLinkedList;

public class DoublyLinkedListAllPrograms {

	public static class Node{
		int data;
		Node next;
		Node prev;
	}
	
	public static class LinkedList{
		Node head;
		Node tail;
		int size;
		
		public void addFirst(int data)
		{
			Node temp = new Node();
			temp.data = data;
			if(head == null)
			{
				head = tail = temp;
				return;
			}
			temp.next = head;
			head.prev = temp;
			head = temp;
			size++;
		}
		
		public void removeFirs()
		{
			if(size == 0)
			{
				return;
			}
			if(size == 1)
			{
				System.out.println("Node removed " + head.data);
				head = null;
				tail = null;
				size--;
				return;
			}
			Node temp = head;
			head = temp.next;
			head.prev = null;
			temp.next = null;
			size--;		
		}
		
		public void removeLast()
		{
			if(size == 0)
			{
				System.out.println("Linked List is empty.");
				return;
			}
			Node temp = tail;
			tail = tail.prev;
			tail.next = null;
			temp.prev = null;
		}
		
		public void getFirst()
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			System.out.println(head.data);
		}
		
		public void getLast()
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			System.out.println(tail.data);
		}
		
		public void getAt(int index)
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
			}
			Node temp = head;
			for(int i = 0; i < index ; i++)
			{
				temp = temp.next;
			}
			System.out.println("The data at the index is " + temp.data);
		}
		
		public void addAt(int data,int index)
		{
			Node temp = new Node();
			temp.data = data;
			if(size == 0)
			{
				head = tail = temp;
				size++;
				return;
			}
			Node traverse = head;
			for(int i = 0 ; i < index ; i++)
			{
				traverse = traverse.next;
			}
			temp.next = traverse.next;
			Node temp2 = traverse.next;
			temp2.prev = temp;
			traverse.next = temp;
		}
		
		public void removeAt(int index)
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			
			Node temp = head;
			while(index > 0)
			{
				temp = temp.next;
				index--;
			}
			Node prev = temp.prev;
			Node newnext = temp.next;
			prev.next = newnext;
			newnext.prev = prev;
			temp.next = null;
			temp.prev = null;
		}
		
		public void addBefore(int index , int data)
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			Node temp = head;
			Node nodeToBeAdded = new Node();
			nodeToBeAdded.data = data;
			while(index > 0)
			{
				temp = temp.next;
				index--;
			}
			Node prev = temp.prev;
			prev.next = nodeToBeAdded;
			nodeToBeAdded.prev = prev;
			nodeToBeAdded.next = temp;
			temp.prev = nodeToBeAdded;
		}
		
		public void addAfter(int index , int data)
		{
			if(size == 0)
			{
				System.out.println("The lsit os empty");
				return;
			}
			Node temp = new Node();
			temp.data = data;
			Node traverse = head;
			while(index > 0)
			{
				traverse = traverse.next;
			}
			Node nextNode = new Node();
			nextNode = traverse.next;
			// adding now
			traverse.next = temp;
			temp.prev = traverse;
			nextNode.prev = temp;
			temp.next = nextNode;
		}
		
		// adding a function called as getNode
		// to make it more modular
		
		public Node getNode(int index)
		{
			if(index > size)
			{
				System.out.println("Enter the index in the range");
				return null;
			}
			
			Node temp =head;
			while(index > 0)
			{
				temp = temp.next;
				index--;
			}
			return temp;
		}
		public void removeAfter(int index)
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			
			Node temp = getNode(index);
			Node next = temp.next;
			Node prev = temp.prev;
			prev.next = next;
			next.prev = prev;
			temp.next = null;
			temp.next = null;
		}
		
		public void removeBefore(int index)
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
				return;
			}
			
			Node temp = getNode(index);
			Node prev = temp.prev.prev;
			prev.next = temp;
			temp.prev = prev;
			temp.next = null;
			temp.next = null;
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
