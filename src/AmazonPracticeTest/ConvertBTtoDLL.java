package AmazonPracticeTest;

import java.util.Stack;

public class ConvertBTtoDLL {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data)
		{
			this.data = data;
		}
	}
	
	public static class Pair{
		int state;
		Node node;
		public Pair(Node node,int state)
		{
			this.state = state;
			this.node = node;
		}
	}
	
	public static Node treeConstructor(Integer [] arr)
	{
		Node root = new Node(arr[0]);
		Pair p = new Pair(root,1);
		Stack<Pair> st = new Stack<>();
		st.push(p);
		int index = 1;
		while(st.size()>0)
		{
			Pair top = st.peek();
			if(top.state == 1)
			{
				top.state++;
				if(arr[index] != null)
				{
					Node lc = new Node(arr[index]);
					Pair lcp = new Pair(lc,1);
					top.node.left = lc;
					st.push(lcp);
				}
				index++;
			}
			else if(top.state == 2)
			{
				top.state++;
				if(arr[index] != null)
				{
					Node rc = new Node(arr[index]);
					Pair rcp = new Pair(rc,1);
					top.node.right = rc;
					st.push(rcp);
				}
				index++;
			}
			else if(top.state == 3)
			{
				st.pop();
			}
		}
		return root;
	}
	
	public static Node prev;
	
	public static Node head;
	public static Node tail;
	public static void converToDll(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		converToDll(node.left);
		if(prev == null)
		{
			head = prev;
		}
		else {
			node.left = prev;
			prev.right = node;
		}
		prev = node;
		converToDll(node.right);
	}
	
	public static void displayDLL()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.right;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
