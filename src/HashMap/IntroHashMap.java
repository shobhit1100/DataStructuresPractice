package HashMap;
import java.util.*;
public class IntroHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> hmap = new HashMap<>();
		/////////// putting the values /////////////////
		hmap.put("India", 140);
		hmap.put("China", 110);
		hmap.put("USA", 40);
		hmap.put("Japan", 25);
		hmap.put("Russia", 80);
		System.out.println(hmap);
		//////// get by the values ////////////////////////
		System.out.println(hmap.get("India"));
		System.out.println(hmap.get("USA"));
		System.out.println(hmap.get("Nigeria"));
		System.out.println(hmap.get("Marturis"));
		//////////// checking the values //////////////////////
		System.out.println(hmap.containsKey("India"));
		System.out.println(hmap.containsKey("Paris"));
		
		Set<String> key = hmap.keySet();
		System.out.println(key);
		
		for(String keys : hmap.keySet())
		{
			Integer val = hmap.get(keys);
			System.out.println(keys + " "+val);
		}
		///////// Hmap wont work on values -- values are the integer part and keys are the string part////////////
		System.out.println(hmap.get(25));
	}

}
