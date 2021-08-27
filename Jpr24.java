package com.Training;

public class Jpr24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Design d= new Design();
		d.Team();
		
		Development d1= new Development();
		d1.Team();
		
		Account a=new Account();
		a.Team();
		
	        Sales s=new Sales();
	        s.Team();
	    
	        testing t=new testing();
	        t.Team();
	    
	}

}
//Super class Company

class Company
{
	String Product="Calculator";
	int Teamcount;
	String TleaderName;
	
	void AssignProject()
	{
		System.out.println("Our Product is "+Product);
	}
}
/* single inheritance 
 * super class Company
 * child class Design
 */

class Design extends Company
{
	String TleaderName="Ajay";
	void Team()
	{
		
		Teamcount=100;
		AssignProject();
		System.out.println("Team leader of department Design is "+TleaderName);
	}
	
}
/* hierarchical inheritance 
 * super class Company
 * child class Development
 */
class Development extends Company 
{
	String TleaderName="Vijay";
	void Team()
	{
		
		Teamcount=100;
		AssignProject();
		System.out.println("Team leader of department Development is "+TleaderName);
	}
	
	
	
}
/* Multilevel inheritance 
 * first super class Company
 * second super class Development
 * child class Account
 */

class Account extends Development
{
	String TleaderName="Arun";
	void Team()
	{
		
		Teamcount=100;
		AssignProject();
		System.out.println("Team leader of department Account is "+TleaderName);
	}
	
	
}
/* single inheritance 
 * super class Company
 * child class sales
 */
class Sales extends Company 
{
	String TleaderName="Varun";
	void Team()
	{
		
		Teamcount=100;
		AssignProject();
		System.out.println("Team leader of department Sales is "+TleaderName);
	}
	
}
/* Multilevel inheritance 
 * first super class Company
 * second super class Sales
 * child class testing
 */
class testing  extends Sales
{
	String TleaderName="Neha";
	void Team()
	{
		
		Teamcount=100;
		AssignProject();
		System.out.println("Team leader of department Testing is "+TleaderName);
	}
	
}
