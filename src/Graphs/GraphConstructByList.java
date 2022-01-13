package Graphs;
import java.util.*;
public class GraphConstructByList {

	static class Edges{
		int src;
		int nbr;
		int wts;
		public Edges(int src , int nbr , int wts)
		{
			this.src = src;
			this.nbr = nbr;
			this.wts = wts;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 7;
		ArrayList<Edges> graph [] = new  ArrayList[7];
		for(int i = 0 ; i < n ; i++)
		{
			graph[i] = new ArrayList<Edges>();
		}
		graph[0].add(new Edges(0,3,40));
		graph[0].add(new Edges(0,1,10));
		graph[1].add(new Edges(1,2,10));
		graph[1].add(new Edges(1,0,10));
		graph[2].add(new Edges(2,1,10));
		graph[2].add(new Edges(2,3,10));
		graph[3].add(new Edges(3,0,40));
		graph[3].add(new Edges(3,2,10));
		graph[3].add(new Edges(3,4,2));
		graph[4].add(new Edges(4,3,2));
		graph[4].add(new Edges(4,5,3));
		graph[4].add(new Edges(4,6,8));
		graph[5].add(new Edges(5,4,3));
		graph[5].add(new Edges(5,6,3));
		graph[6].add(new Edges(6,5,3));
		graph[6].add(new Edges(6,4,8));
		//<---------- My Thinking Part before watching the solution----------------->
		// for first loop we will be accessing the index.
		// but that index has a list 
		// so we also need to access that list
		// we will be needing one more loop to access that list
		for(ArrayList<Edges> arr : graph)
		{
			
			for(int i = 0 ; i < arr.size() ; i++)
			{
				System.out.println("src : "+arr.get(i).src + " nbr : "+ arr.get(i).nbr +" weigths : "+arr.get(i).wts);
			}
		}
		
		// approach works perfectly fine 
		
	}

}
