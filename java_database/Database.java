package java_database;
import java.sql.*;

public class Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create database
		 try{
	            Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");//create connection

	            Statement stmt=con.createStatement();//create statement 
	           String rs="create database my_DB";//create database query
	            stmt.executeUpdate(rs);//execute query
	            System.out.println("Database created successfully...");
	            con.close();//close connection
	        }
	        catch(Exception exp)
	        { System.out.println(exp);
	        }
	}

}
