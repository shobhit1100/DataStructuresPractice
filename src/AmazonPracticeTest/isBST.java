package AmazonPracticeTest;

import java.util.Stack;

public class isBST {

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
					top.node.right= rc;
				}
				index++;
			}
			else {
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
		str += node.left == null?'.':node.left.data+" ";
		str += "<-"+node.data+"->";
		str += node.right == null?'.':node.right.data+" ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static class bstPair
	{
		int min;
		int max;
		boolean isbst;
	}
	
	public static bstPair checkBST(Node node)
	{
		if(node == null)
		{
			bstPair bsPair = new bstPair();
			bsPair.max = Integer.MIN_VALUE;
			bsPair.min = Integer.MAX_VALUE;
			bsPair.isbst = true;
			return bsPair;
		}
		
		bstPair islbst = checkBST(node.left);
		bstPair isrbst = checkBST(node.right);
		bstPair myPair = new bstPair();
		myPair.max = Math.max(node.data, Math.max(islbst.max,isrbst.max));
		myPair.min = Math.min(node.data, Math.min(islbst.min, isrbst.min));
		myPair.isbst = islbst.isbst && isrbst.isbst && node.data > islbst.max && node.data <isrbst.min;
		return myPair;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = treeConstructor(new Integer[3]);
		bstPair checkbst = checkBST(node);
		System.out.println(checkbst.isbst);
		
	}

}
