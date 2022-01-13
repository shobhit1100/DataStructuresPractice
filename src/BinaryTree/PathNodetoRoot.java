package BinaryTree;
import java.util.*;

import BinaryTree.BinaryTree.Node;
public class PathNodetoRoot {

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
		public Pair(Node node , int state)
		{
			this.node = node;
			this.state = state;
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
			else if(top.state == 3) {
				st.pop();
			}
		}
		return root;
	}
	
	public static ArrayList<Integer> nodetoroot(Node node , int data)
	{
		if(node == null)
		{
			return new ArrayList<>();
		}
		
		if(node.data == data)
		{
			ArrayList <Integer> list = new ArrayList<>();
			list.add(node.data);
			return list;
		}
		
		ArrayList<Integer> llist = nodetoroot(node.left, data);
		if(llist.size()>0)
		{
			llist.add(node.data);
			return llist;
		}
		
		ArrayList<Integer> rlist = nodetoroot(node.right, data);
		if(rlist.size() > 0)
		{
			rlist.add(node.data);
			return rlist;
		}
		
		return new ArrayList<>();
	}
	
	public static void printKlevelDown(Node node , int k)
	{
		if(k<0 || node == null)
		{
			return ;
		}
		
		if(k == 0)
		{
			System.out.print(node.data +" ");
		}
		printKlevelDown(node.left, k-1);
		printKlevelDown(node.right, k-1);
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
	
	public static ArrayList<Node> list;
	
	public static boolean find(Node node , int data)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.data == data)
		{
			list.add(node);
			return true;
		}
		
		boolean fleft = find(node.left,data);
		if(fleft)
		{
			list.add(node);
			return true;
		}
		
		boolean fright = find(node.right,data);
		if(fright)
		{
			list.add(node);
			return true;
		}
		
		return false;
	}
	
	public static void printKlevelDown(Node node , int k , Node blocker)
	{
		if(node == null || k < 0 || node == blocker)
		{
			return;
		}
		if(k == 0)
		{
			System.out.print(node.data+" ");
		}
		printKlevelDown(node.left, k-1);
		printKlevelDown(node.right, k-1);
	}
	
	public static void printnodesKdistance(Node node , int data , int k)
	{
		find(node, data);
		for(int i = 0;i < list.size();i++)
		{
			printKlevelDown(list.get(i), k-i ,  i == 0 ? null : list.get(i-1));
			System.out.println(); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list = new ArrayList();
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		 Node root = treeConstructor(arr);
		 display(root);
		 ArrayList<Integer> mlist = nodetoroot(root,37);
		 System.out.println(mlist);
		// printKlevelDown(root, 2);
		 printnodesKdistance(root, 37, 2);
	}

}
