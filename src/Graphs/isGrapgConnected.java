package Graphs;

import java.util.ArrayList;

public class isGrapgConnected {

	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src , int nbr , int wts) {
			this.src  = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	public static ArrayList<Edge> [] createGraph()
	{
		ArrayList<Edge> [] graph  = new ArrayList[7];
		for(int i = 0 ; i <  7 ; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		
		// creating a graph 
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
		for(ArrayList<Edge> e  : graph)	
		{
			for(int i = 0 ; i < e.size() ; i ++)
			{
				System.out.println(e.get(i).src+" -> "+e.get(i).nbr + " @ " +e.get(i).wts);
			}
		}
	}
	
	// now finding the components of the graph.
	// if the component is 1 -> it is a connected graph.
	// if the component is grater than one -> it is not a connected graph.
	
	public static void getConnectedComponents(ArrayList<Edge> [] graph , ArrayList<Integer> comps , int src , boolean [] visited)
	{
		
		// we have to call the getConnectedComponents and get a path or basically drawing a tree from src to all the edges of the graoh
		// Our motive is to reach all the vertices of the graph
		visited[src] = true;
		comps.add(src);
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				getConnectedComponents(graph , comps , e.nbr , visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Edge> [] graph = createGraph();
		
		// Printing the graph after the crating it
		System.out.println("***********Printing the graph**************");
		printGraph(graph);
		System.out.println("*******************************");
		// Creating a boolean Array
		
		boolean [] visited = new boolean[7];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		// We are going to each and every edge of the graph 
		// Since the Vertices of the graph are from 0 to 6
		// i.e 7 in total . this gives us the intuition to have a loop on the all the vertices
		// and the vertices can be find out using the for loop from 0 to 7.
		// we have not iterated on the graph because it will give us the list of the edges 
		// and as we know edges entries are repeated in a graph
		// Therefore the best way is to have a loop till the vertices i.e 7 in our case and call the function.
		
		for(int i = 0 ; i < 7 ; i++)
		{
			if(visited[i] == false)
			{
				ArrayList<Integer> comp = new ArrayList<>();
				getConnectedComponents(graph, comp, i, visited);
				comps.add(comp);
			}
		}
		
		if(comps.size() == 1)
		{
			System.out.println("The graph is a connected graph");
		}
		else {
			System.out.println("The graph is not a connected graph");
		}
	}

}
