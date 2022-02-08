package Graphs;
import java.util.ArrayList;
import Graphs.GraphConstructByList.Edges;

public class graphAdjacencyList {

	public static class Edge{
		int src;
		int wts;
		int nbr;
		public Edge(int src , int wts , int nbr)
		{
			this.src = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Edge> [] graph = new ArrayList[7];
		for(int i = 0 ; i < 7 ; i++)
		{
			graph[i] = new ArrayList<Edge>();
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
		
		for(ArrayList<Edge> edge : graph)
		{
			for(int i = 0 ; i < edge.size() ; i++)
			{
			System.out.println(edge.get(i).src + " "+edge.get(i).wts + " " + edge.get(i).wts);	
			}
		}
	}

}
