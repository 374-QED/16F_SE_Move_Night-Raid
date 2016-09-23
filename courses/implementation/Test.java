package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		String hold = "CS374";
		List<String> someList1 = new ArrayList<String>(csvParser.parsePreReq("\"CS374\""));
		List<String> someList2 = new ArrayList<String>(csvParser.parseSemester("\"CS374\""));

			
		//System.out.println(someList);
		System.out.println(someList1);

}