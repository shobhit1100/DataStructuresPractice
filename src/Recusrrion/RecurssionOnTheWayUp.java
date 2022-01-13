package Recusrrion;
import java.util.*;
public class RecurssionOnTheWayUp {

	public static void printSS(String ques , String answer)
	{
		
		if(ques.length() == 0)
		{
			System.out.println(answer);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSS(roq,answer+ch);
		printSS(roq,answer +"");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		printSS(str,"");
	}
	
}
