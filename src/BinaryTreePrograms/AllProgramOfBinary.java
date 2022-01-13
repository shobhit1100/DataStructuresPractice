package BinaryTreePrograms;
import java.util.*;

import BinaryTreePrograms.targetSumPair.Node;
public class AllProgramOfBinary {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data , Node left , Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static Node treeConstructor(int [] arr, int lo , int hi)
	{
		if(lo>hi)
		{
			return null;
		}
		int mid = (lo+hi)/2;
		Node lc = treeConstructor(arr, lo, mid-1);
		Node rc = treeConstructor(arr, mid+1, hi);
		Node myNode = new Node(arr[mid],lc,rc);
		return myNode;
	}
	
	public static int max(Node node)
	{
		if(node.right != null)
		{
			return max(node.right);
		}
		else {
			return node.data;
		}
	}
//	public static Node maxNode(Node node)
//	{
//		if(node.right != null)
//		{
//			return maxNode(node.right);
//		}
//		else {
//			return node;
//		}
//	}
	public static int min(Node node)
	{
		if(node.left != null)
		{
			return min(node.left);
		}
		else {
			return node.data;
		}
	}
	
	public static boolean find(Node node,int data)
	{
		if(node == null)
		{
			return false;
		}
		if(node.data<data)
		{
			return find(node.right,data);
		}
		else if(node.data>data)
		{
			return find(node.left,data);
		}
		else
		{
			return true;
		}
	}
	public static void display(Node node)
	{
		if(node == null)
		{
			return ;
		}
		String str = "";
		str += node.left == null?".":node.left.data+" ";
		str += " <- "+node.data+ "->";
		str += node.right == null?".":node.right.data+" ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	public static int sum(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int ls = sum(node.left);
		int rs = sum(node.right);
		int sum = ls+rs+node.data;
		return sum;
	}
	public static int size(Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		int ts = Math.max(ls, rs)+1;
		return ts;
	}
	public static Node add(Node node , int data)
	{
		if(node == null)
		{
			return new Node(data, null , null);
		}
		
		if(node.data>data)
		{
			node.right = add(node.right,data);
		}
		else if(node.data <data)
		{
			node.left = add(node.left,data);
		}
		return node;
	}
	public static Node remove(Node node,int data)
	{
		if(node == null)
		{
			return null;
		}
		
		if(node.data>data)
		{
			node.right=remove(node.right,data);
		}
		else if(node.data<data)
		{
			node.left = remove(node.left,data);
		}
		else {
			if(node.left!= null && node.right != null)
			{
				int max = max(node.left);
				node.data = max;
				node.left = remove(node.left,data);
				return node; 
				
			}
			else if(node.left == null && node.right != null)
			{
				return node.right;
			}
			else if(node.left!=null && node.right == null)
			{
				return node.left;
			}
			else {
				return null;
			}
		}
		return node;
	}
	public static void pir(Node node , int d1, int d2)
	{
		if(node == null)
		{
			return ;
		}
		if(node.data>d1 && node.data>d2)
		{
			pir(node.right,d1,d2);
		}
		else if(node.data<d1 && node.data<d2)
		{
			pir(node.left,d1,d2);
		}
		else {
			pir(node.left,d1,d2);
			System.out.println(node.data);
			pir(node.right,d1,d2);
		}
	}
	public static void tsp(Node root ,Node node , int data)
	{
		if(node == null)
		{
			return;
		}
		
		tsp(root ,node.left,data);
		
		int compliment = data - node.data;
		if(compliment > node.data)
		{
		if(find(root,compliment))
		{
			System.out.println(node.data + " " + compliment);
		}
		}
		
		tsp(root,node.right,data);
	}
	
	public static int LCA(Node node , int data , int fdata)
	{
			if(node.data<data && node.right.data<fdata)
			{
				return LCA(node.right, data,fdata);
			}
			else if(node.data > data && node.data > fdata)
			{
				return LCA(node.left,data,fdata);
			}
			else {
				return node.data;
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {12,25,37,40,50,62,60,75,87};
		Node root = treeConstructor(arr, 0, arr.length-1);
		display(root);
		//findTargetSumPair(root , ro ot , 100 );
		System.out.println(max(root));
		System.out.println(min(root));
		System.out.println(find(root,60));
		System.out.println(find(root,88));
		System.out.println(sum(root));
		System.out.println(size(root));
		root = add(root,90);
		root = add(root,100);
		display(root);
		remove(root,90);
		remove(root,100);
		display(root);
		System.out.println(LCA(root,62,75));
		System.out.println("Printing in the range");
		pir(root,12,72);
		tsp(root,root,100);
	}

}
