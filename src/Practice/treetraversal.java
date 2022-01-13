package Practice;
import java.io.*;
import java.lang.*;
import java.util.*;

class Node{
	
	int data;
	
	Node left , right ;
	
	Node(int key)
	{
		data = key;
		left = right = null;
		
	}
	
}
public class treetraversal {

	Node node;
	
	treetraversal()
	{
		node = null;
	}
	
	void preorder(Node node)
	{
		if(node == null)
		{
			return;
		}
		else
		{
			preorder(node.left);
			
			preorder(node.right);
			
			System.out.println(node.data + " " );
			
			
		}
	}
	
	public static void main (String [] args)
	{
		treetraversal tree = new treetraversal();
		tree.node = new Node(1);
		tree.node.left = new Node(2);
		tree.node.right = new Node(3);
		tree.node.left.left = new Node (4);
		tree.node.left.right = new Node(5);
		
		tree.preorder(tree.node);
		
		
	}
}
