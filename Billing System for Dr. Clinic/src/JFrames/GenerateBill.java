/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;


import static database.DB_Connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohan babar
 */
public class GenerateBill extends javax.swing.JFrame {

    /**
     * Creates new form GenerateBill
     */
     int lastNo;
   
    public GenerateBill() {
        initComponents();
    
        
     
      getBill_No();
        getPatient();
       getService();
    
      
      
    }

      //Method to get the Patient Name
    void getPatient()
    {
        try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
              stmt=con.createStatement();
              String query="select * from Patient";
              ResultSet r=stmt.executeQuery(query);
              while(r.next())
              {
                  String PatName=r.getString("Patient_Name");
                  Bpatient.addItem(PatName);//add patient name to JcomboBox
              }
        } catch (Exception e) {
        }
    }

   //Method to get the Service Name
    void getService()
    {
        try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
              stmt=con.createStatement();
              String query="select * from Services";
              ResultSet r=stmt.executeQuery(query);
              while(r.next())
              {
                 // String SName=r.getString("Service_Name");
                  Bservice.addItem(r.getString("Service_Name"));//add service name to JcomboBox
              }
        } catch (Exception e) {
        }
    }
   //Method to get the Service Name
    void getBill_No()
    {
       try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
              stmt=con.createStatement();
              String query="select Max(Bill_No) from Bill_details";
              ResultSet r=stmt.executeQuery(query);
             
             
              if( r.next())
              {
                  lastNo= r.getInt(1);
                  lastNo++;
                  billNo.setText(Integer.toString(lastNo));
              }
              
              
        } catch (Exception e) {
        }
    }  
    
    
     //To clear the TextFields
        void clearFiled()
        {
        billDate.setDate(null);
        billType.setSelectedItem("Choose");
       Pregno.setText("");
       OPD.setSelectedItem("Choose");
       OPDno.setText("");
       Bpatient.setSelectedItem("Select");
       Bservice.setSelectedItem("Choose"); 
       amount.setText("0");
       discount.setText("0");
       Grandtotal.setText("");
       payMode.setSelectedItem("Choose");
       quantity.setText("");
       disType.setSelectedItem("Choose");
       price.setText("");
        }
    
    
    
    
    
    
     //Method to Calculate Amount
    void CalculateAmounts()
    {
        try {
     double Price=Double.parseDouble(price.getText());
      double quan=Double.parseDouble(quantity.getText());
      double cal=Price*quan;
      // String  cal=String.valueOf(Price*quan);
       amount.setText(Double.toString(cal));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
       
    }  
    
    
    
   //Method to insert values into GenerateBill_tb 
   public void insertBillDetails()
    {
        //if the Patient Details are not filled up
        if(billNo.getText().isEmpty() || billDate.getDate()==null ||  billType.getSelectedIndex()==-1 || disType.getSelectedIndex()==-1 ||Bpatient.getSelectedIndex()==-1  ||Bservice.getSelectedIndex()==-1  ||price.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//set the date format 
                String date=sdf.format(billDate.getDate());//store in date from jdatechooser
                //insert Bill details into  Bill_details Table
               pst=con.prepareStatement("insert into Bill_details(Bill_No,Bill_Date ,Bill_Type,OPD_Type,OPD_NO ,Patient_Name,PRegNo,Services,Service_Amount,Quantity,DisType ,Discount,Total_Amount,PayMode ) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       
              
              pst.setString(1,billNo.getText());
              pst.setString(2,date);
              pst.setString(3,billType.getSelectedItem().toString());
              pst.setString(4,OPD.getSelectedItem().toString());
              pst.setString(5,OPDno.getText());
              pst.setString(6,Bpatient.getSelectedItem().toString());
              pst.setString(7,Pregno.getText());
              pst.setString(8,Bservice.getSelectedItem().toString());
              pst.setString(9,amount.getText());
              pst.setString(10, quantity.getText());
               pst.setString(11,disType.getSelectedItem().toString());
              pst.setString(12,discount.getText());
              pst.setString(13,Grandtotal.getText());
              pst.setString(14,payMode.getSelectedItem().toString());
              pst.executeUpdate();//execute query  
                JOptionPane.showMessageDialog(this, "Bill Generated Successfully");//show message
                getBill_No();
                 clearFiled();
                con.close();//connection close 
              
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        billNo = new javax.swing.JTextField();
        billDate = new com.toedter.calendar.JDateChooser();
        billType = new javax.swing.JComboBox<>();
        Bservice = new javax.swing.JComboBox<>();
        disType = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Bpatient = new javax.swing.JComboBox<>();
        Grandtotal = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        Pregno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        payMode = new javax.swing.JComboBox<>();
        OPD = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        OPDno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Patient Reg No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 160, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Bill No:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Bill Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Amount");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Select OPD");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 160, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Select Pay Mode");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 160, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 102));
        jLabel7.setText("Generate Bill");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 160, 30));

        amount.setBackground(new java.awt.Color(255, 255, 204));
        amount.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        amount.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 150, 40));

        billNo.setBackground(new java.awt.Color(255, 255, 204));
        billNo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        billNo.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(billNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 150, 40));

        billDate.setBackground(new java.awt.Color(255, 255, 204));
        billDate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        billDate.setForeground(new java.awt.Color(0, 51, 204));
        billDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(billDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 230, 40));

        billType.setBackground(new java.awt.Color(255, 255, 204));
        billType.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        billType.setForeground(new java.awt.Color(0, 51, 204));
        billType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "OPD", "Sonography", "RECEPT" }));
        billType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(billType, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 240, 40));

        Bservice.setBackground(new java.awt.Color(255, 255, 204));
        Bservice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Bservice.setForeground(new java.awt.Color(0, 51, 204));
        Bservice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        Bservice.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Bservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BserviceActionPerformed(evt);
            }
        });
        jPanel1.add(Bservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 240, 40));

        disType.setBackground(new java.awt.Color(255, 255, 204));
        disType.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        disType.setForeground(new java.awt.Color(0, 51, 204));
        disType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "%(per)", "Cost" }));
        disType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        disType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disTypeActionPerformed(evt);
            }
        });
        jPanel1.add(disType, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 190, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Select Bill Type");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 160, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Select Patient");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("Grand Total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, 160, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Quantity");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 160, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 204));
        jLabel12.setText("Price");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 160, 30));

        Bpatient.setBackground(new java.awt.Color(255, 255, 204));
        Bpatient.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Bpatient.setForeground(new java.awt.Color(0, 51, 204));
        Bpatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        Bpatient.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Bpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpatientActionPerformed(evt);
            }
        });
        jPanel1.add(Bpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 230, 40));

        Grandtotal.setBackground(new java.awt.Color(255, 255, 204));
        Grandtotal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Grandtotal.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(Grandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 150, 40));

        price.setBackground(new java.awt.Color(255, 255, 204));
        price.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        price.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 150, 40));

        Pregno.setBackground(new java.awt.Color(255, 255, 204));
        Pregno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Pregno.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(Pregno, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 150, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("Services");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 160, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 204));
        jLabel15.setText("Discount");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 160, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 204));
        jLabel16.setText("Dis Type");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 160, 30));

        quantity.setBackground(new java.awt.Color(255, 255, 204));
        quantity.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quantity.setForeground(new java.awt.Color(0, 51, 204));
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 150, 40));

        discount.setBackground(new java.awt.Color(255, 255, 204));
        discount.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 150, 40));

        Save.setBackground(new java.awt.Color(255, 0, 102));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, 100, 40));

        Back.setFont(new java.awt.Font("Yu Gothic", 1, 23)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 0, 51));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous.png"))); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        payMode.setBackground(new java.awt.Color(255, 255, 204));
        payMode.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        payMode.setForeground(new java.awt.Color(0, 51, 204));
        payMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Cash", "Credit card", "Debit card", "UPI", "Online Transfer" }));
        payMode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(payMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 220, 40));

        OPD.setBackground(new java.awt.Color(255, 255, 204));
        OPD.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        OPD.setForeground(new java.awt.Color(0, 51, 204));
        OPD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Orthopedic", "Gynecologist" }));
        OPD.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(OPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 240, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("OPD Number:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 160, 30));

        OPDno.setBackground(new java.awt.Color(255, 255, 204));
        OPDno.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        OPDno.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(OPDno, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 150, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 670));

        setBounds(500, 100, 1010, 676);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
          dispose();//causes the JFrame window to be distroyed
    }//GEN-LAST:event_BackMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        insertBillDetails();   
    }//GEN-LAST:event_SaveActionPerformed
