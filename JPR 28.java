package modifi;

import modifi.defaultAcc.Test;//import Test class
import modifi.privateAcc.Test3;//import Test3 class
import modifi.publicAcc.Test4;//import Test4 class
import modifi.protectAcc.Test2;//import Test2 class



public class Modifi1 extends Test2{

	void supermethod()
	{   //protected members or fields accessible by inheritance outside the package
		super.a=30; //Accessing protected member of class Test2 using super 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create object of class test which have all methods and fields default
		Test t =new Test();
		//t.Multiplication(); Error: default not accessible outside the package 
		
		//Create object of class test3 which have all methods and fields private 
		Test3 t3 =new Test3();
		//t3.addition(); Error : not Accessible outside package
		
		
		//Create object of class Test2 which have all methods and fields  protected 
		Test2 t2=new Test2();
		//t2.a=20;//Protected members not accessible outside package without using super 
		
		
       //Create object of class Test4 which have all methods and fields  public
		//public is Accessible anywhere
		Test4 t4=new Test4();
		t4.division();
	
	}

}
/*
 * private is accessible only inside that class
 * default is accessible inside same class and same package
 * protected is accessible inside same class same package and subclass of other package 
 * public is accessible anywhere
 */
