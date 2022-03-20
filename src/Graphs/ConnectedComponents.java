package Graphs;

import java.util.ArrayList;

import Graphs.MultiSolverGraph.Edge;

public class ConnectedComponents {

	public static int k;
	
	public static class Edge{
		int nbr ;
		int src;
		int wts;
		public Edge(int src ,int nbr , int wts){
			this.nbr= nbr;
			this.src = src;
			this.wts = wts;
		}
	}	
	
	public static ArrayList<Edge> [] constructGraph()
	{
		ArrayList<Edge> [] graph = new ArrayList[7];
		// Initialising the arrayList at every index of the array
		for(int i = 0 ; i < 7 ;i++)
		{
			graph[i] = new ArrayList<Edge>();
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
	
	public static void printGraph(ArrayList<Edge> [] graph)
	{
		for(ArrayList<Edge> e : graph)
		{
			for(int i = 0 ; i < e.size() ; i++)
			{
				System.out.println(e.get(i).src + " => " + e.get(i).nbr +  " @ " + e.get(i).wts);
			}
		}
	}
	
	// So , We have to find the number of connected components 
	// Now the approach is to give the chance of making the tree to each and every Vertices in the graph
	// But the chance will be given only to those vertices which are unvisited.
	
	// so for the visited part we will first need to have a array of visited
	// so the array of visited will tell us either it is visited or not as True/False , therefore it has to be boolean
	// the length of the graph should be similar to the number of vertices
	
	private static void drawtree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
		
		visited[src] = true;
		comp.add(src);
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				drawtree(graph,e.nbr , comp,visited);
			}
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k  = 7;
		boolean visited[] = new boolean[k];
		
		ArrayList<Edge> graph [] = new ArrayList[k];
		
		graph  = constructGraph();
		
		printGraph(graph);
		
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int i = 0 ; i < k ; i++)
		{
			if(visited[i] == false)
			{
				ArrayList<Integer> comp = new ArrayList<>();
				drawtree(graph , i , comp ,visited);
				comps.add(comp);
			}
		}	
		
		for(ArrayList<Integer> e : comps)
		{
			for(int i = 0 ; i < e.size() ; i++)
			{
				System.out.print(e.get(i));
			}
			System.out.println();
		}
		
	}
}