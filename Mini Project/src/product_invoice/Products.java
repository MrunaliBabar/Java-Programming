/**
 * 
 */
package product_invoice;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;



/**
 * Author: Manali & Mrunali 
 * code to insert product list into Product_details
 */

public class Products extends DB_Connection { 
	
	// this method is created for adding product with price in product_details
	public static  void add_Products() {
		 try {
			 
			 Connection con =getConnection();//accessing database connection from DB_Connection class
         
             String Query="insert into Product_details(Product_Name,Product_Price) Values (?,?)";//insert the product entered by admin
              p=con.prepareStatement(Query);
         
             //Add product name in Product_details table from admin
             System.out.println("Enter Product Name");
             Scanner scanner=new Scanner(System.in);
             p.setString(1, scanner.nextLine());//inserting product name 
         
             //Add Product Price in Product_details table from admin
              System.out.println("Enter Product Price");
              p.setInt(2, scanner.nextInt());//inserting product price
           
              
             //Execute query
             p.executeUpdate();
          
              System.out.println("Product added Successfully...");
              con.close();
		 } //end try
		 
		
		 catch(Exception e) {
			 e.printStackTrace();
		 }//end catch
		 
	 }//end add_Products()
	
	
	 
	 //This method is created for showing product list
	public static void show_ProductList() {
		 
		
		try{
			 Connection con =getConnection();//accessing database connection from DB_Connection class
		          
			      s=con.createStatement();//create Statement
		          String q="select*from Product_details";//fetch data from Product_details
		          ResultSet rs =s.executeQuery(q);//execute query
		          
		          //Displays Column Names
		          System.out.println("-----------------------------------------------------------");
		          System.out.printf("%-15s%-30s%-15s\n","Product_ID","Product_Name","Product_Price");
		          System.out.println("-----------------------------------------------------------");
		          
		          
		          //retrieve data from Product_details table and display it
		          while(rs.next()) {
		        	  System.out.printf("%-15s%-30s%-15s\n",rs.getInt("Product_ID"),rs.getString("Product_Name"),rs.getInt("Product_Price"));
		          }
		          System.out.println("-----------------------------------------------------------");
		          con.close();//close connection 
		        }//end try
		catch(Exception e){
		          e.printStackTrace();
		        }//end catch
			
	}//end show_ProductList()

}//end class
