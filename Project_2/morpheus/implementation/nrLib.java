package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

public class nrLib {
	private static SQLiteAccess test = new SQLiteAccess();

	public static String findStudentname(String student_id) throws SQLException
	{
		//given student id return full name
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
	public static String findStudent(String name) throws SQLException
	{
		//get student fullname output student ID
		String[] split = name.split("\\s+");
		ResultSet student_id;
		List<String> id;
		student_id = test.readDatabase("select distinct Banner_id from class_2017 where First_name = '"+split[0]+"' and Middle_name = '"+split[1]+"' and Last_name = '"+split[2]+"'");
		id  = test.writeResultSet(student_id,"Banner_id");
		return id.get(0); 
	}
	public List<String> getStudentFromCourse(String course) throws SQLException
	{
		String[] crs = test.parseCourse(course);
		ResultSet student = test.readDatabase("select Banner_ID from class_2017 where Subject_Code = '" + crs[0] + "' and Course_Number = '" + crs[1] + "'");
		return test.writeResultSet(student,"Banner_ID");
	}
	public List<String> getDataFromCourse(String course) throws SQLException
	{
		String[] crs = test.parseCourse(course);
	    return test.writeResultSet(test.readDatabase("select distinct Subject_Code, Course_Number, Room_Code1 from class_2017 where Term_Code = '201710' and Subject_Code = '" + crs[0] + "' and Course_Number = '" + crs[1] + "'"), "Room_Code1");

	}
	public List<String> getAllStartTime(String data) throws SQLException
    {
    	//retrive all time either on "MWF" or "TR"
    	List<String> all_time = new ArrayList<String>();
    	ResultSet time;
    	if(data.charAt(0) == 'M')
    		time = test.readDatabase("select distinct Begin_Time from class_2017 where Term_Code = '"+test.getLatestSemester()+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F'");
    	else
    		time = test.readDatabase("select distinct Begin_Time from class_2017 where Term_Code = '"+test.getLatestSemester()+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R'");
		all_time = test.writeResultSet(time,"Begin_Time");
    	return all_time;

    }
    public List<String> comparing(List<String> data1, List<String> data2) throws SQLException
    {
    	//compare two different list of string with same element.
    	List<String> different = new ArrayList<String>();
    	if(data1.size() > data2.size())
    	{
    		List<String> temp = data1;
    		data1 = data2;
    		data2 = temp;
    	}
    	for(int x = 0; x < data1.size();x++)
    	{
    		for(int y = 0; y < data2.size();y++)
    		{
    			if(data1.contains(data2.get(y)) == false)
    				different.add(data2.get(y));
    		}
    	}
    	return different;
    }
    public List<String> allRoom() throws SQLException
    {
    	List<String> room = new ArrayList<String>();
    	ResultSet temp = test.readDatabase("select distinct Room_Code1 from class_2017");
    	room = test.writeResultSet(temp,"Room_Code1");
    	return room;
    }
    public List<String> notavailableRoom(String time, String days) throws SQLException
    {
    	//given time and day how many room is occupied
    	List<String> room = new ArrayList<String>();
    	ResultSet temp;
    	if(days.charAt(0)=='M')
    		temp = test.readDatabase("select distinct Room_Code1 from class_2017 where Term_Code = '"+test.getLatestSemester()+"' and  Begin_Time = '"+time+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F'");
    	else
    		temp = test.readDatabase("select distinct Room_Code1 from class_2017 where Term_Code = '"+test.getLatestSemester()+"' and Begin_Time = '"+time+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R'");
   		room = test.writeResultSet(temp,"Room_Code1");
   		return room; 	
    }	
	public static List<String> findTime(String course, String date) throws SQLException
	{
		//Aldo wanted this function 
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