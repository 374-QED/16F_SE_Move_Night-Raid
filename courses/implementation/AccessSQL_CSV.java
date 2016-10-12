package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

public class AccessSQL_CSV {
	private static MySQLAccess test = new MySQLAccess();
	private static CSVparser csvParser = new CSVparser();

	public static List<String> getStudent(String semester, String course) throws SQLException
	{
		return test.getStudents(semester,course);
	}

	public static List<String> takeOutStudent(List<String> student_id, String course) throws SQLException 
	{
		List<String> prereqs = csvParser.parsePreReq(course);
		List<String> studentNeeding = new ArrayList<String>();
		List<String> studentToTakeOut = new ArrayList<String>();
		ResultSet studentsTook;
		for(int i = 0; i < student_id.size(); i++) {

			for(int j = 0; j < prereqs.size(); j++) 
			{
				String[] parts = csvParser.parseCourse(prereqs.get(j));
				studentsTook = test.readDatabase("select distinct Banner_id from cs374_anon where Banner_id = '"+student_id.get(i)+"' and Subject_Code = '"+parts[0]+"' and Course_number = '"+parts[1]+"' and (Grade_Code = 'A' or Grade_Code = 'B' or Grade_Code = 'C')");
				studentNeeding = test.writeResultSet(studentsTook, "Banner_id");

				if(studentNeeding.isEmpty() && studentToTakeOut.contains(student_id.get(i)) == false) {
					studentToTakeOut.add(student_id.get(i));
				}
			}
		}
		return studentToTakeOut;
	}

	public static String findStudent(String student_id) throws SQLException
	{
		ResultSet student;
		String full_name;
		List<String> first_name;
		List<String> middle_name;
		List<String> last_name;
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from cs374_anon where Banner_id = '"+student_id+"'");
		first_name = test.writeResultSet(student, "First_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from cs374_anon where Banner_id = '"+student_id+"'");
		middle_name = test.writeResultSet(student, "Middle_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from cs374_anon where Banner_id = '"+student_id+"'");		
		last_name = test.writeResultSet(student, "Last_name");
		//System.out.println(first_name);
		full_name = first_name.get(0) + " " + middle_name.get(0) + " " + last_name.get(0);
		return full_name;
	}
	public static String findStudent(String first,String second, String third) throws SQLException
	{
		ResultSet student_id;
		List<String> id;
		student_id = test.readDatabase("select distinct Banner_id from cs374_anon where First_name = '"+first+"' and Middle_name = '"+second+"' and Last_name = '"+third+"'");
		id  = test.writeResultSet(student_id,"Banner_id");
		return id.get(0);
	}
}	