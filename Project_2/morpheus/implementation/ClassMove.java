package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class ClassMove {

	public static void main(String [] args) throws SQLException{

		SQLiteAccess sqlite = new SQLiteAccess();
		Scanner user_input = new Scanner(System.in);

		System.out.println("\nInput the class you would like to move.  -- Example: \"CS120\"");
		
		String class = user_input.next();

		System.out.println("Which days would you like to move the class to? \"MWF\" or \"TR\"")

		String days = user_input.next();

		List<int> studentTimeMWF = // 	give me a list that only contains the distinct begin times
									// 	of the students' other classes for MWF
		
		List<int> studentTimeTR = // 	give me a list that only contains the distinct begin times
									// 	of the students' other classes for TR


		

		ResultSet 
	}

}