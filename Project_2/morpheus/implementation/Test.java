package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class Test {


		public static void main(String[] args) 
		{
			SQLiteAccess sqlite = new SQLiteAccess();

			List<String> list = new ArrayList<String>();

			ResultSet resultSet = sqlite.readDatabase("select * from classes limit 10");

			list = sqlite.writeResultSet(resultSet, "Banner_ID");

			System.out.println(list);			
		}

}