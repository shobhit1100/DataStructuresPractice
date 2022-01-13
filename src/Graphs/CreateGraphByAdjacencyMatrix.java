package Graphs;
import java.util.*;
public class CreateGraphByAdjacencyMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of edges");
		int e = scn.nextInt();
		int graph [][] = new int [e][e];
		int check = 1;
		while(check == 1)
		{
			System.out.println("Enter the edge from");
			int efrom = scn.nextInt();
			System.out.println("Enter the edge to");
			int eto = scn.nextInt();
			System.out.println("Enter the weight of the edges");
			int weight = scn.nextInt();
			
			graph[efrom][eto] = weight;
			graph[eto][efrom] = weight;
			
			System.out.println("Do you want to enter mode data in the graph , if yes press 1 else press any other key");
			
			check = scn.nextInt();
		}
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			for(int j = 0 ; j < graph[0].length ; j++)
			{
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
