package Practice;
import java.io.*;
import java.lang.*;
import java.util.*;

public class LCS {

	int lcs(char [] a1 , char [] a2, int m , int n)
	{
		if(m == 0 || n == 0)
		{
			return 0;
		}
		if( a1[m-1] == a2[n-1] )
			{
				return 1+lcs(a1,a2,m-1,n-1);
			}
		else {
			return max(lcs(a1,a2,m,n-1),lcs(a1,a2,m-1,n));
		}
		
	}
	
	int max(int a , int b)
	{
		return (a>b)? a : b;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCS lcs1 = new LCS();
		String s1 = "abcdefgh";
		String s2 = "qdrtfghy";
		char [] a1 = s1.toCharArray();
		char [] a2 = s2.toCharArray();
		int l1 = a1.length;
		int l2 = a2.length;
		
		System.out.println(lcs1.lcs(a1,a2,l1,l2));
		
	}

}
