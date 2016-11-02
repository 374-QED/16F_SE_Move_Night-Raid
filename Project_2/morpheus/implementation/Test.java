package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class Test {


		public static void main(String[] args) throws Exception 
		{
			SQLiteAccess sqlite = new SQLiteAccess();
			nrLib cool = new nrLib();
			List<String> list = new ArrayList<String>();
			List<String> list1 = new ArrayList<String>();
			list = sqlite.getStudentsFromClass("CS120");
			list1 = sqlite.getClassFromTime("MWF","1330");

			//ResultSet resultSet = sqlite.readDatabase("select * from classes limit 10");

			//list = sqlite.writeResultSet(resultSet, "Banner_ID");
			/*
			for(int x = 0; x < list.size();x++)
			{
				System.out.println(cool.findStudent(list.get(x)));		
			}
			*/

			System.out.println(list1);			
		}

}