// to set the price to  there services
    private void BserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BserviceActionPerformed
        // TODO add your handling code here:
        //Method to get Price
        try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
            String fetch_row="Select * from Services where Service_Name=?";
            pst=con.prepareStatement(fetch_row);
            pst.setString(1,(String)Bservice.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                price.setText(rs.getString("Price"));//set Price to JTextFiled
            }
        }
        catch(NumberFormatException ex)
        {
          ex.printStackTrace();
        }
        catch (Exception e) {
                
            e.printStackTrace();
        }
    }//GEN-LAST:event_BserviceActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        // TODO add your handling code here:
        CalculateAmounts();
    }//GEN-LAST:event_quantityKeyReleased

    private void disTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disTypeActionPerformed
        // TODO add your handling code here:
        //to calculate Grand Total
          try {
              if(disType.getSelectedItem().equals("%(per)")){
              
                  double amt=Double.parseDouble(amount.getText());
                  double dis=Double.parseDouble(discount.getText());  
                  double dis_value=amt*(dis/100);//calculate Discount Value
                  double GrandTotal=amt-dis_value;
                  Grandtotal.setText(Double.toString(GrandTotal)); 
             
                  
              }
              else{
              
                  double amt=Double.parseDouble(amount.getText());
                  double dis=Double.parseDouble(discount.getText());  
                  double GrandTotal=amt-dis;
                 Grandtotal.setText(Double.toString(GrandTotal));
           
                 
              }
        } catch (NumberFormatException num) {
            num.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_disTypeActionPerformed

    private void BpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpatientActionPerformed

        try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
            String fetch_row="Select * from Patient where Patient_Name=?";
            pst=con.prepareStatement(fetch_row);
            pst.setString(1,(String)Bpatient.getSelectedItem());
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                Pregno.setText(rs.getString("Register_No"));//set Reh no to JTextFiled
            }
        }
        catch(NumberFormatException ex)
        {
          ex.printStackTrace();
        }
        catch (Exception e) {
                
            e.printStackTrace();
        }     
         
    }//GEN-LAST:event_BpatientActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JComboBox<String> Bpatient;
    private javax.swing.JComboBox<String> Bservice;
    private javax.swing.JTextField Grandtotal;
    private javax.swing.JComboBox<String> OPD;
    private javax.swing.JTextField OPDno;
    private javax.swing.JTextField Pregno;
    private javax.swing.JButton Save;
    private javax.swing.JTextField amount;
    private com.toedter.calendar.JDateChooser billDate;
    private javax.swing.JTextField billNo;
    private javax.swing.JComboBox<String> billType;
    private javax.swing.JComboBox<String> disType;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> payMode;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
