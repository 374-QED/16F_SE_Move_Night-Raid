package implementation;

import java.io.*;
import java.util.*;
import java.sql.*;

class Test {

	public static void main(String[] args) throws Exception
	{
		String course;
		String semester;
		AccessSQL_CSV test = new AccessSQL_CSV();
		Scanner user_input = new Scanner(System.in);
		System.out.println("Enter course: ");
		course = user_input.next();
		System.out.println("Enter semester: ");
		semester = user_input.next();
		test.print(course,semester);

		
	}	

}