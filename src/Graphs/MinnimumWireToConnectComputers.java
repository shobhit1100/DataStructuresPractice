package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinnimumWireToConnectComputers {

	public static class Edge{
		int src;
		int wts;
		int nbr;
		public Edge(int src , int nbr , int wts)
		{
			this.src  = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	public static class Pair{
		int src;
		String nbr;
		int cost;
		public Pair(int src , String nbr , int cost)
		{
			this.src = src;
			this.nbr = nbr;
			this.cost = cost;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> graph [] = new ArrayList[6];
		 for(int i = 0 ; i < graph.length ; i++)
		 {
			 graph[i] = new ArrayList<>();
		 }
		 
		 // using the Prim's algorithm to solve this problem
		 // algorithm - > r m* w a*
		 // Also we will b=using  a priority queue in this prblem to solve it
		 // starting with the solution
		 
		 //******************************** Graph initialisation part -> yo be ddone later
		 
		 //********************************
		 // program logic starts from here
		 Edge tempEdge = graph[0].get(0);
		 boolean [] visited = new boolean[graph.length];
		 Pair tempPair = new Pair(tempEdge.nbr,tempEdge.src+"",tempEdge.wts);
		 PriorityQueue<Pair> pq = new PriorityQueue<>();
		 pq.add(tempPair);
		 while(pq.size()>0)
		 {
			 Pair p = pq.remove(); // remove done
			 if(visited[p.src] == true) // mark check
			 {
				 continue;
			 }
			 visited[p.src] = true;  // marking if not marked already
			 System.out.println("Source -> "+p.src + " -> destination ->"+p.nbr + " @ " +p.cost);
			 //adding 
			 for(Edge e :graph[p.src])
			 {
				 if(visited[e.nbr] == false)
				 {
					 pq.add(new Pair(e.nbr,p.nbr+e.nbr+"",e.wts));
				 }
			 }
		 }
		 
	}

}
