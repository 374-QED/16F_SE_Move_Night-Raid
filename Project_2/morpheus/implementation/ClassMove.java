package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClassMove {

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
		input = input.replace("'", "");
		input = input.replace("\"", "");
		if(input.equals("QUIT")){
			System.exit(0);
		}
		return input;
	}

	public static void printData(String crn, String days, String time, String room) throws Exception{
		System.out.println("CRN: "+crn);
		System.out.println("Class: "+ (crn.equals("") ? "" : nrLib.crnToClass(crn)));
		System.out.println("Days: "+days);
		System.out.println("Time: "+time);
		System.out.println("Room: "+room+"\n\n");
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
		String room="";
		List<Integer> numCon=null;
		List<String> student;

		while(true)
		{
			input="";
			go = true;
			crn="";
			days="";
			time="";
			room="";
			numCon=null;


			while(go){

				System.out.print("\033[2J\033[1;1H");
				printData(crn,days,time,room);

				System.out.println("Input the CRN of the class you would like to move or QUIT to stop.");
				
				System.out.println("\nExample: \"10902\" \n");

				crn = input(user_input.next());
				
				ResultSet rs = sqlite.readDatabase("select CRN from class_2016 where CRN='"+crn+"'");
				temp = sqlite.writeResultSet(rs, "CRN");
				if(temp.isEmpty())
				{
					System.out.println("\nError: "+crn+" does not seem to be a valid CRN.");
					printContinue();
					crn="";
				}
				else
					go = !go;
			}
			go = !go;

			while(go){	
				System.out.print("\033[2J\033[1;1H");
				printData(crn,days,time,room);
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

			if(t_avail.isEmpty()) {

				while(go){	
					System.out.print("\033[2J\033[1;1H");
					printData(crn,days,time,room);
					System.out.println("The class you want to move has time conflicts with all times.\nDo you want to prioritize Seniors? Yes or No? \n");
					input = input(user_input.next());
					if(input.equals("YES")) {

						t_avail = nr.comparing(nr.findTime(crn, days,1), nr.getAllStartTime(days));
						go = !go;
					}
					else if(input.equals("NO")){
						
						t_avail = nr.getAllStartTime(days);
						numCon = nr.numConflicts(days, crn);

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
					printData(crn,days,time,room);
					System.out.println("Choose one of the following available times in which to move the class to:\n");
					
					if(numCon != null){
						System.out.println("times available  |  number of Conflicts\n");
						nr.printList(t_avail, numCon);
					} else{
						nrLib.printList(t_avail);
					}

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
					printData(crn,days,time,room);
					System.out.println("Choose one of the following rooms: \n");

					for(int x = 0; x < temp.size();x++)
			       	{
			       		if(!nr.compare_room(temp.get(x),crn))
			       			temp.remove(x);
			       	}

					nr.printList(temp);
					room = input(user_input.next());

					if(temp.contains(room)){
						go = !go;
					}else{
						System.out.println("\nError: "+room+" is not one of the available rooms.");
						printContinue();
					}
				}
				go = !go;

				System.out.print("\033[2J\033[1;1H");
				printData(crn,days,time,room);
				System.out.println("\nYou can move the class with CRN:"+crn+" to the days "+days+" at "+time+" in the "+room+" room of the MBB\n\n");

				System.out.println("These are the students (if any) that have time conflict.\n");

				student = nr.getStudentFromCourse_CRN(crn);
				for(int i = 0; i < student.size();i++){
					if(!nr.in_this_class(student.get(i), time, days)){
						System.out.println(nr.classification(student.get(i))+"  "+student.get(i)+"  "+nr.findStudentname(student.get(i)));
					}
				}
			}
			else

				System.out.println("\nSorry, there does not seem to be an available time slot for this class.\n\n");


			// System.out.print("Press \"Enter\" to continue...");
			printContinue();
			user_input.nextLine();
		}
		
	}

}