package BinaryTree;

import java.util.Stack;

import BinaryTree.BinaryTree.Node;

public class FindRootToNode {

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
					Pair lp = new Pair(lc,1);
					top.node.left = lc;
					st.push(lp);
				}
				index++;
			}
			else if(top.state == 2)
			{
				top.state++;
				if(arr[index] != null)
				{
					Node rc = new Node(arr[index]);
					Pair rp = new Pair(rc,1);
					top.node.right = rc;
					st.push(rp);
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
	
	
	public static void rootToNode(Node node , int destination , String path  )
	{
		if(node == null)
		{
			return;
		}
		if(node.data == destination)
		{
			System.out.println(path+node.data);
			
		}
		rootToNode(node.left,destination,path+node.data+" ");
		rootToNode(node.right,destination,path+node.data+" ");
	}
	
	public static void rootTochild(Node node, String path)
	{
		if(node == null)
		{
			return;
		}
		
		if(node.left == null && node.right == null)
		{
			System.out.println(path+node.data);
		}
		
		rootTochild(node.left , path+node.data+" ");
		rootTochild(node.right, path+node.data+" ");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

		
		    Node root = treeConstructor(arr);
		    rootToNode(root, 37 ,"");
		    rootTochild(root,"");
		
	}

}
