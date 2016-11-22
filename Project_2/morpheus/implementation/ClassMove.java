package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


class ClassMove {

	public static void clearScreen(int n){
		if(n != 0){ 
			System.out.print("\n");
			clearScreen(n-1);
		}
	}

	public static void main(String [] args) throws Exception{

		SQLiteAccess sqlite = new SQLiteAccess();
		Scanner user_input = new Scanner(System.in);
		nrLib nr = new nrLib();

		List<String> temp;
		String input;

		while(true)
		{
			System.out.print("\033[2J\033[1;1H");
	
			System.out.println("\nInput the CRN of the class you would like to move or QUIT to stop.");
			
			System.out.println("\nExample: \"10902\" or \"QUIT\"");

			String crn = user_input.next();
			crn = crn.toUpperCase();
			if(crn.contains("QUIT"))
			{
				break;
			}

			System.out.println("\nWhich days would you like to move the class to? \"MWF\" or \"TR\"");

			String days = user_input.next();
			days = days.toUpperCase();
			if(days.contains("QUIT"))
			{
				break;
			}

			List<String> t_avail = nr.comparing(nr.findTime(crn, days,0), nr.getAllStartTime(days));
			//System.out.println(t_avail);
			
			if(t_avail.isEmpty()) {

				System.out.println("\nThe class you want to move has time conflicts with all times.\nDo you want to prioritize Seniors? Yes or No?");
				input = user_input.next();
				input = input.toUpperCase();
				if(input.equals("YES")) {

					t_avail = nr.comparing(nr.findTime(crn, days,1), nr.getAllStartTime(days));
				}
				/*
				if(input.equals("NO")) {

					System.out.println("\nDo you want to prioritize Juniors? Yes or No?");
					input = user_input.next();
					input = input.toUpperCase();
					if(input.equals("YES")) {
						t_avail = nr.comparing(nr.findTime(crn, days,2), nr.getAllStartTime(days));
					}
				}
				*/
			}
			if(t_avail.isEmpty()==false)
			{
				System.out.println("Choose one of the following available times in which to move the class to:");
				System.out.println(t_avail);
				String time = user_input.next();

				temp = nr.comparing(nr.notavailableRoom(time, days), nr.allRoom());

				System.out.println("Choose one of the following rooms: \n" + temp);
				input = user_input.next();

				System.out.println("You can move the class with CRN:"+crn+" to the days "+days+" at "+time+" in the "+input+" room of the MBB\n\n\n");
			}
			else

				System.out.println("\nSorry, there does not seem to be an available time slot for this class.\n\n");


			System.out.println("Press \"Enter\" to continue...");
			Scanner scanner = new Scanner(System.in);
   			scanner.nextLine();
		}
		
	}

}