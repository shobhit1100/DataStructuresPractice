package Graphs;

import java.util.ArrayList;

public class perfectFriends {

	public static class Edge{
		int src;
		int nbr;
		public Edge(int src , int nbr)
		{
			this.src = src;
			this.nbr = nbr;
		}
	}
	public static ArrayList<Edge> [] constructGraph()
	{
		int vertices = 7;
		ArrayList<Edge> [] graph = new ArrayList[vertices];
		for(int i = 0 ; i < vertices ; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		graph[0].add(new Edge(0,1));
		graph[1].add(new Edge(1,0));
		graph[2].add(new Edge(2,3));
		graph[3].add(new Edge(3,2));
		graph[4].add(new Edge(4,5));
		graph[4].add(new Edge(4,6));
		graph[5].add(new Edge(5,4));
		graph[6].add(new Edge(6,4));
		return graph;
	}
	// getting connected components
	public static void getConnectedComponents(ArrayList<Edge> [] graph,int src, boolean [] visited , ArrayList<Integer> comp)
	{
		visited[src] = true;
		comp.add(src);
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{		
				getConnectedComponents(graph, e.nbr, visited,comp);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = constructGraph();
		boolean [] visited = new boolean[7];
		ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
		for(int i = 0 ; i < 7 ; i++)
		{
			if(visited[i] == false)
			{
			ArrayList<Integer> comps = new ArrayList<>();
			getConnectedComponents(graph,i,visited,comps);
			comp.add(comps);
			}
		}
		int pair = 0;
		for(int i = 0 ; i < comp.size() ; i++)
		{
			for(int j = i+1 ; j <comp.size() ; j++ )
			{
				pair += comp.get(i).size() * comp.get(j).size();
			}
		}
		System.out.println(pair);
	}

}
