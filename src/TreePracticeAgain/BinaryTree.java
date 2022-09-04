package TreePracticeAgain;

import java.util.*;
public class BinaryTree {

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
		Node node;
		int state;
		public Pair(Node node , int state)
		{
			this.node = node;
			this.state = state;
		}
	}
	
	public static Node createTree(Integer [] arr)
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
					top.node.left = lc;
					Pair lcp = new Pair(lc,1);
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
					top.node.right = rc;
					Pair rcp = new Pair(rc,1);
					st.push(rcp);
					
				}
				index++;
			}
			else if(top.state == 3) {
				st.pop();
			}
		}
		return root;
	}
	
	public static void display(Node root)
	{
		if(root == null)
		{
			return;
		}
		
		String data = " <- " + root.data + " -> ";
		data += (root.left == null)?".":""+root.left.data;
		data += (root.right == null)?".":""+root.right.data;
		System.out.println(data);
		
		display(root.left);
		display(root.right);
	}
	
	static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null,                                       75, 62, null, 70, null, null, 87, null, null};
		    Node root = createTree(arr);
		    display(root);
	}

}
