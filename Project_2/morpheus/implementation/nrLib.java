package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

public class NRLib {
	private static SQLiteAccess test = new SQLiteAccess();

	public static String findStudent(String student_id) throws SQLException
	{
		ResultSet student;
		String full_name;
		List<String> first_name;
		List<String> middle_name;
		List<String> last_name;
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2017 where Banner_id = '"+student_id+"'");
		first_name = test.writeResultSet(student, "First_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2017 where Banner_id = '"+student_id+"'");
		middle_name = test.writeResultSet(student, "Middle_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2017 where Banner_id = '"+student_id+"'");		
		last_name = test.writeResultSet(student, "Last_name");
		//System.out.println(first_name);
		full_name = first_name.get(0) + " " + middle_name.get(0) + " " + last_name.get(0);
		return full_name;
	}
	public static String findStudent(String first,String second, String third) throws SQLException
	{
		ResultSet student_id;
		List<String> id;
		student_id = test.readDatabase("select distinct Banner_id from class_2017 where First_name = '"+first+"' and Middle_name = '"+second+"' and Last_name = '"+third+"'");
		id  = test.writeResultSet(student_id,"Banner_id");
		return id.get(0); 
	}
	public static List<String> findTime(String course, String date) throws SQLException
	{
		String semester = test.getLatestSemester();
		String[] parse = test.parseCourse(course);
		ResultSet student_id;
		if(date.charAt(0) == 'M')
			student_id = test.readDatabase("select distinct Banner_id from class_2017 where Subject_Code = '"+parse[0]+"' and Course_Number ='"+parse[1]+"' and Term_Code = '"+semester+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F'");
		else
			student_id = test.readDatabase("select distinct Banner_id from class_2017 where Subject_Code = '"+parse[0]+"' and Course_Number ='"+parse[1]+"' and Term_Code = '"+semester+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R'");

		List<String> student =  test.writeResultSet(student_id, "Banner_id");
		List<String> dist_time = new ArrayList<String>();
		for(int x = 0; x < student.size(); x++)
		{
			ResultSet class_t;
			if(date.charAt(0) == 'M')
				class_t = test.readDatabase("select distinct Begin_Time from class_2017 where Banner_id = '"+student.get(x)+"' and Term_Code = '"+semester+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F'");
			else
				class_t = test.readDatabase("select distinct Begin_Time from class_2017 where Banner_id = '"+student.get(x)+ "' and Term_Code = '"+semester+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R'");
			List<String> class_time = test.writeResultSet(class_t, "Begin_Time");
			for(int y = 0; y < class_time.size();y++)
			{
				if(dist_time.contains(class_time.get(y))==false)
					dist_time.add(class_time.get(y));
			}

		}
		return dist_time;
	}
}	