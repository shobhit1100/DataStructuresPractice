 package BinaryTree;
import java.util.*;
public class BinaryTree {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data)
		{
			this.data = data;
//			this.left = left;
//			this.right = right;
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
	
	public static Node treeConstructor(Integer [] arr ) {
		Node node = new Node(arr[0]);
		Pair p = new Pair(node,1);
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
		return node;
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
	
	public static int min(Node node)
	{
		if(node == null)
		{
			return Integer.MAX_VALUE;
		}
		
		int minl = min(node.left);
		int minr = min(node.right);
		
		int minData = Math.min(node.data , Math.min(minl, minr));
		return minData;
	}
	

	public static int max(Node node)
	{
		if(node == null)
		{
			return Integer.MIN_VALUE;
		}
		
		int maxl = max(node.left);
		int maxr = max(node.right);
		
		int maxData = Math.max(node.data , Math.max(maxl, maxr));
		return maxData;
	}
	
	public static int size(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int left_size = size(node.left);
		int right_size = size(node.right);
		int size = left_size+right_size+1;
		return size;
	}
	
	public static HashMap<Integer , ArrayList<Integer>> hmap = new HashMap<>();
	public static void printVertical(Node node, int hd)
	{
		if(node == null)
		{
			hd = 0;
			return;
		}
		
		if(hmap.containsKey(hd))
		{
			ArrayList<Integer> list = hmap.get(hd);
			list.add(node.data);
//			System.out.println("In contains hd->"+hd +"node -> "+node.data);
			hmap.put(hd, list);
		}
		else {
			ArrayList<Integer> list = new ArrayList<>();
//			System.out.println("In adding new element hd->"+hd +"node -> "+node.data);
			list.add(node.data);
			hmap.put(hd, list);
		}
		printVertical(node.left ,hd-1);
		printVertical(node.right,hd+1);
	}
	
	
	public static int height(Node node)
	{
		if(node == null)
		{
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int th = Math.max(lh, rh) + 1;
		return th;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

		    Node root = treeConstructor(arr);
		    display(root);
		    System.out.println("Min Value : " + min(root));
		    System.out.println("Min Value : " + max(root));
		    System.out.println("Size of tree : " + size(root));
		    System.out.println("Height of tree : " + height(root));
		    System.out.println("****************************************");
		    printVertical(root,0);
		    System.out.println("****************************************");
		    
		    Set<Integer> set = hmap.keySet();
			ArrayList<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list);
			
			for(int i = 0 ; i < list.size() ; i++)
			{
				ArrayList<Integer> itrtList = 	hmap.get(list.get(i));
				for(int k :itrtList)
				{
					System.out.print(k +" ");
				}
				System.out.println();
			}
			
//		    for(Map.Entry<Integer, ArrayList<Integer>> map : hmap.entrySet())
//		    {
//		    	for(int i = 0 ; i < map.getValue().size() ; i++)
//		    	{
//		    		System.out.print(map.getValue().get(i)+" ");
//		    	}
//		    	System.out.println();
//		    }
	}

}
