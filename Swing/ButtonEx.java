package swingGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonEx implements ActionListener {
	
	JFrame f =new JFrame();
	JButton yes;
	JButton no;
	ButtonEx()
	{
		//Adding yes Button
		 yes = new JButton("Yes");
		 yes.setBounds(90,100,100,30);
	     f.add(yes); 
	     yes.addActionListener(this);
	     //adding No button
	     no = new JButton("No");
		 no.setBounds(230,100,100,30);
	     f.add(no); 
	     no.addActionListener(this);
	    
	     f.setLayout(null);//set Layout of Frame
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setSize(400,400);//set size of Frame
		 f.setVisible(true);//set visibility of frame
	}
	public void actionPerformed(ActionEvent e) {
		     // executes when yes button pressed
              if(e.getSource()==yes) {
			  yes.setText("No");
		      }
              // executes when no button pressed
              if(e.getSource()==no) {
      		  no.setText("Yes");
      		  }
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new ButtonEx();//create instance of ButtonEx
	}
	

}

