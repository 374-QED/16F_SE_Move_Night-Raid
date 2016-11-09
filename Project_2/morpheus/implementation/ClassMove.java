package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class ClassMove {

	public static void main(String [] args) throws SQLException{

		SQLiteAccess sqlite = new SQLiteAccess();
		nrLib awesome = new nrLib();
		System.out.println("\nInput the class you would like to move.  -- Example: \"CS120\"");
		System.out.println(sqlite.readDatabase())
		Scanner user_input = new Scanner(System.in);
		String class;

		List<int> studentTimeMWF = // 	give me a list that only contains the distinct begin times
									// 	of the students' other classes for MWF
		
		List<int> studentTimeTR = // 	give me a list that only contains the distinct begin times
									// 	of the students' other classes for TR

		System.out.println("Do you want to move the class to the ?");
		Scanner user_input = new Scanner(System.in);
		String class;
		//nrLib.findTime("FIN412");
	}

}