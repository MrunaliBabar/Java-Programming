package com.Training;

public class Jpr23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st=new Student();
		Student st1=new Student("Mrunali","TYCO","C","22/8/2021","Sangola","mrunali@gmail.com",9658741203l);
		st1.admit();//admit student
		st1.changeAdd("pandhrpur");//change address
		st1.changeEmail("manali@gmail.com"); //change email
		st1.changeMob(8541569874l);//change Mobile number
	}

}
class Student{

	  String name;
	  String cls;
	  String div;
	  String admdate;
	  String address;
	  String email;
	  long mobile;
	  //default constructor
	  Student()
	  {
		  System.out.println("Default constructor...");
	  }
	  //constructor overloading
	  Student(String name,String cls,String div)
	  {
		 this.name=name;
		 this.cls=cls;
		 this.div=div;
		 
	  }
	  Student(String name,String cls,String div,String admdate)
	  {
		 this.name=name;
		 this.cls=cls;
		 this.div=div;
		 this.admdate=admdate;
		 
	  }
	  Student(String name,String cls,String div,String admdate,String address)
	  {
		 this.name=name;
		 this.cls=cls;
		 this.div=div;
		 this.admdate=admdate;
		 this.address=address;
		 
		 
	  }
	  Student(String name,String cls,String div,String admdate,String address,String email)
	  {
		 this.name=name;
		 this.cls=cls;
		 this.div=div;
		 this.admdate=admdate;
		 this.address=address;
		 this.email=email;
		 
		 
	  }
	  Student(String name,String cls,String div,String admdate,String address,String email,long mobile)
	  {
		 this.name=name;
		 this.cls=cls;
		 this.div=div;
		 this.admdate=admdate;
		 this.address=address;
		 this.email=email;
		 this.mobile=mobile;
		 
		 
	  } 
	  
	  void admit()
	  {
		  System.out.println("You are admited in Shivaji polytechnic college");
		  System.out.println("Name of student is "+name);
		  System.out.println("Class of student is "+cls);
		  System.out.println("Mobile number of student is "+mobile);
		  System.out.println("Email of student is "+email);
		  System.out.println("Address of student is "+address);
		  System.out.println("Admission of student is "+admdate);
	  }
	  void terminate()
	  {
		  System.out.println("You are terminated from Shivaji polytechnic college ");
		  
	  }
	  void changeDiv(String d)
	  {
		  div=d;
		  System.out.println("Your changed division is "+div);
		  
	  }
	  
	  void changeEmail(String e)
	  {
		  email=e;
		  System.out.println("Your changed Email is "+email);
		  
	  }
	  void changeAdd(String a)
	  {
		  address=a;
		  System.out.println("Your changed Address is "+address);
		  
	  }
	  void changeMob(long mob)
	  {
		  mobile=mob;
		  System.out.println("Your changed Mobile Number is "+mobile);
		  
	  }

   
   
}

