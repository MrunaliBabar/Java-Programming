/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Mohan babar
 */
public class DB_Connection {
    public static Connection con=null;
    public static PreparedStatement pst=null;
    public  static Statement stmt=null;
    public static Connection getConnection(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_db","root","");
        }catch(Exception e){
          e.printStackTrace();
        }
        return con;
    }

}
