/**
 * 
 */
package database;

import java.sql.Connection;
import product_invoice.DB_Connection;


/**
 * Author: Manali & Mrunali 
 * code to create table for product details
 */
public class Product_details extends DB_Connection {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Connection con =getConnection();//accessing database connection from DB_Connection class
			
	          String query="create table Product_details(Product_ID int PRIMARY key not null AUTO_INCREMENT , Product_Name varchar(50) , Product_Price int) ";//create table query
	          p=con.prepareStatement(query);
	          p.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	

	}

}
