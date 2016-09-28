package implementation;

import java.io.*;
import java.util.*;

class Test {

	public static void main(String[] args)
	{
		CSVparser csvParser = new CSVparser();
		String course = "ACCT324";
		String semester = "201320";
		String student_name = "Ivan Mary Rico";

		List<String> someList1 = new ArrayList<String>(csvParser.parseUnique(5,6));
		List<String> someList2 = new ArrayList<String>(csvParser.parseClass(course,semester));
		List<String> someList3 = new ArrayList<String>(csvParser.parseStudent(student_name));
		/*
		System.out.println(student_name + "took:\n");
		for(int i = 0; i < someList3.size();i++)
			System.out.println(someList3.get(i));
		*/
			
		/*
		System.out.println("Find " + course + " with " + semester + ":\n");
		for(int i = 0; i < someList2.size();i++)
			System.out.println(someList2.get(i));
		*/
		
		/*
		System.out.println("Distinct Courses:\n");
		for(int i = 0; i < someList1.size();i++)
			System.out.println(someList1.get(i));
		System.out.println(someList1.size());
		*/
	}

}