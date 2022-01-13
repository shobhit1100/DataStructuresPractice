package HashMap;
import java.util.*;
public class KLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {13,12,62,22,15,37,99,11,37,98,67,31,84,99,4};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to sort : ");
		int k  = scn.nextInt();
		for(int i = 0 ; i < k ; i++ )
		{
			pq.add(arr[i]);
		}
		for(int i = k ; i < arr.length ; i++)
		{
			if(arr[i] > pq.peek())
			{
				pq.remove();
				pq.add(arr[i]);
			}
		}
		while(pq.size()>0)
		{
			System.out.println(pq.peek());
			pq.remove();
		}
		scn.close();
	}

}
