package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


class ClassMove {

	public static void main(String [] args) throws SQLException{

		SQLiteAccess sqlite = new SQLiteAccess();
		Scanner user_input = new Scanner(System.in);
		nrLib nr = new nrLib();

		List<String> temp;
		String input;

		System.out.println("\nInput the CRN of the class you would like to move.  -- Example: \"10902\"");
		
		String crn = user_input.next();

		System.out.println("Which days would you like to move the class to? \"MWF\" or \"TR\"");

		String days = user_input.next();

		List<String> t_avail = nr.comparing(nr.findTime(crn, days,0), nr.getAllStartTime(days));
		if(t_avail.isEmpty()) {

			System.out.println("The class you want to move has time conflicts with all times. Do you want to prioritize Seniors? Yes or No?");
			input = user_input.next();
			if(input.equals("Yes")) {

				t_avail = nr.comparing(nr.findTime(crn, days,1), nr.getAllStartTime(days));
			}

		}

		System.out.println("Choose one of the following available times in which to move the class to:");
		System.out.println(t_avail);
		String time = user_input.next();

		temp = nr.comparing(nr.notavailableRoom(time, days), nr.allRoom());

		System.out.println("Choose one of the following rooms: \n" + temp);
		input = user_input.next();

		System.out.println("You can move the class with CRN:"+crn+" to the days "+days+" at "+time+" in the "+input+" room of the MBB");
		
	}

}