/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Author: Manali & Mrunali 
 * code to create database using jdbc
 */
public class Stationary_db {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
	            Class.forName("com.mysql.cj.jdbc.Driver"); //register driver class
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");//create connection
                Statement stmt=con.createStatement();//create statement 
	            String rs="create database stationary_db";//create database query
	            stmt.executeUpdate(rs);//execute query
	            System.out.println("Database created successfully");
	            con.close();//close connection
	        }
	        catch(Exception e)
	        { 
	        	e.printStackTrace();
	        }

	}

}
