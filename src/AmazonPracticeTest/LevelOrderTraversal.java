package AmazonPracticeTest;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

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
	
	public static Node treeConstructor(Integer [] arr)
	{
		Node root = new Node(arr[0]);
		Pair p = new Pair(root , 1);
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
					st.push(lcp);
					top.node.left = lc;
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
					st.push(rcp);
					top.node.right = rc;
				}
				index++;
			}
			else if(top.state == 2)
			{
				st.pop();
			}
		}
		return root;
	}
	
	public static void printtLeftChild(Node node)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		while(q.size()>0)
		{
			int size = q.size();
			for(int i = 0 ; i < q.size() ; i++)
			{
				node = q.remove();
				System.out.print(node + " ");
				if(node.left != null)
				{
					q.add(node.left);
				}
				if(node.right != null)
				{
					q.add(node.right);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
