package Graphs;
import java.util.*;
public class SingleClassOfHasAndPrint {

	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src, int nbr , int wts)
		{
			this.src = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	public static boolean hasPath(ArrayList<Edge> [] graph , int src , int dest , boolean [] visited)
	{
		if(src == dest)
		{
			return true;
		}
		
		visited[src] = true;
		
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				boolean findpaht = hasPath(graph, e.nbr, dest, visited);
				if(findpaht)
				{
					return true;
				}
			}
		}
		visited[src] = false;
		
		return false;
	}
	
	public static void printpath(ArrayList<Edge> [] graph , int src, int dest , boolean[] visited , String path)
	{
		if(src == dest)
		{
			System.out.println(path);
			return;
		}
		visited[src] = true;
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				printpath(graph, e.nbr,dest, visited, path+e.nbr+"");
			}
		}
		visited[src] = false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		ArrayList<Edge> [] graph = new ArrayList[v];
		for(int i = 0 ; i < v ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		int e = scn.nextInt();
		for(int i = 0 ; i < e ; i++)
		{
			int src= scn.nextInt();
			int nbr = scn.nextInt();
			int wts = scn.nextInt();
			graph[src].add(new Edge(src,nbr,wts));
			graph[nbr].add(new Edge(nbr,src,wts));
		}
		boolean [] visited1 = new boolean[v];
		boolean [] visited2 = new boolean[v];
		System.out.println(hasPath(graph,0,6,visited1));
		printpath(graph,0,6,visited2,"0");
	}

}
