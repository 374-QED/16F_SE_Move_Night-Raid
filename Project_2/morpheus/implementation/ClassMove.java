package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class ClassMove {

	public static void main(String [] args) throws SQLException{

		SQLiteAccess sqlite = new SQLiteAccess();
		Scanner user_input = new Scanner(System.in);
		nrLib nr = new nrLib();

		System.out.println("\nInput the class you would like to move.  -- Example: \"CS120\"");
		
		String class_t = user_input.next();

		System.out.println("Which days would you like to move the class to? \"MWF\" or \"TR\"");

		String days = user_input.next();
		if(days == "MWF")
		{
			List<String> studentTimeMWF = nr.findTime(class_t,days);
			//System.out.println(studentTimeMWF);
		}
		else
		{
			List<String> studentTimeTR = nr.findTime(class_t,days);
			//System.out.println(studentTimeTR);
		}
	}

}