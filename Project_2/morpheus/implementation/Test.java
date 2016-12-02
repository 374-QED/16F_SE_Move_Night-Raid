package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


class Test {

		
		public static void main(String[] args) throws Exception 
		{
			SQLiteAccess sqlite = new SQLiteAccess();
			nrLib lib = new nrLib();

			List<Integer> temp = lib.numConflicts("MWF", "10902");
			System.out.println(temp);
			CSVparser test = new CSVparser();
			System.out.println(test.parse_room("115"));

			// System.out.println(lib.comparing(lib.notavailableRoom("1200", "MWF"), lib.allRoom()));

		}
		/*
		public static void main(String[] args) throws SQLException {
			
			SQLiteAccess sqlite = new SQLiteAccess();
			nrLib cool = new nrLib();
		
			//System.out.println(cool.notavailableRoom("900","MWF"));
			//System.out.println(cool.allRoom());
			//List<String> all = cool.getAllStartTime("MWF");
			//List<String> find = cool.findTime("MKTG320","MWF");
			
			//System.out.println(cool.getAllStartTime("MWF"));
			//System.out.println(cool.getAllStartTime("TR"));
			//System.out.println(cool.findTime("MKTG320","MWF"));
			//System.out.println(cool.comparing(all,find));
		

			
			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();
			List<String> list4 = new ArrayList<String>();
			List<String> list5 = new ArrayList<String>();
			List<String> list6 = new ArrayList<String>();
			Scanner user_input = new Scanner(System.in);

			String course;
			String semester;
			String room_code1;
			//select distinct First_Name, Middle_Name, Last_Name, Banner_ID, Begin_Time, End_Time, Room_Code1 from classes where Term_Code = 201420 and Subject_Code = "CS" and Course_Number = "120" and begin_time = "800" and room_code1 = 117 order by begin_time, last_name, first_name asc;

			//System.out.println(list);

			String begin_time;
		
			ResultSet resultSet1 = sqlite.readDatabase("select distinct Term_Code from class_2016");
			list1 = sqlite.writeResultSet(resultSet1, "Term_Code");

			System.out.println("Available semesters: ");
			for(int x = 0; x < list1.size()-1;x++)
			{
				System.out.println(list1.get(x));
			}
			System.out.println("");

			System.out.println("Enter a semester: ");
			semester = user_input.next();
			System.out.println("");

			ResultSet resultSet2 = sqlite.readDatabase("select distinct subject_code from class_2016");
			list2 = sqlite.writeResultSet(resultSet2, "Subject_Code");
			System.out.println("Available Subjects: ");
			for(int i = 0; i < list2.size(); i++)
			{
				System.out.println(list2.get(i));
			}
			System.out.println("");
			System.out.println("Enter a course (such as 'CS120'): ");
			course = user_input.next();
			System.out.println("");

			String[] parts = sqlite.parseCourse(course);

			ResultSet resultSet3 = sqlite.readDatabase("select begin_time from class_2016 where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' order by begin_time asc");
			list3 = sqlite.writeResultSet(resultSet3, "Begin_Time");
			ResultSet resultSet4 = sqlite.readDatabase("select Room_Code1 from class_2016 where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' order by begin_time asc");
			list4 = sqlite.writeResultSet(resultSet4, "Room_Code1");
			System.out.println("Available Class Times and Rooms: ");
			
			for(int i = 0; i < list3.size(); i++)
			{
				if(list6.contains(list3.get(i) + " " + list4.get(i)) == false)
					list6.add(list3.get(i) + " " + list4.get(i));
			}
			for(int i = 0; i < list6.size(); i++)
			{
				System.out.println(list6.get(i));
			}
			System.out.println("");
			System.out.println("Enter a Class Time (I.E. '800'): ");
			begin_time = user_input.next();
			System.out.println("");

			System.out.println("Enter a Room_Code (I.E. '117'): ");
			room_code1 = user_input.next();
			System.out.println("");

			ResultSet resultSet5 = sqlite.readDatabase("select * from class_2016 where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' and begin_time = '"+begin_time+"' and room_code1 = '"+room_code1+"'");
			list5 = sqlite.writeResultSet(resultSet5, "Banner_ID");
			for(int x = 0; x < list5.size();x++)
 			{
 				System.out.println(cool.findStudent(list5.get(x)));		
 			}
			//System.out.println(list5);
			
	}
	*/
	
}