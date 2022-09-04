package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class LowestWieghtPath {

	public static class Edge{
		int src;
		int nbr;
		int wts;
		public Edge(int src , int nbr , int wts){
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
			graph[i] = new ArrayList<>(); 
		}
		return graph;
	}
	
	public static class Pair{
		int v;
		int w;
		String psf;
		public Pair(int v , int w , String psf)
		{
			this.v = v;
			this.w = w;
			this.psf = psf;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = drawGraph();
		
		// starting the dikstra algorithm
		// we will use the algorithm of r , m* , w , a*
		boolean [] visited = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(graph[0].get(0).src,graph[0].get(0).wts,graph[0].get(0).src+""));
		while(pq.size()>0)
		{
			Pair remPair = pq.remove();
			visited[remPair.v] =true;
			for(Edge e : graph[remPair.v])
			{
				if(visited[e.nbr] != true)
				{
					pq.add(new Pair(e.nbr,e.wts+remPair.w,remPair.w+e.nbr+""));
				}
			}
		}
	}
}