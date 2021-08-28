package com.Training;

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Rectangle r = new Rectangle();
         r.Area();
         Triangle  t= new Triangle();
         t.Area();
         Circle c = new Circle();
         c.Area();
         Pentagon p = new Pentagon(10,6);
         p.Area();
         Hexagon h = new Hexagon();
         h.Area();
         Trapezium tr = new Trapezium(10,10,6);
         tr.Area();
         
	}

}

// creating interface
interface Calculate_Area
{
	final float width=5;
	final float height=10;
	void Area();
}

class Area
{
	static double pi=3.14;
	double area;
	double radius;
	

}

/*
Inheritance Rectangle ->Area
Implements Rectangle ->Calculate_Area
Area of rectangle =Width*height
 */
class Rectangle extends Area implements Calculate_Area
{
     //override interface method
	public void Area()
	{
		area=width*height;
		System.out.println("Area of Rectangle is "+area);
	}
}


/*
Inheritance Triangle ->Area
Implements Triangle ->Calculate_Area
Area of Triangle =base*height/2
*/
class Triangle extends Area implements Calculate_Area
{
	  //override interface method
	public void Area()
	{
		area=(width*height)/2;
		System.out.println("Area of Triangle is "+area);
		
	}
}


/*
Inheritance Circle->Area
Implements Circle ->Calculate_Area
Area of circle =pi*radius*radius
*/
class Circle extends Area implements Calculate_Area
{
	  //override interface method
	public void Area()
	{
		area=pi*radius*radius;
		System.out.println("Area of Circle is "+area);
		
	}
	
}


/*
Inheritance Pentagon->Area
Implements Pentagon ->Calculate_Area
Area of Pentagon=5/2*s*a
*/
class Pentagon extends Area implements Calculate_Area
{
	float s;// side of the pentagon
	float a; // apothem length
	Pentagon(float s, float a)
	{
		this.s=s;
		this.a=a;
	}
	  //override interface method
	public void Area()
	{
		
		area=(5.0/2.0)*s*a;
		System.out.println("Area of Pentagon is "+area);
	}
}


/*
Inheritance Hexagon->Area
Implements Hexagon ->Calculate_Area
Area of Hexagon = (3*sqrt(3)/2)*n*n
*/

class Hexagon extends Area implements Calculate_Area
{
	double n=6;//length of side
	  //override interface method
	public void Area()
	{
		area=((3*Math.sqrt(3)*(n*n))/2);
		System.out.println("Area of Hexagon is "+area);
		
	}
}


/*
Inheritance Trapezium->Area
Implements Trapezium ->Calculate_Area
Area of Trapezium=((side1+side2)*height)/2
*/
class Trapezium extends Area implements Calculate_Area
{
	double height;//height of Trapezium
	double side1;//length of parallel side
	double side2;//length of parallel side
	Trapezium(double height,double side1,double side2)
	{
		this.height=height;
		this.side1=side1;
		this.side2=side2;
	}
	  //override interface method
	public void Area()
	{
		area=((side1+side2)*height)/2;
		System.out.println("Area of Trapezium is "+area);
		
	}
	
}

/*
 * Output:-
Area of Rectangle is 50.0
Area of Triangle is 25.0
Area of Circle is 0.0
Area of Pentagon is 150.0
Area of Hexagon is 93.53074360871938
Area of Trapezium is 80.0
*/

