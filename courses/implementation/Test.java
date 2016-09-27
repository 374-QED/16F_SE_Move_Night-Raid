package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		String hold = "CS374";

		//List<String> someList1 = new ArrayList<String>(csvParser.parseStudent("Aldo Anaya"));
		List<String> someList2 = new ArrayList<String>(csvParser.parseUnique(0,1));


		//uncommted below to see all the list
		//for(int i = 400; i < 500;i++)
		System.out.println(someList2);
		System.out.println(someList2.size());
	}

}