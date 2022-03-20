package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

import Graphs.ConnectedComponents.Edge;

public class isGraphCyclic {

	
	// this question will be using the solution of two questions 
	// first -> connected components
	// second -> BFS
	// Note : we cans solve this question by both DFS and BFS but we are using the BFS here.
	
	// Edge class
	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src , int nbr , int wts)
		{
			this.nbr = nbr;
			this.src = src;
			this.wts = wts;
		}
	}
	// construct a graph using adjacency list
	public static ArrayList<Edge> [] constructGraph()
	{
		ArrayList<Edge> [] graph = new ArrayList[7];
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0,1,10));
		graph[1].add(new Edge(1,0,10));
		graph[2].add(new Edge(2,3,10));
		graph[3].add(new Edge(3,2,10));
		graph[4].add(new Edge(4,5,3));
		graph[4].add(new Edge(4,6,8));
		graph[5].add(new Edge(5,4,3));
		graph[5].add(new Edge(5,6,3));
		graph[6].add(new Edge(6,5,3));
		graph[6].add(new Edge(6,4,8));
		return graph;
	}
	
	
	// in BFS we used a pair class of vertices and and psf i.e path so far.
	// therefore creating the same
	public static class Pair{
		int v;
		String psf;
		public Pair(int v , String psf)
		{
			this.v = v;
			this.psf = psf;
		}
	}
	
	// using a function draw tree.
	public static boolean drawTree(ArrayList<Edge> [] graph ,int src , String psf, boolean [] visited)
	{
		// First we have created a queue 
		ArrayDeque<Pair> q = new ArrayDeque<>();
		// added the first element in the queue
		q.add(new Pair(src,src+""));
		
		while(q.size() > 0)
		{
			// word to be done -> remove , mark* , work , add*
			 Pair remPair = q.removeFirst();
			 if(visited[remPair.v] == true)
			 {
				 return true;
			 }
			 visited[remPair.v] = true;
			 for(Edge e : graph[remPair.v])
			 {
				 if(visited[e.nbr] == false)
				 {
					 q.add(new Pair(e.nbr,remPair.psf+e.nbr+""));
				 }
			 }
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// first creating the graph
		ArrayList<Edge> [] graph = constructGraph();
		// now we will be traversing each and every vertices of the graph
		boolean [] visited = new boolean[7];
		for(int i = 0 ; i < graph.length ; i++)
		{
			// now the chance will be given to each and every vertices if the graph
			// we will be visiting only and only the non visited vertices
			if(visited[i] == false)
			{
				// now we will call the function
				boolean isCycle = drawTree(graph,i,"",visited);
				if(isCycle)
				{
					System.out.println("True");
					return;
				}
			}
		}
		System.out.println("False");
	}

}
