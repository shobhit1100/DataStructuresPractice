package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePractice {

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
		Pair(Node node,int state)
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
		int Index = 1;
		while(st.size() > 0)
		{
			Pair top = st.peek();
			if(top.state == 1)
			{
				top.state++;
				if(arr[Index] != null)
				{
					Node lc = new Node(arr[Index]);
					Pair lcp = new Pair(lc,1);
					top.node.left = lc;
					st.push(lcp);
				}
				Index++;
			}
			else if(top.state == 2)
			{
				top.state++;
				if(arr[Index] != null)
				{
					Node rc = new Node(arr[Index]);
					Pair rcp = new Pair(rc,1);
					top.node.right = rc;
					st.push(rcp);
				}
				Index++;
			}
			else {
				st.pop();
			}
		}
		return root;
	}
	
	public static int size(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int ls = size(node.left);
		int rs = size(node.right);
		int totalSize  = ls+rs+1;
		return totalSize;
	}
	
	public static int height(Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int height = Math.max(lh, rh) +1;
		return height;
	}
	
	public static int min(Node node)
	{
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		
		int minleft = min(node.left);
		int minright = min(node.right);
		int min = Math.min(node.data,Math.min(minleft, minright));
		return min;
	}
	
	public static int max(Node node)
	{
		if(node == null)
		{
			return Integer.MIN_VALUE;
		}
		int minleft = min(node.left);
		int minright = min(node.right);
		int totalMin = Math.min(node.data,Math.min(minleft, minright));
		return totalMin;
	}
	
	public static int sum(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int rsum = sum(node.right);
		int lsum = sum(node.right);
		int totalSum = rsum+lsum+node.data;
		return totalSum;
	}
	// second method for sum
	
	static int treeSum = 0;
	public static void sum2(Node node)
	{
		if(node == null)
		{
			return;
		}
		
		sum(node.left);
		sum(node.right);
		treeSum += node.data;
	}
	
	public static void displayTree(Node node)
	{
		if(node == null)
		{
			return ;
		}
		String str = "";
		
		str += node.left == null?".":node.left.data+"";
		str += "<-"+node.data+"->";
		str += node.right == null?".":node.right.data+"";
		System.out.println(str);
	}
	
	public static void printLebelOrder(Node node)
	{
		if(node == null)
		{
			return ;
		}
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		
		while(q.size()>0)
		{
			int count = q.size();
			for(int i = 0 ; i < count ; i++)
			{
				node = q.remove();
				System.out.print(node.data + " ");
				if(node.right!= null)
				{
				q.add(node.right);
				}
				if(node.left != null)
				{
				q.add(node.left);
				}
			}
			System.out.println();
		}
	}
	static String pre = "";
	static String post = "";
	static String in = "";
	public static void prepostinTraversal(Node node)
	{
		if(node == null)
		{
			return;
		}
		pre += node.data+"";
		prepostinTraversal(node.left);
		in += node.data+"";
		prepostinTraversal(node.right);
		post += node.data+"";
	}
	
	public static void IterativePrePostIn(Node node)
	{
		if(node == null)
		{
			return;
		}
		Pair p = new Pair(node,1);
		Stack<Pair> st = new Stack<>();
		st.push(p);
		String pre = "";
		String post = "";
		String in = "";
		while(st.size()>0)
		{
			
			Pair top = st.peek();
			if(top.state == 1)
			{
				pre += top.node.data;
				top.state++;
				if(top.node.left!= null)
				{
					Pair lp = new Pair(top.node.left,1);
					st.push(lp);
				}
			}
			else if(top.state == 2)
			{
				in += top.node.data;
				top.state++;
				if(top.node.right!= null)
				{
					Pair rp = new Pair(top.node.right,1);
					st.push(rp);
				}
			}
			else {
				post += top.node.data+"";
				st.pop();
			}
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		System.out.println("pre -> "+pre);
		System.out.println("post -> "+post);
		System.out.println("in -> "+in);
	}

}
