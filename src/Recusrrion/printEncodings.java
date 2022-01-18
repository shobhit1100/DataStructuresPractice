package Recusrrion;

public class printEncodings {

	// we will be getting a string - >  "123"
	//  take the first character a and encode it to the integer value.
	// then make two call first will be for the next character and for the remaining string
	// i.e for 1 the will be for 2 and 23 and 1 will get in the answer.
	
	public static void printEncodings(String question, String answer)
	{
		if(question.length() == 0)
		{
			System.out.println(answer);
			return;
		}
		else if(question.length() == 1)
			{
				char ch = question.charAt(0);
				if(ch == '0')
				{
					return;
				}
				else {
					int chv = ch - '0';
					char code = (char)(chv+'a'-1);
					System.out.println(answer+code);
				}
			}
		else {
			char ch = question.charAt(0);
			String remQues = question.substring(1);
			if(ch == '0')
			{
				return;
			}
			else {
				int chv = ch - '0';
				char code = (char)('a'+chv - 1);
				printEncodings(remQues, answer+code);
			}
			
			String ch12 = question.substring(0,2);
			String remStr = question.substring(2);
			int chval = Integer.parseInt(ch12);
			if(chval <= 26)
			{
				char code = (char)('a'+chval -1);
				printEncodings(remStr, answer+code);
			}
		}
//		if (ques.length() == 0) {
//		      System.out.println(ans);
//		      return;
//		    } else if (ques.length() == 1) {
//		      if (ques.charAt(0) == '0') {
//		        return;
//		      } else {
//		        String ch0 = ques.substring(0, 1);
//		        String roq0 = ques.substring(1);
//		        String code0 = (char)('a' +
//		                              (Integer.parseInt(ch0) - 1)) + "";
//		        printEncodings(roq0, ans + code0);
//		      }
//		    } else {
//		      if (ques.charAt(0) == '0') {
//		        return;
//		      } else {
//		        String ch0 = ques.substring(0, 1);
//		        String roq0 = ques.substring(1);
//		        String code0 = (char)('a' +
//		                              (Integer.parseInt(ch0) - 1)) + "";
//		        printEncodings(roq0, ans + code0);
//
//		        String ch01 = ques.substring(0, 2);
//		        String roq01 = ques.substring(2);
//		        String code01 = (char)('a' +
//		                               (Integer.parseInt(ch01) - 1)) + "";
//
//		        if (Integer.parseInt(ch01) <= 26) {
//		          printEncodings(roq01, ans + code01);
//		        }
//		      }
//		    }
		  }
	
	
	public static void printEncodingPractice(String ques , String asf)
	{
		if(ques.length() == 0)
		{
			System.out.println(asf);
			return;
		}
		else if(ques.length() == 1)
		{
			char ch = ques.charAt(0);
			if(ch == '0')
			{
				return;
			}
			else {
				int chval = ch -'0';
				char code = (char)(chval + 'a'-1);
				String remQues = ques.substring(1);
				printEncodingPractice(remQues,asf+code+"");
			}
		}
		else {
			char ch0 = ques.charAt(0);
			if(ch0 == '0')
			{
				return;
			}
			else {
				int chval = ch0 -'0';
				char code = (char)(chval + 'a' -1);
				String remQues = ques.substring(1);
				printEncodingPractice(remQues,asf+code+"");
				
				String ch2 = ques.substring(0, 2);
				int n = Integer.parseInt(ch2);
				String remQues2 = ques.substring(2);
				if(n <= 26)
				{
					char code2 = (char)(n+'a'-1);
					printEncodingPractice(remQues2 ,asf+code2+"");
				}
				}
		}
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		printEncodings("123","");
//		printEncodingPractice("123","");
	}

}
