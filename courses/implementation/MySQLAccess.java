package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;


public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;


	public void readDatabase(String query) throws Exception {

		try {	

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup connection with database    getConnection("database", "username", "password")
			connect = DriverManager.getConnection("jdbc:mysql://localhost/cs374?autoReconnect=true&useSSL=false", "root", "Wildcat87!");

			// Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();

	        // Result set get the result of the SQL query
	        resultSet = statement.executeQuery(query);

	        //writeResultSet(resultSet);
	        writeMetaData(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}



	private void writeMetaData(ResultSet resultSet) throws SQLException {
        // Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            
            String firstName = resultSet.getString("First_name");
            
            System.out.println("First Name: " + firstName);
        }
    }

    // You need to close the resultSet
    private void close() {
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