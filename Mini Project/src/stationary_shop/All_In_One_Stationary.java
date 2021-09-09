/**
 * 
 */
package stationary_shop;
import java.util.*;
import product_invoice.*;

/**
 * @author Manali & Mrunali 
 *
 */
public class All_In_One_Stationary {
	//Declaration of variable 
	static int input=0;//to store the choice
	static String pwd=null;//to store the admin password
	static String p=null;//to store continue choice of user
 
	public static void main(String[] args) {
		
			//choice to select admin or user
			System.out.println("1.Admin\n2.User\n3.Exit");
			System.out.println("Enter your choice");
			
			//taking input 
			Scanner sc=new Scanner(System.in);
			 input=sc.nextInt();
			 
		//switch Statement
         switch(input)
		     {
		     //executes when input is 1 
		     case 1:   
		    	
		    	  System.out.println("Enter Password");
		    	  Scanner s=new Scanner(System.in);
		    	  pwd=s.nextLine();//Accepting password
		    	
		    	  //checking authentication of admin
		    	  if(pwd.equals("@1234"))
		    	  {
		    		
		    		  while(true){
		    			
		    		  System.out.println("1.Show Product List\n2.Add Products\n3.Exit");
		    		  System.out.println("Enter choice");
		    		  int ch=sc.nextInt();
		    		  //Switch statement 
		    		switch(ch)
		    		  {
		    		  //executes when admin enters 1 
		    		   case 1:
		    			//method of Products class
		    			Products.show_ProductList();//Call Method to show Products
		    			   break;
		    		    case 2:
		    			//method of Product class
		    			Products.add_Products();//call Method to Add products
		    			   break;
		    			//executes when none of the case is true
		    		    case 3:
		    			System.out.println("Thank you");
		    			System.exit(0);
		    			    break;
		    		    default:
		    			 System.out.println("Invalid choice");	 
		    		  }//end inner switch
		    		
		    	   }//end while
		 	  
			        
		          }//end outer if
		    	
		      else {
		    		System.out.println("Invalid Password...");
		    	 }
		    	  
		    break;//end case1
		    	 
		    	 //executes when input 2
		    case 2:
		    	 System.out.println("*********************************************************************");
	    		 System.out.println("                Welcome to All In One Stationary  ");
	    		 System.out.println("*********************************************************************");
	    		 System.out.println("");
		    	 while(true){
		    	    
		    	 System.out.println("1.Show Product List\n2.Show Bill\n3.Exit");
		    	 System.out.println("Enter choice");
		    	 int choice=sc.nextInt();//to accept the user choice
		    	 
		    	  switch(choice)
		    		  {
		    		//executes when User enters 1 
		    		 case 1:
		    			//method of product class
		    			Products.show_ProductList();//Call Method to show Products
		    			//methods of invoice class
		    			Invoice.generate_bill();//Call method to genetare the User bill
		    			break;
		    		 case 2:
		    			//method of invoice class
		    			Invoice.Show_bill();//call Method to show bill to user
		    			break;
		    		 case 3:
		    			System.out.println("Thank you");
		    			System.exit(0);
		    			break;
		    			//executes when none of the case is true
		    		 default:
		    			 System.out.println("Invalid choice");	 
		    		}//end inner switch
		    	 }
		    	 
		   case 3:
		    	 System.exit(0);
		    	 break;
		    	 
		     default:
		    	 System.out.println("Invalid choice");	 
 
		     }
				
	
	}//end main
	
	
}//end class
