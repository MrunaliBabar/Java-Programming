/**
 * 
 */
package swingGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Manali & Mrunali
 * code to create puzzle game
 */
public class PuzzleGame implements ActionListener {
	
	JFrame f =new JFrame();
	JButton[] puzzle=new JButton[9];
	JLabel l1;
	JLabel Msg=new JLabel();
    int a[][]={{0,0,0},{0,0,0},{0,0,0}};
	

	PuzzleGame()
	{
		//labels
		
		l1=new JLabel("Puzzle  Game");
		l1.setBounds(200,20,100,30);
		f.add(l1);
		Msg.setBounds(100,450,100,50);
		f.add(Msg);	
		 
		//JPanel
		JPanel p= new JPanel();
		p.setLayout(new GridLayout(3, 3));//set GridLayout
		
		//adding 9 Buttons on JPanel
	    	for(int i=0;i<9;i++) {
	    		puzzle[i]=new JButton();
	    		p.setBounds(100, 100, 60, 60);
	    		p.setSize(300,300);
	    		p.add(puzzle[i]);
	    		puzzle[i].addActionListener(this);
	    	}	
	    	//setText to Buttons
	    	puzzle[0].setText("1");
	    	puzzle[1].setText("2");
	    	puzzle[2].setText("3");
	    	puzzle[3].setText("4");
	    	puzzle[4].setText("5");
	    	puzzle[5].setText("6");
	    	puzzle[6].setText("7");
	    	puzzle[7].setText("8");
	    	puzzle[8].setText("9");
		 
	   
	     f.add(p);//add JPanel on Frame
	     f.setLayout(null);//set Layout of Frame
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 f.setSize(800,800);//set size of Frame
		 f.setVisible(true);//set visibility of frame
	}
	
	public void actionPerformed(ActionEvent e) {
		//CYAN color
		if(e.getSource()==puzzle[4])
		{
			a[1][1]=1;
			puzzle[4].setBackground(Color.CYAN);
			
		}
		if(e.getSource()==puzzle[0])
		{

			a[0][0]=1;
			puzzle[0].setBackground(Color.CYAN);
		}
		if(e.getSource()==puzzle[6])
		{
			a[2][0]=1;
			puzzle[6].setBackground(Color.CYAN);
		}
		
		
	  //PINK COLOR
		if(e.getSource()==puzzle[1])
		{
			a[0][1]=1;
			puzzle[1].setBackground(Color.PINK);
		}
		if(e.getSource()==puzzle[5])
		{
			a[1][2]=1;
			puzzle[5].setBackground(Color.PINK);
		}
		if(e.getSource()==puzzle[2])
		{
			a[0][2]=1;
			puzzle[2].setBackground(Color.PINK);
		}
	  
		//Yellow Color
		if(e.getSource()==puzzle[3])
		{
			a[1][0]=1;
			puzzle[3].setBackground(Color.yellow);
		}
		if(e.getSource()==puzzle[7])
		{
			a[2][1]=1;
			puzzle[7].setBackground(Color.yellow);
		}
		if(e.getSource()==puzzle[8])
		{
			a[2][2]=1;
			puzzle[8].setBackground(Color.yellow);
		}
		check();

	}
	//check if colors are matched
		void check()
		{
			if(a[1][1]!=0 && a[0][0]!=0 && a[2][0]!=0){
	            Msg.setText("Congratulations!!!!!");//CYAN wins

	        }
	        if(a[0][1]!=0 && a[1][2]!=0 && a[0][2]!=0){
	            Msg.setText("Congratulations!!!!");//Pink wins

	        }
        if(a[1][0]!=0 && a[2][1]!=0 && a[2][2]!=0){	     
	            Msg.setText("Congratulations!!!!");//Yellow wins
        }

		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new PuzzleGame();//create instance of PuzzleGame
	}

}
