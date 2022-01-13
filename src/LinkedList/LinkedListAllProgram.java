package LinkedList;
import java.util.*;
public class LinkedListAllProgram {

	public static class Node{
		int data;
		Node next;
	}	
	
	public static class Likedlist{
		Node head;
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
				tail = temp;
				
			}
			size++;
		}
		public void display()
		{
			int index = 0; // initially index == 0
			Node temp = new Node(); // make a node temp
			temp = head; // initialize temp as head
			temp.next = head.next;
			while(index<size ) // if index is smaller than size
			{
				System.out.println(temp.data); // print temp data
				temp = temp.next; // temp will be equal to temp.next
				index++; // index will be incremented
			}
		}
		public void removeFirst()
		{
			if(size == 0) // if size == 0 
			{
				System.out.println("There is no data in the list"); // list is already empty.
				return;
			}
			if(size == 1) // if size == 1 , make head and tail equals to 1.
			{
				head = tail = null;
			}
			else {
				head = head.next; // else head will be head.next
			}
			size--; // and size will be subtracted by 1.
			System.out.println("The data has been successfullt removed"); // print the message that the node is remoced.
		}
		public void size()
		{
			System.out.println("The size of the linked list is : "+ size); // simply return size.
		}
		public void getFirst() // return head.data
		{
			System.out.println("The data at the first index is "+head.data);
		}
		public void getLast() // return tail tail.data
		{
			System.out.println("The data at the last index is "+tail.data);
		}
		public void getAt(int index) // take the index in the parameters
		{
			if(index<0 || index>size) // if index is less than 0 or grater than size print an message to enter correct index.
			{
				System.out.println("please enter the index under the list size");
			}						// else
			Node temp = head; //initialize the temp Node as head;
//			int i = 0;
//			while(i<index-1)
//			{
//				temp = temp.next;
//				i++;
//			}
			for(int i = 0 ; i < index ; i++) // use a for loop to iterate till the index of the linked list
			{
				temp = temp.next; // and temp will be temp.next
			}
			
			System.out.println("The data at the "+index + " is "+ temp.data); // at the end print the data at that index
		}
		
		public void addFirst(int val) // take the value in the parameter
		{
			Node temp = new Node(); // initialze temp to head
			temp.data = val;
			temp.next = head;
			if(size == 0)	// if size == 0 
			{
				head = tail = temp; // head == tail == temp
			}
			else {
				head = temp; //else head == temp;
			}
			size++; // adding therefore size will be incremented
		}
		
		public void removeLast()
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
			}
			if(size == 1)
			{
				head = tail = null;
			}
			else {                                    // initialise temp to head.
				Node temp = head;
				for(int i = 0 ; i < size-2 ; i++)	 	  //	iterate till size-2
				{
					temp = temp.next;                	// till then temp will be temp.next
				}
				tail = temp;						  // make tail as temp
				tail.next = null;					 // and temp.next as null
			}
			size--;									// decrement the size						
		
		}
		
		public void RemoveAtIndex(int index)	// iterate till index-1
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
			}
			if(size == 1)
			{
				head = tail = null;
			}
			else {
				Node temp = head;
				for(int i =0 ; i < index-1;i++)
				{
					temp = temp.next;		
				}
				temp.next = temp.next.next;				// set temp.next = temp.next.next
			}
		}
		
		public Node getNodeAt(int index)
		{
			if(size == 0 || index>size)
			{
				System.out.println("Please enter the correct index.");
				return null;
			}
			else {
				Node temp = head;
				for(int i = 0 ; i < index-1 ; i++)
				{
					temp = temp.next;
				}
				return temp;
			}
		}
		
		public void reverseDI() // reverse data iterative needs a getNode function to get the node
		{
			if(size == 0)
			{
				System.out.println("The list is empty");
			}
			else {				
				int li = 0;		// left index as 1
				int ri = size;	// right index as size
				while(li<ri)	// while li < ri 	
				{
					Node ln = getNodeAt(li);	// get the node at left index
					Node rn = getNodeAt(ri);	// get the node at giht index
					int data = ln.data;			// put the data of left node int temporary integer data variable.
					ln.data = rn.data;			// not assign left node to right node
					rn.data = data;				// assign right node to data
					li++;						// left index++
					ri--;						// right index--
				}
			}
		}
		
		public void reverPI()				// in reverse pointer iterative we are using current , temp and prev to reverse a linked list.
		{
			if(size == 0)					
			{
				System.out.println("The list is empty");
			}
			else {
				Node prev = null;
				Node current = head;
				while(current != null)
				{
					Node temp = current.next;
					current.next = prev;
					prev = current;
					current = temp;
				}
				Node t = head;
				head = tail;
				tail = t;
			}
		}
		
		public void ReverseIterativeHelper(Node node)
		{
			if(node == null)
			{
				return ;
			}
			ReverseIterativeHelper(node.next);
			System.out.println(node.data);
		}
		
		public void reverseIterative()
		{
			ReverseIterativeHelper(this.head);
		}
		
		public void foldhelper(Node node , int floor)
		{
			if(node == null)
			{
				return ;
			}
			
			foldhelper(node.next,floor+1);
			
			if(floor > size/2)
			{
				Node temp = fleft.next;
				fleft.next = node;
				node.next = temp;
				fleft = temp;
			}
			else if(floor == size/2) {
				tail = node;
				tail.next = null;
				
			}
			
			
			
			
		}
		
		Node fleft;
		public void fold()
		{
			fleft = head;
			foldhelper(head,0);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn  = new Scanner(System.in);
		Likedlist list = new Likedlist();
		int i = 0;
		while(i != 1)
		{
				System.out.println("Enter the value to be added");
				int val = scn.nextInt();
				list.addLast(val);
				System.out.println("Do you want to continue ? press 1 for no or else press any number");
				i = scn.nextInt();
		}
		System.out.println("Linked list after the desired operaitons");
		list.display();
		
		System.out.println("Do you want to remove the data from linked list ? press 0 for yes or else pressa any key");
		i = scn.nextInt();
		while(i != 1)
		{
			list.removeFirst();
			System.out.println("Do you want to continue ? press 1 for no or else press any number");
			i = scn.nextInt();
		}
		System.out.println("Linked list after the desired operaitons");
		list.display();
		System.out.println("First value from the linked list");
		list.getFirst();
		System.out.println("Last value from the linked list");
		list.getLast();
		System.out.println("Index you want to get from the linked list");
		i = scn.nextInt();
		list.getAt(i);
		
		list.reverseDI();
		System.out.println("Linked list after the reverse operaiton");
		list.display();
		
		scn.close();
		
	}

}
