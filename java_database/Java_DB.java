package java_database;
import java.sql.*;

public class Java_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create Table
		try{
	          Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_DB","root","");//create connection
	          Statement s=con.createStatement();//create statement 
	          String query="create table Student(student_id int(4),student_name varchar(100))";//create table query
	          PreparedStatement pst=con.prepareStatement(query);
	          pst.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	}

}
