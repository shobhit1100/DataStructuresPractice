package DynamicProgrammingAndGreedy;

public class CountBinaryStringWithNoConsecutiveZeroesDP {

	// initially for string of length 1 that ends with 0 and 1 is 1 i.e ending with 0 is '0' and ending with 1 is '1'.
	// now for new strings of length 2 that are ending with 0 just add 0 in the old ones , this will make sure that there is no duplicacy
	// and for new strings that ends with 1 there will be the sum of old '0' strings and old '1' strings.
	// i.e add 1 before the old 1 strings and add 1 before the old 0 strings.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ozero = 1;
		int oones = 1;
		for(int i = 2 ; i<5 ; i++)
		{
			int nzeroes = oones;
			int nones = ozero+oones;
			ozero = nzeroes;
			oones = nones;
		}
		System.out.println(ozero + oones);
	}

}
