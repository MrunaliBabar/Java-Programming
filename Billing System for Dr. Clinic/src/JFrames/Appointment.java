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
public class Appointment extends javax.swing.JFrame {

    /**
     * Creates new form Appointment
     */
    public Appointment() {
        initComponents();
        getPatient();//get the Patient name in Jcombobox
        displayAppointmentList();//call method to display Appointment list in appt_tbl 
    }

    //Method to get the Patient
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
                  patient_name.addItem(PatName);//add patient name to JcomboBox
              }
        } catch (Exception e) {
        }
    }
    
    //Method to insert values into appt_tb 
    public void insertAppointmentDetails()
    {
        //if the Appointment Details are not filled up
        if(patient_name.getSelectedIndex()==-1 || session.getSelectedIndex()==-1|| apptOPD.getSelectedIndex()==-1|| apptDate.getDate()==null)
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//set the date format 
                String appt_date=sdf.format(apptDate.getDate());//store in date from jdatechooser
                //insert patient details into patient table
                pst=con.prepareStatement("insert into Appointment(Appt_ID,PatientName,Appt_Session,Appt_Date ,Appt_OPD,Message) values(?,?,?,?,?,?)");
                  pst.setString(1,apptId.getText());
                pst.setString(2,patient_name.getSelectedItem().toString());
                pst.setString(3,session.getSelectedItem().toString());
                pst.setString(4, appt_date);
                pst.setString(5,apptOPD.getSelectedItem().toString());
                pst.setString(6,msg.getText());
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Appointment Added Successfully");//show message
                clearFiled();//to clear all fileds
                clearTable();//to clear appt_tbl 
                displayAppointmentList();//display data in appt_tbl
                con.close();//connection close 
              
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
    
     //Display Appointment list in the appt_tbl table
  void displayAppointmentList()
    {
         Connection con =getConnection();//accessing database connection from DB_Connection class
        try {
              stmt=con.createStatement();//create Statement
             ResultSet rs=stmt.executeQuery("select * from Appointment");
           while(rs.next())
            {
                //data will be added until finish
               
                String srNo=String.valueOf(rs.getInt("Sr_No"));
                  String id=String.valueOf(rs.getInt("Appt_ID"));
                String Pname=rs.getString("PatientName");
                 String aSession=rs.getString("Appt_Session");
                String aDate=String.valueOf(rs.getDate("Appt_Date"));
               
                String aOPD=String.valueOf(rs.getString("Appt_OPD"));  
                String aMsg=rs.getString("Message");
             
                //String array for store data into appt_tbl
                String tbData[]={srNo,id,Pname,aSession,aDate,aOPD,aMsg};
                DefaultTableModel model=(DefaultTableModel)appt_tbl.getModel();  
                //add String array data into appt_tbl
                model.addRow(tbData);
            }
           con.close();//connection close
        } catch (Exception e) {
           e.printStackTrace();
       }
    }
    
       //method to clear table
   void clearTable()
    {
        //to clear all data from appt_tbl
      DefaultTableModel tmodel=(DefaultTableModel) appt_tbl.getModel();
      tmodel.setRowCount(0);
    }
    
     //To clear the TextFields
        void clearFiled()
        {
        apptId.setText("");
        patient_name.setSelectedItem("Choose");
        session.setSelectedItem("Choose");
        apptDate.setDate(null);
        apptOPD.setSelectedItem("Choose");
        msg.setText("");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        apptOPD = new javax.swing.JComboBox<>();
        patient_name = new javax.swing.JComboBox<>();
        apptDate = new com.toedter.calendar.JDateChooser();
        session = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        apptId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appt_tbl = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Select Patient:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Appointment Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Appointment Session:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 200, 34));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Appointment For OPD:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 210, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Appointment ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 160, 34));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Appointment");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 160, 30));

        apptOPD.setBackground(new java.awt.Color(204, 255, 255));
        apptOPD.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        apptOPD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Orthopedic", "Gynecologist", " " }));
        jPanel1.add(apptOPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 250, 40));

        patient_name.setBackground(new java.awt.Color(204, 255, 255));
        patient_name.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        patient_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        jPanel1.add(patient_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 40));

        apptDate.setBackground(new java.awt.Color(204, 255, 255));
        apptDate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(apptDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 290, 40));

        session.setBackground(new java.awt.Color(204, 255, 255));
        session.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose", "Morning ", "Afternoon", "Evening" }));
        jPanel1.add(session, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 250, 40));

        msg.setBackground(new java.awt.Color(204, 255, 255));
        msg.setColumns(20);
        msg.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        msg.setRows(5);
        jScrollPane2.setViewportView(msg);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 250, 5));

        Save.setBackground(new java.awt.Color(0, 51, 204));
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 100, 30));

        update.setBackground(new java.awt.Color(0, 51, 204));
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Edit");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 100, 30));

        Delete.setBackground(new java.awt.Color(0, 51, 204));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setBorder(new javax.swing.border.MatteBorder(null));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 100, 30));

        Back.setFont(new java.awt.Font("Yu Gothic", 1, 23)); // NOI18N
        Back.setForeground(new java.awt.Color(0, 153, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous.png"))); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Message:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 112, 34));

        apptId.setBackground(new java.awt.Color(204, 255, 255));
        apptId.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(apptId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 200, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 370));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appt_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr.No", "Appointment ID", "Patient Name", "Appointment session", "Appointment Date", "Appointment ODP", "Message"
            }
        ));
        appt_tbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        appt_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appt_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(appt_tbl);
        if (appt_tbl.getColumnModel().getColumnCount() > 0) {
            appt_tbl.getColumnModel().getColumn(0).setMinWidth(70);
            appt_tbl.getColumnModel().getColumn(0).setMaxWidth(100);
            appt_tbl.getColumnModel().getColumn(1).setMinWidth(100);
            appt_tbl.getColumnModel().getColumn(1).setMaxWidth(150);
            appt_tbl.getColumnModel().getColumn(2).setMinWidth(200);
            appt_tbl.getColumnModel().getColumn(2).setMaxWidth(250);
            appt_tbl.getColumnModel().getColumn(3).setMinWidth(200);
            appt_tbl.getColumnModel().getColumn(3).setMaxWidth(250);
            appt_tbl.getColumnModel().getColumn(4).setMinWidth(200);
            appt_tbl.getColumnModel().getColumn(4).setMaxWidth(250);
            appt_tbl.getColumnModel().getColumn(5).setMinWidth(200);
            appt_tbl.getColumnModel().getColumn(5).setMaxWidth(250);
            appt_tbl.getColumnModel().getColumn(6).setMinWidth(200);
            appt_tbl.getColumnModel().getColumn(6).setMaxWidth(250);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 830, 290));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("Appointment List");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 210, 30));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 250, 5));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 990, 470));

        setBounds(400, 70, 989, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //Add Appointment details in Appointment table
       insertAppointmentDetails();
    }//GEN-LAST:event_SaveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        //code to update Appointment details
      if(appt_tbl.getSelectedRowCount()==1)
        {
            //if row is selected then update
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//set the date format
                String appt_date=sdf.format(apptDate.getDate());//store in date from jdatechooser
                //Update Appointment details into Appointment table
                pst=con.prepareStatement("Update Appointment set PatientName=?,Appt_Session=?,Appt_Date=?,Appt_OPD=?,Message=? where Appt_ID=?");

                 pst.setString(1,patient_name.getSelectedItem().toString());
                pst.setString(2,session.getSelectedItem().toString());
                pst.setString(3, appt_date);
                pst.setString(4,apptOPD.getSelectedItem().toString());
                pst.setString(5,msg.getText());
                pst.setString(6,apptId.getText());
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Update Successfully");//update message disply
                clearFiled();
                clearTable();//to clear appt_tbl
                displayAppointmentList();//display data in appt_tbl
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            if(appt_tbl.getRowCount()==0)
            {
                //if table is empty
                JOptionPane.showMessageDialog(this, "No any Appointment in Appointment list");//show message
            }
            else
            {      //if row is not selected
                JOptionPane.showMessageDialog(this, "select the Appointment");//show message
            }
        }

    }//GEN-LAST:event_updateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        //To Delete record
       if(appt_tbl.getSelectedRowCount()==1)
        {
            try {
                Connection con =getConnection();//accessing database connection from DB_Connection class
                String sql="delete from Appointment where Appt_ID=?";
                pst=con.prepareStatement(sql);
                pst.setInt(1,Integer.parseInt(apptId.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");//show message
                clearFiled();
                clearTable();//to clear appt_tbl
                displayAppointmentList();//display data in appt_tbl
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            if(appt_tbl.getRowCount()==0)
            {
                //if table is empty then display message
                JOptionPane.showMessageDialog(this, "No any Appointment in Appointment list");//show message
            }
            else
            {
                //if row is not selected
                JOptionPane.showMessageDialog(this, "select the  Appointments ");//show message
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
     
        dispose();//causes the JFrame window to be distroyed 
    }//GEN-LAST:event_BackMouseClicked

    private void appt_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appt_tblMouseClicked
        // TODO add your handling code here:
        //set data to their Textfields
       
       DefaultTableModel tbmodel=(DefaultTableModel)appt_tbl.getModel();
        //set data to textfield  when row is selected 
        int index=appt_tbl.getSelectedRow();
         apptId.setText(tbmodel.getValueAt(index, 1).toString());
        patient_name.setSelectedItem(tbmodel.getValueAt(index, 2).toString());
        session.setSelectedItem(tbmodel.getValueAt(index, 3).toString());
        apptOPD.setSelectedItem(tbmodel.getValueAt(index, 5).toString());
        msg.setText(tbmodel.getValueAt(index, 6).toString());
        //set  date to JDatechooser when row is selected 
         try {
            java.util.Date date= new SimpleDateFormat("yyyy-MM-dd").parse((String)tbmodel.getValueAt(index, 4).toString());
            apptDate.setDate(date);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_appt_tblMouseClicked

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
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Save;
    private com.toedter.calendar.JDateChooser apptDate;
    private javax.swing.JTextField apptId;
    private javax.swing.JComboBox<String> apptOPD;
    private javax.swing.JTable appt_tbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea msg;
    private javax.swing.JComboBox<String> patient_name;
    private javax.swing.JComboBox<String> session;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
