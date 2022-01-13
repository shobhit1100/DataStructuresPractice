package BinaryTreePrograms;

public class targetSumPair {

	public static class Node{
		int data;
		Node left ;
		Node right;
		public Node(int data , Node left , Node right)
		{	
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node treeConstructor(int [] arr , int min , int max)
	{
		if(min>max)
		{
			return null;
		}
		int mid = (min+max)/2;
		Node lc = treeConstructor(arr, min, mid-1);
		Node rc = treeConstructor(arr, mid+1, max);
		Node myPair = new Node(arr[mid],lc,rc);
		return myPair;
	}
	
	public static void display(Node node)
	{
		if(node == null)
		{
			return;
		}
		String str = "";
		str += node.left == null?".":node.left.data+" ";
		str += " <- "+node.data+" -> ";
		str += node.right == null?".":node.right.data+" ";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
	public static boolean find(Node node , int data)
	{
		if(node == null)
		{
			return false;
		}
		
		if(node.data == data)
		{
			return true;
		}
			
		boolean filc = find(node.left,data);
		if(filc)
		{
			return true;
		}
		
		boolean firc = find(node.right,data);
		if(firc)
		{
			return true;
		}
		
		return false;
		
	}
	
	public static void findTargetSumPair(Node root , Node node ,int target)
	{
		
		
		if(node == null)
		{
			return;
		}
		findTargetSumPair(root, node.left, target);
		
		int comp = target - node.data;
		if(comp > node.data)
		{
			if(find(root,comp))
			{
				System.out.println(node.data+" "+comp);
			}
		}
		
		findTargetSumPair(root, node.right, target);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {12,25,37,40,50,62,60,75,87};
		Node root = treeConstructor(arr, 0, arr.length-1);
		display(root);
		findTargetSumPair(root , root , 100 );
	}

}
