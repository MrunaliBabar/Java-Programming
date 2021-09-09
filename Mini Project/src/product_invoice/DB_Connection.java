package product_invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DB_Connection {

	public static Connection con=null;
	public static PreparedStatement p=null; 
	public static Statement s=null;
	 
	    public static Connection getConnection(){
	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
		         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stationary_db","root","");
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	        return con;

	}

}
