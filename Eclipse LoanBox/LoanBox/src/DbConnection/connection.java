package DbConnection;

import java.sql.*;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;

import DbConnection.dbConfig;
import DbConnection.DataQuery;

public class connection {

	
	
	private static Connection connection;
	   private static Statement statement;
	   private static ResultSet rs;

	    //@Before
	    public static void ConnectDB() {
	            
	            connection = null;
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	                System.out.println("Connecting to Database...");
	                connection = DriverManager.getConnection(dbConfig.databaseURL, dbConfig.user, dbConfig.password);
	                if (connection != null) {
	                    System.out.println("Connected to the Database...");
	                }
	            } catch (SQLException ex) {
	               ex.printStackTrace();
	            }
	            catch (ClassNotFoundException ex) {
	               ex.printStackTrace();
	            }
	    }
        
	   
	    public static int id = 0;
	    public static String apikey = null;
	   // @Test
	    public static void getEmployeeData() {
	        try {
	            String query = DataQuery.Get_ApiLog;
	            statement = connection.createStatement();
	            rs = statement.executeQuery(query);

	            while(rs.next()){
	            	id= rs.getInt("id");
	                apikey= rs.getString("apikey");
	                System.out.println(id +"-----------,-------" + apikey);
	               /* String EmpAddress=rs.getString(3);
	                String EmpDept=rs.getString("EmpDept");
	                Double EmpSal= rs.getDouble(5);
	                System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);*/
	            }
	        } catch (SQLException ex) {
	           ex.printStackTrace();
	        }
	    }

	   // @After
	    public static void CloseConnection() {
	      if (connection != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	      }
	
	
}
