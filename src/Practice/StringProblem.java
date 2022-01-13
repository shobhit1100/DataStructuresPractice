package Practice;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
public class StringProblem {

	public static void main(String [] args)
	{
		Map<Character,Integer> hashmap = new TreeMap<Character,Integer>();
		
		String text;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter the String : ");
		
		text = sc.nextLine();
		int i = 0;
		while(i<text.length())
		{
			if(hashmap.containsKey(text.charAt(i))==false)
			{
				hashmap.put(text.charAt(i), 1);
			
			}
			else
			{
				int value = hashmap.get(text.charAt(i));
				value += 1;
				hashmap.put(text.charAt(i),value);
			}
			i++;
		}
		
		int max = 0;
		char charac =' ' ;
		for(Map.Entry<Character, Integer> entry :hashmap.entrySet())
		{	
			if(entry.getValue()>max)
			{
				max = entry.getValue();
				charac = entry.getKey();
			}
			System.out.println(entry.getKey()+"=>"+entry.getValue());
		}
		
		
		System.out.println("THE MAXIMUM FREQUENCY CHARACTER IN THE GIVEN STRING IS :"+charac +" WITH THE FREQUENCY OF "+max);
	}
}
