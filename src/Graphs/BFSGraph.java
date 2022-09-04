package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

import Graphs.MultiSolverGraph.Edge;

public class BFSGraph {

	
	
	// BFS in graph is like the level order of tree.
	// but with some differences i.e here we make the traversal with equal number of the vertices.
	// the similarity is that we will be using a queue.
	
	// let's start by making the graph first 
	
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
	
	public static class Pair{
		int v;
		String psf;
		public Pair(int v , String psf)
		{
			this.v = v;
			this.psf = psf;
		}
	}
	
	public static ArrayList<Edge> [] constructGraph()
	{
		ArrayList<Edge> [] graph= new ArrayList[7];
		for(int i = 0 ; i<graph.length ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		// initialise the graph here;
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
		return graph;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = constructGraph();
		boolean [] visited = new boolean[graph.length];
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(0,0+""));
		while(queue.size() > 0)
		{
			//r m* w a*
			Pair removePair = queue.remove();
			
			if(visited[removePair.v] == false)
			{
				visited[removePair.v] = true;
			}
			
			System.out.println( removePair.v+" @ "+removePair.psf);
			
			for(Edge e : graph[removePair.v])
			{
				if(visited[e.nbr] == false)
				{
					queue.add(new Pair(e.nbr , removePair.psf+e.nbr+""));
				}
			}
		}
	}

}
