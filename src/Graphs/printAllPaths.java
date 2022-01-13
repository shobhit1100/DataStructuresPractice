package Graphs;
import java.util.*;
public class printAllPaths {
	
	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src , int nbr , int wts)
		{
			this.src = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	public static void printAllPaths(ArrayList<Edge> []  graph , int src , int dest , boolean [] visited, String psf)
	{
		if(src == dest)
		{
			System.out.println(psf);
			return ;
		}
		
		visited[src] = true;
		
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				printAllPaths(graph, e.nbr, dest, visited , psf + e.nbr);
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
			int src = scn.nextInt();
			int nbr = scn.nextInt();
			int wts = scn.nextInt();
			graph[src].add(new Edge(src,nbr,wts));
			graph[nbr].add(new Edge(nbr,src,wts));
		}
		
		boolean [] visited = new boolean[v];
		
		printAllPaths(graph , 0 , 6 , visited, 0+"");
		
		
		
	}

}
