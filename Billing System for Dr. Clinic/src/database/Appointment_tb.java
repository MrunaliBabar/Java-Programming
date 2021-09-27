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
public class Appointment_tb extends DB_Connection{
    
      public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		Connection con =getConnection();//accessing database connection from DB_Connection class
			
	          String query="create table Appointment(Sr_No int  NOT NULL PRIMARY KEY AUTO_INCREMENT ,Appt_ID int Unique KEY ,PatientName varchar(50),Appt_Session varchar(100),Appt_Date DATE,Appt_OPD varchar(100),Message varchar(500))";//create table query
	          pst=con.prepareStatement(query);
	          pst.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }
	

	}
    
}
