package AmazonPracticeTest;

public class ImplementAStackWithPushPop {

	public static class Stack{
		int [] arr;
		int tos;
		public Stack(int cap)
		{
			arr = new int[cap];
			tos = -1;
		}
		int size()
		{
			return tos;
		}
		void push(int val)
		{
			if(tos == arr.length-1)
			{
				System.out.println("Stack Overflow");
				return;
			}
			tos++;
			arr[tos] = val;
		}
		int pop()
		{
			if(tos == -1)
			{
				System.out.println("Stack Underflow");
				return -1;
			}
			int val = arr[tos];
			tos--;
			return val;
		}
		int top()
		{
			if(tos == -1)
			{
				System.out.println("Stack is Empty Right Now");
			}
			return arr[tos];
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
