package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class ClassMove {

	public static void main(String [] args) throws SQLException{

		SQLiteAccess sqlite = new SQLiteAccess();

		Scanner user_input = new Scanner(System.in);
		String class;

		System.out.println("Which class would you like to move?  Example: \"CS120\"");
		class = user_input.next();
	}

}