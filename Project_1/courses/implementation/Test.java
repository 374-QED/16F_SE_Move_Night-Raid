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
		System.out.println("Team: Night-Raid");
		System.out.println("Members: Aldo Anaya, Nattapat White, and Darius Bell");
		System.out.println("Project for CS374.01 Software Engineering");
		System.out.println("Date: 10/14/2016");
		System.out.println("\n");
		System.out.println("Enter a course (such as 'CS120'): ");
		course = user_input.next();
		System.out.println("Enter a semester (such as '201320'): ");
		semester = user_input.next();
		test.print(course,semester);
	}	

}