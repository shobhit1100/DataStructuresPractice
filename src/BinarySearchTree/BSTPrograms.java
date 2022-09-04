package BinarySearchTree;

public class BSTPrograms {
	
	public static class Node{
		int data;
		Node right;
		Node left;
		public Node(int data,Node left,Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node createBinarySearchTree(int [] arr , int low, int high)
	{
		
		if(low>high)
		{
			return null;	
		}
		
		int mid = (low + high)/2;
		int data = arr[mid];
		
		Node lc = createBinarySearchTree(arr, low, mid-1);
		
		Node rc = createBinarySearchTree(arr, mid+1, high);
		
		Node root = new Node(data,lc,rc);
	
		return root;
		
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		display(node.left);
		System.out.println(node.data);		
		display(node.right);	
	}
	
	public static void min(Node node)
	{
		if(node == null)
		{
			return;
		}
		if(node.left == null)
		{
			System.out.println(node.data);
		}
			
		min(node.left);
	}
	
	
	static int sum = 0;
	public static void sum(Node node)
	{
		if(node == null)
		{
			return ;
		}
		
		sum(node.left);
		sum(node.right);
		sum += node.data;
	}
	
	
	 public static int findMin(Node node)
	 {
		 if(node == null)
		 {
			 return Integer.MAX_VALUE;
		 }
		 
		  int lMin = findMin(node.left);
		  int rMin = findMin(node.right);
		  int min = Math.min(lMin, Math.min(node.data, rMin));
		 
		  return min;
	 }
	 
	 public static int findMax(Node node)
	 {
		 if(node == null)
		 {
			 return Integer.MIN_VALUE;
		 }
		 
		 int lMax = findMax(node.left);
		 int rMax = findMax(node.right);
		 int max = Math.max(lMax, Math.max(node.data, lMax));
		 return max;
	 }
	
	 public static Node addNode(Node node, int data)
	 {
		 if(node == null)
		 {
			 return new Node(node.data,null,null);
		 }
		 
		 if(data < node.left.data)
		 {
			 node.left = addNode(node.left,data);
		 }
		 else if(data>node.right.data)
		 {
			node.right = addNode(node.right,data);
		 }
		 
		 return node;
	 }
	 
	 public static Node minNode(Node node)
	 {
		if(node.left == null)
		{
			return node;
		}
		Node minNode =  minNode(node.left); 
		return minNode;
	 }
	 
	 
	 public static boolean find(Node node , int data)
	 {
		 if(node == null)
		 {
			 return false;
		 }
		 if(node.data>data)
		 {
			 find(node.left,data);
		 }
		 else if (node.data<data)
		 {
			 find(node.right,data);
		 }
		 return true;
	 }
	 
	 public static Node removeNode(Node node, int data)
	 {
		 if(node == null)
		 {
			 return null;
		 }
		 
		 if(node.data>data)
		 {
			 removeNode(node.right,data);
		 }
		 else if(node.data < data)
		 {
			 removeNode(node.left,data);
		 }
		 else if(node.left!=null)
		 {
			 return node.left;
		 }
		 else if(node.right != null)
		 {
			 return node.right;
		 }
		 else {
			 Node leftMin = minNode(node);
			 node.data = leftMin.data;
			 node.left = removeNode(node, leftMin.data);
			 return node;
		 }
		 return node;
	 }
	 
	 static int sumNode;
	 
	 public static void rsol(Node node,int sum)
	 {
		 
		 if(node == null)
		 {
			 return;
		 }
		 
		 rsol(node.right,sum);
		 
		 int tempsum = node.data;
		 node.data = sumNode;
		 sumNode += tempsum;
		 
		 rsol(node.left,sum);
		 
		 return;
	 }
	 
	 public Node lca(Node node, int d1, int d2)
	 {
		 if(node == null)
		 {
			 return null;
		 }
		 
		 if(d1>node.data && d2>node.data)
		 {
			 return lca(node.right,d1,d2);
		 }
		 else if(d1<node.data && d2<node.data)
		 {
			 return lca(node.left,d1,d2);
		 }
		 else {
			 return node;
		 }
	 }
	 
	 
	 
}
