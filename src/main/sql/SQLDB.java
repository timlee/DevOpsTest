package main.sql;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class SQLDB {

	    private static final String DB_DRIVER = "org.h2.Driver";
	    private static final String DB_CONNECTION = "jdbc:h2:mem:secure;DB_CLOSE_DELAY=-1";
	    private static final String DB_USER = "";
	    private static final String DB_PASSWORD = "";

	    private static final String TEST_USER = "HelloSecure";
	    private static final String TEST_PASS = "1234";
	    
	    
	    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
	        Class.forName(DB_DRIVER);
	        Connection dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	        return dbConnection;
	    }

	    public void createTable() throws SQLException, ClassNotFoundException {
	        Connection conn = getDBConnection();
	        Statement stmt = conn.createStatement();
	        stmt.execute("CREATE TABLE USER(userName varchar(255), password varchar(255))");    
	        stmt.close();
	        conn.commit();
	        conn.close();
	    }
	    
	    public void addUser() throws ClassNotFoundException, SQLException {
	        Connection conn = getDBConnection();
	        Statement stmt = conn.createStatement();
	        stmt.execute("INSERT INTO USER(userName, password) VALUES ('"+TEST_USER+"', '"+TEST_PASS+"')");        
	        stmt.close();
	        conn.commit();
	        conn.close();
	    }
	    
	    public boolean isValidUser(String userName, String pass) throws ClassNotFoundException, SQLException {
	        Connection conn = getDBConnection();
	        Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE userName='"+userName+"' AND password='"+pass+"'");
	        boolean valid = false;
	        if(rs.next()) {
	            valid = true;
	        }
	        rs.close();
	        stmt.close();
	        conn.commit();
	        conn.close();
	        return valid;
	    }


	}
