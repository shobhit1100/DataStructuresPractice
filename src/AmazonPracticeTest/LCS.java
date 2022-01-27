package AmazonPracticeTest;
import java.util.HashMap;
import java.util.Map;
public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {2,3,1,4,6,7,9,19};
		
		HashMap<Integer,Boolean> hmap = new HashMap<>();
		// Initialisation
		for(int i : arr)
		{
			hmap.put(i,true);
		}
		 // Checking
		for(int i : arr)
		{
			if(!hmap.containsKey(i+1))
			{
				hmap.put(i, false);
			}
		}
		
//		for(Map.Entry<Integer, Boolean> map: hmap.entrySet())
//		{
//			System.out.println(map.getKey() + " - " + map.getValue());
//		}
		
		//traversing
		int maxrange = 0;
		int maxLcs = 0;
		for(int i : arr)
		{
			if(hmap.get(i) == true)
			{
				int index = 1;
				while(hmap.containsKey(i+index))
				{
					index++;
				}
				if(maxrange < index)
				{
					maxrange = index;
					maxLcs = i;
				}
			}
		}
		
		for(int i = 0 ; i < maxrange ; i++)
		{
			System.out.println(maxLcs+i);
		}
	}

}
