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
//	,floor(alternativeCode/1000) AS parentCode
	
	public static ResultSet GetAreaListByLevel(int level,int parentCode, int alternativeCode) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT code,level,name,alternativeCode FROM GEOGRAPHICAREA WHERE level="+level;
		//get subList
		if(alternativeCode != -1 && parentCode != -1 ) {
			if(level == 2) {
				query += " AND ((alternativeCode-code)/1000)=" + parentCode;
			}
			
		}
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
	
	public static ResultSet GetAreaDetailByAlternativeCode(int alternativeCode) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT * FROM GEOGRAPHICAREA WHERE alternativeCode="+alternativeCode;
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
}