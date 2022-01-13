package HashMap;
import java.util.*;
public class LCSINARRAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {10,5,9,1,11,8,6,15,3,12,2};
		HashMap<Integer , Boolean> hmap = new HashMap<>();
		for(int i : arr)
		{
			hmap.put(i,true);
		}
		for(int i : arr)
		{
			if(hmap.containsKey(i-1))
			{
				hmap.put(i, false);
			}
		}
		int msp = 0;
		int ml = 0;
		for(int val : arr)
		{
			if(hmap.get(val) == true)
			{
				int tl = 1;
				int tsp = val;
				
				while(hmap.containsKey(tsp+tl))
				{
					tl++;
				}
				
				if(tl>ml)
				{
					msp = tsp;
					ml = tl;
				}
			}
		}
		
		for(int i = 0 ; i<ml ; i++)
		{
			System.out.println(msp+i);
		}
	}

}
