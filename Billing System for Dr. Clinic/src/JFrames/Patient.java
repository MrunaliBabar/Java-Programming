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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohan babar
 */
public class Patient extends javax.swing.JFrame {

    
    /**
     * Creates new form Patient
     */
    public Patient() {
        initComponents();
       displayPatients();//call method to display patient list in Patient_tbl 
    }
//Method to insert values into Patient_tb 
    public void insertPatientDetails()
    {
        //if the Patient Details are not filled up
        if(RegNo.getText().isEmpty() || pname.getText().isEmpty() ||  age.getText().isEmpty()|| mob.getText().isEmpty()||add.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//set the date format 
                String date=sdf.format(dob.getDate());//store in date from jdatechooser
                //insert patient details into patient table
                pst=con.prepareStatement("insert into Patient(Register_No,Patient_Name,DOB,Patient_age,Gender ,Mobile,Email,Address) values(?,?,?,?,?,?,?,?)");
                pst.setString(1,RegNo.getText());
                pst.setString(2,pname.getText());
                pst.setString(3, date);
                pst.setString(4,age.getText());
                pst.setString(5,gender.getSelectedItem().toString());
                pst.setString(6,mob.getText());
                pst.setString(7,email.getText());
                pst.setString(8,add.getText());
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Patient Added Successfully");//show message
                clearFields();
                clearTable();//to clear Patient_tbl 
                displayPatients();//display data in Patient_tbl
                con.close();//connection close 
              
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
   
    //Display patient list in the table
  void displayPatients()
    {
         Connection con =getConnection();//accessing database connection from DB_Connection class
        try {
              stmt=con.createStatement();//create Statement
             ResultSet rs=stmt.executeQuery("select * from Patient");
           while(rs.next())
            {
                //data will be added until finish
               
                String srno=String.valueOf(rs.getInt("Sr_No"));
                String regno=String.valueOf(rs.getInt("Register_No"));
                String name=rs.getString("Patient_Name");
                String p_dob=String.valueOf(rs.getDate("DOB"));
                String p_age=String.valueOf(rs.getInt("Patient_age"));
                String p_gender=rs.getString("Gender");
                String p_mob=String.valueOf(rs.getString("Mobile"));  
                String p_email=rs.getString("Email");
                String p_add=rs.getString("Address");
                
                //String array for store dara into Patient_tbl
                String tbData[]={srno,regno,name,p_dob,p_age,p_gender,p_mob,p_email,p_add};
                DefaultTableModel model=(DefaultTableModel)Patient_tbl.getModel();  
                //add String array data into Patient_tbl
                model.addRow(tbData);
            }
           con.close();//connection close
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
  
  //method to check Duplicate register No.
   public boolean checkDuplicateRegNo(){
        boolean isExits=false;
        String reg=RegNo.getText();
        try {
             Connection con =getConnection();//accessing database connection from DB_Connection class
           pst=con.prepareStatement("select * from Patient where Register_No=?");
            pst.setString(1, reg);
            ResultSet rs =pst.executeQuery();
            if(rs.next()){
                isExits=true;
            }
            else{
                isExits=false;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return isExits;
    }
    //method to clear table
   void clearTable()
    {
        //to clear all data from Patient_tbl
      DefaultTableModel tmodel=(DefaultTableModel) Patient_tbl.getModel();
      tmodel.setRowCount(0);
    }
    
   //to clear all fileds
   void clearFields()
   {
       RegNo.setText("");
         pname.setText("");
         dob.setDate(null);
         age.setText("");
         gender.setSelectedItem("Select");
         mob.setText("");  
         email.setText("");
         add.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RegNo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        dob = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        add = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mob = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Back = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Patient_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 181, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Registration");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 230, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registration No:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 260, 40));

        RegNo.setBackground(new java.awt.Color(0, 181, 204));
        RegNo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        RegNo.setForeground(new java.awt.Color(255, 255, 255));
        RegNo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(RegNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, 40));

        pname.setBackground(new java.awt.Color(0, 181, 204));
        pname.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        pname.setForeground(new java.awt.Color(255, 255, 255));
        pname.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 330, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gender:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 190, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DOB:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 190, 40));

        gender.setBackground(new java.awt.Color(0, 181, 204));
        gender.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        gender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, 190, 40));

        dob.setBackground(new java.awt.Color(0, 181, 204));
        dob.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        dob.setForeground(new java.awt.Color(255, 255, 255));
        dob.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 290, 40));

