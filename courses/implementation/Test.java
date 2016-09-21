package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		List<String> someList = new ArrayList<String>(csvParser.parsePreReq("\"CS374\""));

		System.out.println(someList);
	}
}