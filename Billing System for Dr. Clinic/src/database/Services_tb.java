/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;

/**
 *
 * @author Mohan babar
 */
public class Services_tb extends DB_Connection {
    
     public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		Connection con =getConnection();//accessing database connection from DB_Connection class
			
	          String query="create table Services(Sr_No int NOT NULL PRIMARY KEY AUTO_INCREMENT,Service_ID int Unique Key ,Service_Name varchar(50),Price int(200))";//create table query
	          pst=con.prepareStatement(query);
	          pst.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	

	}
}
