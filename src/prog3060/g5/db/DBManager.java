package prog3060.g5.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager{
	
	static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/CanadaCensusDB;traceFile=trace.txt;traceLevel=7";
	static Connection tempConnection;
	static Statement tempStatement;
	
	public static Connection OpenConnection(String username,String password) throws SQLException {
		Properties tempConnectionProperties = new Properties();
		tempConnectionProperties.put("user", username);
		tempConnectionProperties.put("password", password);
		
		tempConnection = DriverManager.getConnection(CONNECTION_STRING, tempConnectionProperties);
		
		//Disable Auto-Commit Mode
		tempConnection.setAutoCommit(false);
		tempConnection.createStatement().executeUpdate("SET SCHEMA APP");
		
		return tempConnection;
    }
	
	public static ResultSet GetAreaListByLevel(int level) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT * FROM GEOGRAPHICAREA WHERE level="+level;
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
}