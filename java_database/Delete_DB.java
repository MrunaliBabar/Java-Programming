package java_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Delete_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//delete database
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_DB","root","");//create connection
	          Statement s=con.createStatement();//create statement 
	          PreparedStatement pst=con.prepareStatement("Drop database my_DB");//Delete Database query
	          pst.executeUpdate();//execute query
	          System.out.println("Database Deleted successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	}

}
