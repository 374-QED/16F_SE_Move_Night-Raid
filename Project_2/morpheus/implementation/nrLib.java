package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

//complexity: 6,3,3,2,5,3,2,5,8
//total: 9

public class nrLib {
	private static SQLiteAccess test = new SQLiteAccess();

	public static String findStudentname(String student_id) throws SQLException
	{
		// CC = 6
		//given student id return full name
		ResultSet student;
		String full_name;
		List<String> first_name;
		List<String> middle_name;
		List<String> last_name;
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2016 where Banner_Id = '"+student_id+"'");
		first_name = test.writeResultSet(student, "First_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2016 where Banner_Id = '"+student_id+"'");
		middle_name = test.writeResultSet(student, "Middle_name");
		student = test.readDatabase("select distinct First_name, Middle_name, Last_name from class_2016 where Banner_Id = '"+student_id+"'");		
		last_name = test.writeResultSet(student, "Last_name");
		//System.out.println(first_name);
		full_name = first_name.get(0) + " " + middle_name.get(0) + " " + last_name.get(0);
		return full_name;
	}
	public static String findStudent(String name) throws SQLException
	{
		//get student fullname output student ID
		// CC = 3
		String[] split = name.split("\\s+");
		ResultSet student_id;
		List<String> id;
		student_id = test.readDatabase("select distinct Banner_id from class_2016 where First_name = '"+split[0]+"' and Middle_name = '"+split[1]+"' and Last_name = '"+split[2]+"'");
		id  = test.writeResultSet(student_id,"Banner_id");
		return id.get(0); 
	}
	
	public List<String> getStudentFromCourse(String course) throws SQLException
	{
		// CC = 3
		String[] crs = test.parseCourse(course);
		ResultSet student = test.readDatabase("select Banner_ID from class_2016 where Subject_Code = '" + crs[0] + "' and Course_Number = '" + crs[1] + "'");
		return test.writeResultSet(student,"Banner_ID");
	}
	public List<String> crn_time(String crn) throws SQLException
	{
		ResultSet crn1 = test.readDatabase("select distinct Begin_Time from class_2016 where CRN = '"+crn+"'");
		return test.writeResultSet(crn1,"Begin_Time");
	}

	public List<String> crn_day(String crn) throws SQLException
	{
		ResultSet crn1 = test.readDatabase("select distinct Begin_Time, Monday_Ind1 from class_2016 where CRN = '"+crn+"'");
		return test.writeResultSet(crn1,"Monday_Ind1");
	}

	public List<String> crn_Exit() throws SQLException
	{
		ResultSet crn = test.readDatabase("select distinct CRN from class_2016");
		return test.writeResultSet(crn,"CRN");
	}
	public List<String> getStudentFromCourse_CRN(int crn) throws SQLException
	{
		// CC = 3
		ResultSet student = test.readDatabase("select Banner_ID from class_2016 where CRN = '"+ crn + "'");
		return test.writeResultSet(student,"Banner_ID");
	}

	public ResultSet getStudentsClasses(String banner_id) throws SQLException
	{
		return test.readDatabase("select * from class_2016 where Term_Code = '"+test.getLatestSemester()+"' and Banner_id = '"+banner_id+"'");
	}

