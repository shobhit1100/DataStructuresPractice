package AmazonPracticeTest;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import BinaryTree.FindRootToNode.Node;

public class printZigZagTree {

	public static class Node{
		int data ;
		Node left ;
		Node right;
		public Node(int data)
		{
			this.data = data;
		}
	}
	public static class Pair
	{
		int state;
		Node node;
		public Pair(Node node,int state)
		{
			this.node = node;
			this.state = state;
		}
	}
	public static Node constructTree(Integer [] arr) {
		Node root = new Node(arr[0]);
		Pair pair = new Pair(root,1);
		Stack<Pair> st = new Stack<>();
		st.push(pair);
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
			else if(top.state == 3) {
				st.pop();
			}
		}
		return root;
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		String str = "";
		str += node.left == null?".":node.left.data+"";
		str += "<-"+node.data+"->";
		str += node.right == null?".":node.right.data+"";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	// this question can not be solved using queue as using queue the problem is that it will insert always in the front.
	// and if at the next level we will store at the front then we will not be able to get the correct order.
	 // there for we will use the stack to solve this particular question.
	// we will be using two stack to slve this problem and one temp stack to exchange the data.
	
	public static void zigZag(Node node)
	{	
		Stack<Node> st = new Stack<>();
		boolean leftToRight = true;
		Stack<Node> nextLevel = new Stack<>();
		st.push(node);
		while(st.size()>0)
		{
			Node valueNode = st.pop(); // pop the element
			System.out.print(valueNode.data+" ");
			if(leftToRight)
			{
				if(valueNode.left!=null)
				{
				nextLevel.push(valueNode.left);
				}
				if(valueNode.right!=null)
				{
				nextLevel.push(valueNode.right);
				}
			}
			else {
				if(valueNode.right!=null)
				{
				nextLevel.push(valueNode.right);
				}
				if(valueNode.left!=null)
				{
				nextLevel.push(valueNode.left);
				}
			}
			if(st.isEmpty())
			{
				leftToRight = !leftToRight;
				Stack<Node> temp = st;
				st = nextLevel;
				nextLevel = temp;
			}
			//System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

			
		    Node root = constructTree(arr);
		    display(root);
		    zigZag(root);
	}

}
