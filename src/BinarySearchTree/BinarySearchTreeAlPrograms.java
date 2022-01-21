package BinarySearchTree;

import java.util.Arrays;

public class BinarySearchTreeAlPrograms {

	
	public static class Node{
		int data;
		Node right;
		Node left;
		public Node(int data , Node left , Node right)
		{
			this.data = data;
			this.left  = left;
			this.right = right;
		}
	}
	public static Node constructTree(int [] arr , int li , int ri)
	{
		if(li > ri)
		{
			return null;
		}
		
		int median  = (li+ri)/2;
		int data = arr[median];
		Node lc = constructTree(arr, li, median-1);
		Node rc = constructTree(arr, median+1, ri);
		Node node = new Node(data,lc,rc);
		return node;
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return ;
		}
		String str = "";
		str += node.left == null?"." : node.left.data+"";
		str += "<-"+node.data+"->";
		str += node.right == null?"." : node.right.data+"";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	// First method of sum
	
	public static int sum(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int lSum = sum(node.left);
		int rSum = sum(node.right);
		int tSum = lSum +rSum + node.data;
		return tSum;
	}
	
	// first method for size
	public static int size = 0;
	public static void Size(Node node)
	{
		
		if(node == null)
		{
			return;
		}
		
		Size(node.left);
		Size(node.right);
		size = size+1;
	}
	
	// Second function for the size
	
	public static int size(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int size ;
		int lcSize = size(node.left);
		int rSize = size(node.right);
		size = lcSize + rSize +1;
		return size;
	}
	
	// min in BST
	
	public static int min(Node node)
	{
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		int lmin = min(node.left);
		int rmin = min(node.right);
		int min = Math.min(node.data, Math.min(lmin, rmin));
		return min;
	}
	
	
	// max in bst
	 
	public static int max(Node node)
	{
		if(node == null)
		{
			return Integer.MIN_VALUE;
		}
		int Lm = max(node.left);
		int Rm = max(node.right);
		int min = Math.max(node.data, Math.min(Lm, Rm));
		return min;
	}
	
	// Add node to bst
	public static Node addNode(Node node ,  int data)
	{
		if(node == null)
		{
			Node nnode = new Node(data,null,null);
			return nnode;
		}
		
		if(data < node.data)
		{
			node.left = addNode(node.left,data);
		}
		else if(data > node.data)
		{
			node.right = addNode(node.right,data);
		}
		else {
			
		}
		return node;
	}
	
	
//	public static Node maxNode(Node node)
//	{
//		if(node == null)
//		{
//			return null;
//		}
//		
//	}
	
	// Remove Nodes from BST
	public static Node removeNode(Node node ,  int data)
	{
		if(node == null)
		{
			return null;
		}
		if(node.data > data)
		{
			node.left =removeNode(node.left,data);
		}
		else if(node.data < data)
		{
			node.right =removeNode(node.right,data);
		}
		else {
			if(node.left == null && node.right !=null)
			{
				return node.right;
			}
			else if(node.left != null && node.right == null)
			{
				return node.left;
			}
			else if(node.left == null && node.right == null)
			{
				return null;
			}
			else {
//				Node maxLnode = maxNode(node.left);
				
			}
		}
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[]arr = {50,25,12,37,30,75,62,70,87};
		 Arrays.sort(arr);
		 Node root = constructTree(arr, 0, arr.length-1);
		 display(root);
		 Size(root);
		 System.out.println("Size 1 fuction where static variable is used" + size);
		 System.out.println("Size 1 fuction where static variable is used" + size(root));
		 addNode(root,29);
		 display(root);
	}

}
