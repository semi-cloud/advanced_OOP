package OOP.week10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordDaoImpl extends DAOImpl<PasswordInfo, String> {
	
	final static String DB_FILE_NAME = "userinfo.db";
	 
    Connection connection = null;  
	ResultSet rs = null;
	Statement statement = null;
	
	public PasswordDaoImpl(String dbTableName) {      
		super(dbTableName);
		final String table = " (url text PRIMARY KEY, id text, password text)";
	    try {
	        connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
	        statement = connection.createStatement();

	        statement.setQueryTimeout(30); 
	        
	        statement.executeUpdate("DROP TABLE IF EXISTS " +  dbTableName);
	        statement.executeUpdate("CREATE TABLE " + dbTableName + table);
	    }
	    catch (SQLException e) { e.printStackTrace(); }
		
	}
	
	public String getInsertValueStr(PasswordInfo data) {
	    String fmt = "'%s', '%s', '%s'";
	    String q = String.format(fmt, data.getKey(), data.getId(), data.getPassword());
		return q;
	}
	
	public Statement getStatement() {
		return statement;
	}
	
	public PasswordInfo getNewData(ResultSet rs) {	
		PasswordInfo p = null;
		if(rs != null) {
			try {
				return new PasswordInfo(rs.getString("url"),
						rs.getString("id"), rs.getString("password"));
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;		
	}
	public String getKeyColumnName() {   //자식에서 key설정
		return "url";
	}
	
	public String getUpdateValueStr(PasswordInfo data) {
		  String fmt = "id = '%s', password = '%s'";
          String q = String.format(fmt,data.getId(), data.getPassword());
          return q;
	}
}
