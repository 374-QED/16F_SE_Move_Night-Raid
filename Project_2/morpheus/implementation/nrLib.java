package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

public class nrLib {
	private static SQLiteAccess test = new SQLiteAccess();

	public static String findStudent(String student_id) throws SQLException
	{
		ResultSet student;
		String full_name;
		List<String> first_name;
		List<String> middle_name;
		List<String> last_name;
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from classes where Banner_id = '"+student_id+"'");
		first_name = test.writeResultSet(student, "First_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from classes where Banner_id = '"+student_id+"'");
		middle_name = test.writeResultSet(student, "Middle_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from classes where Banner_id = '"+student_id+"'");		
		last_name = test.writeResultSet(student, "Last_name");
		//System.out.println(first_name);
		full_name = first_name.get(0) + " " + middle_name.get(0) + " " + last_name.get(0);
		return full_name;
	}
	public static String findStudent(String first,String second, String third) throws SQLException
	{
		ResultSet student_id;
		List<String> id;
		student_id = test.readDatabase("select distinct Banner_id from classes where First_name = '"+first+"' and Middle_name = '"+second+"' and Last_name = '"+third+"'");
		id  = test.writeResultSet(student_id,"Banner_id");
		return id.get(0);
	}
}	