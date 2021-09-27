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
public class GenerateBill_tb extends DB_Connection{
      public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		Connection con =getConnection();//accessing database connection from DB_Connection class
			
	          String query="create table Bill_details(Bill_No int NOT NULL PRIMARY KEY AUTO_INCREMENT ,Bill_Date DATE ,Bill_Type varchar(50),OPD_Type varchar(50),OPD_NO int(50),Patient_Name varchar(50),PRegNo int(50),Services varchar(100),Service_Amount float(50),Quantity int(50),DisType varchar(20),Discount float(50),Total_Amount float(50),PayMode varchar(50))";//create table query
	          pst=con.prepareStatement(query);
	          pst.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	

	}
}
