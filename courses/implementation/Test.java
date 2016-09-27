package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		String hold = "CS374";
		//List<String> someList1 = new ArrayList<String>(csvParser.parseStudent("Aldo Anaya"));
		List<String> someList2 = new ArrayList<String>(csvParser.parseClass("ACCT324"));

			
		//System.out.println(someList);
		System.out.println(someList2);
	}

}