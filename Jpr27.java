package com.Training;

public class Jpr27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Robot Rb=new Robot();
       Buy b=new Buy();
       b.disp();
       Rb. Robo_type1_fun();
       Rb. Robo_type2_fun();
       Rb. Robo_type3_fun();
       Rb. Robo_type4_fun();
       Rb.Price();
		
	}//end main

}//end Jpr27

/*Multilevel inheritance 
 *  First_interface->Second_interface->Third_interface
 */
interface First_interface
{
	String Robo_type1="Industrial Robot";
	String Robo_type2="Domestic Robot";
	String Robo_type3="Medical Robot";
	String Robo_type4="Service Robot";
	
	
}//end First_interface 



interface Second_interface extends First_interface
{
	//This is a Empty interface known as Marker or tagged interface
}//end Second_interface 


/*
 * Multiple inheritance
 * Super classes=Second_interface,First_interface
 * child class=Third_interface
 */

interface Third_interface extends Second_interface,First_interface
{
	
	void Robo_type1_fun();
	void Robo_type2_fun();
	void Robo_type3_fun();
	void Robo_type4_fun();
	
	
}//end  Third_interface 



class Robot implements Third_interface
{
	
	final int cost; //final blank variable
	Robot()
	{
		cost=900000; // initialization of final blank variable
	}
	// Override all methods of Third_intetrface
	 public void Robo_type1_fun()
	{
		System.out.println("Function of "+Robo_type1+" is to manufactures of goods such as welding ,painting");
	}
	public void Robo_type2_fun()
	{
		System.out.println("Function of "+Robo_type2+" is to perform household chores");
	}
	public void Robo_type3_fun()
	{
		System.out.println("Function of "+Robo_type3+" is to perform very delicate medical procedures ");
	}
	public void Robo_type4_fun()
	{
		System.out.println("Function of "+Robo_type4+" is to perform various service related task");
	}
	
	final void Price()
	{
		System.out.println("Price of Robot is "+cost);
	}	
		
}//end Robot

class Buy extends Robot
{
	/* 
	 We cannot override the final method
	void Price()
	{
		System.out.println("Price of Robot is "+cost);
	}
	*/
	void disp()
	{
		System.out.println("Robots and there Functions :");
	}
	
}//end Buy
