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
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	          Statement s=con.createStatement();
	          ResultSet rs =s.executeQuery("insert into Student Values(?,?)");
	          while(rs.next()) {
	          System.out.println(rs.getInt(1)+ ""+rs.getString(2)+""+rs.getString(3));
	          }
	          
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	}

}
