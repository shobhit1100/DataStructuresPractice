package Graphs;

import java.util.Scanner;

public class NumberOfIsIands {

	public static void drawGraph(int [][] graph , int i , int j ,  boolean [][] visited)
	{
		// initialising the base case for the reactive cases 
		if(i<0 || j < 0 || i >= graph.length || j >= graph[0].length || visited[i][j] == true || graph[i][j] == 1)
		{
			return;
		}
		
		visited[i][j] = true;
		
		drawGraph(graph,i-1,j,visited);
		drawGraph(graph,i,j+1,visited);
		drawGraph(graph,i,j-1,visited);
		drawGraph(graph,i+1,j,visited);
	}
	
	public static void main(String [] args)
	{
		Scanner scn = new Scanner(System.in);
		int rows  = scn.nextInt();
		int cols = scn.nextInt();
		int [][] graph = new int[rows][cols];
		for(int i = 0 ; i < graph.length ; i++)
		{
			for(int j = 0 ; j < graph[0].length ; j++)
			{
				graph[i][j] = scn.nextInt();
			}
		}
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			for(int j =  0 ; j < graph[0].length ;j++)
			{
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
		// we will start the solution from here 
		// First part will be to iterate the whole array any then while iterating we have to find the answer
		// So for the answer we have to just draw a tree until and unless we are finding the land.
		// Now we have to make sure that the vertices of the graph that are visited should not be visited again
		// For that we will use a visited array
		// And yes , You guessed it right , The boolean array will be of the the same size as the graph i.e a 2F array in this case
		// and every time we are going to make a call we will just increase the count
		// for count we are creating the variable
		int count = 0 ;
		// creating array of visited and it will be of type boolean
		boolean [][] visited = new boolean[rows][cols]; // by default it will be storing false for each and every vertices.
		// now traversing the array one by one
		for(int i = 0 ; i < graph.length ; i++)
		{
			for(int j = 0 ; j < graph[0].length ; j++)
			{
				if(visited[i][j] == false && graph[i][j] == 0)
				{
					// now we will make a call to the draw function
					drawGraph(graph,i,j,visited);
					count++;
				}
			}
		}
		System.out.println(count);
		scn.close();
	}
}