/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import static database.DB_Connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohan babar
 */
public class Services extends javax.swing.JFrame {

    /**
     * Creates new form Services
     */
    public Services() {
        initComponents();
        displayServiceList();
    }

    
   //Method to insert values into services_tb 
    public void insertServiceDetails()
    {
        //if the service  Details are not filled up
        if(serviceID.getText().isEmpty() || servicePrice.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(this, "Missing Information");
        }
        else
        {
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
             
                //insert Service details into Services table
                pst=con.prepareStatement("insert into Services(Service_ID,Service_Name,Price) values(?,?,?)");
                pst.setString(1,serviceID.getText());
                pst.setString(2,serviceName.getText());
                pst.setString(3,servicePrice.getText());
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Service Added Successfully");//show message
                clearFields();
                clearTable();//to clear services_tbl 
                displayServiceList();//display data in services_tbl
                con.close();//connection close 
              
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
    
    
    //method to clear table
   void clearTable()
    {
        //to clear all data from services_tbl
      DefaultTableModel tmodel=(DefaultTableModel) services_tbl.getModel();
      tmodel.setRowCount(0);
    }
    
   //to clear all fileds
   void clearFields()
   {
       serviceID.setText("");
       serviceName.setText("");
        servicePrice.setText("");
   }

    //Display Services list in the table
  void displayServiceList()
    {
         Connection con =getConnection();//accessing database connection from DB_Connection class
        try {
              stmt=con.createStatement();//create Statement
             ResultSet rs=stmt.executeQuery("select * from Services");
           while(rs.next())
            {
                //data will be added until finish
               
                String srno=String.valueOf(rs.getInt("Sr_No"));
                  String id=String.valueOf(rs.getInt("Service_ID"));
                String Sname=(rs.getString("Service_Name"));
                String sprice=rs.getString("Price");
                
                
                //String array for store dara into services_tbl
                String tbData[]={srno,id,Sname,sprice};
                DefaultTableModel model=(DefaultTableModel)services_tbl.getModel();  
                //add String array data into services_tbl
                model.addRow(tbData);
            }
           con.close();//connection close
        } catch (Exception e) {
           e.printStackTrace();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        servicePrice = new javax.swing.JTextField();
        serviceID = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Back = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        serviceName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        services_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Add Services");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 190, 30));

        jPanel4.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 200, 5));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Service Price:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 160, 34));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Service ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 160, 34));

        servicePrice.setBackground(new java.awt.Color(102, 204, 255));
        servicePrice.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(servicePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 250, 40));

        serviceID.setBackground(new java.awt.Color(102, 204, 255));
        serviceID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(serviceID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, 40));

        Save.setBackground(new java.awt.Color(0, 51, 204));
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 80, 30));

        Update.setBackground(new java.awt.Color(0, 51, 204));
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 80, 30));

        Delete.setBackground(new java.awt.Color(0, 51, 204));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 70, 30));

        Back.setFont(new java.awt.Font("Yu Gothic", 1, 23)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous.png"))); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("Service Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 160, 34));

        serviceName.setBackground(new java.awt.Color(102, 204, 255));
        serviceName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(serviceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 250, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 920, 310));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Services List");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 190, 30));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 200, 5));

        services_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SR No", "Service ID", "Service Name", "Service Price"
            }
        ));
        services_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                services_tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(services_tbl);
        if (services_tbl.getColumnModel().getColumnCount() > 0) {
            services_tbl.getColumnModel().getColumn(0).setMinWidth(70);
            services_tbl.getColumnModel().getColumn(0).setMaxWidth(100);
            services_tbl.getColumnModel().getColumn(1).setMinWidth(150);
            services_tbl.getColumnModel().getColumn(1).setMaxWidth(200);
            services_tbl.getColumnModel().getColumn(2).setMinWidth(200);
            services_tbl.getColumnModel().getColumn(2).setMaxWidth(250);
            services_tbl.getColumnModel().getColumn(3).setMinWidth(200);
            services_tbl.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 640, 240));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 920, 330));

        setBounds(500, 100, 918, 643);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
      
        dispose();//causes the JFrame window to be distroyed
    }//GEN-LAST:event_BackMouseClicked

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        insertServiceDetails();
    }//GEN-LAST:event_SaveActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        //code to update service details 
         if(services_tbl.getSelectedRowCount()==1)
        {
            //if row is selected then update 
            Connection con =getConnection();//accessing database connection from DB_Connection class
            try {
               
                //Update service details into Service table
                pst=con.prepareStatement("Update Services set Service_Name=?,Price=? where Service_ID=?");
                
               pst.setString(1,serviceName.getText());
               pst.setString(2,servicePrice.getText().toString());
                pst.setString(3,serviceID.getText());
              
                pst.executeUpdate();//execute query
                JOptionPane.showMessageDialog(this, "Update Successfully");//update message disply
                clearFields();
                clearTable();//to clear services_tbl
                displayServiceList();//display data in services_tbl
                con.close();
              
            } catch (Exception e) {
               e.printStackTrace();
            }
              
        }
        else
        {
           if(services_tbl.getRowCount()==0)
           {
               //if table is empty
               JOptionPane.showMessageDialog(this, "No any Service in Services list");//show message 
           }
           else
           {      //if row is not selected 
                 JOptionPane.showMessageDialog(this, "select the Service ");//show message 
           }
        }
         
        
        
    }//GEN-LAST:event_UpdateActionPerformed

    private void services_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_services_tblMouseClicked
        // TODO add your handling code here:
       //set data to their Textfields
       
       DefaultTableModel tbmodel=(DefaultTableModel)services_tbl.getModel();
        //set data to textfield  when row is selected 
        int index=services_tbl.getSelectedRow();
        serviceID.setText(tbmodel.getValueAt(index, 1).toString());
        serviceName.setText(tbmodel.getValueAt(index, 2).toString());
        servicePrice.setText(tbmodel.getValueAt(index, 3).toString());
       
     
    }//GEN-LAST:event_services_tblMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        
         //To Delete record 
        if(services_tbl.getSelectedRowCount()==1)
        {
            try {
                Connection con =getConnection();//accessing database connection from DB_Connection class
                String sql="delete from Services where Service_ID=?";
                pst=con.prepareStatement(sql);
                pst.setInt(1,Integer.parseInt(serviceID.getText()));
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Record Deleted Successfully");//show message
                 clearFields();
                  clearTable();//to clear servicest_tbl
                 displayServiceList();//display data in services_tbl
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
          
        }
        else
        {
            if(services_tbl.getRowCount()==0)
            {
                //if table is empty then display message
                JOptionPane.showMessageDialog(this, "No any Service in Services list");//show message 
            }
            else
            {
                //if row is not selected 
                JOptionPane.showMessageDialog(this, "select the service ");//show message 
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
            java.util.logging.Logger.getLogger(Services.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Services.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Services.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Services.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Services().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Save;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField serviceID;
    private javax.swing.JTextField serviceName;
    private javax.swing.JTextField servicePrice;
    private javax.swing.JTable services_tbl;
    // End of variables declaration//GEN-END:variables
}
