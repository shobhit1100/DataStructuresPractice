package HashMap;
import java.util.*;
public class KSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,1,3,5,4,6,8,7,9};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the value of k : ");
		int k = scn.nextInt();
		for(int i = 0 ; i < k ; i++)
		{
			pq.add(arr[i]);
		}
		for(int i = k ; i < arr.length ; i++)
		{
			System.out.print(pq.peek()+"->");
			pq.remove();
			pq.add(arr[i]);
		}
		
		while(pq.size()>0)
		{
			System.out.print(pq.peek() + "->");
			pq.remove();
		}
		scn.close();
	}

}
