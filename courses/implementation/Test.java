package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		String course = "ACCT324";
		String semester = "201320";

		//List<String> someList1 = new ArrayList<String>(csvParser.parseStudent("Aldo Anaya"));
		List<String> someList2 = new ArrayList<String>(csvParser.parseClass(course,semester));
		List<String> someList1 = new ArrayList<String>(csvParser.parseUnique(5,6));


		//uncommted below to see all the list
		System.out.println("Find " + course + " with " + semester + ":\n");
		for(int i = 0; i < someList2.size();i++)
			System.out.println(someList2.get(i));
		//for(int i = 0; i < someList1.size();i++)
			//System.out.println(someList1.get(i));
		//System.out.println(someList2.size());
	}

}