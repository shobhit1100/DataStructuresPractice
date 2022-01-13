package DynamicProgrammingAndGreedy;

public class NumberOfHouseArrangementsWithNoConsucitiveHousesTogetherDP {

	// same case as CountBinaryStrings 
	// Difference is that in here the number of ways will get doubles in the end
	// because for each way in first row , there exists total_ways to select for the second row as well , i.e for 5 it will be 16 becase for one way it is 8. 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ohouseCount = 1;
		int ospacecount = 1;
		for(int i = 2 ; i<5 ; i++)
		{
			int newHouseCount = ospacecount;
			int newSpaceCount = ospacecount+ohouseCount;
			ohouseCount = newHouseCount;
			ospacecount = newSpaceCount;
		}
		int total_Ways = (ohouseCount + ospacecount);
		System.out.println(total_Ways*total_Ways);
	}

}
