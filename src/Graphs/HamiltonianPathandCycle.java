package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathandCycle {

	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src , int nbr)
		{
			this.src = src;
			this.nbr = nbr;
		}
	}
	
	public static ArrayList<Edge> [] constructGraph()
	{
		ArrayList<Edge> graph [] = new ArrayList[7];
		
		for(int i = 0 ; i < 7 ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		 
		// intialise the graph here
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,3));
		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,2));
		graph[2].add(new Edge(2,1));
		graph[2].add(new Edge(2,3));
		graph[2].add(new Edge(2,5));
		graph[3].add(new Edge(3,0));
		graph[3].add(new Edge(3,2));
		graph[3].add(new Edge(3,4));
		graph[4].add(new Edge(4,5));
		graph[4].add(new Edge(4,6));
		graph[5].add(new Edge(5,2));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
		graph[6].add(new Edge(6,4));
		graph[6].add(new Edge(6,5));
		return graph;
	}
	
	// main code
	
	public static void drawHamiltonianCyclePath(ArrayList<Edge> [] graph ,int src , HashSet<Integer> visited , String ans , int osrc)
	{
		// base case
		if(visited.size() == graph.length-1)
		{
			System.out.print(ans);
			
			boolean closingEdgeFound = false;
			for(Edge e : graph[src])
			{
				if(e.nbr == osrc)
				{
					closingEdgeFound = true;
					break;
				}
			}
			if(closingEdgeFound == true)
			{
				System.out.println("*");
			}
			else {
				System.out.println(".");
			}
			return;
		}
		
		visited.add(src);
		for(Edge e : graph[src])
		{
			if(visited.contains(e.nbr) == false)
			{
				drawHamiltonianCyclePath(graph, e.nbr, visited, ans+e.nbr , osrc);
			}
		}
		visited.remove(src);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = constructGraph();
		for(ArrayList<Edge> list : graph)
		{
			for(int i = 0 ; i < list.size() ; i++)
			{
				System.out.println(list.get(i).src + " " + list.get(i).nbr);
			}
		}
		
		
		HashSet<Integer> visited = new HashSet<>();
		drawHamiltonianCyclePath(graph,0,visited,0+"",0);
	}

}