        add.setBackground(new java.awt.Color(0, 181, 204));
        add.setColumns(20);
        add.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setRows(5);
        add.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jScrollPane1.setViewportView(add);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 330, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 190, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Patient Age:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 190, 40));

        age.setBackground(new java.awt.Color(0, 181, 204));
        age.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 160, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patient Mobile:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, 40));

        mob.setBackground(new java.awt.Color(0, 181, 204));
        mob.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        mob.setForeground(new java.awt.Color(255, 255, 255));
        mob.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 190, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 190, 40));

        email.setBackground(new java.awt.Color(0, 181, 204));
        email.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 310, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 300, 5));

        Back.setFont(new java.awt.Font("Yu Gothic", 1, 23)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous.png"))); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        Save.setBackground(new java.awt.Color(0, 51, 204));
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 100, 30));

        update.setBackground(new java.awt.Color(0, 51, 204));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Edit");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 100, 30));

        Delete.setBackground(new java.awt.Color(0, 51, 204));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setBorder(new javax.swing.border.MatteBorder(null));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 100, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 370));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 181, 204));
        jLabel10.setText("Patient List");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 150, 30));

        jPanel3.setBackground(new java.awt.Color(0, 181, 204));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 200, 5));

        Patient_tbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Patient_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR No.", "Register Number", "Patient Name", "DOB", "Patient age", "Gender", "Mobile No.", "Email", "Address"
            }
        ));
        Patient_tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Patient_tbl.setGridColor(new java.awt.Color(153, 153, 153));
        Patient_tbl.setRowHeight(24);
        Patient_tbl.setSelectionBackground(new java.awt.Color(0, 181, 204));
        Patient_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Patient_tblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Patient_tbl);
        if (Patient_tbl.getColumnModel().getColumnCount() > 0) {
            Patient_tbl.getColumnModel().getColumn(0).setMinWidth(70);
            Patient_tbl.getColumnModel().getColumn(0).setMaxWidth(100);
            Patient_tbl.getColumnModel().getColumn(1).setMinWidth(150);
            Patient_tbl.getColumnModel().getColumn(1).setMaxWidth(200);
            Patient_tbl.getColumnModel().getColumn(2).setMinWidth(200);
            Patient_tbl.getColumnModel().getColumn(2).setMaxWidth(250);
            Patient_tbl.getColumnModel().getColumn(3).setMinWidth(100);
            Patient_tbl.getColumnModel().getColumn(3).setMaxWidth(150);
            Patient_tbl.getColumnModel().getColumn(4).setMinWidth(100);
            Patient_tbl.getColumnModel().getColumn(4).setMaxWidth(150);
            Patient_tbl.getColumnModel().getColumn(5).setMinWidth(100);
            Patient_tbl.getColumnModel().getColumn(5).setMaxWidth(150);
            Patient_tbl.getColumnModel().getColumn(6).setMinWidth(100);
            Patient_tbl.getColumnModel().getColumn(6).setMaxWidth(150);
            Patient_tbl.getColumnModel().getColumn(7).setMinWidth(200);
            Patient_tbl.getColumnModel().getColumn(7).setMaxWidth(200);
            Patient_tbl.getColumnModel().getColumn(8).setMinWidth(200);
            Patient_tbl.getColumnModel().getColumn(8).setMaxWidth(250);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1110, 370));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 1120, 490));

        setBounds(400, 70, 1115, 819);
    }// </editor-fold>//GEN-END:initComponents
     
    private void Patient_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Patient_tblMouseClicked
       //set data to their Textfields
       
       DefaultTableModel tbmodel=(DefaultTableModel)Patient_tbl.getModel();
        //set data to textfield  when row is selected 
        int index=Patient_tbl.getSelectedRow();
        RegNo.setText(tbmodel.getValueAt(index, 1).toString());
        pname.setText(tbmodel.getValueAt(index, 2).toString());
        age.setText(tbmodel.getValueAt(index, 4).toString());
        gender.setSelectedItem(tbmodel.getValueAt(index, 5).toString());
        mob.setText(tbmodel.getValueAt(index, 6).toString());
        email.setText(tbmodel.getValueAt(index, 7).toString());
        add.setText(tbmodel.getValueAt(index, 8).toString());
        //set  date to JDatechooser when row is selected 
         try {
            java.util.Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)tbmodel.getValueAt(index, 3).toString());
            dob.setDate(date);
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }//GEN-LAST:event_Patient_tblMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
         dispose();//causes the JFrame window to be distroyed 
    }//GEN-LAST:event_BackMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        //code to update patient details 
         if(Patient_tbl.getSelectedRowCount()==1)
        {
            //if row is selected then update 
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//set the date format 
                String date=sdf.format(dob.getDate());//store in date from jdatechooser
                //Update patient details into patient table
                pst=con.prepareStatement("Update Patient set Patient_Name=?,DOB=?,Patient_age=?,Gender=? ,Mobile=?,Email=?,Address=? where Register_No=?");
                
                pst.setString(1,pname.getText());
                pst.setString(2, date);
                pst.setString(3,age.getText());
                pst.setString(4,gender.getSelectedItem().toString());
                pst.setString(5,mob.getText());
                pst.setString(6,email.getText());
                pst.setString(7,add.getText());
                pst.setInt(8,Integer.parseInt(RegNo.getText()));
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Update Successfully");//update message disply
                clearFields();
                clearTable();//to clear Patient_tbl
                displayPatients();//display data in Patient_tbl
                con.close();
              
            } catch (Exception e) {
               e.printStackTrace();
            }
              
        }
        else
        {
           if(Patient_tbl.getRowCount()==0)
           {
               //if table is empty
               JOptionPane.showMessageDialog(this, "No any Patient in Patient list");//show message 
           }
           else
           {      //if row is not selected 
                 JOptionPane.showMessageDialog(this, "select the patient ");//show message 
           }
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //Add patient details in patient table
        if(checkDuplicateRegNo()==false){
            insertPatientDetails();
        }
         else{
                JOptionPane.showMessageDialog(this, "Register Number already Exits");
            }
         
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       //To Delete record 
        if(Patient_tbl.getSelectedRowCount()==1)
        {
            try {
                Connection con =getConnection();//accessing database connection from DB_Connection class
                String sql="delete from Patient where Register_No=?";
                pst=con.prepareStatement(sql);
                pst.setInt(1,Integer.parseInt(RegNo.getText()));
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Record Deleted Successfully");//show message
                 clearFields();
                  clearTable();//to clear Patient_tbl
                 displayPatients();//display data in Patient_tbl
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
          
        }
        else
        {
            if(Patient_tbl.getRowCount()==0)
            {
                //if table is empty then display message
                JOptionPane.showMessageDialog(this, "No any Patient in Patient list");//show message 
            }
            else
            {
                //if row is not selected 
                JOptionPane.showMessageDialog(this, "select the patient ");//show message 
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton Delete;
    private javax.swing.JTable Patient_tbl;
    private javax.swing.JTextField RegNo;
    private javax.swing.JButton Save;
    private javax.swing.JTextArea add;
    private javax.swing.JTextField age;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField pname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
