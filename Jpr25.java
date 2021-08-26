package com.Training;

public class Jpr25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arithmetic a= new result();
		a.add();
		a.sub();
		a.mul();
		a.div();
	}//end main
	
}//end class

 abstract class arithmetic
{
	 int a=90;
	 int b=80;
	 //abstract methods
	public abstract void add();
	public abstract void sub();
	public abstract void mul();
	public abstract  void div();
}// end arithmetic 

 //class result extends arithmetic class
class result extends arithmetic
{
	public void add()
	{
	 System.out.println("Addition is "+(a+b));
	}
	public void sub()
	{
		
		 System.out.println("Substraction is "+(a-b));
	}
	public void mul()
	{
		
		 System.out.println("Multiplication is "+(a*b));
	}
	public void div()
	{
		
		 System.out.println("Division is "+(a/b));
	}
	
}

 