package BinaryTree;
import java.util.*;
import java.lang.Math;
public class BinaryTreeAllProgramsPractice {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
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
		return root;
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		String str = "";
		str += node.left == null?".":node.left.data+" ";
		str += "<-"+node.data+"->";
		str += node.right == null?".":node.right.data+" ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static void prefix(Node node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data +" ");
		prefix(node.left);
		prefix(node.right);
	}
	
	public static void postfix(Node node)
	{
		if(node == null)
		{
			return;
		}
		postfix(node.left);
		postfix(node.right);
		System.out.print(node.data+" ");
	}
	
	public static void infix(Node node)
	{
		if(node == null)
		{
			return;
		}
		infix(node.left);
		System.out.print(node.data+" ");
		infix(node.right);
	
	}
	
	public static int Max(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		
		int max =  Integer.MIN_VALUE;
		int left = Max(node.left);
		int right = Max(node.right);
		max = Math.max(node.data, Math.max(left, right));
		return max;
	}
	
	public static int Min(Node node)
	{ 
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		
		int min =  Integer.MAX_VALUE;
		int left = Min(node.left);
		int right = Min(node.right);
		min = Math.min(node.data, Math.min(left, right));
		return min;
	}
	
	public static int size(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int size = 0;
		int lsize = size(node.left);
		int rsize = size(node.right);
		size = lsize+rsize+1;
		return size;
	}
	
	public static int height (Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int height = 0;
		int lHight = height(node.left);
		int rHight = height(node.right);
		height = Math.max(lHight, rHight) +1;
		return height;
	}
	 // iterative access for pre post in
	// state == 1 pre -> add it to the pre -> increase the state -> if top.node.left != null add it to the stack
	// state  == 2 in -> -> add it to the in -> increase the state -> if top.node.left != null add it to the stack
	// state == 3 post & pop
	
	public static void IterativeTraversing(Node node)
	{	
		String pre = "";
		String in = "";
		String post = "";
		
		Stack<Pair> st = new Stack<>();
		Pair p = new Pair(node,1);
		st.push(p);
		while(st.size()>0)
		{
			Pair top = st.peek();
			if(top.state==1)
			{
				top.state++;
				pre += top.node.data +" ";
				if(top.node.left != null)
				{
					Pair lPair = new Pair(top.node.left , 1);
					st.push(lPair);
				}
			}
			else if(top.state == 2)
			{
				top.state++;
				in += top.node.data +" ";
				if(top.node.right != null)
				{
					Pair rPair = new Pair(top.node.right , 1);
					st.push(rPair);
				}
			}
			else{
				post += top.node.data+" ";
				st.pop();
			}
		}
			
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
	
	// all child nodes
	public static void printAllRootNodes(Node node)
	{
		if(node == null)
		{
			return ;
		}
		
		if(node.left == null && node.right == null)
		{
			System.out.print(node.data);
		}
		
		printAllRootNodes(node.left);
		printAllRootNodes(node.right);
		
	}
	
	// node to root 
	public static void nodeToRoot(Node node,String path)
	{
		if(node == null)
		{
			return;
		}
		if(node.left == null & node.right == null)
		{
			System.out.println(path + node.data);
			
		}
		nodeToRoot(node.left , path+node.data+" ");
		nodeToRoot(node.right, path+node.data+" ");
		
	}
	
	public static void LevelOrder(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(q.size()>0)
		{
			int size = q.size();
			for(int i = 0 ; i < size ; i++)
			{
				Node node = q.remove();
				System.out.print(node.data +" ");
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
	
	
	public static void LevelOrderRightToLeft(Node root)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while(q.size()>0)
		{
			int size = q.size();
			for(int i = 0 ; i < size ; i++)
			{
				Node node = q.remove();
				System.out.print(node.data +" ");
				if(node.right != null)
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
	
	// find
	// Base Cases -> null check , end check
	// root is the destination
	static ArrayList<Integer> list = new ArrayList<>();
	public static boolean find(Node node ,  int destination)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.data == destination)
		{
			list.add(node.data);
			return true;
		}
		
		boolean lfind = find(node.left , destination);
		if(lfind)
		{
			list.add(node.data);
			return true;
		}
		
		boolean rfind = find(node.right, destination);
		if(rfind)
		{
			list.add(node.data);
			return true;
		}
		return false;
	}
	
	
	// diameter of a binary Tree
	public static int dia1(Node node)
	{
		if(node  == null)
		{
			return 0;
		}
		
		int ldia = dia1(node.left);
		int rdia = dia1(node.right);
		int mdia = height(node.left) + height(node.right)+2;
		int dia = Math.max(mdia, Math.max(rdia, mdia));
		return dia;
	}
	// another method for diameter
	
	public static class DiaPair{
		int height;
		int dia;
	}
	
	public static DiaPair dia2(Node node)
	{
		if(node == null)
		{
			DiaPair bp = new DiaPair();
			bp.height = -1;
			bp.dia = 0;
			return bp;
		}
		
		DiaPair ldia = dia2(node.left);
		DiaPair rdia = dia2(node.right);
		DiaPair myPair = new DiaPair();
		myPair.height = Math.max(ldia.height, rdia.height)+1;
		myPair.dia = Math.max(ldia.height + rdia.height+2, Math.max(ldia.dia, rdia.dia));
		return myPair;
	}
	
	public static class bstPair{
		boolean isbst;
		int max;
		int min;
	}
	
	public static bstPair isBst(Node node)
	{
		if(node == null)
		{
			bstPair bp = new bstPair();
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.isbst = true;
			return bp;
		}
		
		bstPair islBST = isBst(node.left);
		bstPair isrBST = isBst(node.right);
		bstPair myPair = new bstPair();
		myPair.min = Math.min(myPair.min, Math.min(islBST.min,isrBST.min)); 
		myPair.min = Math.min(myPair.min, Math.min(islBST.min,isrBST.min));
		myPair.isbst = islBST.isbst && isrBST.isbst && node.data>islBST.max && node.data < isrBST.min;
		return myPair;
	}
	
	
	
	public static class BalancedTree
	{
		boolean isBal;
		int height;
	}
	
	public static BalancedTree BalancedTree(Node node)
	{
		if(node == null)
		{
			BalancedTree bp = new BalancedTree();
			bp.isBal = true;
			bp.height = -1;
		}
		
		BalancedTree lp = BalancedTree(node.left);
		BalancedTree rp = BalancedTree(node.right);
		BalancedTree mp = new BalancedTree();
		int gap = Math.abs(lp.height - rp.height);
		if(gap > 1)
		{
			mp.isBal = false;
		}
		int th = Math.max(mp.height, mp.height)+1;
		return mp;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		 Node root = treeConstructor(arr);
		 System.out.println("Tree");
		 display(root);
		 System.out.println("Prefix");
		 prefix(root);
		 System.out.println("Postfix");
		 postfix(root);
		 System.out.println("Infix");
		 infix(root);
		 System.out.println("Height");
		 height(root);
		 System.out.println("Max"+ Max(root));
		 System.out.println("Min"+Min(root));
		 System.out.println("size"+size(root));
		 IterativeTraversing(root);
		 
		 printAllRootNodes(root);
		 
		 System.out.println("Path to root");
		 nodeToRoot(root,"");
		 
		 find(root, 30);
		 list.sort(Collections.reverseOrder());
		 System.out.println(list);
		 
		 System.out.println("Level order");
		 LevelOrder(root);
		 System.out.println("Level order");
		 LevelOrderRightToLeft(root);
		 
		
	}

}
