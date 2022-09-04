 package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {

	
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
	
	public static ArrayList<Edge> [] initiaseGraph()
	{
		ArrayList<Edge> [] graph = new ArrayList[7];
		for(int i = 0 ; i < graph.length ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0,1,10));
		graph[0].add(new Edge(0,3,10));
		graph[1].add(new Edge(1,0,10));
		graph[1].add(new Edge(1,2,10));
		graph[2].add(new Edge(2,1,10));
		graph[2].add(new Edge(2,3,10));
		graph[3].add(new Edge(3,0,10));
		graph[3].add(new Edge(3,2,10));
		graph[3].add(new Edge(3,4,10));
		graph[4].add(new Edge(4,3,10));
		graph[4].add(new Edge(4,5,10));
		graph[4].add(new Edge(4,6,10));
		graph[5].add(new Edge(5,4,10));
		graph[5].add(new Edge(5,6,10));
		graph[6].add(new Edge(6,5,10));
		graph[6].add(new Edge(6,4,10));
		
		return graph;
	}
	
	public static class Pair{
		int src;
		String psf;
		public Pair(int src , String psf)
		{
			this.src = src;
			this.psf = psf;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// i will be needing a graph to solve this question
		
		// let us call a finction to initialze the graph first
		ArrayList<Edge> [] graph = initiaseGraph();
		
		// iterative algo start from here
		// the algo goes like r,m*,w,a*
		Pair p = new Pair(0,"0");
		Stack<Pair> st = new Stack<>();
		st.push(p);
		boolean [] visited = new boolean[7];
		while(st.size()>0)
		{
			Pair rp = st.pop();
			if(visited[rp.src] == true || visited[6] == true)
			{
				continue;
			}
			visited[rp.src] = true;
			System.out.println("src : "+rp.src + " @ psf : " + rp.psf);
			for(Edge e :graph[rp.src])
			{
				if(visited[e.nbr] == false)
				{
					st.push(new Pair(e.nbr,rp.psf+e.nbr));
				}
			}
		}
		
	}

}
