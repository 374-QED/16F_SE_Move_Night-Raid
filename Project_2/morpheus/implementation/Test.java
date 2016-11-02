package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


class Test {

		private static CSVparser csvParser = new CSVparser();

		public static void main(String[] args) throws SQLException {
			
			SQLiteAccess sqlite = new SQLiteAccess();

			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();
			List<String> list4 = new ArrayList<String>();
			List<String> list5 = new ArrayList<String>();
			Scanner user_input = new Scanner(System.in);

			String course;
			String semester;
			String begin_time;
			String room_code1;
			//select distinct First_Name, Middle_Name, Last_Name, Banner_ID, Begin_Time, End_Time, Room_Code1 from classes where Term_Code = 201420 and Subject_Code = "CS" and Course_Number = "120" and begin_time = "800" and room_code1 = 117 order by begin_time, last_name, first_name asc;

			//System.out.println(list);


			ResultSet resultSet1 = sqlite.readDatabase("select distinct Term_Code from classes");
			list1 = sqlite.writeResultSet(resultSet1, "Term_Code");
			System.out.println("Avialiable semesters: ");
			System.out.println(list1);
			System.out.println("Enter a semester: ");
			semester = user_input.next();

			ResultSet resultSet2 = sqlite.readDatabase("select distinct subject_code from classes");
			list2 = sqlite.writeResultSet(resultSet2, "Subject_Code");
			System.out.println("Avialiable Subjects: ");
			System.out.println(list2);
			System.out.println("Enter a course (such as 'CS120'): ");
			course = user_input.next();

			String[] parts = csvParser.parseCourse(course);

			ResultSet resultSet3 = sqlite.readDatabase("select begin_time from classes where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' order by begin_time asc");
			list3 = sqlite.writeResultSet(resultSet3, "Begin_Time");
			ResultSet resultSet4 = sqlite.readDatabase("select Room_Code1 from classes where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' order by begin_time asc");
			list4 = sqlite.writeResultSet(resultSet4, "Room_Code1");
			System.out.println("Avialiable Class Times and Rooms: ");
			for(int i = 0; i < list3.size(); i++)
			{
				System.out.println(list3.get(i) + " " + list4.get(i));
			}
			System.out.println("Enter a Class Time (I.E. '800'): ");
			begin_time = user_input.next();
			System.out.println("Enter a Room_Code (I.E. '117'): ");
			room_code1 = user_input.next();

			ResultSet resultSet5 = sqlite.readDatabase("select * from classes where Term_Code = '"+semester+"' and Subject_Code = '"+parts[0]+"' and Course_Number = '"+parts[1]+"' and begin_time = '"+begin_time+"' and room_code1 = '"+room_code1+"'");
			list5 = sqlite.writeResultSet(resultSet5, "Banner_ID");
			System.out.println(list5);

		}

}