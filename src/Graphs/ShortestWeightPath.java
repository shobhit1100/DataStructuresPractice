package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestWeightPath {

	public static class Edge{
		int src;
		int wts;
		int nbr;
		public Edge(int src, int nbr , int wts)
		{
			this.nbr = nbr;
			this.src = src;
			this.wts = wts;
		}
	}
	
	public static class Pair implements Comparable<Pair>{
		int src;
		String path;
		int cost;
		public Pair(int src , String path , int  cost)
		{
			this.src = src;
			this.path = path;
			this.cost = cost;
		}
		public int compareTo(Pair o)
		{
			return this.cost-o.cost;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// to create a graph using a adjacency list we will be using an array of list
		ArrayList<Edge> graph [] = new ArrayList[7];
		// list in front of each index has been initialised.
		for(int i = 0 ; i < graph.length ; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		// initialising the graph
		//		0---3---4
		//		|	|	| \
		//		1---2	5--6
		//
		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,3,40));
		graph[1].add(new Edge(1,0,10));
		graph[1].add(new Edge(1,2,10));
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
		graph[6].add(new Edge(6,4,8));
		graph[6].add(new Edge(6,5,3));
		// initialising of the graph has been done here
		
		// making the priority queue , we will follow the same rm*wa* algorithm
		// and we will be using priority queue here for using the Dijkstra Algorithm
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Edge e = graph[0].get(0);
		pq.add(new Pair(e.src,e.src+"",0));
		boolean	[] visited = new boolean[graph.length];
		while(pq.size()>0)
		{
			Pair removedEdge = pq.remove();
			
			if(visited[removedEdge.src])
			{
				continue;
			}
			visited[removedEdge.src] = true;
			
			System.out.println("Src : "+removedEdge.src + " Path : "+removedEdge.path + " cost : "+removedEdge.cost);
			
			for(Edge edg : graph[removedEdge.src])
			{
				if(visited[edg.nbr] == false)
				{
					pq.add(new Pair(edg.nbr,removedEdge.path+edg.nbr,removedEdge.cost+edg.wts));
				}
			}
		}
	}

}
