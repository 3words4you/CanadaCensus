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
	
	//if get all,parentCode is -1
	public static ResultSet GetAreaList(int level,int parentCode) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT code,level,name,alternativeCode FROM GEOGRAPHICAREA WHERE level="+level;
		//get subList
		if(parentCode != -1 ) {
			if(level == 2) {
				query += " AND ((alternativeCode-code)/1000)=" + parentCode;
			}
			if(level == 3) {
				query += " AND MOD(code,1000) =" + parentCode;
			}
			
		}
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
	
	public static ResultSet GetAreaDetailByAlternativeCode(int alternativeCode) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT g.*,SUM(a.combined) AS totalPopulation FROM GEOGRAPHICAREA g LEFT JOIN AGE a ON g.geographicAreaID = a.geographicArea AND a.censusYear=1 WHERE g.alternativeCode="+alternativeCode + " GROUP BY g.geographicAreaID,g.code,g.level,g.name,g.alternativeCode";
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
	//span exactly 5 year and over100
	public static ResultSet GetAgeGroupList() throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT * FROM AGEGROUP WHERE ageGroupID IN (3,9,15,22,28,34,40,46,52,58,64,70,76,83,89,95,101,108,114,120,126)";
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
	
	public static ResultSet GetAgeGroupDetail(int ageGroupID,int censusYear) throws SQLException {
		tempStatement = tempConnection.createStatement();
		String query = "SELECT SUM(male) AS totalMale,SUM(female) AS totalFemale FROM AGE WHERE ageGroup="+ageGroupID+" AND censusYear="+censusYear;
		ResultSet res = tempStatement.executeQuery(query);
		return res;
	}
}