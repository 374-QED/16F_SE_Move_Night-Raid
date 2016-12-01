package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


class ClassMove {

	private static Scanner newInput = new Scanner(System.in);
	public static void clearScreen(int n){
		if(n != 0){ 
			System.out.print("\n");
			clearScreen(n-1);
		}
	}

	public static void printContinue(){
		System.out.print("\nPress \"Enter\" to continue...");
		newInput.nextLine();
	}

	public static String input(String input){
		input = input.toUpperCase();
		if(input.equals("QUIT")){
			System.exit(0);
		}
		return input;
	}

	public static void main(String [] args) throws Exception{

		SQLiteAccess sqlite = new SQLiteAccess();
		Scanner user_input = new Scanner(System.in);
		nrLib nr = new nrLib();

		List<String> temp;
		String input="";
		boolean go = true;
		String crn="";
		String days="";
		String time="";

		while(true)
		{
			while(go){

				System.out.print("\033[2J\033[1;1H");
		
				System.out.println("Input the CRN of the class you would like to move or QUIT to stop.");
				
				System.out.println("\nExample: \"10902\" \n");

				crn = input(user_input.next());
				
				ResultSet rs = sqlite.readDatabase("select CRN from class_2016 where CRN='"+crn+"'");
				temp = sqlite.writeResultSet(rs, "CRN");
				if(temp.isEmpty())
				{
					System.out.println("\nError: "+crn+" does not seem to be a valid CRN.");
					printContinue();
				}
				else
					go = !go;
			}
			go = !go;

			while(go){	
				System.out.print("\033[2J\033[1;1H");
				System.out.println("Which days would you like to move the class to? \"MWF\" or \"TR\" \n");
				days = input(user_input.next());
				if(days.equals("MWF") || days.equals("TR")){
					go = !go;
				} else{
					System.out.println("\nError: Invalid days set. Please choose \"MWF\" or \"TR\".");
					printContinue();
				}
			}
			go = !go;

			List<String> t_avail = nr.comparing(nr.findTime(crn, days,0), nr.getAllStartTime(days));
			//System.out.println(t_avail);
			
			if(t_avail.isEmpty()) {

				while(go){	
					System.out.print("\033[2J\033[1;1H");
					System.out.println("The class you want to move has time conflicts with all times.\nDo you want to prioritize Seniors? Yes or No? \n");
					input = input(user_input.next());
					if(input.equals("YES")) {

						t_avail = nr.comparing(nr.findTime(crn, days,1), nr.getAllStartTime(days));
						go = !go;
					}
					else if(input.equals("NO")){
						// Gonna do something later... maybe
						go = !go;
					}
					else{
						System.out.println("\nError: Invalid input. Please type \"YES\" or \"NO\".");
						printContinue();
					}
				}
				go = !go;
				
			}
			if(!t_avail.isEmpty())
			{
				while(go){	
					System.out.print("\033[2J\033[1;1H");
					System.out.println("Choose one of the following available times in which to move the class to:\n");
					nrLib.printList(t_avail);
					time = input(user_input.next());

					if(t_avail.contains(time)){
						go = !go;
					}
					else{
						System.out.println("\nError: "+time+" is not in the available time options.");
						printContinue();
					}
				}
				go = !go;

				temp = nr.comparing(nr.notavailableRoom(time, days), nr.allRoom());

				while(go){	
					System.out.print("\033[2J\033[1;1H");
					System.out.println("Choose one of the following rooms: \n");
					nrLib.printList(temp);
					input = input(user_input.next());
					if(temp.contains(input)){
						go = !go;
					}else{
						System.out.println("\nError: "+input+" is not one of the available rooms.");
						printContinue();
					}
				}
				go = !go;

				System.out.print("\033[2J\033[1;1H");
				System.out.println("\n\nYou can move the class with CRN:"+crn+" to the days "+days+" at "+time+" in the "+input+" room of the MBB\n\n\n");
			}
			else

				System.out.println("\nSorry, there does not seem to be an available time slot for this class.\n\n");


			// System.out.print("Press \"Enter\" to continue...");
			printContinue();
			user_input.nextLine();
		}
		
	}

}