	public List<String> getDataFromCourse(String course) throws SQLException
	{
		// CC = 2
		String[] crs = test.parseCourse(course);
	    return test.writeResultSet(test.readDatabase("select distinct Subject_Code, Course_Number, Room_Code1 from class_2016 where Term_Code = '"+ test.getLatestSemester()+"' and Subject_Code = '" + crs[0] + "' and Course_Number = '" + crs[1] + "'"), "Room_Code1");

	}
	public List<String> getAllStartTime(String data) throws SQLException
    {
    	//retrive all time either on "MWF" or "TR"
    	// CC = 5
    	List<String> all_time = new ArrayList<String>();
    	ResultSet time;
    	if(data.charAt(0) == 'M')
    		time = test.readDatabase("select distinct Begin_Time from class_2016 where Term_Code = '"+test.getLatestSemester()+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F' and Begin_Time >= 800 and Begin_Time <= 1700 order by Begin_Time");
    	else
    		time = test.readDatabase("select distinct Begin_Time from class_2016 where Term_Code = '"+test.getLatestSemester()+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R' and Begin_Time >= 800 and Begin_Time <= 1700 and (End_Time - Begin_Time) = 120 order by Begin_Time");
		all_time = test.writeResultSet(time,"Begin_Time");
    	return all_time;

    }
    public List<String> comparing(List<String> data1, List<String> data2) throws SQLException
    {
    	// CC = 3
    	//compare two different list of string with same element.
    	if(data1.size()==0)
    		return data2;
    	else if(data2.size()==0)
    		return data1;
    	List<String> different = new ArrayList<String>();
    	for(int x = 0; x < data2.size();x++)
    	{
    		if(data1.contains(data2.get(x))==false)
    		{
    			different.add(data2.get(x));
    		}
    	}
    	
    	return different;
    }
    public List<String> comparingRoom(List<String> all, List<String> data2) throws SQLException
    {
    	// CC = 3
    	//compare two different list of string with same element.
    	if(data2.size()==0)
    		return all;
    	List<String> different = new ArrayList<String>();
    	for(int x = 0; x < data2.size();x++)
    	{
    		if(all.contains(data2.get(x))==false)
    		{
    			different.add(data2.get(x));
    		}
    	}
    	
    	return different;
    }
    public List<String> allRoom() throws SQLException
    {
    	//CC = 2
    	List<String> room = new ArrayList<String>();
    	ResultSet temp = test.readDatabase("select distinct Room_Code1 from class_2016 where Bldg_Code1 = 'MBB' and Term_Code = '"+test.getLatestSemester()+"' order by Room_Code1");
    	room = test.writeResultSet(temp,"Room_Code1");
    	return room;
    }
    public List<String> notavailableRoom(String time, String days) throws SQLException
    {
    	//given time and day how many room is occupied
    	//CC = 5
    	List<String> room = new ArrayList<String>();
    	ResultSet temp;
    	if(days.charAt(0)=='M')
    		temp = test.readDatabase("select distinct Room_Code1 from class_2016 where Bldg_Code1 = 'MBB' and Term_Code = '"+test.getLatestSemester()+"' and Begin_Time = '"+time+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F' order by Room_Code1");
    	else
    		temp = test.readDatabase("select distinct Room_Code1 from class_2016 where Bldg_Code1 = 'MBB' and Term_Code = '"+test.getLatestSemester()+"' and Begin_Time = '"+time+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R' order by Room_Code1");
   		room = test.writeResultSet(temp,"Room_Code1");
   		return room; 	
    }	
	public static List<String> findTime(String crn, String date, int priority) throws SQLException
	{
		//CC = 8
		//Aldo wanted this function 
		String semester = test.getLatestSemester();
		//String[] parse = test.parseCourse(course);
		ResultSet student_id;
		
		if(priority == 1)
			student_id = test.readDatabase("select distinct Banner_id from class_2016 where Class_Desc = 'Senior' and CRN = '"+crn+"' and Term_Code = '"+semester+"'");
		else if(priority == 2)
			student_id = test.readDatabase("select distinct Banner_id from class_2016 where Class_Desc = 'Junior' and CRN = '"+crn+"' and Term_Code = '"+semester+"'");
		else
			student_id = test.readDatabase("select distinct Banner_id from class_2016 where CRN = '"+crn+"' and Term_Code = '"+semester+"'");

		List<String> student =  test.writeResultSet(student_id, "Banner_id");
		List<String> dist_time = new ArrayList<String>();
		for(int x = 0; x < student.size(); x++)
		{
			ResultSet class_t;
			if(date.charAt(0) == 'M')
				class_t = test.readDatabase("select distinct Begin_Time from class_2016 where Banner_id = '"+student.get(x)+"' and Term_Code = '"+semester+"' and Monday_Ind1 = 'M' and Wednesday_Ind1 = 'W'and Friday_Ind1 = 'F' order by Begin_Time");
			else
				class_t = test.readDatabase("select distinct Begin_Time from class_2016 where Banner_id = '"+student.get(x)+ "' and Term_Code = '"+semester+"' and Tuesday_Ind1 = 'T' and Thursday_Ind1 = 'R' order by Begin_Time");
			List<String> class_time = test.writeResultSet(class_t, "Begin_Time");
			for(int y = 0; y < class_time.size();y++)
			{
				if(dist_time.contains(class_time.get(y))==false)
					dist_time.add(class_time.get(y));
			}

		}
		return dist_time;
	}
	public boolean error_term(String crn, String days) throws SQLException
	{
		List<String> not_all = findTime(crn,days,0);
		List<String> all = getAllStartTime(days);
		List<String> single = crn_day(crn);
		List<String> single_t = crn_time(crn);
		List<String> compare = new ArrayList<String>();
		String s = ""+days.charAt(0);
		if(s == single.get(0))
		{
			compare = comparing(not_all,all);
			if(compare.size() == 0)
				return false;
			else
			{	
				int count = 0;
				for(int x = 0; x < compare.size();x++)
				{
					if(not_all.contains(compare.get(x)) || single_t.get(0) == compare.get(0))
						count++;
				}
				if(count == compare.size())
					return false;
			}
		}
		else
		{
			compare = comparing(not_all,all);
			if(compare.size() == 0)
				return false;
			else
			{	
				int count = 0;
				for(int x = 0; x < compare.size();x++)
				{
					if(not_all.contains(compare.get(x)))
						count++;
				}
				if(count == compare.size())
					return false;
			}
		}
		return true;
	} 
}	