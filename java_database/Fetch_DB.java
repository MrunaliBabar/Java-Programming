package java_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fetch_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");//create connection
	          Statement s=con.createStatement();//create statement
	          ResultSet rs =s.executeQuery("select * from Student");//select all database from student table
	          while(rs.next()) {
	          System.out.println(rs.getInt(1)+ ""+rs.getString(2));
	          }
	          con.close();//close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	}

}
