package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class isBipartite {
	
	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src ,int nbr,int wts){
			this.src = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	// lets create our pair class
	public static class Pair{
		int v;
		int level;
		String psf;
		public Pair(int v ,	int level , String psf )
		{
			this.v = v;
			this.level = level;
			this.psf = psf;
		}
	}
	
	public static boolean checkBipartite(ArrayList<Edge> [] graph , int v , int [] visited)
	{
		// to check Bipartite we need to make sure the sets of the graph are mutually exclusive and exhaustive
		// if the graph is disconnected and if the graph is cyclic and having an even length that it will be a bipartite graph
		// we will  be making the use of the BFS in this question and then we will go with the conventional algorithm of the BFS
		// r m* w a* -> remove , mark , work , add
		ArrayDeque<Pair> list = new ArrayDeque<>();
		list.add(new Pair(v,0,v+""));
		while(list.size()>0)
		{
			//remove 
			Pair removePair = list.remove();
			//mark
			if(visited[removePair.v] != -1)
			{
				// we will do some work
				if(visited[removePair.v] != removePair.level)
				{
					return true;
				}
			}
			else {
				visited[removePair.v] = removePair.level;
			}
			
			for(Edge e : graph[removePair.v])
			{
				if(visited[e.nbr] == -1)
				{
					list.add(new Pair(e.nbr,removePair.level+1,removePair.v+e.nbr+""));
				}
			}
			
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = new ArrayList[7];
		for(int i = 0 ; i < graph.length ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0,3,40));
		graph[0].add(new Edge(0,1,10));
		graph[1].add(new Edge(1,2,10));
		graph[1].add(new Edge(1,0,10));
		graph[2].add(new Edge(2,1,10));
		graph[2].add(new Edge(2,3,10));
		graph[3].add(new Edge(3,0,40));
		graph[3].add(new Edge(3,2,10));
		graph[3].add(new Edge(3,4,2));
		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,3));
		graph[4].add(new Edge(4,6,8));
		graph[5].add(new Edge(5,4,3));
		graph[5].add(new Edge(5,6,3));
		graph[6].add(new Edge(6,5,3));
		graph[6].add(new Edge(6,4,8));
		
		// graph has been created till here
		// now we will work on the bipartite check of the graph
		
		int visited [] = new int[7];
		Arrays.fill(visited, -1);
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			if(visited[i] == -1)
			{
				boolean isBipartite = checkBipartite(graph,i,visited);
				if(isBipartite)
				{
					System.out.println("The given graph is not bipartite");
					return;
				}
			}
		}
		
		System.out.println("The given graph is bipartite");
		return;
	}

}
