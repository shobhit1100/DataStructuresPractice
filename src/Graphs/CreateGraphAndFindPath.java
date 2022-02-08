package Graphs;

import java.util.ArrayList;


public class CreateGraphAndFindPath {

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
	
	public static ArrayList<Edge>[] createGraph()
	{
		ArrayList<Edge> [] graph = new ArrayList[7];
		for(int i = 0 ; i < 7 ; i++ )
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
		
		return graph;
	}
	
	public static void printGraph(ArrayList<Edge> [] graph)
	{
		
		for(ArrayList<Edge> g : graph)
		{
			for(int i = 0 ; i < g.size() ; i++)
			{
				System.out.println(g.get(i).src +" -> "+g.get(i).nbr + " : " + g.get(i).wts);
			}
		}
		
	}
	
	public static ArrayList<Integer> list;
	
	public static boolean printPath(ArrayList<Edge> [] graph , int src , int dest , boolean [] visited )
	{
		if(src == dest)
		{
			return true;
		}
		visited[src] = true;
		for(Edge edge : graph[src])
		{
			if(visited[edge.nbr] == false)
			{
				boolean hasPath = printPath(graph,edge.nbr,dest,visited);
				if(hasPath == true)
				{
					list.add(edge.nbr);
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	public static void printAllPaths(ArrayList<Edge> [] graph , int src , int dest , boolean [] visited , String asf)
	{
		if(src == dest)
		{
			System.out.println(asf);
			return;
		}
		visited[src] = true;
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				printAllPaths(graph , e.nbr , dest , visited , asf+src+"");
			}
		}
		visited[src] = false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Edge> [] graph = createGraph();
		//printGraph(graph);
		list = new ArrayList<>();
		boolean [] visited = new boolean[7];
		
//		printPath(graph,0,6,visited);
//		list.add(0);
//		System.out.println(list);
		
		printAllPaths(graph , 0 , 6 , visited , 0+"");
	}

}
