/**
 * 
 */
package product_invoice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * @author Manali & Mrunali
 *
 */
public class Invoice extends DB_Connection {

	//This method is used to insert invoice details in Invoice_details for generating bill
	public static void generate_bill()
	{
		try {
			
			 Connection con =getConnection();//accessing database connection from DB_Connection class
		
              System.out.println("Choose Product ID of product From list which you want to buy ");
		      Scanner sc=new Scanner(System.in);
		      int id=sc.nextInt();//accepting the product id from the user
		
		      System.out.println("Enter Quantity");
		      int quan=sc.nextInt();//accepting quantity from the user
		    
	
		     //selecting details from Product_details to insert it into Invoice_details
        	  String qr="select Product_ID, Product_Name,Product_Price from Product_details where Product_ID="+id+";";
        	  s=con.createStatement();
        	  ResultSet r =s.executeQuery(qr);
        	
              Boolean check=(r.next()); //true if data selected
              
           //check id entered by the user is valid or not 
           if(check==true) {
        	   
             String sql="insert into Invoice_details(Product_ID,Product_Name,Product_Price,Quantity) Values (?,?,?,?)";
             p=con.prepareStatement(sql);//insert into table query 
        	
             p.setInt(1,r.getInt("Product_ID"));//Fetch the Product_ID from Product_details and insert it into parameter 1
             p.setString(2,r.getString("Product_Name"));//Fetch the Product_Name from Product_details and insert it into parameter 2
             p.setInt(3,r.getInt("Product_Price"));//Fetch the Product_Price from Product_details and insert it into parameter 3
             p.setInt(4,quan);//insert quantity entered by user into parameter 4
             p.executeUpdate();//execute query
        	
        	System.out.println("Your Product is added in Your bill Please check the bill");
        	System.out.println("");
		}
		else {
			System.out.println("Invalid choice.. Please choose correct Product_id from List");
		}
		}//end try
		catch (Exception e) {
			e.printStackTrace();
		}//end catch
	}//end generate_bill()
	
	
	static public void Show_bill()
	{
	
		try {
			
			 Connection con =getConnection();//accessing database connection from DB_Connection class
				
	        
	          s=con.createStatement();//create Statement
	          String que="select count(*) from Invoice_details";//count the No. of rows of Invoice_details
	          ResultSet rest =s.executeQuery(que);
	          rest.next();
	          int count=rest.getInt(1);//return the count
	          
	          //checks at least one product is selected or not
	          if(count>0) {
	          
	          s=con.createStatement();//create Statement
	          String q="select Product_ID,Product_Name,Quantity,Product_Price,(Quantity*Product_Price)as Total from Invoice_details";
	          ResultSet rs =s.executeQuery(q);
	           
	          System.out.println("********************************************************************************************");
	          
	          System.out.println("                                         Invoice Receipt");
	          System.out.println("  ");
	          System.out.println("Shop Name: All In One Stationary                                     Invoice ID:#579896    ");
	          System.out.println("Email Id:allinone1050@gmail.com                                      Contact No.9867546734");
	          System.out.println("  ");
	          
	          //Displays all the data from the table
	          System.out.println("-------------------------------------------------------------------------------------------");
	          System.out.printf("%-15s%-30s%-15s%-20s%8s\n","Product_ID","Product_Name","Quantity","Product_Price","Total");
	          System.out.println("-------------------------------------------------------------------------------------------");
	          
	          while(rs.next()) {
	        
	        	  System.out.printf("%-15s%-30s%-15s%s%-20s%s%-10s\n",rs.getInt("Product_ID"),rs.getString("Product_Name"),rs.getInt("Quantity"),"Rs.",rs.getInt("Product_Price"),"Rs.",rs.getInt("Total"));
	          }
	          System.out.println("-------------------------------------------------------------------------------------------");
	         
	          //here we calculate the total amount
	          int sum=0;
	          Statement stmt=con.createStatement();//create Statement
	          
	          //here we are selecting the sum of (Quantity*Product_Price) i.e total
	          String Sub_Total="select sum(Quantity*Product_Price) as Total from Invoice_details ";
	          ResultSet set =stmt.executeQuery(Sub_Total);
	          
	          //to add all the row of Total column
	           while(set.next()) {
	        	  int Total_price=set.getInt(1);
	        	  sum=sum+Total_price;
	           }
	           
	           //Calculate Gst 
	        	  float gst;
	        	  
	           //here we display the sub total gst and total amount on invoice bill
	        	  System.out.println("");
	        	  System.out.println("\t\t\t\t\t\t\t\t\t Sub Total:Rs."+sum);
	        	 
	        	  gst=sum*(12.0f/100);
	        	  System.out.println("\t\t\t\t\t\t\t\t\t Gst(12%) :Rs."+gst);
	        	  System.out.println("\t\t\t\t\t\t\t\t     ----------------------");
	        	  System.out.println("\t\t\t\t\t\t\t\t      Total Amount:Rs."+(gst+sum));
	        	  System.out.println("");
	        	  System.out.println("--------------------------------------------------------------------------------------------");
	        	  System.out.println("");
	        	  System.out.println("                         Thanks for shopping visit again ");
	        	  System.out.println("*********************************************************************************************");
	           
	          
	         }//end if
	         else {
	        	 System.out.println("You Haven't purchased any items yet");
	         }
	           con.close();//close connection 
		          
	        }//end try
	
		catch (Exception e) {
			e.printStackTrace();
		}//end Show_bill()
}

}//end class

