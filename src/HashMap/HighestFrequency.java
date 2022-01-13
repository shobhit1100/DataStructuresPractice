package HashMap;
import java.util.*;
public class HighestFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		HashMap<Character, Integer> hmap = new HashMap<>();
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			if(hmap.containsKey(ch))
			{
				int old = hmap.get(ch);
				int nval = old+1;
				hmap.put(ch, nval);
			}
			else {
				hmap.put(ch, 1);
			}
		}
		
		char max = str.charAt(0);
		
		for(Character key : hmap.keySet())
		{
			int val = hmap.get(key);
			if(val > hmap.get(max))
			{
				max = key;
			}
		}
		
		System.out.println(max);
		
	}

}
