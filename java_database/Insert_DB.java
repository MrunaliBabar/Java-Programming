package java_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Insert_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insert into table
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_DB","root","");//create connection
	          Statement s=con.createStatement();//create statement 
	          PreparedStatement pst=con.prepareStatement("insert into Student Values(?,?)");//insert into table query
	          pst.setInt(1, 101);
	          pst.setString(2, "Manali");
	          pst.executeUpdate();//execute query
	          System.out.println("data inserted successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	}

}
