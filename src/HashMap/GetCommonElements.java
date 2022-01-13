package HashMap;
import java.util.*;
public class GetCommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = {1,1,2,2,3,5};
		int [] arr2 = {1,1,1,2,2,4,5};
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for(int i : arr1)
		{
			if(hmap.containsKey(i))
			{
			int old = hmap.get(i);
			int nval = old+1;
			hmap.put(i, nval);
			}
			else {
				hmap.put(i,1);
			}
		}
		for(int a2:arr2)
		{
			if(hmap.containsKey(a2))
			{
				System.out.println(a2);
				hmap.remove(a2);
			}
		}
	}

}
