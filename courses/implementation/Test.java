package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		List<String> someList1 = new ArrayList<String>(csvParser.parsePreReq("\"CS374\""));
		//List<String> someList1 = new ArrayList<String>(csvParser.parseClass("CS374"));
		//List<String> someList1 = new ArrayList<String>(csvParser.parseStudent("Aldo Anaya"));
			
		//System.out.println(someList);
		System.out.println(someList1);
	

	}
}