package com.Training;

public class Jpr26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 myinterface m=new Demo();
		 m.add();
		 m.sub();
		 m.mul();
		 m.div();
	}

}
interface myinterface
{
	
	final int i=99;
	final int j=23;
	public void add();
	public void sub();
	public void mul();
	public void div();
	
	
}// end myinterface
// Demo class implements myinterface 

class Demo implements myinterface
{
	public void add()
	{
	 System.out.println("Addition is "+(i+j));
	}
	public void sub()
	{
		
		 System.out.println("Substraction is "+(i-j));
	}
	public void mul()
	{
		
		 System.out.println("Multiplication is "+(i*j));
	}
	public void div()
	{
		
		 System.out.println("Division is "+(i/j));
	}
	
}//end Demo
