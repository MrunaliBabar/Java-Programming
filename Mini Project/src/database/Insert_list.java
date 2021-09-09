/**
 * 
 */
package database;

import java.sql.Connection;
import product_invoice.DB_Connection;
/**
 * Author: Manali & Mrunali 
 * code to insert product list into Product_details
 */
public class Insert_list extends DB_Connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			 Connection con =getConnection();//accessing database connection from DB_Connection class
	          //insert Product_Name into array Name
	          String [] Name =new String[] {"Scissors","Oil pastels","Starter Sketch Book A4","A3 Zipper Bag","Pencil HB","Small Glue Stick","A4 Folder Clipboard","Compass Box","Highlighter pen(pack of 4) ","Calculator"};
	          //insert Product_Price into array Price
	          Integer [] price =new  Integer[] {86,203,100,30,10,25,92,90,71,700};
	          String sql="insert into Product_details(Product_Name,Product_Price) Values (?,?)";
	          p=con.prepareStatement(sql);//insert into table query 
	          //Inserting Multiple rows in table
	          for(int i=0;i<10;i++) {
	          p.setString(1,Name[i]);
	          p.setInt(2,price[i]);
	          p.executeUpdate();//execute query
	          }
	          System.out.println("data inserted successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	        }

	}

}
