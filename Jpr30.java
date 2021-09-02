package com.Training;


class AgeException extends Exception{
	AgeException(String str)
	{
		//calling the constructor of parent Exception
		super(str);
	}
}
public class Jpr30 {

	//main method 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			//calling the method 
			validate(16);
			
		}
		catch(AgeException e) {
			//printing the message from AgeException Object
			System.out.println("Exception Occured: "+e);
		}

	}
	
	//method to check age
	static void validate(int age)throws AgeException
	{
		if (age<18)
		{
			//throw an object of user defined exception 
			throw new  AgeException("you are not eligible for vote");
		}
		else
		{
			System.out.println("you are  eligible for vote");
		}
	}

}

