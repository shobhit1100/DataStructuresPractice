package Graphs;
import java.util.*;
public class hasPath {
	
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
	
	public static boolean hasPathfunction(ArrayList<Edge> [] arr , int src ,int dest , boolean [] visited )
	{
		if(src == dest)
		{
			return true;
		}
		
		visited[src] = true;
		
		for(Edge edge : arr[src])
		{
			if(visited[edge.nbr] == false)
			{
				boolean hasNbrPath = hasPathfunction(arr, edge.nbr,dest , visited);
				if(hasNbrPath == true)
				{
					return true;
				}
			}
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int e = scn.nextInt();
		ArrayList<Edge>[] graph = new ArrayList[e];
		int v = scn.nextInt();
		for(int i = 0 ; i < e ; i++)
		{
			graph[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < v ; i++)
		{
			int src = scn.nextInt();
			int nbr = scn.nextInt();
			int wts = scn.nextInt();
			graph[src].add(new Edge(src,nbr,wts));
			graph[nbr].add(new Edge(nbr,src,wts));
		}
		
		for(ArrayList<Edge> g :graph)
		{
			for(int i = 0 ; i < g.size() ; i++)
			{
				System.out.println(g.get(i).src + " " + g.get(i).nbr +" "+ g.get(i).wts);
			}
		}
		
		boolean [] visited = new boolean[e];
		
		System.out.println(hasPathfunction(graph,0,6,visited));
		
	}

}
