/**
 * 
 */
package database;

import java.sql.Connection;
import product_invoice.DB_Connection;
/**
 * @author Manali & Mrunali
 *
 */
public class Invoice_details extends DB_Connection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Connection con =getConnection();//accessing database connection from DB_Connection class
	          String query="create table Invoice_details(Product_ID int ,Product_Name varchar(50) ,Product_Price int,Quantity int) ";//create table query
	          p=con.prepareStatement(query);
	          p.executeUpdate();//execute query
	          System.out.println("Table created Successfully");
	          con.close();  //close connection
	        }catch(Exception e){
	          e.printStackTrace();
	}

}
}
