package Graphs;
import java.util.*;
public class hasPathPractice {
	
	
	public static class Edges{
		 int src ;
		 int nbr;
		 int wts;
		 public Edges(int src , int nbr , int wts)
		 {
			 this.src = src;
			 this.nbr = nbr;
			 this.wts = wts;
		 }
	}
	
	// this problem is similar to flood fill.
	// In this case also a loop will start because the nbr of 0 is 1 and when 1 will make a call to its neighbour then
	// the function will have the source as 1 , nut the nbr of 1 is also 0 , then the function for src 1 will again make
	// a call to the initial src i.e 0
	// and after this loop , the stack will get overflow.
	// to prevent this we will be using a visited Array and it will store the edges
	// to make sure if that edges has been visited or not.
	public static boolean hasPath(ArrayList<Edges> [] arr , int sc , int dest , boolean [] visited)
	{
		if(sc == dest)
		{
			return true;
		}
		
		visited[sc] = true;
		for(Edges e : arr[sc])
		{
			if(visited[e.nbr] == false)
			{
			boolean found_Path = hasPath(arr,e.nbr , dest,visited);
			if(found_Path)
			{
				return true;
			}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int edges = scn.nextInt();
		ArrayList<Edges> [] graph = new ArrayList[edges];
		
		for(int i = 0 ; i < edges ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		int vertices = scn.nextInt();
		
		for(int i = 0 ; i < vertices ; i++)
		{
			int src = scn.nextInt();
			int nbr = scn.nextInt();
			int wts = scn.nextInt();
			graph[src].add(new Edges(src,nbr,wts));
			graph[nbr].add(new Edges(nbr,src,wts));
		}
		
		for(ArrayList<Edges> e : graph)
		{
			for(int i = 0 ; i < e.size() ; i++)
			{
				System.out.println("src :" + e.get(i).src + " nbr :" + e.get(i).nbr + " wts :"+e.get(i).wts);
			}
		}
		int sc = 0;
		int dest = 6;
		boolean [] visited = new boolean[edges];
		System.out.println(hasPath(graph , sc , dest , visited));
		scn.close();
		
	}

}
