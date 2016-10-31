package implementation;

import java.io.*;
import java.util.*;
import implementation.CSVparser;


class Test {


		public static void main(String[] args) 
		{
			String course = "CS315";
			CSVparser csvParser = new CSVparser();
			List<String> student = new ArrayList<String>(csvParser.parsePreReq(course));
			System.out.println(student);
		}
}