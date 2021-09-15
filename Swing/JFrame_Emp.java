package swingGUI;
import javax.swing.*;
import java.awt.*;

public class JFrame_Emp {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  Emp_Joining();//create instance of class
	}

}

class Emp_Joining extends JFrame{
	
	 JLabel l, name,email,mob,address,Edu_details,DOB,gender,Degree;
	 JTextField nm,em,pho;
	 JTextArea add;
	 JRadioButton male,female;
	 JComboBox date,month,year,degree;
	 JButton submit;
	 
	 
	 Emp_Joining(){
		 
	//JLabels  
		 
	 l=new JLabel("Employee Joining Form");
     l.setBounds(130,25,200,50);
	 add(l);
	 name=new JLabel("Name:");
	 name.setBounds(10,90,100,40);
     add(name);
     email=new JLabel("Email:");
	 email.setBounds(10,140,100,40);
     add(email);
     mob=new JLabel("Contact No.:");
	 mob.setBounds(10,190,100,40);
     add(mob);
     DOB=new JLabel("Date of Birth:");
	 DOB.setBounds(10,240,100,40);
     add(DOB);
     address=new JLabel("Address:");
	 address.setBounds(10,290,100,40);
     add(address);
     Degree=new JLabel("Degree:");
     Degree.setBounds(10,350,200,40);
     add(Degree);
     gender=new JLabel("Gender:");
     gender.setBounds(10,390,100,40);
     add(gender);
     
     //JTextFields
     
     nm=new JTextField();
     nm.setBounds(100,100,190,25);
     add(nm);
     em=new JTextField();
     em.setBounds(100,150,190,25);
     add(em);
     pho=new JTextField();
     pho.setBounds(100,200,190,25);
     add(pho);
     
     //JTextArea 
     add=new JTextArea();
     add.setBounds(100,290,190,60);
     add(add);
     
     //JRadioButton
     male=new JRadioButton("Male");
     male.setBounds(100,390,70,40);
     add(male);
     female=new JRadioButton("Female");
     female.setBounds(170,390,110,40);
     add(female);
     
     //JComboBox
     String dates[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"
    		 ,"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"
     };
     String months[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sup","Oct","Nov","Dec"
    	 
     };
     String Years[]= {"1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989"
    		 ,"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"
     };
     
     
     date=new JComboBox(dates);
     date.setBounds(100,250,60,20);
     month=new JComboBox(months);
     month.setBounds(160,250,60,20);
     year=new JComboBox(Years);
     year.setBounds(220,250,60,20);
     add(date);
     add(month);
     add(year);
     String deg []= {"BTech","BE","MTech","ME"
     };
     
     degree=new JComboBox(deg);
     degree.setBounds(100,360,130,20);
     add(degree);
     
     //JButton
     submit = new JButton("Submit");
     submit.setBounds(130,450,100,30);
     add(submit); 
     
        
	 setLayout(null);//set Layout of Frame
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(400,600);//set size of Frame
	 setVisible(true);//set visibility of frame
	 
	  
	}//end main
}//end class