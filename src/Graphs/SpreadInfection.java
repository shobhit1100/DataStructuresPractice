package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadInfection {

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
	
	public static ArrayList<Edge> [] drawGraph()
	{
		ArrayList<Edge> [] graph = new ArrayList[7];
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			graph[i] = new ArrayList<Edge>();
		}
		
		// graph representation
		// 0--3--4
		// |  |  /\
		// 1--2 5--6
		graph[0].add(new Edge(0,1,20));
		graph[0].add(new Edge(0,3,10));
		graph[1].add(new Edge(1,0,20));
		graph[1].add(new Edge(1,2,40));
		graph[2].add(new Edge(2,1,40));
		graph[2].add(new Edge(2,3,32));
		graph[3].add(new Edge(3,0,10));
		graph[3].add(new Edge(3,2,32));
		graph[3].add(new Edge(3,4,20));
		graph[4].add(new Edge(4,3,20));
		graph[4].add(new Edge(4,5,20));
		graph[4].add(new Edge(4,6,20));
		graph[5].add(new Edge(5,4,20));
		graph[5].add(new Edge(5,4,20));
		graph[6].add(new Edge(6,4,20));
		graph[6].add(new Edge(6,5,20));
		return graph;
	}
	
	public static class Pair{
		int v;
		int time;
		public Pair(int v , int time)
		{
			this.v = v;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = new ArrayList[7];
		graph = drawGraph();
		ArrayDeque<Pair> list = new ArrayDeque<>();
		// adding the initial pair
		list.add(new Pair(graph[0].get(0).src,1));
		int [] visited = new int[graph.length];
		
		// printing all the neighbours of the graph 
//		for(ArrayList<Edge> e : graph)
//		{
//			for(int i = 0 ; i < e.size() ; i++)
//			{
//				System.out.println(e.get(i).src + " -> " + e.get(i).nbr);
//			}
//		}
		
		
		while(list.size()>0)
		{
			// algorithm for the BFS -> r,m*,w,a* (remove, mark, work, add)
			Pair remPair = list.removeFirst();
			if(visited[remPair.v] > 0)
			{
				continue;
			}
			visited[remPair.v] = remPair.time;
			System.out.println("This Vertex with src as "+remPair.v +" is infected at "+remPair.time);
			for(Edge e : graph[remPair.v])
			{
//				System.out.println(e.nbr);
				
				if(visited[e.nbr] == 0)
				{
					list.add(new Pair(e.nbr,remPair.time+1));
				}
			}
		}
	}

}
