 package BinaryTree;
import java.util.*;
public class BinaryTree {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data)
		{
			this.data = data;
//			this.left = left;
//			this.right = right;
		}
	}
	
	public static class Pair{
		int state;
		Node node;
		public Pair(Node node , int state)
		{
			this.node = node;
			this.state = state;
			
		}
	}
	
	public static Node treeConstructor(Integer [] arr ) {
		Node node = new Node(arr[0]);
		Pair p = new Pair(node,1);
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
		return node;
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		String str = "";
		str += node.left == null?".":node.left.data+" ";
		str += " <- "+node.data +" -> ";
		str += node.right == null?".":node.right.data+" ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static int min(Node node)
	{
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		
		int minl = min(node.left);
		int minr = min(node.right);
		
		int minData = Math.min(node.data , Math.min(minl, minr));
		return minData;
	}
	

	public static int max(Node node)
	{
		if(node == null)
		{
			return Integer.MIN_VALUE;
		}
		
		int maxl = max(node.left);
		int maxr = max(node.right);
		
		int maxData = Math.max(node.data , Math.max(maxl, maxr));
		return maxData;
	}
	
	public static int size(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int left_size = size(node.left);
		int right_size = size(node.right);
		int size = left_size+right_size+1;
		return size;
	}
	
	public static int height(Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int th = Math.max(lh, rh) + 1;
		return th;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

		    Node root = treeConstructor(arr);
		    display(root);
		    System.out.println("Min Value : " + min(root));
		    System.out.println("Min Value : " + max(root));
		    System.out.println("Size of tree : " + size(root));
		    System.out.println("Height of tree : " + height(root));
	}

}
