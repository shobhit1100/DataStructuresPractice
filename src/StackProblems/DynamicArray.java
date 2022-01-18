package StackProblems;

public class DynamicArray {

	public static class stack{
		int [] arr;
		int tos;
		
		public stack(int cap)
		{
			arr = new int[cap]; 
			tos = -1;
		}
		
		public int size()
		{
			return tos+1;
		}
		
		public void push(int data)
		{
			if(tos == arr.length-1)
			{
				int [] narr = new int[arr.length*2];
				for(int i = 0; i < arr.length;i++)
				{
					narr[i] = arr[i]; 
				}
				arr = narr;
			}
			else {
				tos++;
				arr[tos] = data;
			}
		}
		
		public int pop()
		{
			if(tos == -1)
			{
				System.out.println("Stack underflown");
				return -1;
			}
			else {
				int val = arr[tos];
				tos--;
				return val;
			}
		}
		
		public int peek()
		{
			if(tos == -1)
			{
				System.out.println("No elements in the array");
				return -1;
			}
			else {
				return arr[tos];
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
