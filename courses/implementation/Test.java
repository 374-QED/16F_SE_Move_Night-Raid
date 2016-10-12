package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

class Test {

	public static void main(String[] args) throws Exception
	{
		// CSVparser csvParser = new CSVparser();
		// String course = "ACCT324";
		// String semester = "201320";
		// String student_name = "Ivan Mary Rico";

		// List<String> someList1 = new ArrayList<String>(csvParser.parseUnique(5,6));
		// List<String> someList2 = new ArrayList<String>(csvParser.parseClass(course,semester));
		// List<String> someList3 = new ArrayList<String>(csvParser.parseStudent(student_name));

		// System.out.println(student_name + " took:\n");
		// for(int i = 0; i < someList3.size();i++)
		// 	System.out.println(someList3.get(i));
	
		// System.out.println("\n");
		
		// System.out.println("Find " + course + " with " + semester + ":\n");
		// for(int i = 0; i < someList2.size();i++)
		// 	System.out.println(someList2.get(i));
	
		
		/*
		System.out.println("Distinct Courses:\n");
		for(int i = 0; i < someList1.size();i++)
			System.out.println(someList1.get(i));
		System.out.println(someList1.size());
		*/
		//List<String> student;
		//ResultSet studentsTook;
		//MySQLAccess test = new MySQLAccess();
		//CSVparser csvParser = new CSVparser();
		AccessSQL_CSV test = new AccessSQL_CSV();

		//test.findStudent("817979");//test.takeOutStudent(test.getStudent("201320","BHEB472"),"BHEB472");
		//System.out.println(cool);
		//test.writeResultSet(test.readDatabase("Select * from cs374_anon limit 10"), "Subject_Code");
		/*
		student = test.getStudents("201320","BHEB472");
		System.out.println(student);

		List<String> prereqs = csvParser.parsePreReq("BHEB472");
		List<String> studentsNeeding = new ArrayList<String>();
		List<String> studentsToTakeOut = new ArrayList<String>();
		System.out.println(prereqs);

		for(int i = 0; i < student.size(); i++) {

			for(int j = 0; j < prereqs.size(); j++) {
				String[] parts = test.parseCourse(prereqs.get(j));
				studentsTook = test.readDatabase("select Banner_id from cs374_anon where Banner_id = '"+student.get(i)+"' and Subject_Code = '"+parts[0]+"' and Course_number = '"+parts[1]+"' and (Grade_Code = 'A' or Grade_Code = 'B' or Grade_Code = 'C')");
				studentsNeeding = test.writeResultSet(studentsTook, "Banner_id");

				if(studentsNeeding.isEmpty()) {
					studentsToTakeOut.add(student.get(i));
				}
			}
		}
		System.out.println(studentsToTakeOut);
		*/

	}	

}