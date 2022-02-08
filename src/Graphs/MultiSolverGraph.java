package Graphs;

import java.util.ArrayList;

import Graphs.CreateGraphAndFindPath.Edge;

public class MultiSolverGraph {

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
	
	public static ArrayList<Edge> [] prepareGraph()
	{
		// I am setting the graph as 7 by default and using this method to inly return the graph
		// We are using the adjacency list method
		ArrayList<Edge> [] graph = new ArrayList[7];
		for(int i = 0 ; i < 7 ; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		// Here we are adding the values into the graph
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
		for(ArrayList<Edge> list : graph)
		{
			for(int i = 0 ; i < list.size() ; i++)
			{
				System.out.println(list.get(i).src+ " - > " + list.get(i).nbr + " @ " + list.get(i).wts);
			}
		}
	}
	
	public static int mincost = Integer.MAX_VALUE;
	public static String minPath = null;
	public static int maxCost = Integer.MIN_VALUE;
	public static String maxPath = null;
	public static int ceilValue = Integer.MAX_VALUE;
	public static String ceilPath = null;
	public static int floorValue = Integer.MIN_VALUE;
	public static String floorPath = null;
	// So initially we will be solving for getting all the paths
	// the we will think out getting the answers of the above declared variables form it.
	public static void multisolver(ArrayList<Edge> []  graph , int src , int dest , boolean [] visited , int ssf , String psf)
	{
		
		// Now since our initial code is done , there fore we will focus on more important things
		// we will do all the code in the base case
		//we will use the same concept of tree in this problem
		
		if(src == dest)
		{
			// first find the min
			if(mincost > ssf)
			{
				mincost = ssf;
				minPath = psf;
			}
			// mow for the max
			if(maxCost < ssf)
			{
				maxCost = ssf;
				maxPath = psf;
			}
			// now we are done with the 2 parts
			// lets now think of ceil and floor values 
			// for ceil and floor values we will be needing the criteria
			// so the criteria can be taken by two ways either by passing the criteria as an argument in the method
			// I am using the word method as in Java we say functions as method
			// Second way is to assume the criteria
			// In our case we will use simply assume a criteria 
			// the sum of weights are having as  - > 48,50,38,40
			// so lets assume the criteria as 39
			// Now the floor for the criteria for this will be 38 and the ceil will be 40
			// *******************************************************************************
			// So for floor value 
			if(ssf < 39 && ssf > floorValue )
			{
				floorValue = ssf;
				floorPath = psf;
			}
			
			if(ssf > 39 && ssf < ceilValue)
			{
				ceilValue = ssf;
				ceilPath = psf;
			}
			
			//System.out.println(psf + " -> " +ssf);
			
			return;
		}
		
		visited[src] = true;
		
		for(Edge e : graph[src])
		{
			if(visited[e.nbr] == false)
			{
				multisolver(graph , e.nbr , dest , visited , ssf+e.wts , psf+e.nbr+"");
			}
		}
		
		visited[src] = false;
	}
	
	public static void main(String [] args)
	{
		ArrayList<Edge> graph [] = prepareGraph();
		//printGraph(graph);
		boolean [] visited = new boolean[7];
		multisolver(graph, 0, 6, visited , graph[0].get(0).src , "0");
		System.out.println(minPath +" @ "+mincost);
		System.out.println(maxPath +" @ "+maxCost);
		System.out.println(ceilPath +" @ "+ceilValue);
		System.out.println(floorPath +" @ "+floorValue);
	}
	
}
