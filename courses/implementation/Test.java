package implementation;

import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		List<String> someList = new ArrayList<String>(csvParser.parseClass("\"CS374\""));

		System.out.println(someList);
	}
}