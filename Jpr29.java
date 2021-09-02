package com.Training;

public class Jpr29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a=100/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception Occured:"+e);
			System.out.println("can not divide by zero");
		}
		

	}

}

