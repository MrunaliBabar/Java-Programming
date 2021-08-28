package com.Training;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          IDcard ID=new IDcard();
          ID.Emp_IDcard();
	}

}
abstract class Employee
{
	int id=2365;
	String name="Ajay";
	String department="IT";
	String company="IT Development Corporation";
	String Education="Btech IT";
	long mob=9651242328l;
	String email="ajay@gmail.com";
	 abstract public void Emp_IDcard();
	
}
 class IDcard extends  Employee
{
	public void Emp_IDcard()
	{
		System.out.println("*ID card Of Employee*");
		System.out.println("");
		System.out.println("Company Name:"+company);
		System.out.println("ID: "+id);
		System.out.println("Name : "+name);
		System.out.println("Dept: "+department);
		System.out.println("Education: "+Education);
		System.out.println("Mob No.: "+mob);
		System.out.println("Email: "+email);
			
	}
}
 /*
   Output 
  
  *ID card Of Employee*

Company Name:IT Development Corporation
ID: 2365
Name : Ajay
Dept: IT
Education: Btech IT
Mob No.: 9651242328
Email: ajay@gmail.com

   
  *
 */
 