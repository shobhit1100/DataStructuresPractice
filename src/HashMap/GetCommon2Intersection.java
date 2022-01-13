package HashMap;
import java.util.*;
public class GetCommon2Intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = {1, 1, 2 ,2, 2 ,3 ,5};
		int [] arr2 = {1, 1 ,1 ,2 ,2, 4, 5};
		HashMap<Integer , Integer> hmap = new HashMap<>();
		for(int n : arr1)
		{
			if(hmap.containsKey(n))
			{
				int old = hmap.get(n);
				int newval = old+1;
				hmap.put(n,newval);
			}
			else {
				hmap.put(n, 1);
			}
		}
		
		for(int n2 : arr2)
		{
			if(hmap.containsKey(n2))
			{
				int oldval = hmap.get(n2);
				if(oldval > 0)
				{
					System.out.println(n2);
					hmap.put(n2,oldval-1);
				}
			}
		}
	}

}
