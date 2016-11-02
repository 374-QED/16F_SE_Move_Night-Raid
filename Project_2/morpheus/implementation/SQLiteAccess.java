package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.*;

import java.util.*;

public class SQLiteAccess {

	public String[] parseCourse(String name)
    {
        int t = 0;
        for(int x = 0; x < name.length();x++)
        {
            int hold = name.charAt(x);
            if(hold >= 48 && hold <= 58 && t==0)
            {
                t = x;
            }
        }
        String[] parts = {name.substring(0,t),name.substring(t)};
        return parts;
    }
	public ResultSet readDatabase(String query){

		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {	

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("org.sqlite.JDBC");

			// Setup connection with database    getConnection("database", "username", "password")
			connect = DriverManager.getConnection("jdbc:sqlite:resources/SQLite/classes.db");
			// Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();

	        // Result set get the result of the SQL query
	        resultSet = statement.executeQuery(query);




		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return resultSet;
		}
	}

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //                           Needs Work On
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
	public List<String> getStudentsFromClass(String course) throws SQLException {
		Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String word = "Banner_id";
		String[] parts = parseCourse(course);
		resultSet = readDatabase("select Banner_id from classes where Term_Code = '"+getLatestSemester()+"' and Subject_Code = '"+parts[0]+"' and Course_number = '"+parts[1]+"'");
		return writeResultSet(resultSet, word);
	}


    public String getLatestSemester() throws SQLException {
        // return the latest semester
        Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        resultSet = readDatabase("select distinct Term_Code from classes order by Term_Code desc");
        return writeString(resultSet,"Term_Code");
    }
 
    public List<String> getClassFromTime(String days, String time) throws SQLException {
        // return the classes that have this time
         Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//resultSet = readDatabase("select Subject_Code, Course_number from classes where ")

    }



	public void writeMetaData(ResultSet resultSet) throws SQLException {
        // Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    public List<String> writeResultSet(ResultSet resultSet, String column_set) {
        // ResultSet is initially before the first data set
        //System.out.println("Hello");
        try {
            List<String> item = new ArrayList<String>();
    
            while (resultSet.next()) {
                
                item.add(resultSet.getString(column_set));
                //System.out.println(column_set + ": " + firstName);
            }
            return item;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String writeString(ResultSet resultSet, String column_set) throws SQLException {
            return resultSet.getString(column_set);
    }

    // You need to close the resultSet
    private void close() {
    	Connection connect = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
                if (resultSet != null) {
                        resultSet.close();
                }

                if (statement != null) {
                        statement.close();
                }

                if (preparedStatement != null) {
                        preparedStatement.close();
                }

                if (connect != null) {
                        connect.close();
                }
        } catch (Exception e) {

        }
    }

}