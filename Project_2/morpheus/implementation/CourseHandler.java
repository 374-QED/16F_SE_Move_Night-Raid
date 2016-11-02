package implementation;

import java.io.*;
import java.util.*;
import java.sql.ResultSet;
import implementation.SQLiteAccess;


class CourseHandler {

	private SQLiteAccess sqlite = new SQLiteAccess();
		
	public boolean moveClass(String course, String days, String time) {

		List<String> students = getStudentsFromClass(course);
	}

	public

}